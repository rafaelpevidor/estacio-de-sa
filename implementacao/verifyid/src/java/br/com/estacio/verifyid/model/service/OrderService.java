/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.service;

import br.com.estacio.verifyid.model.dao.OrderDAO;
import br.com.estacio.verifyid.model.domain.Order;
import java.util.List;

/**
 *
 * @author rafaelpevidor
 */
public class OrderService extends AbstractService<Order> implements BaseService {

    public OrderService(OrderDAO repository) {
        super(repository);
    }
    
    @Override
    public Order add(Order entidade) {
        return repository.add(entidade);
    }

    @Override
    public Order update(Order entidade) {
        return repository.update(entidade);
    }

    @Override
    public Order get(Order entidade) {
        return repository.get(entidade.getId());
    }

    @Override
    public void remove(Integer entidadeId) {
        repository.remove(entidadeId);
    }

    @Override
    public List<Order> getAll() {
        return repository.getAll();
    }

    @Override
    public Order get(Integer entidadeId) {
        return repository.get(entidadeId);
    }
    
}
