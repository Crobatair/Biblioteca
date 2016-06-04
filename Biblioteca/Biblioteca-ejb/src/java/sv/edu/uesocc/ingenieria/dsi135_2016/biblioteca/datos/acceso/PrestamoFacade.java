/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.definiciones.Prestamo;

/**
 *
 * @author Ale
 */
@Stateless
public class PrestamoFacade extends AbstractFacade<Prestamo> implements PrestamoFacadeLocal {
    @PersistenceContext(unitName = "Biblioteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamoFacade() {
        super(Prestamo.class);
    }
    
}
