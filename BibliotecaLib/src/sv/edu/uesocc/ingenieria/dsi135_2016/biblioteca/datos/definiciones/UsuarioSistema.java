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
@Table(name = "usuario_sistema", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioSistema.findAll", query = "SELECT u FROM UsuarioSistema u"),
    @NamedQuery(name = "UsuarioSistema.findByUsuarioSistema", query = "SELECT u FROM UsuarioSistema u WHERE u.usuarioSistema = :usuarioSistema"),
    @NamedQuery(name = "UsuarioSistema.findByPassword", query = "SELECT u FROM UsuarioSistema u WHERE u.password = :password"),
    @NamedQuery(name = "UsuarioSistema.findByNombres", query = "SELECT u FROM UsuarioSistema u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "UsuarioSistema.findByApellidos", query = "SELECT u FROM UsuarioSistema u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "UsuarioSistema.findByDireccion", query = "SELECT u FROM UsuarioSistema u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "UsuarioSistema.findByNumeroContacto", query = "SELECT u FROM UsuarioSistema u WHERE u.numeroContacto = :numeroContacto"),
    @NamedQuery(name = "UsuarioSistema.findByEmail", query = "SELECT u FROM UsuarioSistema u WHERE u.email = :email"),
    @NamedQuery(name = "UsuarioSistema.findByAccesoTotal", query = "SELECT u FROM UsuarioSistema u WHERE u.accesoTotal = :accesoTotal")})
public class UsuarioSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario_sistema", nullable = false, length = 16)
    private String usuarioSistema;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 2147483647)
    private String password;
    @Basic(optional = false)
    @Column(name = "nombres", nullable = false, length = 255)
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos", nullable = false, length = 255)
    private String apellidos;
    @Column(name = "direccion", length = 2147483647)
    private String direccion;
    @Column(name = "numero_contacto", length = 9)
    private String numeroContacto;
    @Column(name = "email", length = 2147483647)
    private String email;
    @Basic(optional = false)
    @Column(name = "acceso_total", nullable = false)
    private boolean accesoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioSistema")
    private List<Prestamo> prestamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioSistema")
    private List<DetallePrestamo> detallePrestamoList;

    public UsuarioSistema() {
    }

    public UsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public UsuarioSistema(String usuarioSistema, String password, String nombres, String apellidos, boolean accesoTotal) {
        this.usuarioSistema = usuarioSistema;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.accesoTotal = accesoTotal;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public boolean getAccesoTotal() {
        return accesoTotal;
    }

    public void setAccesoTotal(boolean accesoTotal) {
        this.accesoTotal = accesoTotal;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
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
        hash += (usuarioSistema != null ? usuarioSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioSistema)) {
            return false;
        }
        UsuarioSistema other = (UsuarioSistema) object;
        if ((this.usuarioSistema == null && other.usuarioSistema != null) || (this.usuarioSistema != null && !this.usuarioSistema.equals(other.usuarioSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.UsuarioSistema[ usuarioSistema=" + usuarioSistema + " ]";
    }
    
}
