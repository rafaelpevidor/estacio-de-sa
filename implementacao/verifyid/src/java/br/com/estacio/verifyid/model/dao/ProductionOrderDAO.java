/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.dao;

import br.com.estacio.verifyid.model.domain.ProductionOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rafaelpevidor
 */
public class ProductionOrderDAO implements BaseDAO<ProductionOrder> {

    private Map<Integer, ProductionOrder> records = new HashMap<>();

    @Override
    public ProductionOrder add(ProductionOrder entidade) {
        entidade.setId(records.size()+1);
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public ProductionOrder update(ProductionOrder entidade) {
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public ProductionOrder get(ProductionOrder entidade) {
        return records.get(entidade.getId());
    }

    @Override
    public void remove(Integer entidadeId) {
        records.remove(entidadeId);
    }

    @Override
    public List<ProductionOrder> getAll() {
        List<ProductionOrder> out = new ArrayList<>();
        out.addAll(records.values());
        return out;
    }
  
    @Override
    public ProductionOrder get(Integer entidadeId) {
       return records.get(entidadeId);
    }
    
}
