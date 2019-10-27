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
    
//    @WebMethod(operationName = "verificarUsuario")
//    public boolean verificarUsuario(@WebParam(name = "usuario") Usuario usuario) {
//        return DBController.verificarUsuario(usuario);
//    }
    
    //Almacen
    public void insertarAlmacen(@WebParam(name = "almacen") Almacen almacen){
        DBController.insertarAlmacen(almacen);
    }
    @WebMethod(operationName = "actualizarAlmacen")
    public void actualizarAlmacen(@WebParam(name = "almacen") Almacen almacen){
        DBController.actualizarAlmacen(almacen);
    }
    @WebMethod(operationName = "listarAlmacen")
    public ArrayList<Almacen> listarAlmacen(){
        return DBController.listarAlmacen();
    }
        
    //DetalleAlmacenInsumo
    public void insertarDetalleAlmacenInsumo(@WebParam(name = "detalleAlmacenInsumo") DetalleAlmacenInsumo detalleAlmacenInsumo){
        DBController.insertarDetalleAlmacenInsumo(detalleAlmacenInsumo);
    }
    @WebMethod(operationName = "actualizarDetalleAlmacenInsumo")
    public void actualizarDetalleAlmacenInsumo(@WebParam(name = "detalleAlmacenInsumo") DetalleAlmacenInsumo detalleAlmacenInsumo){
        DBController.actualizarDetalleAlmacenInsumo(detalleAlmacenInsumo);
    }
    @WebMethod(operationName = "listarDetalleAlmacenInsumo")
    public ArrayList<DetalleAlmacenInsumo> listarDetalleAlmacenInsumo(){
        return DBController.listarDetalleAlmacenInsumo();
    }
    //DetalleAlmacenProducto
    public void insertarDetalleAlmacenProducto(@WebParam(name = "detalleAlmacenProducto") DetalleAlmacenProducto detalleAlmacenProducto){
        DBController.insertarDetalleAlmacenProducto(detalleAlmacenProducto);
    }
    @WebMethod(operationName = "actualizarDetalleAlmacenProducto")
    public void actualizarDetalleAlmacenProducto(@WebParam(name = "detalleAlmacenProducto") DetalleAlmacenProducto detalleAlmacenProducto){
        DBController.actualizarDetalleAlmacenProducto(detalleAlmacenProducto);
    }
    @WebMethod(operationName = "listarDetalleAlmacenProducto")
    public ArrayList<DetalleAlmacenProducto> listarDetalleAlmacenProducto(){
        return DBController.listarDetalleAlmacenProducto();
    }
    //Maquinaria
    public void insertarMaquinaria(@WebParam(name = "maquinaria") Maquinaria maquinaria){
        DBController.insertarMaquinaria(maquinaria);
    }
    @WebMethod(operationName = "actualizarMaquinaria")
    public void actualizarMaquinaria(@WebParam(name = "maquinaria") Maquinaria maquinaria){
        DBController.actualizarMaquinaria(maquinaria);
    }
    @WebMethod(operationName = "listarMaquinaria")
    public ArrayList<Maquinaria> listarMaquinaria(){
        return DBController.listarMaquinaria();
    }
    
    //DetalleMaquinaria
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
    public void insertarLineaOrden(@WebParam(name = "lineaInsumo") LineaOrden lineaInsumo,
            @WebParam(name = "idOrden") int idOrden){
        DBController.insertarLineaOrden(lineaInsumo,idOrden);
    }
    @WebMethod(operationName = "actualizarLineaOrden")
    public void actualizarLineaOrden(@WebParam(name = "lineaInsumo") LineaOrden lineaInsumo,
            @WebParam(name = "idOrden") int idOrden){
        DBController.actualizarLineaOrden(lineaInsumo,idOrden);
    }
    @WebMethod(operationName = "listarLineaOrden")
    public ArrayList<LineaOrden> listarLineaOrden(@WebParam(name = "idOrden") int idOrden){
        return DBController.listarLineaOrden(idOrden);
    }
    
    //LineaProyeccion
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
    public void insertarMaquinaria(@WebParam(name = "maquinaria") Maquinaria maquinaria){
        DBController.insertarMaquinaria(maquinaria);
    }
    @WebMethod(operationName = "actualizarMaquinaria")
    public void actualizarMaquinaria(@WebParam(name = "maquinaria") Maquinaria maquinaria){
        DBController.actualizarMaquinaria(maquinaria);
    }
    @WebMethod(operationName = "listarMaquinaria")
    public ArrayList<Maquinaria> listarMaquinaria(){
        return DBController.listarMaquinaria();
    }
    

           
