/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.dao;

import java.util.ArrayList;
import lp2tecnoquim.model.DetalleMaquinaria;

public interface DetalleMaquinariaDAO {
    
    void insertar(DetalleMaquinaria detalleM, int idPMP);
    void actualizar(DetalleMaquinaria detalleM);
    void eliminar(int id);
    ArrayList<DetalleMaquinaria> listar(int idPMP);
    ArrayList<DetalleMaquinaria> listarTodo(String maq);
    
}
