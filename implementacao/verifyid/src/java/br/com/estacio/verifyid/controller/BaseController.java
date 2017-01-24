/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.model.actions.AddCustomerAction;
import br.com.estacio.verifyid.model.actions.BaseAction;
import br.com.estacio.verifyid.model.actions.DeleteCustomerAction;
import br.com.estacio.verifyid.model.actions.EditCustomerAction;
import br.com.estacio.verifyid.model.actions.ListCustomersAction;
import br.com.estacio.verifyid.model.actions.UpdateCustomerAction;
import br.com.estacio.verifyid.model.dao.CustomerDAO;
import br.com.estacio.verifyid.model.enums.ActionEnum;
import br.com.estacio.verifyid.model.service.CustomerService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public abstract class BaseController extends HttpServlet {
    
    protected static final String HOME_PAGE = "/WEB-INF/view/home.jsp";
    
    private Map<String, BaseAction> actions;

    //TODO: adicionar ao mapa as ações que forem sendo criadas
    protected Map<String, BaseAction> getActions() {
        if (null == actions) {
            actions = new HashMap<>();
            actions.put(ActionEnum.ADD_CUSTOMER.getPath(), new AddCustomerAction(new CustomerService(new CustomerDAO())));
            actions.put(ActionEnum.DELETE_CUSTOMER.getPath(), new DeleteCustomerAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.EDIT_CUSTOMER.getPath(), new EditCustomerAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.LIST_CUSTOMERS.getPath(), new ListCustomersAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.UPDATE_CUSTOMER.getPath(), new UpdateCustomerAction((new CustomerService(new CustomerDAO()))));
        }
        return actions;
    }
    
    public void forward(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(page).forward(request, response);
    }
}
