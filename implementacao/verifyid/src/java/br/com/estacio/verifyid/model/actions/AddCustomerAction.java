/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.domain.Customer;
import br.com.estacio.verifyid.model.enums.PageEnum;
import br.com.estacio.verifyid.model.service.CustomerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class AddCustomerAction extends AbstractAction<Customer> implements BaseAction {

    public AddCustomerAction(CustomerService service) {
        super(service);
    }
    
    private Customer entidade;
    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
       
        try {
            entidade = bind(request);
            service.add(entidade);
            
        } catch (Exception e) {
            addMessage(request, "Desculpe, houve um erro ao salvar o cliente.");
            
        }
        
        return PageEnum.CUSTOMERS_LIST.getUrl();
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
