package com.example.entities;

import javax.persistence.*;

/**
 * Created by Eefret on 1/31/14.
 */


@Entity
@Table(name = "tbl_lote", schema = "", catalog = "jpatest")
public class TblLoteEntity {
    public int idlote;
    public String categoria;
    public String grupo;
    public String descripcion;

    @Id
    @Column(name = "idlote", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getIdlote() {
        return idlote;
    }

    public void setIdlote(int idlote) {
        this.idlote = idlote;
    }

    @Basic
    @Column(name = "categoria", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "grupo", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Basic
    @Column(name = "descripcion", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblLoteEntity that = (TblLoteEntity) o;

        if (idlote != that.idlote) return false;
        if (categoria != null ? !categoria.equals(that.categoria) : that.categoria != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idlote;
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }


}
