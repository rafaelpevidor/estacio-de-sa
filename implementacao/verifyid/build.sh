#!/bin/bash

set -u

# Include Definitions

source './config.sh'

# Declare locals

declare app_name=${APP_NAME:-''}
declare servlet_container_home=${SERVLET_CONTAINER_HOME:-''}
declare servlet_container_lib=''
declare servlet_container_webapps=''
declare servlet_container_classpath=''
declare servlet_container_app=''
declare classes_dir=${CLASSES_DIR:-''}
declare sources_dir=${SOURCES_DIR:-''}
declare lib_dir=${LIB_DIR:-''}
declare etc_dir=${ETC_DIR:-''}
declare web_dir=${WEB_DIR:-''}
declare tmp_app_dir=''
declare tmp_dir=${TMP_DIR:-''}
declare source_files=''
declare target_file=''
declare encoding=${SOURCE_ENCODING:-''}
declare options=${OPTIONS:-''}

# Trailing slashes clean up...

classes_dir=${classes_dir%'/'}
sources_dir=${sources_dir%'/'}
lib_dir=${lib_dir%'/'}
etc_dir=${etc_dir%'/'}
web_dir=${web_dir%'/'}
servlet_container_home=${servlet_container_home%'/'}

# If app_name is empty, user MyApp instead...

if [ -z "$app_name" ]; then
    app_name='MyApp'
fi

# Make sure classes directory exists

if [ -z "$classes_dir" ]; then
    classes_dir='bin'
fi

if [ ! -d "$classes_dir" ]; then
    [ -e "$classes_dir" ] && rm -fR "$classes_dir"
    mkdir -p "$classes_dir"
fi

# Make sure we have a valid encoding

if [ -z "$encoding" ]; then
    encoding='UTF-8'
fi

# Make sure we have access to the Servlet API

if [ -z "$servlet_container_home" ]; then
    echo 'The environment variable "$SERVLET_CONTAINER_HOME" has not been defined...'
    exit 127
fi

if [ ! -d "$servlet_container_home" ]; then
    echo 'The "$SERVLET_CONTAINER_HOME" variable does not point to a valid directory...'
    exit 127
fi

# Define and validate important Tomcat directories

servlet_container_lib="$servlet_container_home/lib"
servlet_container_webapps="$servlet_container_home/webapps"
servlet_container_app="$servlet_container_webapps/$app_name"

if [ ! -d "$servlet_container_lib" -o ! -d "$servlet_container_webapps" ]; then
    echo 'The path specified in "$SERVLET_CONTAINER_HOME" variable does not seem a valid container directory...'
    exit 127
fi

echo "Servlet Container: $servlet_container_home"

# Populate Tomcat classpath

while read file
do
    if [ -z "$servlet_container_classpath" ]; then
        servlet_container_classpath="$file"
    else
        servlet_container_classpath="$servlet_container_classpath:$file"
    fi
done < <(find "$servlet_container_lib" -iname "*.jar" | grep -E '\bservlet\b')

if [ -z "$servlet_container_classpath" ] || [[ "$servlet_container_classpath" != *"servlet"* ]]; then
    echo 'The Servlet API could not be found...'
    exit 127
fi

# Make sure classes and source directory exists

if [ ! -d "$sources_dir" -o ! -d "$classes_dir" -o ! -d "$lib_dir" -o ! -d "$web_dir" ]; then
    echo "$sources_dir" "$classes_dir" "$lib_dir" "$web_dir"
    echo 'Important project directories could not be found...'
    exit 127
fi

# Compile each source file

while read file
do
    target_file="$classes_dir/${file#"$sources_dir/"}"
    target_file="${target_file%'.java'}.class"
    if [ "$target_file" -ot "$file" ]; then
        printf 'Compiling "%s"...\n' "$file"
        javac -g -encoding "$encoding" -d "$classes_dir" -classpath "$classes_dir:$servlet_container_classpath" -sourcepath "$sources_dir" "$file"
        if [ $? -ne 0 ]; then
            printf '... ERROR! :-(\n'
            echo 'Aborting...'
            exit 127
        fi
        printf '... OK! :-)\n'
    else
        echo "Skipping \"$file\"... "
    fi
done < <(find "$sources_dir" -iname "*.java")

# Create temporary application directory...

echo 'Creating application directory...'

# Create temporary app dir
[ -e "$tmp_dir" ] && rm -fR "$tmp_dir"
tmp_app_dir="$tmp_dir/$app_name"
mkdir -p "$tmp_app_dir"

# Copy entire WEB dir to temporary web dir
cp -fR "$web_dir/" "$tmp_app_dir/"
[ -f "$etc_dir/web.xml" ] && cp "$etc_dir/web.xml" "$tmp_app_dir/WEB-INF/"

# Make sure classes and lib dirs exist
# [ -e "$tmp_app_dir/WEB-INF" ] && rm -fR "$tmp_app_dir/WEB-INF"
mkdir -p "$tmp_app_dir/WEB-INF/"{classes,lib}
cp -fR "$classes_dir/" "$tmp_app_dir/WEB-INF/classes/"
cp -fR "$lib_dir/" "$tmp_app_dir/WEB-INF/lib/"

echo 'OK'

echo 'Moving application to container directory...'
[ -e "$servlet_container_app" ] && rm -fR "$servlet_container_app"
mkdir -p "$servlet_container_app"
cp -fR "$tmp_app_dir/" "$servlet_container_app/"
[[ "$options" != *"--preserve-tmp"* ]] && rm -fR "$tmp_dir"
echo 'OK'

echo 'Done!'
