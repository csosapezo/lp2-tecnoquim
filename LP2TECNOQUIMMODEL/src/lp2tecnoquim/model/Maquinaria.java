/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.model;

import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class Maquinaria {
    private int id;
    private String nombre;
    private String tipo;
    private ArrayList<DetalleMaquinaria> detallesMaquinaria;

    public Maquinaria() {
    }

    public Maquinaria(String nombre, String tipo,ArrayList<DetalleMaquinaria> detallesMaquinaria) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.detallesMaquinaria=detallesMaquinaria;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<DetalleMaquinaria> getDetallesMaquinaria() {
        return detallesMaquinaria;
    }
    public void setDetallesMaquinaria(ArrayList<DetalleMaquinaria> detallesMaquinaria) {
        this.detallesMaquinaria = detallesMaquinaria;
    }
    
    
    
}
