/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.domain;

import br.com.estacio.verifyid.model.BaseEntity;

/**
 *
 * @author rafaelpevidor
 */
public class Order implements BaseEntity{

    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
}
