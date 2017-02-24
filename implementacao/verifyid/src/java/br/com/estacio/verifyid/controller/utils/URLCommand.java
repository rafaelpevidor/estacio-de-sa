package br.com.estacio.verifyid.controller.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Locale;

public class URLCommand {

    private static final String PATTERN;
    private static final Pattern pattern;

    static {
        PATTERN = "^/?(list|edit|remove|save)(?:/([^/]+))?/?$";
        pattern = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
    }

    private final String name;
    private final String value;

    private URLCommand(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private static URLCommand createCommand(Matcher matcher) {
        URLCommand command = null;
        String name = matcher.group(1);
        if (name != null) {
            String value = matcher.group(2);
            command = new URLCommand(name.toLowerCase(Locale.ENGLISH), value);
        }
        return command;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public long getValueAsLong() {
        long longValue = 0L;
        String value = this.value;
        if (value != null) {
            try {
                longValue = Long.parseLong(value, 10);
            } catch (NumberFormatException e) { /* Nothing to do... */ }
        }
        return longValue;
    }

    public static URLCommand parse(String command) {
        URLCommand result = null;
        if (command != null) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.matches()) {
                result = createCommand(matcher);
            }
        }
        return result;
    }

}
