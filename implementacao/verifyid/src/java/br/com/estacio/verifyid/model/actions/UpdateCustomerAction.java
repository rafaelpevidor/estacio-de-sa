/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.domain.Customer;
import br.com.estacio.verifyid.model.service.CustomerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class UpdateCustomerAction extends AbstractAction<Customer> implements BaseAction {

    public UpdateCustomerAction(CustomerService service) {
        super(service);
    }
    
    private Customer entity;
    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        entity = bind(request);
        service.update(entity);
        return "";
    }

    @Override
    protected Customer bind(HttpServletRequest request) {
        Customer customer = new Customer();
        customer.setCnpj((request.getParameter("cnpj")));
        customer.setEndereco((request.getParameter("endereco")));
        customer.setId(getId(request));
        customer.setNome((request.getParameter("nome")));
        customer.setRazaoSocial((request.getParameter("razaoSocial")));
        customer.setTelefone(request.getParameter("telefone"));
        
        return customer;
    }
    
}
