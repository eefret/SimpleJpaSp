package com.example.mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.entities.TblLoteEntity;
import com.example.util.JPAUTIL;

/**
 * Created by Eefret on 1/31/14.
 */
@ManagedBean
@ViewScoped
public class IndexBean implements Serializable{

    private String idLote;
    private String categoria;
    private String grupo;
    List<TblLoteEntity> datatableList = new ArrayList<TblLoteEntity>();

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public List<TblLoteEntity> getDatatableList() {
        return datatableList;
    }

    public void setDatatableList(List<TblLoteEntity> datatableList) {
        this.datatableList = datatableList;
    }

    public void consultarLotes(){
        EntityManagerFactory emf = JPAUTIL.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try{
            datatableList =  em.createNativeQuery("{call P_GET_LOTE(?,?,?)}", TblLoteEntity.class)
                    .setParameter(1,getIdLote())
                    .setParameter(2,getCategoria())
                    .setParameter(3,getGrupo()).getResultList();

          /* datatableList = em.createNamedQuery("spgetlote",TblLoteEntity.class)
                    .setParameter("pidlote", getIdLote())
                    .setParameter("pcategoria",getCategoria())
                    .setParameter("pgrupo",getGrupo()).getResultList();*/
        }catch(Exception ex){
            ex.printStackTrace();
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null,new FacesMessage("hello ", ex.getMessage()));
        }




    }
}
