package lp2tecnoquim.model;

import java.util.Date;

public class DetalleMaquinaria {

    private int idDetalleM;
    private Date fecha;
    private Maquinaria maquinaria;

    public DetalleMaquinaria(int idDetalleM, Maquinaria maquinaria, Date fecha) {
        this.idDetalleM = idDetalleM;
        this.fecha = fecha;
        this.maquinaria = maquinaria;
    }

    public DetalleMaquinaria() {
        fecha = new Date();
        maquinaria = new Maquinaria();
    }

    public int getIdDetalleM() {
        return idDetalleM;
    }

    public void setIdDetalleM(int idDetalleM) {
        this.idDetalleM = idDetalleM;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Maquinaria getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(Maquinaria maquinaria) {
        this.maquinaria = maquinaria;
    }
}
