/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.dao.CustomerDAO;
import br.com.estacio.verifyid.model.domain.Customer;
import br.com.estacio.verifyid.model.service.CustomerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class DeleteCustomerAction extends AbstractAction<Customer> implements BaseAction {

    public DeleteCustomerAction(CustomerService service) {
        super(service);
    }
    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            service.remove(getId(request));
            addMessageDeleteWithSuccess(request);
        } catch (Exception e) {
            e.printStackTrace();
            addMessage(request, "Desculpe, houve um erro ao tentar remover o cliente");
        }
        
        return new ListCustomersAction(new CustomerService(new CustomerDAO())).processRequest(request, response);
    }

    @Override
    protected Customer bind(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
