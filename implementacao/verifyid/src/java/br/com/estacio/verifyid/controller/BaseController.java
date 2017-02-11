/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.model.actions.AddCustomerAction;
import br.com.estacio.verifyid.model.actions.AddOrderAction;
import br.com.estacio.verifyid.model.actions.BaseAction;
import br.com.estacio.verifyid.model.actions.DeleteCustomerAction;
import br.com.estacio.verifyid.model.actions.DeleteOrderAction;
import br.com.estacio.verifyid.model.actions.EditCustomerAction;
import br.com.estacio.verifyid.model.actions.EditOrderAction;
import br.com.estacio.verifyid.model.actions.HomeAction;
import br.com.estacio.verifyid.model.actions.ListCustomersAction;
import br.com.estacio.verifyid.model.actions.ListOrdersAction;
import br.com.estacio.verifyid.model.actions.LoginAction;
import br.com.estacio.verifyid.model.actions.NewCustomerAction;
import br.com.estacio.verifyid.model.actions.NewOrderAction;
import br.com.estacio.verifyid.model.actions.UpdateCustomerAction;
import br.com.estacio.verifyid.model.actions.UpdateOrderAction;
import br.com.estacio.verifyid.model.dao.CustomerDAO;
import br.com.estacio.verifyid.model.dao.OrderDAO;
import br.com.estacio.verifyid.model.dao.UserDAO;
import br.com.estacio.verifyid.model.enums.ActionEnum;
import br.com.estacio.verifyid.model.service.CustomerService;
import br.com.estacio.verifyid.model.service.OrderService;
import br.com.estacio.verifyid.model.service.UserService;
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
    
    private Map<String, BaseAction> actions;

    //TODO: adicionar ao mapa as ações que forem sendo criadas
    private Map<String, BaseAction> getActions() {
        if (null == actions) {
            actions = new HashMap<>();
            actions.put(ActionEnum.LOGIN.getPath(), new LoginAction(new UserService(new UserDAO())));
            actions.put(ActionEnum.HOME.getPath(), new HomeAction());
            actions.put(ActionEnum.ADD_CUSTOMER.getPath(), new AddCustomerAction(new CustomerService(new CustomerDAO())));
            actions.put(ActionEnum.DELETE_CUSTOMER.getPath(), new DeleteCustomerAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.EDIT_CUSTOMER.getPath(), new EditCustomerAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.LIST_CUSTOMERS.getPath(), new ListCustomersAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.UPDATE_CUSTOMER.getPath(), new UpdateCustomerAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.NEW_CUSTOMER.getPath(), new NewCustomerAction((new CustomerService(new CustomerDAO()))));
            actions.put(ActionEnum.ADD_ORDER.getPath(), new AddOrderAction(new OrderService(new OrderDAO())));
            actions.put(ActionEnum.DELETE_ORDER.getPath(), new DeleteOrderAction((new OrderService(new OrderDAO()))));
            actions.put(ActionEnum.EDIT_ORDER.getPath(), new EditOrderAction((new OrderService(new OrderDAO()))));
            actions.put(ActionEnum.LIST_ORDERS.getPath(), new ListOrdersAction((new OrderService(new OrderDAO()))));
            actions.put(ActionEnum.UPDATE_ORDER.getPath(), new UpdateOrderAction((new OrderService(new OrderDAO()))));
            actions.put(ActionEnum.NEW_ORDER.getPath(), new NewOrderAction((new OrderService(new OrderDAO()))));
        }
        return actions;
    }
    
    public void forward(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(page).forward(request, response);
    }
    
    public void redirect(String page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(page);
    }
    
    public BaseAction getAction(String userPath) {
       return getActions().get(userPath);
    }
}
