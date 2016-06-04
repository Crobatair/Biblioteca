/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ale
 */
@Entity
@Table(name = "prestamo", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByIdPrestamo", query = "SELECT p FROM Prestamo p WHERE p.idPrestamo = :idPrestamo"),
    @NamedQuery(name = "Prestamo.findByTimestampRegistroPrestamo", query = "SELECT p FROM Prestamo p WHERE p.timestampRegistroPrestamo = :timestampRegistroPrestamo"),
    @NamedQuery(name = "Prestamo.findByObservaciones", query = "SELECT p FROM Prestamo p WHERE p.observaciones = :observaciones")})
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestamo", nullable = false)
    private Integer idPrestamo;
    @Basic(optional = false)
    @Column(name = "timestamp_registro_prestamo", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampRegistroPrestamo;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "usuario_sistema", referencedColumnName = "usuario_sistema", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioSistema usuarioSistema;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamo")
    private List<DetallePrestamo> detallePrestamoList;

    public Prestamo() {
    }

    public Prestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo(Integer idPrestamo, Date timestampRegistroPrestamo) {
        this.idPrestamo = idPrestamo;
        this.timestampRegistroPrestamo = timestampRegistroPrestamo;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getTimestampRegistroPrestamo() {
        return timestampRegistroPrestamo;
    }

    public void setTimestampRegistroPrestamo(Date timestampRegistroPrestamo) {
        this.timestampRegistroPrestamo = timestampRegistroPrestamo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public UsuarioSistema getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(UsuarioSistema usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<DetallePrestamo> getDetallePrestamoList() {
        return detallePrestamoList;
    }

    public void setDetallePrestamoList(List<DetallePrestamo> detallePrestamoList) {
        this.detallePrestamoList = detallePrestamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.Prestamo[ idPrestamo=" + idPrestamo + " ]";
    }
    
}
