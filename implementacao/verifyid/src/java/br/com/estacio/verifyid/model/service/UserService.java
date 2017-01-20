/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.service;

import br.com.estacio.verifyid.model.dao.UserDAO;
import br.com.estacio.verifyid.model.domain.User;
import java.util.List;

/**
 *
 * @author rafaelpevidor
 */
public class UserService implements BaseService<User> {
    
    @Deprecated
    public UserService() {
        this.dao = new UserDAO();
    }

    public UserService(UserDAO dao) {
        this.dao = dao;
    }
      
    private UserDAO dao;

    @Override
    public User add(User entidade) {
        return dao.add(entidade);
    }

    @Override
    public User update(User entidade) {
        return dao.update(entidade);
    }

    @Override
    public User get(User entidade) {
        return dao.get(entidade);
    }

    @Override
    public void remove(Integer entidadeId) {
        dao.remove(entidadeId);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }
    
    
    public User findByLoginAndPassword(String login, String password) {
        return dao.findByLoginAndPassword(login, password);
    }
}
