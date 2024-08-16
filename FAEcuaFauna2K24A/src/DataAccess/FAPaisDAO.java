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

import DataAccess.DTO.FAPaisDTO;
import Framework.FAException;

public class FAPaisDAO extends FAEcuaFaunaDataHelper implements IDAO<FAPaisDTO> {

    @Override
    public FAPaisDTO readBy(Integer id) throws Exception {
        FAPaisDTO pais = new FAPaisDTO();
        String query = " SELECT CodigoPais "
                     + " ,NombrePais      "
                     + " ,Estado          "
                     + " ,FechaCrea       "
                     + " ,FechaModifica   "
                     + " FROM FAPais      "
                     + " WHERE Estado = 'A' AND CodigoPais = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pais = new FAPaisDTO(rs.getInt(1),   // CodigoPais
                                     rs.getString(2), // NombrePais
                                     rs.getString(3), // Estado
                                     rs.getString(4), // FechaCrea
                                     rs.getString(5));// FechaModifica
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return pais;
    }

    @Override
    public List<FAPaisDTO> readAll() throws Exception {
        List<FAPaisDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoPais "
                     + " ,NombrePais      "
                     + " ,Estado          "
                     + " ,FechaCrea       "
                     + " ,FechaModifica   "
                     + " FROM FAPais      "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FAPaisDTO pais = new FAPaisDTO(rs.getInt(1),   // CodigoPais
                                               rs.getString(2), // NombrePais
                                               rs.getString(3), // Estado
                                               rs.getString(4), // FechaCrea
                                               rs.getString(5));// FechaModifica
                lst.add(pais);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FAPaisDTO entity) throws Exception {
        String query = " INSERT INTO FAPais (NombrePais) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombrePais());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FAPaisDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAPais SET NombrePais = ?, FechaModifica = ? WHERE CodigoPais = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombrePais());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoPais());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAPais SET Estado = ? WHERE CodigoPais = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM FAPais "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}

