package lp2tecnoquim.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lp2tecnoquim.config.DBManager;
import lp2tecnoquim.dao.PlanMaestroProduccionDAO;
import lp2tecnoquim.model.PlanMaestroProduccion;
import lp2tecnoquim.model.Estado;

public class PlanMaestroProduccionMySQL implements PlanMaestroProduccionDAO{

    Connection con = null;
    CallableStatement cs;

    @Override
    public int insertar(PlanMaestroProduccion plan) {
        int id = 0;
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_PLAN(?,?,?)}");
            java.sql.Date sqlDate = new java.sql.Date(plan.getPeriodo().getTime());
            cs.setDate("_PERIODO", sqlDate);
            cs.setInt("_ESTADO",1);
            cs.setInt("_FK_ID_TRABAJADOR",plan.getResponsable().getId());
            
            cs.registerOutParameter("_ID_PMP", java.sql.Types.INTEGER);
            cs.executeUpdate();
            plan.setId(cs.getInt("_ID_PMP"));
            id = plan.getId();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return id;
    }

    @Override
    public void actualizar(PlanMaestroProduccion plan) {
        try{
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ACTUALIZAR_PLAN(?,?,?)}");
            cs.setInt("_ID_PMP", plan.getId());
            int nEstado = plan.getEstado().ordinal();
            cs.setInt("_ESTADO",nEstado);
            cs.setInt("_FK_ID_TRABAJADOR",plan.getResponsable().getId());
                    
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
            cs = con.prepareCall("{call ELIMINAR_PLAN(?)}");
            cs.setInt("_ID_PMP", id);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    @Override
    public ArrayList<PlanMaestroProduccion> listar(String periodo) {
        ArrayList<PlanMaestroProduccion> plan = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PLAN(?)}");
            cs.setString("_PERIODO", periodo);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                PlanMaestroProduccion  a = new PlanMaestroProduccion();
                a.setId(rs.getInt("ID_PMP"));
                a.setPeriodo(rs.getDate("PERIODO"));
                int nEstado = rs.getInt("ESTADO");
                switch (nEstado) {
                    case 0:
                        a.setEstado(Estado.Aprobado);
                        break;
                    case 1:
                        a.setEstado(Estado.Rechazado);
                        break;
                    case 2:
                        a.setEstado(Estado.Pendiente);
                        break;
                    default:
                        break;
                }
                a.getResponsable().setId(rs.getInt("FK_ID_TRABAJADOR"));
                a.getResponsable().setNombres(rs.getString("NOMBRES"));
                a.getResponsable().setApellidos(rs.getString("APELLIDOS"));
                //a.getResponsable().getRol().setIdRol(rs.getString("FK_ID_ROL")));
//                ArrayList<DetalleMaquinaria> dm = DBController.listarDetalleMaquinaria(a.getId());
//                for (DetalleMaquinaria det : dm) 
//                { 		      
//                    ArrayList<Maquinaria> m = DBController.listarMaquinaria(det.getMaquinaria().getNombre());
//                    a.getMaquinarias().add(m.get(0));
//                }                
//                a.setOrdenes(DBController.listarOrdenesProduccion(a.getId()));
                
                plan.add(a);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return plan;
    }
    
    @Override
    public ArrayList<PlanMaestroProduccion> listarEstado(int estado) {
        ArrayList<PlanMaestroProduccion> plan = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_PLAN2(?)}");
            cs.setInt("_ESTADO", estado);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                PlanMaestroProduccion  a = new PlanMaestroProduccion();
                a.setId(rs.getInt("ID_PMP"));
                a.setPeriodo(rs.getDate("PERIODO"));
                int nEstado = rs.getInt("ESTADO");
                switch (nEstado) {
                    case 0:
                        a.setEstado(Estado.Aprobado);
                        break;
                    case 1:
                        a.setEstado(Estado.Rechazado);
                        break;
                    case 2:
                        a.setEstado(Estado.Pendiente);
                        break;
                    default:
                        break;
                }
                a.getResponsable().setId(rs.getInt("FK_ID_TRABAJADOR"));
                a.getResponsable().setNombres(rs.getString("NOMBRES"));
                a.getResponsable().setApellidos(rs.getString("APELLIDOS"));
                //a.getResponsable().getRol().setIdRol(rs.getString("FK_ID_ROL")));
//                ArrayList<DetalleMaquinaria> dm = DBController.listarDetalleMaquinaria(a.getId());
//                for (DetalleMaquinaria det : dm) 
//                { 		      
//                    ArrayList<Maquinaria> m = DBController.listarMaquinaria(det.getMaquinaria().getNombre());
//                    a.getMaquinarias().add(m.get(0));
//                }                
//                a.setOrdenes(DBController.listarOrdenesProduccion(a.getId()));
                
                plan.add(a);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return plan;
    }
}
