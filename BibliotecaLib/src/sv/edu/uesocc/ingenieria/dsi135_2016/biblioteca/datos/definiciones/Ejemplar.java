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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ejemplar", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejemplar.findAll", query = "SELECT e FROM Ejemplar e"),
    @NamedQuery(name = "Ejemplar.findByIsbn", query = "SELECT e FROM Ejemplar e WHERE e.ejemplarPK.isbn = :isbn"),
    @NamedQuery(name = "Ejemplar.findByNumeroEjemplar", query = "SELECT e FROM Ejemplar e WHERE e.ejemplarPK.numeroEjemplar = :numeroEjemplar"),
    @NamedQuery(name = "Ejemplar.findByCodBarra", query = "SELECT e FROM Ejemplar e WHERE e.codBarra = :codBarra")})
public class Ejemplar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EjemplarPK ejemplarPK;
    @Basic(optional = false)
    @Column(name = "cod_barra", nullable = false, length = 255)
    private String codBarra;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "id_estado_ejemplar", referencedColumnName = "id_estado_ejemplar", nullable = false)
    @ManyToOne(optional = false)
    private EstadoEjemplar idEstadoEjemplar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejemplar")
    private List<DetallePrestamo> detallePrestamoList;

    public Ejemplar() {
    }

    public Ejemplar(EjemplarPK ejemplarPK) {
        this.ejemplarPK = ejemplarPK;
    }

    public Ejemplar(EjemplarPK ejemplarPK, String codBarra) {
        this.ejemplarPK = ejemplarPK;
        this.codBarra = codBarra;
    }

    public Ejemplar(String isbn, int numeroEjemplar) {
        this.ejemplarPK = new EjemplarPK(isbn, numeroEjemplar);
    }

    public EjemplarPK getEjemplarPK() {
        return ejemplarPK;
    }

    public void setEjemplarPK(EjemplarPK ejemplarPK) {
        this.ejemplarPK = ejemplarPK;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public EstadoEjemplar getIdEstadoEjemplar() {
        return idEstadoEjemplar;
    }

    public void setIdEstadoEjemplar(EstadoEjemplar idEstadoEjemplar) {
        this.idEstadoEjemplar = idEstadoEjemplar;
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
        hash += (ejemplarPK != null ? ejemplarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplar)) {
            return false;
        }
        Ejemplar other = (Ejemplar) object;
        if ((this.ejemplarPK == null && other.ejemplarPK != null) || (this.ejemplarPK != null && !this.ejemplarPK.equals(other.ejemplarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.Ejemplar[ ejemplarPK=" + ejemplarPK + " ]";
    }
    
}
