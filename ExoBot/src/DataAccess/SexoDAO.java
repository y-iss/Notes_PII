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

import DataAccess.DTO.SexoDTO;
import Framework.PatException;

public class SexoDAO extends SQLiteDataHelper implements IDAO<SexoDTO> {

    @Override
    public boolean create(SexoDTO entity) throws Exception {
        //  2            ,'Masculino'   ,'tipos de sexualida'
        String query = " INSERT INTO Catalogo (IdCatalogoTipo ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);   //
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<SexoDTO> readAll() throws Exception {
        List <SexoDTO> lst = new ArrayList<>();
        String query =" SELECT ROW_NUMBER () OVER ( ORDER BY IdCatalogo ) RowNum "
                     +" ,IdCatalogo         "
                     +" ,IdCatalogoTipo     "
                     +" ,Nombre             "
                     +" ,Descripcion        "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +" FROM    Catalogo    "
                     +" WHERE   Estado ='A' "
                     +" AND   IdCatalogoTipo = 2 ";  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                SexoDTO s = new SexoDTO( 
                                        rs.getInt(1)     // RowNum
                                        ,rs.getInt(2)     // IdCatalogo
                                        ,rs.getInt(3)     // IdCatalogoTipo             
                                        ,rs.getString(4)  // Nombre         
                                        ,rs.getString(5)  // Descripcion      
                                        ,rs.getString(6)  // Estado
                                        ,rs.getString(7)  // FechaCreacion
                                        ,rs.getString(8));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean update(SexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE Catalogo SET Estado = ? WHERE IdCatalogo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public SexoDTO readBy(Integer id) throws Exception {
        SexoDTO s = new SexoDTO();
        String query = 
         " SELECT RowNum            "
        +"     ,IdCatalogo          "
        +"     ,IdCatalogoTipo      "
        +"     ,Nombre              "
        +"     ,Descripcion         "
        +"     ,Estado              "
        +"     ,FechaCreacion       "
        +"     ,FechaModifica       "
        +" FROM (                   "
        +"     SELECT ROW_NUMBER() OVER (ORDER BY IdCatalogo) AS RowNum "
        +"         ,IdCatalogo      "
        +"         ,IdCatalogoTipo  "   
        +"         ,Nombre          "
        +"         ,Descripcion     "   
        +"         ,Estado          "
        +"         ,FechaCreacion   "       
        +"         ,FechaModifica   "   
        +"     FROM Catalogo        "
        +"     WHERE Estado = 'A'   "
        +"     AND IdCatalogoTipo = 2 "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            System.out.println(query);
            while (rs.next()) {
                s = new SexoDTO( 
                                rs.getInt(1)     // RowNum
                                ,rs.getInt(2)     // IdCatalogo
                                ,rs.getInt(3)     // IdCatalogoTipo             
                                ,rs.getString(4)  // Nombre         
                                ,rs.getString(5)  // Descripcion      
                                ,rs.getString(6)  // Estado
                                ,rs.getString(7)  // FechaCreacion
                                ,rs.getString(8));// FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return s; 
    }

    public Integer getRowCount()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    Catalogo         "
                     +" WHERE   Estado ='A'      "
                     +" AND     IdCatalogoTipo = 2";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }

}
