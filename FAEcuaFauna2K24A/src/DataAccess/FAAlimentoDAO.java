package DataAccess;

import DataAccess.DTO.FAAlimentoDTO;
import Framework.FAException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FAAlimentoDAO extends SQLiteDataHelper implements IDAO<FAAlimentoDTO> {

    @Override
    public boolean create(FAAlimentoDTO entity) throws Exception {
        String query = "INSERT INTO FAAlimento (Tipo, Categoria, Estado, FechaCreacion, FechaModifica) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getTipo());
            pstmt.setString(2, entity.getCategoria());
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
        String query = "DELETE FROM FAAlimento WHERE Id = ?";
        
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
    public List<FAAlimentoDTO> readAll() throws Exception {
        List<FAAlimentoDTO> lst = new ArrayList<>();
        String query = "SELECT Id, Tipo, Categoria, Estado, FechaCreacion, FechaModifica FROM FAAlimento WHERE Estado = 'A'";
        
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                FAAlimentoDTO dto = new FAAlimentoDTO(
                    rs.getInt("Id"),
                    rs.getString("Tipo"),
                    rs.getString("Categoria"),
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
    public FAAlimentoDTO readBy(Integer id) throws Exception {
        String query = "SELECT Id, Tipo, Categoria, Estado, FechaCreacion, FechaModifica FROM FAAlimento WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new FAAlimentoDTO(
                    rs.getInt("Id"),
                    rs.getString("Tipo"),
                    rs.getString("Categoria"),
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
    public boolean update(FAAlimentoDTO entity) throws Exception {
        String query = "UPDATE FAAlimento SET Tipo = ?, Categoria = ?, Estado = ?, FechaModifica = ? WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getTipo());
            pstmt.setString(2, entity.getCategoria());
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


