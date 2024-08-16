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

import DataAccess.DTO.FAGenoAlimentoDTO;
import Framework.FAException;


public class FAGenoAlimentoDAO extends FAEcuaFaunaDataHelper implements IDAO<FAGenoAlimentoDTO> {

    @Override
    public FAGenoAlimentoDTO readBy(Integer id) throws Exception {
        FAGenoAlimentoDTO geno = new FAGenoAlimentoDTO();
        String query = " SELECT CodigoGenoAlimento "
                     + " ,NombreGenoAlimento "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM FAGenoAlimento "
                     + " WHERE Estado = 'A' AND CodigoGenoAlimento = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                geno = new FAGenoAlimentoDTO(rs.getInt(1),       // CodigoGenoAlimento
                                             rs.getString(2),   // NombreGenoAlimento
                                             rs.getString(3),   // Estado
                                             rs.getString(4),   // FechaCrea
                                             rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return geno;
    }

    @Override
    public List<FAGenoAlimentoDTO> readAll() throws Exception {
        List<FAGenoAlimentoDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoGenoAlimento "
                     + " ,NombreGenoAlimento "
                     + " ,Estado             "
                     + " ,FechaCrea          "
                     + " ,FechaModifica      "
                     + " FROM FAGenoAlimento "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FAGenoAlimentoDTO geno = new FAGenoAlimentoDTO(rs.getInt(1),       // CodigoGenoAlimento
                                                               rs.getString(2),   // NombreGenoAlimento
                                                               rs.getString(3),   // Estado
                                                               rs.getString(4),   // FechaCrea
                                                               rs.getString(5));  // FechaModifica
                lst.add(geno);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FAGenoAlimentoDTO entity) throws Exception {
        String query = " INSERT INTO FAGenoAlimento (NombreGenoAlimento) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreGenoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FAGenoAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAGenoAlimento SET NombreGenoAlimento = ?, FechaModifica = ? WHERE CodigoGenoAlimento = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreGenoAlimento());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoGenoAlimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAGenoAlimento SET Estado = ? WHERE CodigoGenoAlimento = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM FAGenoAlimento "
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

