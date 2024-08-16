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

import DataAccess.DTO.FASexoDTO;
import Framework.FAException;

public class FASexoDAO extends FAEcuaFaunaDataHelper implements IDAO<FASexoDTO> {

    @Override
    public FASexoDTO readBy(Integer id) throws Exception {
        FASexoDTO sexo = new FASexoDTO();
        String query = " SELECT CodigoSexo "
                     + " ,NombreSexo  "
                     + " ,Estado      "
                     + " ,FechaCrea   "
                     + " ,FechaModifica "
                     + " FROM FASexo "
                     + " WHERE Estado = 'A' AND CodigoSexo = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                sexo = new FASexoDTO(rs.getInt(1),       // CodigoSexo
                                     rs.getString(2),   // NombreSexo
                                     rs.getString(3),   // Estado
                                     rs.getString(4),   // FechaCrea
                                     rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return sexo;
    }

    @Override
    public List<FASexoDTO> readAll() throws Exception {
        List<FASexoDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoSexo "
                     + " ,NombreSexo  "
                     + " ,Estado      "
                     + " ,FechaCrea   "
                     + " ,FechaModifica "
                     + " FROM FASexo "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FASexoDTO sexo = new FASexoDTO(rs.getInt(1),       // CodigoSexo
                                                rs.getString(2),   // NombreSexo
                                                rs.getString(3),   // Estado
                                                rs.getString(4),   // FechaCrea
                                                rs.getString(5));  // FechaModifica
                lst.add(sexo);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FASexoDTO entity) throws Exception {
        String query = " INSERT INTO FASexo (NombreSexo) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreSexo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FASexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FASexo SET NombreSexo = ?, FechaModifica = ? WHERE CodigoSexo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreSexo());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoSexo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FASexo SET Estado = ? WHERE CodigoSexo = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM FASexo "
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
