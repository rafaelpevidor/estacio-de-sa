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
public class UpdateOrderAction extends AbstractAction<Order> implements BaseAction {

    public UpdateOrderAction(OrderService service) {
        super(service);
    }
    
    private Order entity;
    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            entity = bind(request);
            service.update(entity);
            return new ListOrdersAction(new OrderService(new OrderDAO())).processRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            addMessage(request, "Desculpe, houve um erro ao atualizar o pedido.");
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
