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
public class EjemplarPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "isbn", nullable = false, length = 17)
    private String isbn;
    @Basic(optional = false)
    @Column(name = "numero_ejemplar", nullable = false)
    private int numeroEjemplar;

    public EjemplarPK() {
    }

    public EjemplarPK(String isbn, int numeroEjemplar) {
        this.isbn = isbn;
        this.numeroEjemplar = numeroEjemplar;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroEjemplar() {
        return numeroEjemplar;
    }

    public void setNumeroEjemplar(int numeroEjemplar) {
        this.numeroEjemplar = numeroEjemplar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        hash += (int) numeroEjemplar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EjemplarPK)) {
            return false;
        }
        EjemplarPK other = (EjemplarPK) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        if (this.numeroEjemplar != other.numeroEjemplar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.EjemplarPK[ isbn=" + isbn + ", numeroEjemplar=" + numeroEjemplar + " ]";
    }
    
}
