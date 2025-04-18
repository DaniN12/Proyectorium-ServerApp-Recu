/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorium.crud.services;

import proyectorium.crud.entities.ProviderEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import proyectorium.crud.exceptions.CreateException;
import proyectorium.crud.exceptions.DeleteException;
import proyectorium.crud.exceptions.ReadException;
import proyectorium.crud.exceptions.UpdateException;
import javax.persistence.TypedQuery;

import proyectorium.crud.entities.ProviderEntity;

/**
 *
 * @author 2dam
 */
@Stateless
@Path("proyectorium.crud.entities.provider")
public class ProviderEntityFacadeREST extends AbstractFacade<ProviderEntity> {

    @PersistenceContext(unitName = "CRUDProyectoriumPU")
    private EntityManager em;

    public ProviderEntityFacadeREST() {
        super(ProviderEntity.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(ProviderEntity entity) {
        try {
            super.create(entity);
        } catch (CreateException ex) {
            Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Long id, ProviderEntity entity) {
        try {
            super.edit(entity);
        } catch (UpdateException ex) {
            Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            try {
                super.remove(super.find(id));
            } catch (DeleteException ex) {
                Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ReadException ex) {
            Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public ProviderEntity find(@PathParam("id") Long id) {
        try {
            return super.find(id);
        } catch (ReadException ex) {
            Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML})
    public List<ProviderEntity> findAll() {
        try {
            return super.findAll();
        } catch (ReadException ex) {
            Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public List<ProviderEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        try {
            return super.findRange(new int[]{from, to});
        } catch (ReadException ex) {
            Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        try {
            return String.valueOf(super.count());
        } catch (ReadException ex) {
            Logger.getLogger(ProviderEntityFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Método para listar por 'contract init'
    @GET
    @Path("listByContractInit")
    @Produces({MediaType.APPLICATION_XML})
    public List<ProviderEntity> listByContractInit() {
        TypedQuery<ProviderEntity> query = em.createNamedQuery("listByContractInit", ProviderEntity.class);
        return query.getResultList();
    }

    // Método para listar por 'contract end'
    @GET
    @Path("listByContractEnd")
    @Produces({MediaType.APPLICATION_XML})
    public List<ProviderEntity> listByContractEnd() {
        TypedQuery<ProviderEntity> query = em.createNamedQuery("listByContractEnd", ProviderEntity.class);
        return query.getResultList();
    }

    // Método para listar por 'price'
    @GET
    @Path("listByPrice")
    @Produces({MediaType.APPLICATION_XML})
    public List<ProviderEntity> listByPrice() {
        TypedQuery<ProviderEntity> query = em.createNamedQuery("listByPrice", ProviderEntity.class);
        return query.getResultList();
    }
    
    //Método para lista por contratos Activos
    @GET
    @Path("listByActiveContract")
    @Produces({MediaType.APPLICATION_XML})
    public List<ProviderEntity> listActiveContracts() {
        TypedQuery<ProviderEntity> query = em.createNamedQuery("listActiveContracts", ProviderEntity.class);
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
