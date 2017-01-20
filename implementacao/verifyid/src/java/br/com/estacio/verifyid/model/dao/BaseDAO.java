/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.dao;

import java.util.List;
import br.com.estacio.verifyid.model.BaseEntity;

/**
 *
 * @author rafaelpevidor
 */
public interface BaseDAO <E extends BaseEntity> {
    
    public E add(E entidade);
    public E update(E entidade);
    public E get(E entidade);
    public void remove(Integer entidadeId);
    public List<E> getAll();
}
