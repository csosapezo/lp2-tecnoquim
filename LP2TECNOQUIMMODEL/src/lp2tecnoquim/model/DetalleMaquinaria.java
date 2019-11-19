/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.model;

import java.util.Date;

public class DetalleMaquinaria {
    private int idDetalleM;
    private boolean activo;
    private Date fecha;

    public DetalleMaquinaria(int idDetalleM, boolean estado, Maquinaria maquinaria, Date fecha) {
        this.idDetalleM = idDetalleM;
        this.activo = estado;
        this.fecha = fecha;
    }

    public DetalleMaquinaria() {
        fecha = new Date();
    }

    public int getIdDetalleM() {
        return idDetalleM;
    }

    public void setIdDetalleM(int idDetalleM) {
        this.idDetalleM = idDetalleM;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
