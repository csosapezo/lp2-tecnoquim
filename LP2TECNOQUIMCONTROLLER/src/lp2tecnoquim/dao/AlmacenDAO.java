/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.dao;

import java.util.ArrayList;
import lp2tecnoquim.model.Almacen;


/**
 *
 * @author alulab14
 */
public interface AlmacenDAO {
    
    void insertar(Almacen almacen);
    void actualizar(Almacen almacen);
    void eliminar(int id);
    ArrayList<Almacen> listar(String tipo);
    
}
