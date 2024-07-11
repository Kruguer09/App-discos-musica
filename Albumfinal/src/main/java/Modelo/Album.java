/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Conti
 */
@Entity
@Table(name = "album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByNumalbum", query = "SELECT a FROM Album a WHERE a.numalbum = :numalbum"),
    @NamedQuery(name = "Album.findByTitulo", query = "SELECT a FROM Album a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Album.findByPrecio", query = "SELECT a FROM Album a WHERE a.precio = :precio"),
    @NamedQuery(name = "Album.findByCategoria", query = "SELECT a FROM Album a WHERE a.categoria = :categoria")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numalbum")
    private Integer numalbum;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "categoria")
    private String categoria;
    @JoinColumn(name = "numcan", referencedColumnName = "numcan")
    @ManyToOne
    private Cantante numcan;

    public Album() {
    }

    public Album(Integer numalbum, String titulo, Integer precio, String categoria, Cantante numcan) {
        this.numalbum = numalbum;
        this.titulo = titulo;
        this.precio = precio;
        this.categoria = categoria;
        this.numcan = numcan;
    }
    
    public Album(Integer numalbum) {
        this.numalbum = numalbum;
    }

    public Album(Integer numalbum, String titulo) {
        this.numalbum = numalbum;
        this.titulo = titulo;
    }

    public Integer getNumalbum() {
        return numalbum;
    }

    public void setNumalbum(Integer numalbum) {
        this.numalbum = numalbum;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cantante getNumcan() {
        return numcan;
    }

    public void setNumcan(Cantante numcan) {
        this.numcan = numcan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numalbum != null ? numalbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.numalbum == null && other.numalbum != null) || (this.numalbum != null && !this.numalbum.equals(other.numalbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Album[ numalbum=" + numalbum + " ]";
    }
    
}
