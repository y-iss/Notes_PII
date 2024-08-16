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

import DataAccess.DTO.FAEstadoDTO;
import Framework.FAException;
import Framework.PatException;

public class FAEstadoDAO extends FAEcuaFaunaDataHelper implements IDAO<FAEstadoDTO> {

    @Override
    public FAEstadoDTO readBy(Integer id) throws Exception {
        FAEstadoDTO estado = new FAEstadoDTO();
        String query = " SELECT CodigoEstado "
                     + " ,NombreEstado  "
                     + " ,Estado        "
                     + " ,FechaCrea     "
                     + " ,FechaModifica "
                     + " FROM FAEstado "
                     + " WHERE Estado = 'A' AND CodigoEstado = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                estado = new FAEstadoDTO(rs.getInt(1),       // CodigoEstado
                                         rs.getString(2),   // NombreEstado
                                         rs.getString(3),   // Estado
                                         rs.getString(4),   // FechaCrea
                                         rs.getString(5));  // FechaModifica
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return estado;
    }

    @Override
    public List<FAEstadoDTO> readAll() throws Exception {
        List<FAEstadoDTO> lst = new ArrayList<>();
        String query = " SELECT CodigoEstado "
                     + " ,NombreEstado  "
                     + " ,Estado        "
                     + " ,FechaCrea     "
                     + " ,FechaModifica "
                     + " FROM FAEstado "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FAEstadoDTO estado = new FAEstadoDTO(rs.getInt(1),       // CodigoEstado
                                                     rs.getString(2),   // NombreEstado
                                                     rs.getString(3),   // Estado
                                                     rs.getString(4),   // FechaCrea
                                                     rs.getString(5));  // FechaModifica
                lst.add(estado);
            }
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(FAEstadoDTO entity) throws Exception {
        String query = " INSERT INTO FAEstado (NombreEstado) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreEstado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(FAEstadoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE FAEstado SET NombreEstado = ?, FechaModifica = ? WHERE CodigoEstado = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreEstado());
            pstmt.setString(2, dtf.format(now));
            pstmt.setInt(3, entity.getCodigoEstado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new FAException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE FAEstado SET Estado = ? WHERE CodigoEstado = ?";
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
        String query = " SELECT COUNT(*) TotalReg FROM FAEstado "
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

