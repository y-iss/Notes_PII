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

import DataAccess.DTO.FAIngestaNativaDTO;
import Framework.FAException;

public class FAIngestaNativaDAO extends FAEcuaFaunaDataHelper implements IDAO<FAIngestaNativaDTO> {

    @Override
    public FAIngestaNativaDTO readBy(Integer id) throws Exception {
        FAIngestaNativaDTO ingesta = new FAIngestaNativaDTO();
        String query = " SELECT CodigoIngestaNativa "
                     + " ,NombreIngestaNativa "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM FAIngestaNativa "
                     + " WHERE Estado = 'A' AND CodigoIngestaNativa = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ingesta = new FAIngestaNativaDTO(rs.getInt(1),       // CodigoIngestaNativa
                                                 rs.getString(2),   // NombreIngestaNativa
                                                 rs.getString(3),   // Estado
                                                 rs.getString(4),   // FechaCrea
                                                 rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return ingesta;
    }

    @Override
    public List<FAIngestaNativaDTO> readAll() throws Exception {
        List<FAIngestaNativaDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoIngestaNativa "
                     + " ,NombreIngestaNativa "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM FAIngestaNativa "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FAIngestaNativaDTO ingesta = new FAIngestaNativaDTO(rs.getInt(1),       // CodigoIngestaNativa
                                                                   rs.getString(2),   // NombreIngestaNativa
                                                                   rs.getString(3),   // Estado
                                                                   rs.getString(4),   // FechaCrea
                                                                   rs.getString(5));  // FechaModifica
                lst.add(ingesta);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FAIngestaNativaDTO entity) throws Exception {
        String query = " INSERT INTO FAIngestaNativa (NombreIngestaNativa) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreIngestaNativa());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FAIngestaNativaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAIngestaNativa SET NombreIngestaNativa = ?, FechaModifica = ? WHERE CodigoIngestaNativa = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreIngestaNativa());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoIngestaNativa());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAIngestaNativa SET Estado = ? WHERE CodigoIngestaNativa = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM FAIngestaNativa "
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

