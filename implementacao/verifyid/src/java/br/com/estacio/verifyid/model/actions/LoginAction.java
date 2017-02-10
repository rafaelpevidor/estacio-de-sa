/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.domain.User;
import br.com.estacio.verifyid.model.enums.ActionEnum;
import br.com.estacio.verifyid.model.enums.PageEnum;
import br.com.estacio.verifyid.model.service.UserService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class LoginAction implements BaseAction {

    @SuppressWarnings("FieldMayBeFinal")
    private UserService service;
    
    public LoginAction(UserService userService) {
        service = userService;
    }

    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {   
        execute(request, response);
        return null;
    }
    
    @SuppressWarnings("UnusedAssignment")
    private void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = null;
        
        if (null != (user = (User) request.getSession(true).getAttribute("user"))) {
            try {
                response.sendRedirect(ActionEnum.HOME.getPath(request.getContextPath()));
            } catch (IOException ex) {
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");  
        
        UserService service = new UserService();
        user = service.findByLoginAndPassword(login, password);
        
        if (null == user) {
            request.setAttribute("msg", "Não foi possível efetuar o login. Verifique usuário e senha.");
            try {  
                request.getRequestDispatcher(PageEnum.LOGIN.getJsp()).forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.getSession().setAttribute("user", user);
                response.sendRedirect(ActionEnum.HOME.getPath(request.getContextPath()));
            } catch (IOException ex) {
                Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
