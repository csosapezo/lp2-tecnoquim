package lp2tecnoquim.model;

public class Maquinaria {
    
    private int id;
    private String nombre;
    private String tipo;
    private boolean estado;

    public Maquinaria() {
        estado = false;
    }

    public Maquinaria(String nombre, String tipo,boolean estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado=estado;
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
    
    public boolean getEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
