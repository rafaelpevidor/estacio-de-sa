/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.model.dao.OrderDAO;
import br.com.estacio.verifyid.model.domain.Order;
import br.com.estacio.verifyid.model.enums.ActionEnum;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
//@WebServlet(name = "OrderController", urlPatterns = {"/order", "/order/add", "/order/edit", "/order/remove", "/order/update", "/order/new"})
public class OrderController extends BaseController {

    private static final long serialVersionUID = 1L;
    
    private OrderDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String userPath = request.getServletPath();
        ActionEnum actionToExecute = ActionEnum.findByPath(userPath);
        
        if (
                (actionToExecute.equals(ActionEnum.ADD_ORDER))||
                (actionToExecute.equals(ActionEnum.UPDATE_ORDER))
        ) {
            throw new ServletException("Ação inválida!");
        }
        
        try {
            String page = getAction(userPath).processRequest(request, response);
            System.out.println(page);
            forward(page, request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userPath = request.getServletPath();
       ActionEnum actionToExecute = ActionEnum.findByPath(userPath);
       
       if (!
                (actionToExecute.equals(ActionEnum.ADD_ORDER))||
                (actionToExecute.equals(ActionEnum.UPDATE_ORDER))
        ) {
            throw new ServletException("Ação inválida!");
        }
       
       try {
            String page = getAction(userPath).processRequest(request, response);
            forward(page, request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}
