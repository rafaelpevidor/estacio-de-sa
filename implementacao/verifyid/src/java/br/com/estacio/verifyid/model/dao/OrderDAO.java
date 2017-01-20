/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.dao;

import br.com.estacio.verifyid.model.domain.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rafaelpevidor
 */
public class OrderDAO implements BaseDAO<Order> {

    private Map<Integer, Order> records = new HashMap<>();

    @Override
    public Order add(Order entidade) {
        entidade.setId(records.size()+1);
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public Order update(Order entidade) {
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public Order get(Order entidade) {
        return records.get(entidade.getId());
    }

    @Override
    public void remove(Integer entidadeId) {
        records.remove(entidadeId);
    }

    @Override
    public List<Order> getAll() {
        List<Order> out = new ArrayList<>();
        out.addAll(records.values());
        return out;
    }
    
}
