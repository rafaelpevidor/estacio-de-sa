/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.dao;

import br.com.estacio.verifyid.model.domain.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rafaelpevidor
 */
public class CustomerDAO implements BaseDAO<Customer> {
    
    @SuppressWarnings("FieldMayBeFinal")
    private Map<Integer, Customer> records = new HashMap<>();

    @Override
    public Customer add(Customer entidade) {
        entidade.setId(records.size()+1);
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public Customer update(Customer entidade) {
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public Customer get(Customer entidade) {
        return records.get(entidade.getId());
    }

    @Override
    public void remove(Integer entidadeId) {
        if (!records.isEmpty() && records.size() > 1)
            records.remove(entidadeId);
        else
            records = new HashMap<>();
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> out = new ArrayList<>();
        out.addAll(records.values());
        return out;
    }

    @Override
    public Customer get(Integer entidadeId) {
        return records.get(entidadeId);
    }
 
    private void populate() {
        Customer customer = new Customer();
        customer.setCnpj("26955865000/03");
        customer.setEndereco("Rua Benjamim Rodrigues 300");
        customer.setId(1);
        customer.setNome("Coca-cola");
        customer.setRazaoSocial("Coca-cola");
        customer.setTelefone("2530-2530");
        records.put(1, customer);
    }
}
