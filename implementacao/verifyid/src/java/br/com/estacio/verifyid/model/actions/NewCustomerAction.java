/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.domain.Customer;
import br.com.estacio.verifyid.model.enums.PageEnum;
import br.com.estacio.verifyid.model.service.AbstractService;
import br.com.estacio.verifyid.model.service.CustomerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class NewCustomerAction extends AbstractAction<Customer> implements BaseAction {

    public NewCustomerAction(CustomerService service) {
        super(service);
    }

    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        Customer entidade = new Customer();
        addEntity(request, entidade);
        return PageEnum.CUSTOMER_FORM.getJsp();
    }

    @Override
    protected Customer bind(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
