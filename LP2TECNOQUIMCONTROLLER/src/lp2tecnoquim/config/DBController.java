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
      
      // Almacen
      
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
      
      // DetalleAlmacenInsumo
      
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
      
      // DetalleAlmacenProducto
      
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
      
      // DetalleMaquinaria
      
      public void insertarDetalleMaquinaria(DetalleMaquinaria detalleMaquinaria, int idPMP){
          daoFactory.getDetalleMaquinariaDAO().insertar(detalleMaquinaria, idPMP);
      }
      
      public void actualizarDetalleMaquinaria(DetalleMaquinaria detalleMaquinaria, int idPMP){
          daoFactory.getDetalleMaquinariaDAO().actualizar(detalleMaquinaria,idPMP);
      }
      
      public void eliminarDetalleMaquinaria(int id){
          daoFactory.getDetalleMaquinariaDAO().eliminar(id);
      }
      
      ArrayList<DetalleMaquinaria> listarDetalleMaquinaria(int idPMP){
          return daoFactory.getDetalleMaquinariaDAO().listar(idPMP);
      }
      
      // Instructivo
      
      public void insertarInstructivo(Instructivo instructivo, int idProducto){
          daoFactory.getInstructivoDAO().insertar(instructivo, idProducto);
      }
      
      public void actualizarInstructivo(Instructivo instructivo, int idProducto){
          daoFactory.getInstructivoDAO().actualizar(instructivo, idProducto);
      }
      
      public void eliminarInstructivo(int idProducto){
          daoFactory.getInstructivoDAO().eliminar(idProducto);
      }
      
      public ArrayList<Instructivo> listarInstructivos(){
          return daoFactory.getInstructivoDAO().listar();
      }
      
      // LineaInsumo
      
      public void insertarLineaInsumo(LineaInsumo lineaInsumo, int idInstructivo){
          daoFactory.getLineaInsumoDAO().insertar(lineaInsumo, idInstructivo);
      }
      
      public void actualizarLineaInsumo(LineaInsumo lineaInsumo, int idInstructivo){
          daoFactory.getLineaInsumoDAO().actualizar(lineaInsumo, idInstructivo);
      }
      
      public void eliminarLineaInsumo(int idLineaInsumo){
          daoFactory.getLineaInsumoDAO().eliminar(idLineaInsumo);
      }
      
      public ArrayList<LineaInsumo> listarLineaInsumo(int idInstructivo){
          return daoFactory.getLineaInsumoDAO().listar(idInstructivo);
      }
      
      // LineaOrden
      
      public void insertarLineaOrden(LineaOrden lineaOrden, int idOrden){
          daoFactory.getLineaOrdenDAO().insertar(lineaOrden, idOrden);
      }
      
      public void actualizarLineaOrden(LineaOrden lineaOrden, int idOrden){
          daoFactory.getLineaOrdenDAO().actualizar(lineaOrden, idOrden);
      }
      
      public void eliminarLineaOrden(int idLineaOrden){
          daoFactory.getLineaOrdenDAO().eliminar(idLineaOrden);
      }
      
      public ArrayList<LineaOrden> listarLineaOrden(int idOrden){
          return daoFactory.getLineaOrdenDAO().listar(idOrden);
      }
      
      // LineaProyeccion
      
      public void insertarLineaProyeccion(LineaProyeccion lineaProyeccion, int idProyeccion){
          daoFactory.getLineaProyeccionDAO().insertar(lineaProyeccion, idProyeccion);
      }
      
      public void actualizarLineaProyeccion(LineaProyeccion lineaProyeccion, int idProyeccion){
          daoFactory.getLineaProyeccionDAO().actualizar(lineaProyeccion, idProyeccion);
      }
      
      public void eliminarLineaProyeccion(int idLineaProyeccion){
          daoFactory.getLineaProyeccionDAO().eliminar(idLineaProyeccion);
      }
      
      public ArrayList<LineaProyeccion> listarLineaProyeccion(int idProyeccion){
          return daoFactory.getLineaProyeccionDAO().listar(idProyeccion);
      }
      
      // Maquinaria
      
      public void insertarMaquinaria(Maquinaria maquinaria){
          daoFactory.getMaquinariaDAO().insertar(maquinaria);
      }
      
      public void actualizarMaquinaria(Maquinaria maquinaria){
          daoFactory.getMaquinariaDAO().actualizar(maquinaria);
      }
      
      public void eliminarMaquinaria(int idMaquinaria){
          daoFactory.getMaquinariaDAO().eliminar(idMaquinaria);
      }
      
      public ArrayList<Maquinaria> listarMaquinaria(){
          return daoFactory.getMaquinariaDAO().listar();
      }
      
      // Mensaje
      
      public void enviarMensaje(Mensaje mensaje){
          daoFactory.getMensajeDAO().insertar(mensaje);
      }
      
      public void eliminarMensaje(int idMensaje){
          daoFactory.getMensajeDAO().eliminar(idMensaje);
      }
      
      public ArrayList<Mensaje> listarMensajes(int idReceptor){
          return daoFactory.getMensajeDAO().listar(idReceptor);
      }
      
      // OrdenProduccion
      
      public void insertarOrdenProduccion(OrdenProduccion ordenProduccion, int idPMP){
          daoFactory.getOrdenProduccionDAO().insertar(ordenProduccion, idPMP);
      }
      
      public void actualizarOrdenProduccion(OrdenProduccion ordenProduccion, int idPMP){
          daoFactory.getOrdenProduccionDAO().actualizar(ordenProduccion, idPMP);
      }
      
      public void eliminarOrdenProduccion(int idOrdenProduccion){
          daoFactory.getOrdenProduccionDAO().eliminar(idOrdenProduccion);
      }
      
      public ArrayList<OrdenProduccion> listarOrdenesProduccion(int idPMP){
          return daoFactory.getOrdenProduccionDAO().listar(idPMP);
      }
      
      // PlanMaestroProduccion
      
      public void insertarPMP(PlanMaestroProduccion plan){
          daoFactory.getPlanMaestroProduccionDAO().insertar(plan);
      }
      
      public void actualizarPMP(PlanMaestroProduccion plan){
          daoFactory.getPlanMaestroProduccionDAO().actualizar(plan);
      }
      
      public void eliminarPMP(int idPMP){
          daoFactory.getPlanMaestroProduccionDAO().eliminar(idPMP);
      }
      
      public ArrayList<PlanMaestroProduccion> listarPMP(){
          return daoFactory.getPlanMaestroProduccionDAO().listar();
      }
      
      // PoliticaStock
      
      public void insertarPoliticaStock(PoliticaStock politicaStock){
          daoFactory.getPoliticaStockDAO().insertar(politicaStock);
      }
      
      public void actualizarPoliticaStock(PoliticaStock politicaStock){
          daoFactory.getPoliticaStockDAO().actualizar(politicaStock);
      }
      
      public void eliminarPoliticaStock(int idPoliticaStock){
          daoFactory.getPoliticaStockDAO().eliminar(idPoliticaStock);
      }
      
      public ArrayList<PoliticaStock> listarPoliticaStock(){
          return daoFactory.getPoliticaStockDAO().listar();
      }
      
      // Producto
      
      public void insertarProducto(Producto producto){
          daoFactory.getProductoDAO().insertar(producto);
      }
      
      public void actualizarProducto(Producto producto){
          daoFactory.getProductoDAO().actualizar(producto);
      }
      
      public void eliminarProducto(int idProducto){
          daoFactory.getProductoDAO().eliminar(idProducto);
      }
      
      public ArrayList<Producto> listarProductos(){
          return daoFactory.getProductoDAO().listar();
      }
      
      // ProyeccionVenta
      
      public void insertarProyeccionVenta(ProyeccionVenta proyeccionVenta){
          daoFactory.getProyeccionVentaDAO().insertar(proyeccionVenta);
      }
      
      public void actualizarProyeccionVenta(ProyeccionVenta proyeccionVenta){
          daoFactory.getProyeccionVentaDAO().actualizar(proyeccionVenta);
      }
      
      public void eliminarProyeccionVenta(int idProyeccionVenta){
          daoFactory.getProyeccionVentaDAO().eliminar(idProyeccionVenta);
      }
      
      public ArrayList<ProyeccionVenta> listarProyeccionVenta(){
          return daoFactory.getProyeccionVentaDAO().listar();
      }
      
      // Rol
      
      public void insertarRol(Rol rol){
          daoFactory.getRolDAO().insertar(rol);
      }
      
      public void actualizarRol(Rol rol){
          daoFactory.getRolDAO().actualizar(rol);
      }
      
      public ArrayList<Rol> listarRoles(){
          return daoFactory.getRolDAO().listar();
      }
      
      // Trabajador
      
      public void insertarTrabajador(Trabajador trabajador){
          daoFactory.getTrabajadorDAO().insertar(trabajador);
      }
      
      public void actualizarTrabajador(Trabajador trabajador){
          daoFactory.getTrabajadorDAO().actualizar(trabajador);
      }
      
      public void eliminarTrabajador(int idTrabajador){
          daoFactory.getTrabajadorDAO().eliminar(idTrabajador);
      }
      
      public ArrayList<Trabajador> listarTrabajadores(){
          return daoFactory.getTrabajadorDAO().listar();
      }
      
      // Usuario
      
      public void insertarUsuario(Usuario usuario, int idTrabajador){
          daoFactory.getUsuarioDAO().insertar(usuario, idTrabajador);
      }
      
      public void actualizarUsuario(Usuario usuario, int idTrabajador){
          daoFactory.getUsuarioDAO().actualizar(usuario, idTrabajador);
      }
      
      public void eliminarUsuario(int idUsuario){
          daoFactory.getUsuarioDAO().eliminar(idUsuario);
      }
      
      public ArrayList<Usuario> listarUsuarios(){
          return daoFactory.getUsuarioDAO().listar();
      }
      
      public boolean verificarUsuario(Usuario usuario){
          return daoFactory.getUsuarioDAO().verificar(usuario);
      }
}
