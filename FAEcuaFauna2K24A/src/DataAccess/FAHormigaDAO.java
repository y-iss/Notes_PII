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

import DataAccess.DTO.FAHormigaDTO;
import Framework.FAException;

public class FAHormigaDAO extends FAEcuaFaunaDataHelper implements IDAO<FAHormigaDTO> {

    @Override
    public FAHormigaDTO readBy(Integer id) throws Exception {
        FAHormigaDTO hormiga = new FAHormigaDTO();
        String query = " SELECT CodigoHormiga "
                     + " ,NombreHormiga "
                     + " ,CodigoSexo "
                     + " ,CodigoTipoHormiga "
                     + " ,CodigoEstado "
                     + " ,CodigoProvincia "
                     + " ,CodigoAlimento "
                     + " ,Estado "
                     + " ,FechaCrea "
                     + " ,FechaModifica "
                     + " FROM FAHormiga "
                     + " WHERE Estado = 'A' AND CodigoHormiga = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                hormiga = new FAHormigaDTO(rs.getInt(1),       // CodigoHormiga
                                           rs.getString(2),   // NombreHormiga
                                           rs.getInt(3),       // CodigoSexo
                                           rs.getInt(4),       // CodigoTipoHormiga
                                           rs.getInt(5),       // CodigoEstado
                                           rs.getInt(6),       // CodigoProvincia
                                           rs.getInt(7),       // CodigoAlimento
                                           rs.getString(8),   // Estado
                                           rs.getString(9),   // FechaCrea
                                           rs.getString(10)); // FechaModifica
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return hormiga;
    }

    @Override
    public List<FAHormigaDTO> readAll() throws Exception {
        List<FAHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoHormiga "
                     + " ,NombreHormiga "
                     + " ,CodigoSexo "
                     + " ,CodigoTipoHormiga "
                     + " ,CodigoEstado "
                     + " ,CodigoProvincia "
                     + " ,CodigoAlimento "
                     + " ,Estado "
                     + " ,FechaCrea "
                     + " ,FechaModifica "
                     + " FROM FAHormiga "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FAHormigaDTO hormiga = new FAHormigaDTO(rs.getInt(1),       // CodigoHormiga
                                                         rs.getString(2),   // NombreHormiga
                                                         rs.getInt(3),       // CodigoSexo
                                                         rs.getInt(4),       // CodigoTipoHormiga
                                                         rs.getInt(5),       // CodigoEstado
                                                         rs.getInt(6),       // CodigoProvincia
                                                         rs.getInt(7),       // CodigoAlimento
                                                         rs.getString(8),   // Estado
                                                         rs.getString(9),   // FechaCrea
                                                         rs.getString(10)); // FechaModifica
                lst.add(hormiga);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FAHormigaDTO entity) throws Exception {
        String query = " INSERT INTO FAHormiga (NombreHormiga, CodigoSexo, CodigoTipoHormiga, CodigoEstado, CodigoProvincia, CodigoAlimento) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.faGetNombreHormiga());
            pstmt.setInt(2, entity.faGetCodigoSexo());
            pstmt.setInt(3, entity.faGetCodigoTipoHormiga());
            pstmt.setInt(4, entity.faGetCodigoEstado());
            pstmt.setInt(5, entity.faGetCodigoProvincia());
            pstmt.setInt(6, entity.faGetCodigoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FAHormigaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAHormiga SET NombreHormiga = ?, CodigoSexo = ?, CodigoTipoHormiga = ?, CodigoEstado = ?, CodigoProvincia = ?, CodigoAlimento = ?, FechaModifica = ? WHERE CodigoHormiga = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.faGetNombreHormiga());
            pstmt.setInt(2, entity.faGetCodigoSexo());
            pstmt.setInt(3, entity.faGetCodigoTipoHormiga());
            pstmt.setInt(4, entity.faGetCodigoEstado());
            pstmt.setInt(5, entity.faGetCodigoProvincia());
            pstmt.setInt(6, entity.faGetCodigoAlimento());
            pstmt.setString(7, dtf.format(now));
            pstmt.setInt(8, entity.faGetCodigoHormiga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAHormiga SET Estado = ? WHERE CodigoHormiga = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM FAHormiga "
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

