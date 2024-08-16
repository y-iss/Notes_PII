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

import DataAccess.DTO.FARegionDTO;
import Framework.FAException;
import Framework.FAException;

public class FARegionDAO extends FAEcuaFaunaDataHelper implements IDAO<FARegionDTO> {

    @Override
    public FARegionDTO readBy(Integer id) throws Exception {
        FARegionDTO oS = new FARegionDTO();
        String query = " SELECT CodigoRegion "
                     + " ,NombreRegion     "
                     + " ,Estado           "
                     + " ,FechaCrea        "
                     + " ,FechaModifica    "
                     + " FROM   FARegion   "
                     + " WHERE  Estado = 'A' AND CodigoRegion = " + id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                oS = new FARegionDTO(rs.getInt(1)       // CodigoRegion
                                    , rs.getString(2)   // NombreRegion
                                    , rs.getString(3)   // Estado             
                                    , rs.getString(4)   // FechaCrea         
                                    , rs.getString(5)); // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<FARegionDTO> readAll() throws Exception {
        List<FARegionDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoRegion "
                     + " ,NombreRegion     "
                     + " ,Estado           "
                     + " ,FechaCrea        "
                     + " ,FechaModifica    "
                     + " FROM   FARegion   "
                     + " WHERE  Estado = 'A' ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                FARegionDTO s = new FARegionDTO(rs.getInt(1)       // CodigoRegion
                                                , rs.getString(2)   // NombreRegion
                                                , rs.getString(3)   // Estado             
                                                , rs.getString(4)   // FechaCrea         
                                                , rs.getString(5)); // FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean create(FARegionDTO entity) throws Exception {
        String query = " INSERT INTO FAREGION (NombreRegion) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreRegion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FARegionDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAREGION SET NombreRegion = ?, FechaModifica = ? WHERE CodigoRegion = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreRegion());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getCodigoRegion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    } 

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAREGION SET Estado = ? WHERE CodigoRegion = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM FAREGION "
                     + " WHERE   Estado = 'A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);
            }
        }
        catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
