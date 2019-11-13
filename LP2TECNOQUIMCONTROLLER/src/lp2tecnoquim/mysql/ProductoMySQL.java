package lp2tecnoquim.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lp2tecnoquim.config.DBController;
import lp2tecnoquim.config.DBManager;
import lp2tecnoquim.dao.ProductoDAO;
import lp2tecnoquim.model.Instructivo;
import lp2tecnoquim.model.Insumo;
import lp2tecnoquim.model.LineaInsumo;
import lp2tecnoquim.model.Producto;

public class ProductoMySQL implements ProductoDAO{

    Connection con = null;
    CallableStatement cs;
    CallableStatement cs1;

    @Override
    public int insertar(Producto producto) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_PRODUCTO(?,?,?,?,?)}");
            cs.setString("_NOMBRE", producto.getNombre());
            cs.setFloat("_GRANULARIDAD",producto.getGranularidad());
            cs.setString("_PRESENTACION",producto.getPresentacion());
            cs.setBoolean("_RESTRICCION",producto.isRestriccion());
            cs.registerOutParameter("_ID_PROD", java.sql.Types.INTEGER);
            cs.executeUpdate();
            producto.setIdProducto(cs.getInt("_ID_PROD"));
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return producto.getIdProducto();
    }

    @Override
    public void actualizar(Producto producto) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_PRODUCTO(?,?,?,?,?)}");
            cs.setInt("_ID_PROD", producto.getIdProducto());
            cs.setString("_NOMBRE", producto.getNombre());
            cs.setFloat("_GRANULARIDAD",producto.getGranularidad());
            cs.setString("_PRESENTACION",producto.getPresentacion());
            cs.setBoolean("_RESTRICCION",producto.isRestriccion());
            //cs.setInt("_FK_ID_INSTRUCTIVO",producto.getInstructivo().getId());
                    
            cs.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public void eliminar(int idProducto) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_PRODUCTO(?)}");
            cs.setInt("_ID_PROD", idProducto);
            cs.executeUpdate();
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public ArrayList<Producto> listar(String dato) {
        ArrayList<Producto> producto = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PRODUCTOS(?)}");
            cs.setString("_NOMBRE", dato);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Producto  a = new Producto();
                a.setIdProducto(rs.getInt("ID_PROD"));
                a.setNombre(rs.getString("NOMBRE"));
                a.setGranularidad(rs.getFloat("GRANULARIDAD"));
                a.setPresentacion(rs.getString("PRESENTACION"));
                a.setRestriccion(rs.getBoolean("RESTRICCION"));
                Instructivo i=new Instructivo();
                i.setId(rs.getInt("ID_INSTRUCTIVO"));
                i.setActividades(rs.getString("ACTIVIDADES"));
                i.setInsumos(DBController.listarLineaInsumo(i.getId()));
                a.setInstructivo(i);
                producto.add(a);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return producto;
    }
    
}
