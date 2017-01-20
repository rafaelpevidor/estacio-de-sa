/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.model.enums.ActionEnum;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author rafaelpevidor
 */
public abstract class BaseController extends HttpServlet {
    
    private Map<Integer, ActionEnum> actions;

    public Map<Integer, ActionEnum> getActions() {
        if (null == actions) {
            actions = new HashMap<>();
            actions.put(ActionEnum.SAVE.ordinal(), ActionEnum.SAVE);
            actions.put(ActionEnum.DELETE.ordinal(), ActionEnum.DELETE);
            actions.put(ActionEnum.EDIT.ordinal(), ActionEnum.EDIT);
            actions.put(ActionEnum.UPDATE.ordinal(), ActionEnum.UPDATE);
            actions.put(ActionEnum.LIST.ordinal(), ActionEnum.LIST);
        }
        return actions;
    }   
}
