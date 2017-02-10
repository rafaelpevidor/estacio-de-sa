/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.enums;

/**
 *
 * @author rafaelpevidor
 */
public enum PageEnum {
    LOGIN("/login", "/login.jsp"),
    HOME("/home", "/WEB-INF/view/home.jsp"),
    CUSTOMERS_LIST("/customer", "/WEB-INF/view/customer/list.jsp"),
    CUSTOMER_FORM("/customer/form", "/WEB-INF/view/customer/form.jsp"),
    ORDER_LIST("", "/WEB-INF/view/order/list.jsp"),
    ORDER_FORM("", "/WEB-INF/view/order/form.jsp"),
    PRODUCTION_ORDER_LIST("", "/WEB-INF/view/production-order/list.jsp"),
    PRODUCTION_ORDER_FORM("", "/WEB-INF/view/production-order/form.jsp")
    ;

    private PageEnum(String url, String page) {
        this.url = url;
        this.jsp = page;
    }
        
    private String url;
    private String jsp;

    public String getJsp() {
        return jsp;
    }
    
    public String getJsp(String contextPath) {
        return contextPath.concat(jsp);
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getUrl(String contextPath) {
        return contextPath.concat(url);
    }
}
