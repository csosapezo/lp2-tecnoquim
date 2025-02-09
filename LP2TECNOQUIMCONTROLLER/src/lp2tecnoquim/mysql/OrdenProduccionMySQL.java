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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import lp2tecnoquim.config.DBController;
import lp2tecnoquim.config.DBManager;
import lp2tecnoquim.dao.OrdenProduccionDAO;
import lp2tecnoquim.model.Mensaje;
import lp2tecnoquim.model.OrdenProduccion;

/**
 *
 * @author Carlos Sosa
 */
public class OrdenProduccionMySQL implements OrdenProduccionDAO {
    Connection con = null;
    CallableStatement cs;
    
    @Override
    public int insertar(OrdenProduccion ordenProduccion, int idPMP) {
         try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ORDEN(?,?,?)}"); // Modificar el SQL
            
            cs.setDate("_FECHA", new java.sql.Date(ordenProduccion.getFecha().getTime()));
            cs.setInt("_FK_ID_PMP", idPMP);
            
            cs.registerOutParameter("_ID_ORDENPROD", java.sql.Types.INTEGER);
            cs.executeUpdate();
            ordenProduccion.setId(cs.getInt("_ID_ORDENPROD"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return ordenProduccion.getId();
    }

    @Override
    public void actualizar(OrdenProduccion ordenProduccion, int idPMP) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{CALL ACTUALIZAR_ORDENPROD(?)}");
            
            cs.setInt("_ID_ORDENPROD", ordenProduccion.getId());
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
            cs = con.prepareCall("{call ELIMINAR_ORDENPROD(?)}");
            cs.setInt("_ID_ORDENPROD", id);
            cs.execute();
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }


    @Override
    public ArrayList<OrdenProduccion> listar(int idPMP) {
       ArrayList<OrdenProduccion> ordenProduccions = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ORDEN_POR_PLAN(?)}"); // Modificar el SQL
            cs.setInt("_FK_ID_PMP", idPMP);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                OrdenProduccion  o = new OrdenProduccion();
                
                o.setId(rs.getInt("ID_ORDENPROD"));
                o.setFecha(rs.getDate("FECHA"));
//                o.setLineasOrden(DBController.listarLineaOrden(o.getId()));
     
                ordenProduccions.add(o);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return ordenProduccions;
    }
    
    @Override
    public ArrayList<OrdenProduccion> listar(String fecha) {
       ArrayList<OrdenProduccion> ordenProduccions = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ORDEN_POR_FECHA(?)}"); // Modificar el SQL
            cs.setString("_FECHA", fecha);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                OrdenProduccion  o = new OrdenProduccion();
                
                o.setId(rs.getInt("ID_ORDENPROD"));
                o.setFecha(rs.getDate("FECHA"));
                //o.setLineasOrden(DBController.listarLineaOrden(o.getId()));
                ordenProduccions.add(o);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return ordenProduccions;
    }
    
    @Override
    public boolean verificarDisponibilidadInsumos(OrdenProduccion ordenProduccion){
        boolean disponible = true;
        ArrayList<String> insumosFaltantes = new ArrayList<String>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call VERIFICAR_DISPONIBILIDAD_INSUMOS(?)}");
            cs.setInt("_ID_ORDEN", ordenProduccion.getId());
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                int remanente = rs.getInt("REMANENTE");
                String nombre = rs.getString("NOMBRE");
                if (remanente < 0) {
                    disponible = false;
                    insumosFaltantes.add(Integer.toString(remanente) + " " + nombre);
                }
            }
            
            if (!disponible){
                Mensaje mensaje = new Mensaje();
            
                cs = con.prepareCall("{call LISTAR_TRABAJADOR_ROL(?)}");
                cs.setInt("_ID_ROL", 6);
                rs = cs.executeQuery();
                while(rs.next()){
                    mensaje.getReceptor().setId(rs.getInt("ID_TRABAJADOR"));
                    break;
                }

                cs = con.prepareCall("{call LISTAR_TRABAJADOR_ROL(?)}");
                cs.setInt("_ID_ROL", 1);
                rs = cs.executeQuery();
                while(rs.next()){
                    mensaje.getEmisor().setId(rs.getInt("ID_TRABAJADOR"));
                    break;
                }

                mensaje.setFechaEnvio(new java.sql.Date((new java.util.Date()).getTime()));

                for (String insumo : insumosFaltantes){
                    mensaje.setDescripcion(" FALTA " + insumo);
                    DBController.enviarMensaje(mensaje);
                }
            }
            
            
            return disponible;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return true;
    }
}
