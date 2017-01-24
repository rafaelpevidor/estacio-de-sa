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
    HOME("/WEB-INF/view/home.jsp"),
    CUSTOMERS_LIST("/WEB-INF/view/customer/list.jsp"),
    CUSTOMER_FORM("/WEB-INF/view/customer/form.jsp"),
    ORDER_LIST("/WEB-INF/view/order/list.jsp"),
    ORDER_FORM("/WEB-INF/view/order/form.jsp"),
    PRODUCTION_ORDER_LIST("/WEB-INF/view/production-order/list.jsp"),
    PRODUCTION_ORDER_FORM("/WEB-INF/view/production-order/form.jsp")
    ;

    private PageEnum(String page) {
        this.url = page;
    }
        
    private String url;

    public String getUrl() {
        return url;
    }
}
