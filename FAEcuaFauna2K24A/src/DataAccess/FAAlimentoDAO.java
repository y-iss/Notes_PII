package DataAccess;

import DataAccess.DTO.FAAlimentoDTO;
import Framework.FAException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FAAlimentoDAO extends FAEcuaFaunaDataHelper implements IDAO<FAAlimentoDTO> {

    @Override
    public FAAlimentoDTO readBy(Integer id) throws Exception {
        FAAlimentoDTO alimento = new FAAlimentoDTO();
        String query = " SELECT CodigoAlimento "
                     + " ,NombreAlimento "
                     + " ,CodigoIngestaNativa "
                     + " ,CodigoGenoAlimento "
                     + " ,DescripcionAlimento "
                     + " ,Estado "
                     + " ,FechaCrea "
                     + " ,FechaModifica "
                     + " FROM FAAlimento "
                     + " WHERE Estado = 'A' AND CodigoAlimento = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                alimento = new FAAlimentoDTO(rs.getInt(1),                 // CodigoAlimento
                                             rs.getString(2),             // NombreAlimento
                                             rs.getInt(3),                // CodigoIngestaNativa
                                             rs.getInt(4),                // CodigoGenoAlimento
                                             rs.getString(5),             // DescripcionAlimento
                                             rs.getString(6),             // Estado
                                             rs.getString(7),             // FechaCrea
                                             rs.getString(8));            // FechaModifica
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return alimento;
    }

    @Override
    public List<FAAlimentoDTO> readAll() throws Exception {
        List<FAAlimentoDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoAlimento "
                     + " ,NombreAlimento "
                     + " ,CodigoIngestaNativa "
                     + " ,CodigoGenoAlimento "
                     + " ,DescripcionAlimento "
                     + " ,Estado "
                     + " ,FechaCrea "
                     + " ,FechaModifica "
                     + " FROM FAAlimento "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FAAlimentoDTO alimento = new FAAlimentoDTO(rs.getInt(1),                 // CodigoAlimento
                                                         rs.getString(2),             // NombreAlimento
                                                         rs.getInt(3),                // CodigoIngestaNativa
                                                         rs.getInt(4),                // CodigoGenoAlimento
                                                         rs.getString(5),             // DescripcionAlimento
                                                         rs.getString(6),             // Estado
                                                         rs.getString(7),             // FechaCrea
                                                         rs.getString(8));            // FechaModifica
                lst.add(alimento);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FAAlimentoDTO entity) throws Exception {
        String query = " INSERT INTO FAAlimento (NombreAlimento, CodigoIngestaNativa, "
                     + " CodigoGenoAlimento, DescripcionAlimento, Estado, FechaCrea) "
                     + " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.faGetNombreAlimento());
            pstmt.setInt(2, entity.faGetCodigoIngestaNativa());
            pstmt.setInt(3, entity.faGetCodigoGenoAlimento());
            pstmt.setString(4, entity.faGetDescripcionAlimento());
            pstmt.setString(5, entity.faGetEstado());
            pstmt.setString(6, entity.faGetFechaCrea());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FAAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAAlimento SET NombreAlimento = ?, CodigoIngestaNativa = ?, "
                     + " CodigoGenoAlimento = ?, DescripcionAlimento = ?, FechaModifica = ? "
                     + " WHERE CodigoAlimento = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.faGetNombreAlimento());
            pstmt.setInt(2, entity.faGetCodigoIngestaNativa());
            pstmt.setInt(3, entity.faGetCodigoGenoAlimento());
            pstmt.setString(4, entity.faGetDescripcionAlimento());
            pstmt.setString(5, dtf.format(now));
            pstmt.setInt(6, entity.faGetCodigoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAAlimento SET Estado = 'X' WHERE CodigoAlimento = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM FAAlimento "
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

