/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.service;

import br.com.estacio.verifyid.model.BaseEntity;
import java.util.List;

/**
 *
 * @author rafaelpevidor
 */
public interface BaseService <E extends BaseEntity> {
    
    public E add(E entidade);
    public E update(E entidade);
    public E get(E entidade);
    public void remove(Integer entidadeId);
    public List<E> getAll();
}
