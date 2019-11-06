package lp2tecnoquim.dao;

import java.util.ArrayList;
import lp2tecnoquim.model.Trabajador;

public interface TrabajadorDAO {
    
    void insertar(Trabajador trabajador);
    void actualizar(Trabajador trabajador);
    void eliminar(int id);
    ArrayList<Trabajador> listar(String nombres);
    
}
