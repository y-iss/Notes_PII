package DataAccess;

import DataAccess.DTO.FAHormigaDTO;
import Framework.FAException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 


public class FAHormigaDAO extends SQLiteDataHelper implements IDAO<FAHormigaDTO>  {

    @Override
    public boolean create(FAHormigaDTO entity) throws Exception {
        String query = "INSERT INTO FAHormiga (TipoHormiga, SexoId, ProvinciaId, GenoAlimentoId, IngestaNativaId, Estado, EstadoRegistro, FechaCreacion, FechaModifica) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getTipoHormiga());
            pstmt.setInt(2, entity.getSexoId());
            pstmt.setInt(3, entity.getProvinciaId());
            pstmt.setInt(4, entity.getGenoAlimentoId());
            pstmt.setInt(5, entity.getIngestaNativaId());
            pstmt.setString(6, entity.getEstado());
            pstmt.setString(7, entity.getEstadoRegistro());
            pstmt.setString(8, entity.getFechaCreacion());
            pstmt.setString(9, entity.getFechaModifica());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "DELETE FROM FAHormiga WHERE Id = ?";
        
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
    public List<FAHormigaDTO> readAll() throws Exception {
            List <FAHormigaDTO> lst = new ArrayList<>();
            String query =
                          " SELECT    Id         "
                         +" , TipoHormiga        "
                         +" , SexoId             "
                         +" , ProvinciaId        "
                         +" , GenoAlimentoId     "
                         +" , IngestaNativaId    "
                         +" , Estado             "
                         +" , EstadoRegistro    "
                         +" , FechaCreacion     "
                         +" , FechaModifica     "
                         +" FROM FAHormiga      "
                         +" WHERE  EstadoRegistro = 'A' ";
                           
            try {

                Connection conn = openConnection();         // conectar a DB     
                Statement  stmt = conn.createStatement();   // CRUD : select * ...    
                ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
                while (rs.next()) {
                    FAHormigaDTO s = new FAHormigaDTO( rs.getInt(1)  // id   
                                            ,rs.getString(2)    // tipohormiga          
                                            ,rs.getInt(3)     // sexoid
                                            ,rs.getInt(4)     // provinciaid 
                                            ,rs.getInt(5)  // genoalimentoid
                                            ,rs.getInt(6)   // ingestanativaid
                                            ,rs.getString(7)   // estado 
                                            ,rs.getString(8)   // estadoregistro
                                            ,rs.getString(9)   // fechacreacion
                                            ,rs.getString(10));  // fechamodifica 
                                             
                    lst.add(s);

                }
            } 
            catch (SQLException e) {
                throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
            }
            return lst; 
        }
    
    @Override
    public FAHormigaDTO readBy(Integer id) throws Exception {
        String query = "SELECT Id, TipoHormiga, SexoId, ProvinciaId, GenoAlimentoId, IngestaNativaId, Estado, EstadoRegistro, FechaCreacion, FechaModifica "
                     + "FROM FAHormiga WHERE Id = ? AND EstadoRegistro = 'A'";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new FAHormigaDTO(
                    rs.getInt("Id"),
                    rs.getString("TipoHormiga"),
                    rs.getInt("SexoId"),
                    rs.getInt("ProvinciaId"),
                    rs.getInt("GenoAlimentoId"),
                    rs.getInt("IngestaNativaId"),
                    rs.getString("Estado"),
                    rs.getString("EstadoRegistro"),
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
    public boolean update(FAHormigaDTO entity) throws Exception {
        String query = "UPDATE FAHormiga SET TipoHormiga = ?, SexoId = ?, ProvinciaId = ?, GenoAlimentoId = ?, IngestaNativaId = ?, "
                     + "Estado = ?, EstadoRegistro = ?, FechaModifica = ? WHERE Id = ?";
        
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getTipoHormiga());
            pstmt.setInt(2, entity.getSexoId());
            pstmt.setInt(3, entity.getProvinciaId());
            pstmt.setInt(4, entity.getGenoAlimentoId());
            pstmt.setInt(5, entity.getIngestaNativaId());
            pstmt.setString(6, entity.getEstado());
            pstmt.setString(7, entity.getEstadoRegistro());
            pstmt.setString(8, entity.getFechaModifica());
            pstmt.setInt(9, entity.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }
}
    


