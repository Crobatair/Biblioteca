/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ale
 */
@Embeddable
public class DetallePrestamoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;
    @Basic(optional = false)
    @Column(name = "id_ejemplar", nullable = false)
    private int idEjemplar;
    @Basic(optional = false)
    @Column(name = "id_prestamo", nullable = false)
    private int idPrestamo;

    public DetallePrestamoPK() {
    }

    public DetallePrestamoPK(String isbn, int idEjemplar, int idPrestamo) {
        this.isbn = isbn;
        this.idEjemplar = idEjemplar;
        this.idPrestamo = idPrestamo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        hash += (int) idEjemplar;
        hash += (int) idPrestamo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePrestamoPK)) {
            return false;
        }
        DetallePrestamoPK other = (DetallePrestamoPK) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        if (this.idEjemplar != other.idEjemplar) {
            return false;
        }
        if (this.idPrestamo != other.idPrestamo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.DetallePrestamoPK[ isbn=" + isbn + ", idEjemplar=" + idEjemplar + ", idPrestamo=" + idPrestamo + " ]";
    }
    
}
