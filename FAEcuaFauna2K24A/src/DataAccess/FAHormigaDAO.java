package DataAccess;

import DataAccess.DTO.FAHormigaDTO;
import Framework.FAException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 


public class FAHormigaDAO extends SQLiteDataHelper implements IDAO<FAHormigaDTO>  {

    @Override
    public boolean create(FAHormigaDTO entity) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        // TODO Auto-generated method stub
        return false;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(FAHormigaDTO entity) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }
    







}
