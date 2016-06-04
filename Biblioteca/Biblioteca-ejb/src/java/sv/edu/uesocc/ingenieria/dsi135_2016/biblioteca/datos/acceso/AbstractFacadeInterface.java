/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.acceso;

import java.util.List;

/**
 *
 * @author Ale
 * @param <T>
 */
public interface AbstractFacadeInterface<T> {
    boolean crear(T entity);

    boolean editar(T entity);

    boolean eliminar(T entity);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    int count();
}
