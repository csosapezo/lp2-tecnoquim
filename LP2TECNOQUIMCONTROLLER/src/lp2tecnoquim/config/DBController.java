/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.config;

import java.util.ArrayList;
import lp2tecnoquim.model.*;

/**
 *
 * @author alulab14
 */
public abstract class DBController {
    
      private static final DAOFactory daoFactory = DAOFactory.getDAOFactory();
      
      public void insertarAlmacen(Almacen almacen){
          daoFactory.getAlmacenDAO().insertar(almacen);
      }
      
      public void actualizarAlmacen(Almacen almacen){
          daoFactory.getAlmacenDAO().actualizar(almacen);
      }
      
      public void eliminarAlmacen(int idAlmacen){
          daoFactory.getAlmacenDAO().eliminar(idAlmacen);
      }
      
      ArrayList<Almacen> listarAlmacen(){
          return daoFactory.getAlmacenDAO().listar();
      }
      
      public void insertarDetalleAlmacenInsumo(DetalleAlmacenInsumo detalleAlmacenInsumo){
          daoFactory.getDetalleAlmacenInsumoDAO().insertar(detalleAlmacenInsumo);
      }
      
      public void actualizarDetalleAlmacenInsumo(DetalleAlmacenInsumo detalleAlmacenInsumo){
          daoFactory.getDetalleAlmacenInsumoDAO().actualizar(detalleAlmacenInsumo);
      }
      
      public void eliminarDetalleAlmacenInsumo(int id){
          daoFactory.getDetalleAlmacenInsumoDAO().eliminar(id);
      }
      
      ArrayList<DetalleAlmacenInsumo> listarDetalleAlmacenInsumo(){
          return daoFactory.getDetalleAlmacenInsumoDAO().listar();
      }
      
      public void insertarDetalleAlmacenProducto(DetalleAlmacenProducto detalleAlmacenProducto){
          daoFactory.getDetalleAlmacenProductoDAO().insertar(detalleAlmacenProducto);
      }
      
      public void actualizarDetalleAlmacenProducto(DetalleAlmacenProducto detalleAlmacenProducto){
          daoFactory.getDetalleAlmacenProductoDAO().actualizar(detalleAlmacenProducto);
      }
      
      public void eliminarDetalleAlmacenProducto(int id){
          daoFactory.getDetalleAlmacenProductoDAO().eliminar(id);
      }
      
      ArrayList<DetalleAlmacenProducto> listarDetalleAlmacenProducto(){
          return daoFactory.getDetalleAlmacenProductoDAO().listar();
      }
}
