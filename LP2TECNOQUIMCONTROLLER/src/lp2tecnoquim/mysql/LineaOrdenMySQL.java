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
import java.util.ArrayList;
import lp2tecnoquim.config.DBController;
import lp2tecnoquim.config.DBManager;
import lp2tecnoquim.dao.LineaOrdenDAO;
import lp2tecnoquim.model.EstadoMaterial;
import lp2tecnoquim.model.LineaOrden;

/**
 *
 * @author pukurin
 */
public class LineaOrdenMySQL implements LineaOrdenDAO {
    Connection con = null;
    CallableStatement cs;
    private int estado;
    
    @Override
    public void insertar(LineaOrden lineaOrden, int idOrden) {
         try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_LINEA_ORDEN(?,?,?,?,?)}");
            
            cs.setInt("_FK_ID_PROD", lineaOrden.getProducto().getIdProducto());
            cs.setInt("_FK_ORDEN_PROD", idOrden);
            cs.setInt("_CANT_PROD", lineaOrden.getCantProducto());
            cs.setInt("_ESTADO_CALIDAD", 0);
            
            cs.registerOutParameter("_ID_LINEAORD", java.sql.Types.INTEGER);
            cs.executeUpdate();
            lineaOrden.setIdLineaOrden(cs.getInt("_ID_LINEAORD"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public void actualizar(LineaOrden lineaOrden) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_LINEA_ORDEN(?,?,?,?)}");
            cs.setInt("_ID_LINEAORD", lineaOrden.getIdLineaOrden());
            cs.setInt("_FK_ID_PROD", lineaOrden.getProducto().getIdProducto());
            cs.setInt("_CANT_PROD", lineaOrden.getCantProducto());
            cs.setInt("_ESTADO_CALIDAD", lineaOrden.getEstadoCalidad().ordinal());
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
            cs = con.prepareCall("{call ELIMINAR_LINEA_ORDEN_PROD(?)}");
            cs.setInt("_ID_LINEAORD", id);
            cs.executeUpdate();
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }


    @Override
    public ArrayList<LineaOrden> listar(int idOrden) {
       ArrayList<LineaOrden> lineasOrden = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_LINEA_ORDEN_PROD(?)}");
            cs.setInt("_FK_ID_ORDEN_PROD", idOrden);
            
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                LineaOrden  l = new LineaOrden();
                
                l.setIdLineaOrden(rs.getInt("ID_LINEAORD"));
                l.setCantProducto(rs.getInt("CANT_PROD"));
                l.getProducto().setIdProducto(rs.getInt("ID_PROD"));
                l.getProducto().setNombre(rs.getString("NOMBRE"));
                l.getProducto().setPresentacion(rs.getString("PRESENTACION"));
                l.getProducto().setGranularidad(rs.getFloat("GRANULARIDAD"));
                l.getProducto().getInstructivo().setId(rs.getInt("ID_INSTRUCTIVO"));
                l.getProducto().getInstructivo().setActividades(rs.getString("ACTIVIDADES"));
//                l.getProducto().getInstructivo().setInsumos(DBController.listarLineaInsumo(l.getProducto().getInstructivo().getId()));
                
                estado = rs.getInt("ESTADO_CALIDAD");
                
                switch (estado) {
                    case 0:
                        l.setEstadoCalidad(EstadoMaterial.Bueno);
                        break;
                    case 1:
                        l.setEstadoCalidad(EstadoMaterial.Corregido);
                        break;
                    default:
                        l.setEstadoCalidad(EstadoMaterial.Pendiente);
                        break;
                }
                
                lineasOrden.add(l);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return lineasOrden;
    }
}
