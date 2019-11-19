package lp2tecnoquim.config;

import java.util.ArrayList;
import lp2tecnoquim.model.*;

public abstract class DBController {
    
      private static final DAOFactory daoFactory = DAOFactory.getDAOFactory();
      
      // Almacen
      
      public static void insertarAlmacen(Almacen almacen){
          daoFactory.getAlmacenDAO().insertar(almacen);
      }
      
      public static void actualizarAlmacen(Almacen almacen){
          daoFactory.getAlmacenDAO().actualizar(almacen);
      }
      
      public static void eliminarAlmacen(int idAlmacen){
          daoFactory.getAlmacenDAO().eliminar(idAlmacen);
      }
      
      public static ArrayList<Almacen> listarAlmacen(String tipo){
          return daoFactory.getAlmacenDAO().listar(tipo);
      }
      
      //Insumo
      
      public static int insertarInsumo(Insumo insumo){
         return daoFactory.getInsumoDAO().insertar(insumo);
      }
      
      public static void actualizarInsumo(Insumo insumo){
          daoFactory.getInsumoDAO().actualizar(insumo);
      }
      
      public static void eliminarInsumo(int idInsumo){
          daoFactory.getInsumoDAO().eliminar(idInsumo);
      }
      
      public static ArrayList<Insumo> listarInsumo(String dato){
          return daoFactory.getInsumoDAO().listar(dato);
      }
      
      public static ArrayList<Insumo> listarInsumoIns(int idIns){
          return daoFactory.getInsumoDAO().listar(idIns);
      }
      
      // DetalleAlmacenInsumo
      
      public static void insertarDetalleAlmacenInsumo(DetalleAlmacenInsumo detalleAlmacenInsumo,int idInsumo){
          daoFactory.getDetalleAlmacenInsumoDAO().insertar(detalleAlmacenInsumo,idInsumo);
      }
      
      public static void actualizarDetalleAlmacenInsumo(DetalleAlmacenInsumo detalleAlmacenInsumo){
          daoFactory.getDetalleAlmacenInsumoDAO().actualizar(detalleAlmacenInsumo);
      }
      
      public static void eliminarDetalleAlmacenInsumo(int id){
          daoFactory.getDetalleAlmacenInsumoDAO().eliminar(id);
      }
      
      public static ArrayList<DetalleAlmacenInsumo> listarDetalleAlmacenInsumo(String dato){
          return daoFactory.getDetalleAlmacenInsumoDAO().listar(dato);
      }
      
      // DetalleAlmacenProducto
      
      public static void insertarDetalleAlmacenProducto(DetalleAlmacenProducto detalleAlmacenProducto){
          daoFactory.getDetalleAlmacenProductoDAO().insertar(detalleAlmacenProducto);
      }
      
      public static void actualizarDetalleAlmacenProducto(DetalleAlmacenProducto detalleAlmacenProducto){
          daoFactory.getDetalleAlmacenProductoDAO().actualizar(detalleAlmacenProducto);
      }
      
      public static void eliminarDetalleAlmacenProducto(int id){
          daoFactory.getDetalleAlmacenProductoDAO().eliminar(id);
      }
      
      public static ArrayList<DetalleAlmacenProducto> listarDetalleAlmacenProducto(String dato){
          return daoFactory.getDetalleAlmacenProductoDAO().listar(dato);
      }
      
      // DetalleMaquinaria
      
      public static void insertarDetalleMaquinaria(DetalleMaquinaria detalleMaquinaria, int idPMP){
          daoFactory.getDetalleMaquinariaDAO().insertar(detalleMaquinaria, idPMP);
      }
      
      public static void actualizarDetalleMaquinaria(DetalleMaquinaria detalleMaquinaria){
          daoFactory.getDetalleMaquinariaDAO().actualizar(detalleMaquinaria);
      }
      
      public static void eliminarDetalleMaquinaria(int id){
          daoFactory.getDetalleMaquinariaDAO().eliminar(id);
      }
      
      public static ArrayList<DetalleMaquinaria> listarDetalleMaquinaria(int idPMP){
          return daoFactory.getDetalleMaquinariaDAO().listar(idPMP);
      }
      
      public static ArrayList<DetalleMaquinaria> listarDetalleMaquinariaTodos(String maq){
          return daoFactory.getDetalleMaquinariaDAO().listarTodo(maq);
      }
      
      // Instructivo
      
      public static int insertarInstructivo(Instructivo instructivo, int idProducto){
          return daoFactory.getInstructivoDAO().insertar(instructivo, idProducto);
      }
      
      public static void actualizarInstructivo(Instructivo instructivo, int idProducto){
          daoFactory.getInstructivoDAO().actualizar(instructivo, idProducto);
      }
      
      public static void eliminarInstructivo(int idProducto){
          daoFactory.getInstructivoDAO().eliminar(idProducto);
      }
      
      public static ArrayList<Instructivo> listarInstructivos(){
          return daoFactory.getInstructivoDAO().listar();
      }
      
      // LineaInsumo
      
      public static void insertarLineaInsumo(LineaInsumo lineaInsumo, int idInstructivo){
          daoFactory.getLineaInsumoDAO().insertar(lineaInsumo, idInstructivo);
      }
      
      public static void actualizarLineaInsumo(LineaInsumo lineaInsumo, int idInstructivo){
          daoFactory.getLineaInsumoDAO().actualizar(lineaInsumo, idInstructivo);
      }
      
      public static void eliminarLineaInsumo(int idLineaInsumo){
          daoFactory.getLineaInsumoDAO().eliminar(idLineaInsumo);
      }
      
      public static ArrayList<LineaInsumo> listarLineaInsumo(int idInstructivo){
          return daoFactory.getLineaInsumoDAO().listar(idInstructivo);
      }
      
      // LineaOrden
      
      public static void insertarLineaOrden(LineaOrden lineaOrden, int idOrden){
          daoFactory.getLineaOrdenDAO().insertar(lineaOrden, idOrden);
      }
      
      public static void actualizarLineaOrden(LineaOrden lineaOrden, int idOrden){
          daoFactory.getLineaOrdenDAO().actualizar(lineaOrden, idOrden);
      }
      
      public static void eliminarLineaOrden(int idLineaOrden){
          daoFactory.getLineaOrdenDAO().eliminar(idLineaOrden);
      }
      
      public static ArrayList<LineaOrden> listarLineaOrden(int idOrden){
          return daoFactory.getLineaOrdenDAO().listar(idOrden);
      }
      
      // LineaProyeccion
      
      public static void insertarLineaProyeccion(LineaProyeccion lineaProyeccion, int idProyeccion){
          daoFactory.getLineaProyeccionDAO().insertar(lineaProyeccion, idProyeccion);
      }
      
      public static void actualizarLineaProyeccion(LineaProyeccion lineaProyeccion, int idProyeccion){
          daoFactory.getLineaProyeccionDAO().actualizar(lineaProyeccion, idProyeccion);
      }
      
      public static void eliminarLineaProyeccion(int idLineaProyeccion){
          daoFactory.getLineaProyeccionDAO().eliminar(idLineaProyeccion);
      }
      
      public static ArrayList<LineaProyeccion> listarLineaProyeccion(int idProyeccion){
          return daoFactory.getLineaProyeccionDAO().listar(idProyeccion);
      }
      
      // Maquinaria
      
      public static int insertarMaquinaria(Maquinaria maquinaria){
          return daoFactory.getMaquinariaDAO().insertar(maquinaria);
      }
      
      public static void actualizarMaquinaria(Maquinaria maquinaria){
          daoFactory.getMaquinariaDAO().actualizar(maquinaria);
      }
      
      public static void eliminarMaquinaria(int idMaquinaria){
          daoFactory.getMaquinariaDAO().eliminar(idMaquinaria);
      }
      
      public static ArrayList<Maquinaria> listarMaquinaria(String dato){
          return daoFactory.getMaquinariaDAO().listar(dato);
      }
      
      // Mensaje
      
      public static void enviarMensaje(Mensaje mensaje){
          daoFactory.getMensajeDAO().insertar(mensaje);
      }
      
      public static void eliminarMensaje(int idMensaje){
          daoFactory.getMensajeDAO().eliminar(idMensaje);
      }
      
      public static ArrayList<Mensaje> listarMensajes(int idReceptor){
          return daoFactory.getMensajeDAO().listar(idReceptor);
      }
      
      // OrdenProduccion
      
      public static int insertarOrdenProduccion(OrdenProduccion ordenProduccion, int idPMP){
          return daoFactory.getOrdenProduccionDAO().insertar(ordenProduccion, idPMP);
      }
      
      public static void actualizarOrdenProduccion(OrdenProduccion ordenProduccion, int idPMP){
          daoFactory.getOrdenProduccionDAO().actualizar(ordenProduccion, idPMP);
      }
      
      public static void eliminarOrdenProduccion(int idOrdenProduccion){
          daoFactory.getOrdenProduccionDAO().eliminar(idOrdenProduccion);
      }
      
      public static ArrayList<OrdenProduccion> listarOrdenesProduccion(int idPMP){
          return daoFactory.getOrdenProduccionDAO().listar(idPMP);
      }
      
      public static ArrayList<OrdenProduccion> listarOrdenesProduccion(String fecha){
          return daoFactory.getOrdenProduccionDAO().listar(fecha);
      }
      
      // PlanMaestroProduccion
      
      public static int insertarPMP(PlanMaestroProduccion plan){
          return daoFactory.getPlanMaestroProduccionDAO().insertar(plan);
      }
      
      public static void actualizarPMP(PlanMaestroProduccion plan){
          daoFactory.getPlanMaestroProduccionDAO().actualizar(plan);
      }
      
      public static void eliminarPMP(int idPMP){
          daoFactory.getPlanMaestroProduccionDAO().eliminar(idPMP);
      }
      
      public static ArrayList<PlanMaestroProduccion> listarPMP(String periodo){
          return daoFactory.getPlanMaestroProduccionDAO().listar(periodo);
      }
      
      public static ArrayList<PlanMaestroProduccion> listarPMPEstado(int estado){
          return daoFactory.getPlanMaestroProduccionDAO().listarEstado(estado);
      }
      
      // PoliticaStock
      
      public static void insertarPoliticaStock(PoliticaStock politicaStock){
          daoFactory.getPoliticaStockDAO().insertar(politicaStock);
      }
      
      public static void actualizarPoliticaStock(PoliticaStock politicaStock){
          daoFactory.getPoliticaStockDAO().actualizar(politicaStock);
      }
      
      public static void eliminarPoliticaStock(int idPoliticaStock){
          daoFactory.getPoliticaStockDAO().eliminar(idPoliticaStock);
      }
      
      public static ArrayList<PoliticaStock> listarPoliticaStock(){
          return daoFactory.getPoliticaStockDAO().listar();
      }
      
      // Producto
      
      public static int insertarProducto(Producto producto){
          return daoFactory.getProductoDAO().insertar(producto);
      }
      
      public static void actualizarProducto(Producto producto){
          daoFactory.getProductoDAO().actualizar(producto);
      }
      
      public static void eliminarProducto(int idProducto){
          daoFactory.getProductoDAO().eliminar(idProducto);
      }
      
      public static ArrayList<Producto> listarProductos(String dato){
          return daoFactory.getProductoDAO().listar(dato);
      }
      
      // ProyeccionVenta
      
      public static void insertarProyeccionVenta(ProyeccionVenta proyeccionVenta){
          daoFactory.getProyeccionVentaDAO().insertar(proyeccionVenta);
      }
      
      public static void actualizarProyeccionVenta(ProyeccionVenta proyeccionVenta){
          daoFactory.getProyeccionVentaDAO().actualizar(proyeccionVenta);
      }
      
      public static void eliminarProyeccionVenta(int idProyeccionVenta){
          daoFactory.getProyeccionVentaDAO().eliminar(idProyeccionVenta);
      }
      
      public static ArrayList<ProyeccionVenta> listarProyeccionVenta(String periodo){
          return daoFactory.getProyeccionVentaDAO().listar(periodo);
      }
      
      // Rol
      
      public static void insertarRol(Rol rol){
          daoFactory.getRolDAO().insertar(rol);
      }
      
      public static void actualizarRol(Rol rol){
          daoFactory.getRolDAO().actualizar(rol);
      }
      
      public static ArrayList<Rol> listarRoles(String descripcion){
          return daoFactory.getRolDAO().listar(descripcion);
      }
      
      // Trabajador
      
      public static void insertarTrabajador(Trabajador trabajador){
          daoFactory.getTrabajadorDAO().insertar(trabajador);
      }
      
      public static void actualizarTrabajador(Trabajador trabajador){
          daoFactory.getTrabajadorDAO().actualizar(trabajador);
      }
      
      public static void eliminarTrabajador(int idTrabajador){
          daoFactory.getTrabajadorDAO().eliminar(idTrabajador);
      }
      
      public static ArrayList<Trabajador> listarTrabajadores(String nombres){
          return daoFactory.getTrabajadorDAO().listar(nombres);
      }
      
      // Usuario
      
      public static void insertarUsuario(Usuario usuario){
          daoFactory.getUsuarioDAO().insertar(usuario);
      }
      
      public static void actualizarUsuario(Usuario usuario){
          daoFactory.getUsuarioDAO().actualizar(usuario);
      }
      
      public static void eliminarUsuario(int idUsuario){
          daoFactory.getUsuarioDAO().eliminar(idUsuario);
      }
      
      public static ArrayList<Usuario> listarUsuarios(String username){
          return daoFactory.getUsuarioDAO().listar(username);
      }
      
      public static Trabajador verificarUsuario(Usuario usuario){
          return daoFactory.getUsuarioDAO().verificar(usuario);
      }
}
