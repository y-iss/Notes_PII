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

import DataAccess.DTO.FAHormigaAlimentoDTO;
import Framework.FAException;

public class FAHormigaAlimentoDAO extends FAEcuaFaunaDataHelper implements IDAO<FAHormigaAlimentoDTO> {

    @Override
    public FAHormigaAlimentoDTO readBy(Integer id) throws Exception {
        FAHormigaAlimentoDTO hormigaAlimento = new FAHormigaAlimentoDTO();
        String query = " SELECT CodigoHormigaAlimento "
                     + " ,CodigoHormiga        "
                     + " ,CodigoAlimento       "
                     + " ,Estado              "
                     + " ,FechaCrea           "
                     + " ,FechaModifica       "
                     + " FROM FAHormigaAlimento "
                     + " WHERE Estado = 'A' AND CodigoHormigaAlimento = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                hormigaAlimento = new FAHormigaAlimentoDTO(rs.getInt(1),       // CodigoHormigaAlimento
                                                           rs.getInt(2),       // CodigoHormiga
                                                           rs.getInt(3),       // CodigoAlimento
                                                           rs.getString(4),   // Estado
                                                           rs.getString(5),   // FechaCrea
                                                           rs.getString(6));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return hormigaAlimento;
    }

    @Override
    public List<FAHormigaAlimentoDTO> readAll() throws Exception {
        List<FAHormigaAlimentoDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoHormigaAlimento "
                     + " ,CodigoHormiga        "
                     + " ,CodigoAlimento       "
                     + " ,Estado              "
                     + " ,FechaCrea           "
                     + " ,FechaModifica       "
                     + " FROM FAHormigaAlimento "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FAHormigaAlimentoDTO hormigaAlimento = new FAHormigaAlimentoDTO(rs.getInt(1),       // CodigoHormigaAlimento
                                                                               rs.getInt(2),       // CodigoHormiga
                                                                               rs.getInt(3),       // CodigoAlimento
                                                                               rs.getString(4),   // Estado
                                                                               rs.getString(5),   // FechaCrea
                                                                               rs.getString(6));  // FechaModifica
                lst.add(hormigaAlimento);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FAHormigaAlimentoDTO entity) throws Exception {
        String query = " INSERT INTO FAHormigaAlimento (CodigoHormiga, CodigoAlimento) VALUES (?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.faGetCodigoHormiga());
            pstmt.setInt(2, entity.faGetCodigoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FAHormigaAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAHormigaAlimento SET CodigoHormiga = ?, CodigoAlimento = ?, FechaModifica = ? WHERE CodigoHormigaAlimento = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.faGetCodigoHormiga());
            pstmt.setInt(2, entity.faGetCodigoAlimento());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.faGetCodigoHormigaAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAHormigaAlimento SET Estado = ? WHERE CodigoHormigaAlimento = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM FAHormigaAlimento "
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

