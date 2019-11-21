/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.dao;

import java.util.ArrayList;
import lp2tecnoquim.model.DetalleAlmacenInsumo;
import lp2tecnoquim.model.OrdenProduccion;


/**
 *
 * @author alulab14
 */
public interface DetalleAlmacenInsumoDAO {
    void insertar(DetalleAlmacenInsumo detalleAlmacenInsumo,int idInsumo);
    void actualizar(DetalleAlmacenInsumo detalleAlmacenInsumo);
    void eliminar(int id);
    ArrayList<DetalleAlmacenInsumo> listar(String dato);
    void actualizarPorOrden(OrdenProduccion orden);
    void actualizarEstado(DetalleAlmacenInsumo detalleAlmacenInsumo);
}
