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
public enum ActionEnum {
    
    HOME("/home"),
    LOGIN("/login"),
    ADD_CUSTOMER("/customer/add"),
    DELETE_CUSTOMER("/customer/remove"),
    EDIT_CUSTOMER("/customer/edit"),
    LIST_CUSTOMERS("/customer"),
    UPDATE_CUSTOMER("/customer/update"),
    NEW_CUSTOMER("/customer/new"),
    ADD_ORDER("/order/add"),
    DELETE_ORDER("/order/remove"),
    EDIT_ORDER("/order/edit"),
    LIST_ORDERS("/order"),
    UPDATE_ORDER("/order/update"),
    NEW_ORDER("/order/new")
    ;
    
    private ActionEnum(String path) {
        this.path = path;
    }
    
    @SuppressWarnings("FieldMayBeFinal")
    private String path;

    public String getPath() {
        return path;
    }
    
    public String getPath(String contextPath) {
        return contextPath.concat(path);
    }
    
    public static ActionEnum findByPath(String path) {
        for (ActionEnum action : ActionEnum.values()) {
            if (action.getPath().equalsIgnoreCase(path))
                return action;
        }
        return null;
    }
}
