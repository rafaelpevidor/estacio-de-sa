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
    SAVE, UPDATE, DELETE, LIST, EDIT;

    public static ActionEnum findById(Integer id) {
        for (ActionEnum action : ActionEnum.values()) {
            if (action.ordinal() == id)
                return action;
        }
        return null;
    }
}
