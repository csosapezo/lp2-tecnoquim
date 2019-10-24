/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.services;

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
    public boolean verificarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        return DBController.verificarUsuario(usuario);
    }
}
