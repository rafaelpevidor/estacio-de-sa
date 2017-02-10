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
public class UserService extends AbstractService<User> implements BaseService {

    public UserService() {
        this.repository = new UserDAO();
    }
    
    public UserService(UserDAO repository) {
        super(repository);
    }
    
    @Override
    public User add(User entidade) {
        return repository.add(entidade);
    }

    @Override
    public User update(User entidade) {
        return repository.update(entidade);
    }

    @Override
    public User get(User entidade) {
        return repository.get(entidade);
    }

    @Override
    public void remove(Integer entidadeId) {
        repository.remove(entidadeId);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
    
    
    public User findByLoginAndPassword(String login, String password) {
        return ((UserDAO)repository).findByLoginAndPassword(login, password);
    }

    @Override
    public User get(Integer entidadeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
