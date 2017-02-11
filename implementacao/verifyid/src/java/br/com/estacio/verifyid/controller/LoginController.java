/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.model.actions.LoginAction;
import br.com.estacio.verifyid.model.domain.User;
import br.com.estacio.verifyid.model.enums.ActionEnum;
import br.com.estacio.verifyid.model.enums.PageEnum;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
//@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends BaseController {

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
        User user = null;
        
        if (null != (user = (User) request.getSession(true).getAttribute("user"))) {
            try {
                redirect(ActionEnum.HOME.getPath(request.getContextPath()), request, response);
                return;
            } catch (IOException ex) {
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            redirect(PageEnum.LOGIN.getJsp(request.getContextPath()), request, response);
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
    @SuppressWarnings("UnusedAssignment")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        String page = getAction(userPath).processRequest(request, response);
        
        if (null != page)
            redirect(page, request, response);
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
