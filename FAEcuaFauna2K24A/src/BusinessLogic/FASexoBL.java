package BusinessLogic;

import java.util.List;

import DataAccess.FASexoDAO;
import DataAccess.DTO.FASexoDTO;

public class FASexoBL {
    private FASexoDTO faSexoDTO;
    private FASexoDAO faSexoDAO = new FASexoDAO();

    public FASexoBL() {}

    public List<FASexoDTO> getAll() throws Exception {
        List<FASexoDTO> lst = faSexoDAO.readAll();
        for (FASexoDTO faSexoDTO : lst) 
            faSexoDTO.setNombreSexo(faSexoDTO.getNombreSexo().toUpperCase());
        return lst;
    }

    public FASexoDTO getBy(int codigoSexo) throws Exception {
        faSexoDTO = faSexoDAO.readBy(codigoSexo);
        return faSexoDTO;
    }

    public boolean add(FASexoDTO faSexoDTO) throws Exception {   
        return faSexoDAO.create(faSexoDTO);
    }

    public boolean update(FASexoDTO faSexoDTO) throws Exception {
        return faSexoDAO.update(faSexoDTO);
    }

    public boolean delete(int codigoSexo) throws Exception {
        return faSexoDAO.delete(codigoSexo);
    }
}

