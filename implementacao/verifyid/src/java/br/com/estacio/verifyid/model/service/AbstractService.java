/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.service;

import br.com.estacio.verifyid.model.dao.BaseDAO;
import br.com.estacio.verifyid.model.domain.BaseEntity;
import java.util.List;

/**
 *
 * @author rafaelpevidor
 * @param <E>
 */
public abstract class AbstractService <E extends BaseEntity> {

    @Deprecated
    public AbstractService() {}
    
    public AbstractService(BaseDAO<E> repository) {
        this.repository = repository;
    }
    
    protected BaseDAO<E> repository;

    public abstract E add(E entidade);
    public abstract E update(E entidade);
    public abstract E get(E entidade);
    public abstract E get(Integer entidadeId);
    public abstract void remove(Integer entidadeId);
    public abstract List<E> getAll();
}
