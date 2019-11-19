/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2tecnoquim.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lp2tecnoquim.config.DBManager;
import lp2tecnoquim.dao.MaquinariaDAO;
import lp2tecnoquim.model.Maquinaria;

public class MaquinariaMySQL implements MaquinariaDAO {
    Connection con = null;
    CallableStatement cs;
    Statement st=null;
    
    @Override
    public int insertar(Maquinaria maquinaria) {
         try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_MAQUINARIA(?,?,?,?)}");
            cs.setString("_NOMBRE", maquinaria.getNombre());
            cs.setString("_TIPO", maquinaria.getTipo());
            cs.setBoolean("_ESTADO", maquinaria.getEstado());
            
            cs.registerOutParameter("_ID_MAQUINARIA", java.sql.Types.INTEGER);
            cs.executeUpdate();
            maquinaria.setId(cs.getInt("_ID_MAQUINARIA"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return maquinaria.getId();
    }

    @Override
    public void actualizar(Maquinaria maquinaria) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_MAQUINARIA(?,?,?,?)}");
            cs.setInt("_ID_MAQUINARIA", maquinaria.getId());
            cs.setString("_NOMBRE", maquinaria.getNombre());
            cs.setString("_TIPO", maquinaria.getTipo());
            cs.setBoolean("_ESTADO", maquinaria.getEstado());
            cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
    
    
    @Override
    public void eliminar(int id) {
       try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_MAQUINARIA(?)}");
            cs.setInt("_ID_MAQUINARIA", id);
            
           cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }


    @Override
    public ArrayList<Maquinaria> listar(String dato) {
       ArrayList<Maquinaria> maquinarias = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_MAQUINARIA(?)}");
            cs.setString("_NOMBRE",dato);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Maquinaria  m = new Maquinaria();
                
                m.setId(rs.getInt("ID_MAQUINARIA"));
                m.setNombre(rs.getString("NOMBRE"));
                m.setTipo(rs.getString("TIPO"));
                m.setEstado(rs.getBoolean("ESTADO"));
     
                maquinarias.add(m);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return maquinarias;
    }

    
}
