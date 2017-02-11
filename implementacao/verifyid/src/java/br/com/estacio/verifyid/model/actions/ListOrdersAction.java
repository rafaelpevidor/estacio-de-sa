/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.domain.Order;
import br.com.estacio.verifyid.model.enums.PageEnum;
import br.com.estacio.verifyid.model.service.OrderService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class ListOrdersAction extends AbstractAction<Order> implements BaseAction {

    public ListOrdersAction(OrderService service) {
        super(service);
    }
    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            addEntityCollection(request, service.getAll());
            return PageEnum.ORDERS_LIST.getJsp();
        } catch (Exception e) {
            addMessage(request, "Desculpe, houve um erro ao listar os clientes.");
            return PageEnum.HOME.getUrl();
        }
    }

    @Override
    protected Order bind(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
