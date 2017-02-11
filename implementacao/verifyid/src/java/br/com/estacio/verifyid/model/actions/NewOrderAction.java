/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.domain.Order;
import br.com.estacio.verifyid.model.enums.PageEnum;
import br.com.estacio.verifyid.model.service.AbstractService;
import br.com.estacio.verifyid.model.service.OrderService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelpevidor
 */
public class NewOrderAction extends AbstractAction<Order> implements BaseAction {

    public NewOrderAction(OrderService service) {
        super(service);
    }

    
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        Order entidade = service.get(getId(request));
        addEntity(request, entidade);
        return PageEnum.ORDER_FORM.getJsp();
    }

    @Override
    protected Order bind(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
