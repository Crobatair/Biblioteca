/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ale
 */
@Entity
@Table(name = "detalle_prestamo", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePrestamo.findAll", query = "SELECT d FROM DetallePrestamo d"),
    @NamedQuery(name = "DetallePrestamo.findByIsbn", query = "SELECT d FROM DetallePrestamo d WHERE d.detallePrestamoPK.isbn = :isbn"),
    @NamedQuery(name = "DetallePrestamo.findByIdEjemplar", query = "SELECT d FROM DetallePrestamo d WHERE d.detallePrestamoPK.idEjemplar = :idEjemplar"),
    @NamedQuery(name = "DetallePrestamo.findByIdPrestamo", query = "SELECT d FROM DetallePrestamo d WHERE d.detallePrestamoPK.idPrestamo = :idPrestamo"),
    @NamedQuery(name = "DetallePrestamo.findByTimestampDevuelto", query = "SELECT d FROM DetallePrestamo d WHERE d.timestampDevuelto = :timestampDevuelto"),
    @NamedQuery(name = "DetallePrestamo.findByObservacion", query = "SELECT d FROM DetallePrestamo d WHERE d.observacion = :observacion")})
public class DetallePrestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePrestamoPK detallePrestamoPK;
    @Column(name = "timestamp_devuelto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampDevuelto;
    @Column(name = "observacion", length = 2147483647)
    private String observacion;
    @JoinColumn(name = "usuario_sistema", referencedColumnName = "usuario_sistema", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioSistema usuarioSistema;
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prestamo prestamo;
    @JoinColumns({
        @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_ejemplar", referencedColumnName = "numero_ejemplar", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ejemplar ejemplar;

    public DetallePrestamo() {
    }

    public DetallePrestamo(DetallePrestamoPK detallePrestamoPK) {
        this.detallePrestamoPK = detallePrestamoPK;
    }

    public DetallePrestamo(String isbn, int idEjemplar, int idPrestamo) {
        this.detallePrestamoPK = new DetallePrestamoPK(isbn, idEjemplar, idPrestamo);
    }

    public DetallePrestamoPK getDetallePrestamoPK() {
        return detallePrestamoPK;
    }

    public void setDetallePrestamoPK(DetallePrestamoPK detallePrestamoPK) {
        this.detallePrestamoPK = detallePrestamoPK;
    }

    public Date getTimestampDevuelto() {
        return timestampDevuelto;
    }

    public void setTimestampDevuelto(Date timestampDevuelto) {
        this.timestampDevuelto = timestampDevuelto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public UsuarioSistema getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(UsuarioSistema usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePrestamoPK != null ? detallePrestamoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePrestamo)) {
            return false;
        }
        DetallePrestamo other = (DetallePrestamo) object;
        if ((this.detallePrestamoPK == null && other.detallePrestamoPK != null) || (this.detallePrestamoPK != null && !this.detallePrestamoPK.equals(other.detallePrestamoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.DetallePrestamo[ detallePrestamoPK=" + detallePrestamoPK + " ]";
    }
    
}
