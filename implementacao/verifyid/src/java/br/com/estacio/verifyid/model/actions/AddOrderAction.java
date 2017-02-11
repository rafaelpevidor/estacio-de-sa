/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.dao.OrderDAO;
import br.com.estacio.verifyid.model.domain.Order;
import br.com.estacio.verifyid.model.enums.PageEnum;
import br.com.estacio.verifyid.model.service.OrderService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class AddOrderAction extends AbstractAction<Order> implements BaseAction {

    public AddOrderAction(OrderService service) {
        super(service);
    }
    
    private Order entidade;
    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
       
        try {
            entidade = bind(request);
            if (null == entidade.getId())
                service.add(entidade);
            else
                service.update(entidade);
            addMessageAddWithSuccess(request);
            return new ListOrdersAction(new OrderService(new OrderDAO())).processRequest(request, response);
        } catch (Exception e) {
            addMessage(request, "Desculpe, houve um erro ao salvar o cliente.");
            e.printStackTrace();
            return PageEnum.ORDER_FORM.getUrl();
        }
    }

    @Override
    protected Order bind(HttpServletRequest request) {
        Order customer = new Order();
        customer.setNomeCliente((request.getParameter("nome")));
        customer.setQuantidade(Integer.valueOf((request.getParameter("quantidade"))));
        customer.setStatus((request.getParameter("status")));
        
        return customer;
    }
}
