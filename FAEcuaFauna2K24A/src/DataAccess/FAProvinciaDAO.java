package DataAccess;

import DataAccess.DTO.FAProvinciaDTO;
import Framework.FAException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FAProvinciaDAO extends SQLiteDataHelper implements IDAO<FAProvinciaDTO> {

    @Override
    public boolean create(FAProvinciaDTO entity) throws Exception {
        String query = "INSERT INTO FAProvincia (Nombre, RegionId, Estado, FechaCreacion, FechaModifica) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getRegionId());
            pstmt.setString(3, entity.getEstado());
            pstmt.setString(4, entity.getFechaCreacion());
            pstmt.setString(5, entity.getFechaModifica());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "DELETE FROM FAProvincia WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public List<FAProvinciaDTO> readAll() throws Exception {
        List<FAProvinciaDTO> lst = new ArrayList<>();
        String query = "SELECT Id, Nombre, RegionId, Estado, FechaCreacion, FechaModifica FROM FAProvincia WHERE Estado = 'A'";
        
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                FAProvinciaDTO dto = new FAProvinciaDTO(
                    rs.getInt("Id"),
                    rs.getString("Nombre"),
                    rs.getInt("RegionId"),
                    rs.getString("Estado"),
                    rs.getString("FechaCreacion"),
                    rs.getString("FechaModifica")
                );
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public FAProvinciaDTO readBy(Integer id) throws Exception {
        String query = "SELECT Id, Nombre, RegionId, Estado, FechaCreacion, FechaModifica FROM FAProvincia WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new FAProvinciaDTO(
                    rs.getInt("Id"),
                    rs.getString("Nombre"),
                    rs.getInt("RegionId"),
                    rs.getString("Estado"),
                    rs.getString("FechaCreacion"),
                    rs.getString("FechaModifica")
                );
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return null;
    }

    @Override
    public boolean update(FAProvinciaDTO entity) throws Exception {
        String query = "UPDATE FAProvincia SET Nombre = ?, RegionId = ?, Estado = ?, FechaModifica = ? WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getRegionId());
            pstmt.setString(3, entity.getEstado());
            pstmt.setString(4, entity.getFechaModifica());
            pstmt.setInt(5, entity.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }
}

