/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estacio.verifyid.model.actions;

import br.com.estacio.verifyid.model.BaseEntity;
import br.com.estacio.verifyid.model.service.AbstractService;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rafaelpevidor
 * @param <E>
 */
public abstract class AbstractAction <E extends BaseEntity> {
    
    @Deprecated
    public AbstractAction() {}
    
    public AbstractAction(AbstractService<E> service) {
        this.service = service;
    }
    
    @SuppressWarnings("unused")
    protected AbstractService<E> service;
    
    protected abstract E bind(final HttpServletRequest request);

    /**
     *
     * @param request
     * @param message
     */
    public void addMessage(final HttpServletRequest request, String message) {
        request.setAttribute("msg", message);
    }
    
    public void addMessageDeleteWithSuccess(final HttpServletRequest request) {
        addMessage(request, "Excluído com sucesso!");
    }
    
    public void addMessageAddWithSuccess(final HttpServletRequest request) {
        addMessage(request, "Inserido com sucesso!");
    }
    
    public void addMessageUpdateWithSuccess(final HttpServletRequest request) {
        addMessage(request, "Atualizado com sucesso!");
    }
    /**
     *
     * @param request
     * @param entity
     */
    public void addEntity(final HttpServletRequest request, final BaseEntity entity) {
        request.setAttribute("entity", entity);
    }
    
    /**
     *
     * @param request
     * @param entityCollection
     */
    public void addEntityCollection(final HttpServletRequest request, Collection<E> entityCollection) {
        request.setAttribute("records", entityCollection);
    }
    
    /**
     *
     * @param request
     * @return
     */
    public Integer getId(final HttpServletRequest request) {
        String id = request.getParameter("id");
        if (null != id && !id.isEmpty())
            return Integer.valueOf(id);
        else
            return null;
    }
}
