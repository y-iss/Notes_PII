package DataAccess;

import DataAccess.DTO.FARegionDTO;
import Framework.FAException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FARegionDAO extends SQLiteDataHelper implements IDAO<FARegionDTO> {

    @Override
    public boolean create(FARegionDTO entity) throws Exception {
        String query = "INSERT INTO FARegion (Nombre, Estado, FechaCreacion, FechaModifica) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.setString(3, entity.getFechaCreacion());
            pstmt.setString(4, entity.getFechaModifica());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "DELETE FROM FARegion WHERE Id = ?";
        
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
    public List<FARegionDTO> readAll() throws Exception {
        List<FARegionDTO> lst = new ArrayList<>();
        String query = "SELECT Id, Nombre, Estado, FechaCreacion, FechaModifica FROM FARegion WHERE Estado = 'A'";
        
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                FARegionDTO dto = new FARegionDTO(
                    rs.getInt("Id"),
                    rs.getString("Nombre"),
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
    public FARegionDTO readBy(Integer id) throws Exception {
        String query = "SELECT Id, Nombre, Estado, FechaCreacion, FechaModifica FROM FARegion WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new FARegionDTO(
                    rs.getInt("Id"),
                    rs.getString("Nombre"),
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
    public boolean update(FARegionDTO entity) throws Exception {
        String query = "UPDATE FARegion SET Nombre = ?, Estado = ?, FechaModifica = ? WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getEstado());
            pstmt.setString(3, entity.getFechaModifica());
            pstmt.setInt(4, entity.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }
}

