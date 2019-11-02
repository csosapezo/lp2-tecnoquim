/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alulab14
 */
public class OrdenProduccion {
    
    private int id;
    private ArrayList<LineaOrden> lineasOrden;
    private Date fecha;

    public OrdenProduccion() {
        lineasOrden = new ArrayList<LineaOrden>();
        fecha = new Date();
    }

    public OrdenProduccion(ArrayList<LineaOrden> lineasOrden, Date fecha) {
        this.lineasOrden = lineasOrden;
        this.fecha = fecha;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public ArrayList<LineaOrden> getLineasOrden() {
        return lineasOrden;
    }

    public void setLineasOrden(ArrayList<LineaOrden> lineasOrden) {
        this.lineasOrden = lineasOrden;
    }

    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void mostrar(){
        
    };

    
}
