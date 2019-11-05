/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import lp2tecnoquim.config.DBController;
import lp2tecnoquim.model.*;

/**
 *
 * @author pukurin
 */
@WebService(serviceName = "Servicio")
public class Servicio {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "enviarMensaje")
    public void enviarMensaje(@WebParam(name = "mensaje") Mensaje mensaje) {
        DBController.enviarMensaje(mensaje);
    }
    
    @WebMethod(operationName = "verificarUsuario")
    public Trabajador verificarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        return DBController.verificarUsuario(usuario);
    }
    
    //Almacen
    @WebMethod(operationName = "insertarAlmacen")
    public void insertarAlmacen(@WebParam(name = "almacen") Almacen almacen){
        DBController.insertarAlmacen(almacen);
    }
    @WebMethod(operationName = "actualizarAlmacen")
    public void actualizarAlmacen(@WebParam(name = "almacen") Almacen almacen){
        DBController.actualizarAlmacen(almacen);
    }
    @WebMethod(operationName = "listarAlmacen")
    public ArrayList<Almacen> listarAlmacen(@WebParam(name = "tipo") String tipo){
        return DBController.listarAlmacen(tipo);
    }
    
    //Insumo
    @WebMethod(operationName = "insertarInsumo")
    public void insertarInsumo(@WebParam(name = "insumo") Insumo insumo){
        DBController.insertarInsumo(insumo);
    }
    @WebMethod(operationName = "actualizarInsumo")
    public void actualizarInsumo(@WebParam(name = "insumo") Insumo insumo){
        DBController.actualizarInsumo(insumo);
    }
    @WebMethod(operationName = "eliminarInsumo")
    public void eliminarInsumo(@WebParam(name = "id") int id){
        DBController.eliminarInsumo(id);
    }
    @WebMethod(operationName = "listarInsumo")
    public ArrayList<Insumo> listarInsumo(@WebParam(name = "dato") String dato){
        return DBController.listarInsumo(dato);
    }
    
    //DetalleAlmacenInsumo
    @WebMethod(operationName = "insertarDetalleAlmacenInsumo")
    public void insertarDetalleAlmacenInsumo(@WebParam(name = "detalleAlmacenInsumo") DetalleAlmacenInsumo detalleAlmacenInsumo){
        DBController.insertarDetalleAlmacenInsumo(detalleAlmacenInsumo);
    }
    @WebMethod(operationName = "actualizarDetalleAlmacenInsumo")
    public void actualizarDetalleAlmacenInsumo(@WebParam(name = "detalleAlmacenInsumo") DetalleAlmacenInsumo detalleAlmacenInsumo){
        DBController.actualizarDetalleAlmacenInsumo(detalleAlmacenInsumo);
    }
    @WebMethod(operationName = "listarDetalleAlmacenInsumo")
    public ArrayList<DetalleAlmacenInsumo> listarDetalleAlmacenInsumo(@WebParam(name = "id") int id){
        return DBController.listarDetalleAlmacenInsumo(id);
    }
    //DetalleAlmacenProducto
    @WebMethod(operationName = "insertarDetalleAlmacenProducto")
    public void insertarDetalleAlmacenProducto(@WebParam(name = "detalleAlmacenProducto") DetalleAlmacenProducto detalleAlmacenProducto){
        DBController.insertarDetalleAlmacenProducto(detalleAlmacenProducto);
    }
    @WebMethod(operationName = "actualizarDetalleAlmacenProducto")
    public void actualizarDetalleAlmacenProducto(@WebParam(name = "detalleAlmacenProducto") DetalleAlmacenProducto detalleAlmacenProducto){
        DBController.actualizarDetalleAlmacenProducto(detalleAlmacenProducto);
    }
    @WebMethod(operationName = "listarDetalleAlmacenProducto")
    public ArrayList<DetalleAlmacenProducto> listarDetalleAlmacenProducto(@WebParam(name = "id") int id){
        return DBController.listarDetalleAlmacenProducto(id);
    }
    //DetalleMaquinaria
    @WebMethod(operationName = "insertarDetalleMaquinaria")
    public void insertarDetalleMaquinaria(@WebParam(name = "maquinaria") DetalleMaquinaria maquinaria,
            @WebParam(name = "idPMP") int idPMP){
        DBController.insertarDetalleMaquinaria(maquinaria,idPMP);
    }
    @WebMethod(operationName = "actualizarDetalleMaquinaria")
    public void actualizarDetalleMaquinaria(@WebParam(name = "maquinaria") DetalleMaquinaria maquinaria,
            @WebParam(name = "idPMP") int idPMP){        
        DBController.actualizarDetalleMaquinaria(maquinaria,idPMP);
    }
    @WebMethod(operationName = "listarDetalleMaquinaria")
    public ArrayList<DetalleMaquinaria> listarDetalleMaquinaria(@WebParam(name = "idPMP") int idPMP){
        return DBController.listarDetalleMaquinaria(idPMP);
    }
     //Instructivo
    @WebMethod(operationName = "insertarInstructivo")
    public void insertarInstructivo(@WebParam(name = "instructivo") Instructivo instructivo,
            @WebParam(name = "idProducto") int idProducto){
        DBController.insertarInstructivo(instructivo,idProducto);
    }
    @WebMethod(operationName = "actualizarInstructivo")
    public void actualizarInstructivo(@WebParam(name = "instructivo") Instructivo instructivo,
            @WebParam(name = "idProducto") int idProducto){
        DBController.actualizarInstructivo(instructivo,idProducto);
    }
    @WebMethod(operationName = "listarInstructivos")
    public ArrayList<Instructivo> listarInstructivos(){
        return DBController.listarInstructivos();
    }
    
    //LineaInsumo
    @WebMethod(operationName = "insertarLineaInsumo")
    public void insertarLineaInsumo(@WebParam(name = "lineaInsumo") LineaInsumo lineaInsumo,
            @WebParam(name = "idInstructivo") int idInstructivo){
        DBController.insertarLineaInsumo(lineaInsumo,idInstructivo);
    }
    @WebMethod(operationName = "actualizarLineaInsumo")
    public void actualizarLineaInsumo(@WebParam(name = "lineaInsumo") LineaInsumo lineaInsumo,
            @WebParam(name = "idInstructivo") int idInstructivo){
        DBController.actualizarLineaInsumo(lineaInsumo,idInstructivo);
    }
    @WebMethod(operationName = "listarLineaInsumo")
    public ArrayList<LineaInsumo> listarLineaInsumo(@WebParam(name = "idInstructivo") int idInstructivo){
        return DBController.listarLineaInsumo(idInstructivo);
    }
    
     //LineaOrden
    @WebMethod(operationName = "insertarLineaOrden")
    public void insertarLineaOrden(@WebParam(name = "lineaOrden") LineaOrden lineaOrden,
            @WebParam(name = "idOrden") int idOrden){
        DBController.insertarLineaOrden(lineaOrden,idOrden);
    }
    @WebMethod(operationName = "actualizarLineaOrden")
    public void actualizarLineaOrden(@WebParam(name = "lineaOrden") LineaOrden lineaOrden,
            @WebParam(name = "idOrden") int idOrden){
        DBController.actualizarLineaOrden(lineaOrden,idOrden);
    }
    @WebMethod(operationName = "listarLineaOrden")
    public ArrayList<LineaOrden> listarLineaOrden(@WebParam(name = "idOrden") int idOrden){
        return DBController.listarLineaOrden(idOrden);
    }
    
    //LineaProyeccion
    @WebMethod(operationName = "insertarLineaProyeccion")
    public void insertarLineaProyeccion(@WebParam(name = "lineaProyeccion") LineaProyeccion lineaProyeccion,
            @WebParam(name = "idProyeccion") int idProyeccion){
        DBController.insertarLineaProyeccion(lineaProyeccion,idProyeccion);
    }
    @WebMethod(operationName = "actualizarLineaProyeccion")
    public void actualizarLineaProyeccion(@WebParam(name = "lineaProyeccion") LineaProyeccion lineaProyeccion,
            @WebParam(name = "idProyeccion") int idProyeccion){
        DBController.actualizarLineaProyeccion(lineaProyeccion,idProyeccion);
    }
    @WebMethod(operationName = "listarLineaProyeccion")
    public ArrayList<LineaProyeccion> listarLineaProyeccion(@WebParam(name = "idProyeccion") int idProyeccion){
        return DBController.listarLineaProyeccion(idProyeccion);
    }
    
    //Maquinaria
    @WebMethod(operationName = "insertarMaquinaria")
    public void insertarMaquinaria(@WebParam(name = "maquinaria") Maquinaria maquinaria){
        DBController.insertarMaquinaria(maquinaria);
    }
    @WebMethod(operationName = "actualizarMaquinaria")
    public void actualizarMaquinaria(@WebParam(name = "maquinaria") Maquinaria maquinaria){
        DBController.actualizarMaquinaria(maquinaria);
    }
    @WebMethod(operationName = "eliminarMaquinaria")
    public void eliminarMaquinaria(@WebParam(name = "id") int id){
        DBController.eliminarMaquinaria(id);
    }
    @WebMethod(operationName = "listarMaquinaria")
    public ArrayList<Maquinaria> listarMaquinaria(@WebParam(name = "dato") String dato){
        return DBController.listarMaquinaria(dato);
    }
    
    //Mensaje
    @WebMethod(operationName = "insertarMensaje")
    public void insertarMensaje(@WebParam(name = "mensaje") Mensaje mensaje){
        DBController.enviarMensaje(mensaje);
    }
    @WebMethod(operationName = "listarMensaje")
    public ArrayList<Mensaje> listarMensaje(@WebParam(name = "idReceptor") int idReceptor){
        return DBController.listarMensajes(idReceptor);
    }
    
    //Orden de Produccion
    @WebMethod(operationName = "insertarOrdenProduccion")
    public void insertarOrdenProduccion(@WebParam(name = "ordenProduccion") OrdenProduccion ordenProduccion,int idPMP){
        DBController.insertarOrdenProduccion(ordenProduccion, idPMP);        
    }

    @WebMethod(operationName = "actualizarOrdenProduccion")
    public void actualizarOrdenProduccion(@WebParam(name = "ordenProduccion") OrdenProduccion ordenProduccion,int idPMP){
        DBController.insertarOrdenProduccion(ordenProduccion, idPMP);        
    }
    
    @WebMethod(operationName = "listarOrdenesProduccionPlan")
    public ArrayList<OrdenProduccion> listarOrdenesProduccionPlan(@WebParam(name = "idPMP") int idPMP){
        return DBController.listarOrdenesProduccion(idPMP);        
    }
    
    @WebMethod(operationName = "listarOrdenesProduccionFecha")
    public ArrayList<OrdenProduccion> listarOrdenesProduccionFecha(@WebParam(name = "fecha")java.util.Date fecha){
        return DBController.listarOrdenesProduccion(fecha);        
    }
    
    //Plan Maestro de Produccion
    @WebMethod(operationName = "insertarPMP")
    public void insertarPMP(@WebParam(name = "politicaStock") PlanMaestroProduccion politicaStock){
        DBController.insertarPMP(politicaStock);        
    }

    @WebMethod(operationName = "actualizarPMP")
    public void actualizarPMP(@WebParam(name = "politicaStock") PlanMaestroProduccion politicaStock){
        DBController.insertarPMP(politicaStock);        
    }
    
    @WebMethod(operationName = "listarPMP")
    public ArrayList<PlanMaestroProduccion> listarPMP(@WebParam(name = "periodo") java.util.Date periodo){
        return DBController.listarPMP(periodo);        
    }
    
    //PoliticaStock
    @WebMethod(operationName = "insertarPoliticaStock")
    public void insertarPoliticaStock(@WebParam(name = "politicaStock") PoliticaStock politicaStock){
        DBController.insertarPoliticaStock(politicaStock);        
    }

    @WebMethod(operationName = "actualizarPoliticaStock")
    public void actualizarPoliticaStock(@WebParam(name = "politicaStock") PoliticaStock politicaStock){
        DBController.insertarPoliticaStock(politicaStock);        
    }
    
    @WebMethod(operationName = "listarPoliticaStock")
    public ArrayList<PoliticaStock> listarPoliticaStock(){
        return DBController.listarPoliticaStock();        
    }
    //Producto
    @WebMethod(operationName = "insertarProducto")
    public void insertarProducto(@WebParam(name = "producto") Producto producto){
        DBController.insertarProducto(producto);        
    }

    @WebMethod(operationName = "actualizarProducto")
    public void actualizarProducto(@WebParam(name = "producto") Producto producto){
        DBController.insertarProducto(producto);        
    }
    @WebMethod(operationName = "eliminarProducto")
    public void eliminarProducto(@WebParam(name = "id") int id){
        DBController.eliminarProducto(id);
    }
    @WebMethod(operationName = "listarProductos")
    public ArrayList<Producto> listarProductos(@WebParam(name = "dato") String dato){
        return DBController.listarProductos(dato);        
    }
    //ProyeccionVenta
    @WebMethod(operationName = "insertarProyeccionVenta")
    public void insertarProyeccionVenta(@WebParam(name = "proyeccionVenta") ProyeccionVenta proyeccionVenta){
        DBController.insertarProyeccionVenta(proyeccionVenta);        
    }

    @WebMethod(operationName = "actualizarProyeccionVenta")
    public void actualizarProyeccionVenta(@WebParam(name = "proyeccionVenta") ProyeccionVenta proyeccionVenta){
        DBController.insertarProyeccionVenta(proyeccionVenta);        
    }
    
    @WebMethod(operationName = "listarProyeccionVenta")
    public ArrayList<ProyeccionVenta> listarProyeccionVenta(@WebParam(name = "periodo")java.util.Date periodo){
        return DBController.listarProyeccionVenta(periodo);        
    }
    //Rol
    @WebMethod(operationName = "insertarRol")
    public void insertarRol(@WebParam(name = "rol") Rol rol){
        DBController.insertarRol(rol);        
    }

    @WebMethod(operationName = "actualizarRol")
    public void actualizarRol(@WebParam(name = "rol") Rol rol){
        DBController.insertarRol(rol);        
    }
    
    @WebMethod(operationName = "listarRoles")
    public ArrayList<Rol> listarRoles(@WebParam(name = "descripcion") String descripcion){
        return DBController.listarRoles(descripcion);        
    }
    //Trabajador
    @WebMethod(operationName = "insertarTrabajador")
    public void insertarTrabajador(@WebParam(name = "trabajador") Trabajador trabajador){
        DBController.insertarTrabajador(trabajador);        
    }

    @WebMethod(operationName = "actualizarTrabajador")
    public void actualizarTrabajador(@WebParam(name = "trabajador") Trabajador trabajador){
        DBController.actualizarTrabajador(trabajador);        
    }
    
    @WebMethod(operationName = "listarTrabajadores")
    public ArrayList<Trabajador> listarTrabajadores(@WebParam(name = "nombres")String nombres){
        return DBController.listarTrabajadores(nombres);        
    }
    //Usuario
    @WebMethod(operationName = "insertarUsuario")
    public void insertarUsuario(@WebParam(name = "usuario") Usuario usuario){
        DBController.insertarUsuario(usuario);        
    }

    @WebMethod(operationName = "actualizarUsuario")
    public void actualizarUsuario(@WebParam(name = "usuario") Usuario usuario){
        DBController.actualizarUsuario(usuario);        
    }
    
    @WebMethod(operationName = "listarUsuarios")
    public ArrayList<Usuario> listarUsuarios(@WebParam(name = "username") String username){
        return DBController.listarUsuarios(username);        
    }
    
    
    
    
    
    
    
    
    
    
}
    
    
           
