/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.enums.PageEnum;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class HomeAction implements BaseAction {

    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        return PageEnum.HOME.getJsp();
    }
    
}
