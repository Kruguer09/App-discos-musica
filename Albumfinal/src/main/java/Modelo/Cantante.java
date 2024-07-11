/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Conti
 */
@Entity
@Table(name = "cantante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cantante.findAll", query = "SELECT c FROM Cantante c"),
    @NamedQuery(name = "Cantante.findByNumcan", query = "SELECT c FROM Cantante c WHERE c.numcan = :numcan"),
    @NamedQuery(name = "Cantante.findByNombre", query = "SELECT c FROM Cantante c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cantante.findByNacionalidad", query = "SELECT c FROM Cantante c WHERE c.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Cantante.findByEdad", query = "SELECT c FROM Cantante c WHERE c.edad = :edad")})
public class Cantante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numcan")
    private Integer numcan;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "edad")
    private Integer edad;
    @OneToMany(mappedBy = "numcan")
    private List<Album> albumList;

    public Cantante() {
    }

    public Cantante(Integer numcan) {
        this.numcan = numcan;
    }

    public Cantante(Integer numcan, String nombre, String nacionalidad, Integer edad) {
        this.numcan = numcan;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.albumList = albumList;
    }
     
    public Cantante(Integer numcan, String nombre, String nacionalidad) {
        this.numcan = numcan;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public Integer getNumcan() {
        return numcan;
    }

    public void setNumcan(Integer numcan) {
        this.numcan = numcan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcan != null ? numcan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cantante)) {
            return false;
        }
        Cantante other = (Cantante) object;
        if ((this.numcan == null && other.numcan != null) || (this.numcan != null && !this.numcan.equals(other.numcan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Cantante[ numcan=" + numcan + " ]";
    }
    
}
