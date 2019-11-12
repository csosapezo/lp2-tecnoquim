package lp2tecnoquim.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lp2tecnoquim.config.DBManager;
import lp2tecnoquim.dao.ProyeccionVentaDAO;
import lp2tecnoquim.model.ProyeccionVenta;

public class ProyeccionVentaMySQL implements ProyeccionVentaDAO{
    Connection con = null;
    CallableStatement cs;

    @Override
    public void insertar(ProyeccionVenta proyeccion) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_PROYECCION(?)}");
            java.sql.Date sqlDate = new java.sql.Date(proyeccion.getPeriodo().getTime());
            cs.setDate("_PERIODO", sqlDate);
            
            cs.registerOutParameter("_ID_PROY_VENTA", java.sql.Types.INTEGER);
            cs.executeUpdate();
            proyeccion.setId(cs.getInt("_ID_PROY_VENTA"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }        
    }

    @Override
    public void actualizar(ProyeccionVenta proyeccion) {
       try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_PROYECCION(?,?)}");
            cs.setInt("_ID_PROY_VENTA", proyeccion.getId());
            java.sql.Date sqlDate = new java.sql.Date(proyeccion.getPeriodo().getTime());
            cs.setDate("_PERIODO", sqlDate);
                    
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
            cs = con.prepareCall("{call ELIMINAR_PROYECCION(?)}");
            cs.setInt("_ID_PROY_VENTA", id);
            
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }  
    }

    @Override
    public ArrayList<ProyeccionVenta> listar(String periodo) {
        ArrayList<ProyeccionVenta> proyeccion = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PROYECCION(?)}");
            cs.setString("_PERIODO", periodo);
            
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                ProyeccionVenta  a = new ProyeccionVenta();
                a.setId(rs.getInt("ID_PROY_VENTA"));
                a.setPeriodo(rs.getDate("PERIODO"));
                ///////////////////////////////////////////////
                
                
                proyeccion.add(a);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return proyeccion;
    }
    
}
