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
import javax.persistence.Id;
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
@Table(name = "libro", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByEdicion", query = "SELECT l FROM Libro l WHERE l.edicion = :edicion"),
    @NamedQuery(name = "Libro.findByAutor", query = "SELECT l FROM Libro l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;
    @Basic(optional = false)
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    @Column(name = "edicion", length = 25)
    private String edicion;
    @Column(name = "autor", length = 2147483647)
    private String autor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio", precision = 17, scale = 17)
    private Double precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private List<Ejemplar> ejemplarList;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    @ManyToOne
    private Pais idPais;
    @JoinColumn(name = "id_editorial", referencedColumnName = "id_editorial")
    @ManyToOne
    private Editorial idEditorial;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    @ManyToOne(optional = false)
    private Categoria idCategoria;

    public Libro() {
    }

    public Libro(String isbn) {
        this.isbn = isbn;
    }

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Ejemplar> getEjemplarList() {
        return ejemplarList;
    }

    public void setEjemplarList(List<Ejemplar> ejemplarList) {
        this.ejemplarList = ejemplarList;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.Libro[ isbn=" + isbn + " ]";
    }
    
}
