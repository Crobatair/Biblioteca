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
@Table(name = "usuario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByNumeroContacto", query = "SELECT u FROM Usuario u WHERE u.numeroContacto = :numeroContacto"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByDui", query = "SELECT u FROM Usuario u WHERE u.dui = :dui"),
    @NamedQuery(name = "Usuario.findByNie", query = "SELECT u FROM Usuario u WHERE u.nie = :nie")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario", nullable = false, length = 16)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Column(name = "direccion", length = 2147483647)
    private String direccion;
    @Column(name = "numero_contacto", length = 9)
    private String numeroContacto;
    @Column(name = "email", length = 2147483647)
    private String email;
    @Column(name = "dui", length = 10)
    private String dui;
    @Column(name = "nie")
    private Integer nie;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario", nullable = false)
    @ManyToOne(optional = false)
    private TipoUsuario idTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Prestamo> prestamoList;

    public Usuario() {
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario(String usuario, String nombre, String apellidos) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Integer getNie() {
        return nie;
    }

    public void setNie(Integer nie) {
        this.nie = nie;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.Usuario[ usuario=" + usuario + " ]";
    }
    
}
