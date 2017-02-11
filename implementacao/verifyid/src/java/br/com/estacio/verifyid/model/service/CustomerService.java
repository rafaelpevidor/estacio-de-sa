/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.service;

import br.com.estacio.verifyid.model.dao.CustomerDAO;
import br.com.estacio.verifyid.model.domain.Customer;
import java.util.List;

/**
 *
 * @author rafaelpevidor
 */
public class CustomerService extends AbstractService<Customer> implements BaseService {

    public CustomerService(CustomerDAO repository) {
        super(repository);
    }
    
    @Override
    public Customer add(Customer entidade) {
        return repository.add(entidade);
    }

    @Override
    public Customer update(Customer entidade) {
        return repository.update(entidade);
    }

    @Override
    public Customer get(Customer entidade) {
        return repository.get(entidade.getId());
    }

    @Override
    public void remove(Integer entidadeId) {
        repository.remove(entidadeId);
    }

    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }

    @Override
    public Customer get(Integer entidadeId) {
        return repository.get(entidadeId);
    }
    
}
