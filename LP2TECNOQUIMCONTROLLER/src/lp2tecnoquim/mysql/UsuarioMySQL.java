package lp2tecnoquim.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lp2tecnoquim.config.DBController;
import lp2tecnoquim.config.DBManager;
import lp2tecnoquim.dao.UsuarioDAO;
import lp2tecnoquim.model.Rol;
import lp2tecnoquim.model.Trabajador;
import lp2tecnoquim.model.Usuario;

public class UsuarioMySQL implements UsuarioDAO {

    Connection con = null;
    CallableStatement cs;
    
    @Override
    public void insertar(Usuario usuario) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_USUARIO(?,?,?)}"); // Modificar el SQL
            cs.setString("_USERNAME", usuario.getUsername());
            cs.setString("_CONTRASENA",usuario.getPassword());
            
            cs.registerOutParameter("_ID_USUARIO", java.sql.Types.INTEGER);
            cs.executeUpdate();
            usuario.setIdUsuario(cs.getInt("_ID_USUARIO"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_USUARIO(?,?,?,?)}"); // Modificar el SQL
            cs.setInt("_ID_USUARIO", usuario.getIdUsuario());
            cs.setString("_USERNAME", usuario.getUsername());
            cs.setString("_CONTRASENA",usuario.getPassword());
                    
            cs.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public void eliminar(int idUsuario) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_USUARIO(?)}");
            cs.setInt("_ID_USUARIO", idUsuario);
            
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public ArrayList<Usuario> listar(String username) {
        ArrayList<Usuario> usuario = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_USUARIO(?)}");
            cs.setString("_USERNAME", username);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Usuario  a = new Usuario();
                a.setIdUsuario(rs.getInt("ID_USUARIO"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("CONTRASENA"));
                ///////////////////////////////////////////////
                
                
                
                
                
                usuario.add(a);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return usuario;
    }
    
    @Override
    public Trabajador verificar(Usuario usuario) {
        Trabajador trabajador = new Trabajador();
        trabajador = null;
        ArrayList<Trabajador> trabajadores = new ArrayList<>(); 
        int id_trabajador=-1;
        boolean resultado;
        
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call VERIFICAR_USUARIO(?,?,?,?)}");
            cs.setString("_USUARIO", usuario.getUsername());
            cs.setString("_CONTRASENA",usuario.getPassword());
            
            cs.registerOutParameter("_ES_VALIDO", java.sql.Types.TINYINT);
            cs.registerOutParameter("_ID_TRABAJADOR", java.sql.Types.TINYINT);
            cs.executeUpdate();
            
            id_trabajador = cs.getInt("_ID_TRABAJADOR");
            resultado =  cs.getBoolean("_ES_VALIDO");
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
            resultado = false;
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        
        if(resultado){
            trabajadores = DBController.listarTrabajadores("%");
            for (Trabajador trabajadorSel : trabajadores) { 		      
                if(trabajadorSel.getId() == id_trabajador){
                    trabajador = trabajadorSel;
                }                
            }
        }
        return trabajador;
    }
    
}
