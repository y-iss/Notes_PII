package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.SexoAnteDTO;
import Framework.PatException;

public class SexoAnteDAO extends SQLiteDataHelper implements IDAO<SexoAnteDTO>{
    @Override
    public SexoAnteDTO readBy(Integer id) throws Exception {
        SexoAnteDTO oS = new SexoAnteDTO();
        String query =" SELECT IdSexo  " 
                     +" ,Nombre        " 
                     +" ,Estado        " 
                     +" ,FechaCrea     " 
                     +" ,FechaModifica "
                     +" FROM    SEXO   "
                     +" WHERE   Estado ='A' AND IdSexo =   " + id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                // oS = new SexoDTO(rs.getInt(1)           // IdSexo
                //                 ,rs.getString(2)        // Nombre             
                //                 ,rs.getString(3)        // Estado         
                //                 ,rs.getString(4)        // FechaCrea      
                //                 ,rs.getString(5));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<SexoAnteDTO> readAll() throws Exception {
        List <SexoAnteDTO> lst = new ArrayList<>();
        String query =" SELECT IdSexo       " 
                     +" ,Nombre             " 
                     +" ,Estado             " 
                     +" ,FechaCrea          " 
                     +" ,FechaModifica      "
                     +" FROM    SEXO        "
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            // while (rs.next()) {
            //     SexoAnteDTO s = new SexoAnteDTO( rs.getInt(1)     // IdSexo
            //                             ,rs.getString(2)  // Nombre             
            //                             ,rs.getString(3)  // Estado         
            //                             ,rs.getString(4)  // FechaCrea      
            //                             ,rs.getString(5));// FechaModifica
            //     lst.add(s);
            // }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(SexoAnteDTO entity) throws Exception {
        String query = " INSERT INTO SEXO (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(SexoAnteDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE SEXO SET Nombre = ?, FechaModifica = ? WHERE IdSexo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdSexo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE SEXO SET Estado = ? WHERE IdSexo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg FROM SEXO "
                     +" WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
