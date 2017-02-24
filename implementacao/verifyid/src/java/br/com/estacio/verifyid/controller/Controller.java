
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.controller.utils.URLCommand;
import br.com.estacio.verifyid.controller.exceptions.NotFoundException;
import br.com.estacio.verifyid.controller.exceptions.BadRequestException;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emanuel F. Oliveira
 */
public abstract class Controller extends HttpServlet {

    public abstract void processRequest(URLCommand command, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException;

    public void doProcessRequest(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        try {
            URLCommand command = URLCommand.parse(request.getPathInfo());
            this.processRequest(command, request, response);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/templates/main.jsp");
            view.forward(request, response);
        } catch (NotFoundException e) {
        } catch (BadRequestException e) {
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        this.doProcessRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        this.doProcessRequest(request, response);
    }

}
