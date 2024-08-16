package DataAccess;

import DataAccess.DTO.FASexoDTO;
import Framework.FAException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FASexoDAO extends SQLiteDataHelper implements IDAO<FASexoDTO> {

    @Override
    public boolean create(FASexoDTO entity) throws Exception {
        String query = "INSERT INTO FASexo (Nombre, Estado, FechaCreacion, FechaModifica) VALUES (?, ?, ?, ?)";
        
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
        String query = "DELETE FROM FASexo WHERE Id = ?";
        
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
    public List<FASexoDTO> readAll() throws Exception {
        List<FASexoDTO> lst = new ArrayList<>();
        String query = "SELECT Id, Nombre, Estado, FechaCreacion, FechaModifica FROM FASexo WHERE Estado = 'A'";
        
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                FASexoDTO dto = new FASexoDTO(
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
    public FASexoDTO readBy(Integer id) throws Exception {
        String query = "SELECT Id, Nombre, Estado, FechaCreacion, FechaModifica FROM FASexo WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new FASexoDTO(
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
    public boolean update(FASexoDTO entity) throws Exception {
        String query = "UPDATE FASexo SET Nombre = ?, Estado = ?, FechaModifica = ? WHERE Id = ?";
        
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

