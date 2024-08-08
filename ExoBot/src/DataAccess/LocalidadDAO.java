package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.LocalidadDTO;
public class LocalidadDAO extends SQLiteDataHelper  {
    
    public LocalidadDTO readBy(Integer id) throws Exception {
        LocalidadDTO oS = new LocalidadDTO();
        String query =
         " SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo"
        +" FROM localida               lo "
        +" JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura"
        +" WHERE   lo.Estado = 'A' "
        +" AND     le.Estado = 'A' "
        +" AND     lo.IdLocalida = "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new LocalidadDTO(rs.getInt(1)              // LocalidaId
                                    ,rs.getString(2)            // Localida             
                                    ,rs.getString(3) );         // LocalidaTipo         
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return oS;
    }

    public List<LocalidadDTO> readAll() throws Exception {
        List <LocalidadDTO> lst = new ArrayList<>();
        String query =
        " SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo"
       +" FROM localida               lo "
       +" JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura"
       +" WHERE   lo.Estado = 'A' "
       +" AND     le.Estado = 'A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                LocalidadDTO s = new LocalidadDTO(rs.getInt(1)              // LocalidaId
                                                ,rs.getString(2)            // Localida             
                                                ,rs.getString(3) );         // LocalidaTipo  
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }

    public List<LocalidadDTO> readAllEstructura(String tipo)  throws Exception {
        List <LocalidadDTO> lst = new ArrayList<>();
        String query =
        " SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo"
       +" FROM localida               lo "
       +" JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura"
       +" WHERE   lo.Estado = 'A' "
       +" AND     le.Estado = 'A' "
       +" AND     lower(le.Nombre) = " + ((tipo.equals("Provincia"))
                                        ? "'Provincia'".toLowerCase() 
                                        : "'Cantón'".toLowerCase());
        System.out.println(query);                                    
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                LocalidadDTO s = new LocalidadDTO(rs.getInt(1)              // LocalidaId
                                                ,rs.getString(2)            // Localida             
                                                ,rs.getString(3) );         // LocalidaTipo  
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }
}
