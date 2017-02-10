/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.dao;

import br.com.estacio.verifyid.model.domain.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rafaelpevidor
 */
public class UserDAO implements BaseDAO<User> {
    
    @SuppressWarnings("FieldMayBeFinal")
    private Map<Integer, User> records = new HashMap<>();

    public UserDAO() {
       if (records.isEmpty())
        populate();
    }

    @Override
    public User add(User entidade) {
        entidade.setId(records.size()+1);
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public User update(User entidade) {
        records.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public User get(User entidade) {
        return records.get(entidade.getId());
    }

    @Override
    public void remove(Integer entidadeId) {
        records.remove(entidadeId);
    }

    @Override
    public List<User> getAll() {
        List<User> out = new ArrayList<>();
        out.addAll(records.values());
        return out;
    }
    
    public User findByLoginAndPassword(String login, String password) {
        for (User user : records.values()) {
            if (((user.getLogin().equals(login)) && (user.getSenha().equals(password))))
                return user;
        }
        return null;
    }
    
    private void populate() {
        records.put(1, new User(1, "Rafael Pevidor", "rafaelpevidor@gmail.com", "123456"));
        records.put(2, new User(2, "Emanuel Fiuza", "emfolg@gmail.com", "123456"));
        records.put(3, new User(3, "Cleiton Luiz", "cleitonlsouza@gmail.com", "123456"));
        records.put(4, new User(4, "Matheus Godoi", "matheusadvs@gmail.com", "123456"));
        records.put(5, new User(5, "Professor", "professor@gmail.com", "123456"));
    }
    
}
