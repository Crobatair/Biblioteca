/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ale
 */
@Entity
@Table(name = "estado_ejemplar", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEjemplar.findAll", query = "SELECT e FROM EstadoEjemplar e"),
    @NamedQuery(name = "EstadoEjemplar.findByIdEstadoEjemplar", query = "SELECT e FROM EstadoEjemplar e WHERE e.idEstadoEjemplar = :idEstadoEjemplar"),
    @NamedQuery(name = "EstadoEjemplar.findByEstado", query = "SELECT e FROM EstadoEjemplar e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstadoEjemplar.findByDescripcion", query = "SELECT e FROM EstadoEjemplar e WHERE e.descripcion = :descripcion")})
public class EstadoEjemplar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_ejemplar", nullable = false)
    private Integer idEstadoEjemplar;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 255)
    private String estado;
    @Column(name = "descripcion", length = 2147483647)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoEjemplar")
    private List<Ejemplar> ejemplarList;

    public EstadoEjemplar() {
    }

    public EstadoEjemplar(Integer idEstadoEjemplar) {
        this.idEstadoEjemplar = idEstadoEjemplar;
    }

    public EstadoEjemplar(Integer idEstadoEjemplar, String estado) {
        this.idEstadoEjemplar = idEstadoEjemplar;
        this.estado = estado;
    }

    public Integer getIdEstadoEjemplar() {
        return idEstadoEjemplar;
    }

    public void setIdEstadoEjemplar(Integer idEstadoEjemplar) {
        this.idEstadoEjemplar = idEstadoEjemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Ejemplar> getEjemplarList() {
        return ejemplarList;
    }

    public void setEjemplarList(List<Ejemplar> ejemplarList) {
        this.ejemplarList = ejemplarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoEjemplar != null ? idEstadoEjemplar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEjemplar)) {
            return false;
        }
        EstadoEjemplar other = (EstadoEjemplar) object;
        if ((this.idEstadoEjemplar == null && other.idEstadoEjemplar != null) || (this.idEstadoEjemplar != null && !this.idEstadoEjemplar.equals(other.idEstadoEjemplar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.EstadoEjemplar[ idEstadoEjemplar=" + idEstadoEjemplar + " ]";
    }
    
}
