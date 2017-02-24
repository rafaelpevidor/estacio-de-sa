
package br.com.estacio.verifyid.controller;

import br.com.estacio.verifyid.controller.utils.URLCommand;
import br.com.estacio.verifyid.controller.exceptions.NotFoundException;
import br.com.estacio.verifyid.controller.exceptions.BadRequestException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emanuel F. Oliveira
 */
public class MyController extends Controller {

    public void processRequest(URLCommand command, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        request.setAttribute("Controller", "MyController");
    }

}
