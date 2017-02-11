/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.model.enums.ActionEnum;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
//@WebServlet(name = "CustomerController", urlPatterns = {"/customer", "/customer/add", "/customer/edit", "/customer/remove", "/customer/update", "/customer/new"})
public class CustomerController extends BaseController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        ActionEnum actionToExecute = ActionEnum.findByPath(userPath);
        
        if (
                (actionToExecute.equals(ActionEnum.ADD_CUSTOMER))||
                (actionToExecute.equals(ActionEnum.UPDATE_CUSTOMER))
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

        /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String userPath = request.getServletPath();
       ActionEnum actionToExecute = ActionEnum.findByPath(userPath);
       
       if (!
                (actionToExecute.equals(ActionEnum.ADD_CUSTOMER))||
                (actionToExecute.equals(ActionEnum.UPDATE_CUSTOMER))
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
