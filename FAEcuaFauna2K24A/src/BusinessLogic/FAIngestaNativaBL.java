package BusinessLogic;

import java.util.List;

import DataAccess.FAIngestaNativaDAO;
import DataAccess.DTO.FAIngestaNativaDTO;

public class FAIngestaNativaBL {
    private FAIngestaNativaDTO faIngestaNativaDTO;
    private FAIngestaNativaDAO faIngestaNativaDAO = new FAIngestaNativaDAO();

    public FAIngestaNativaBL() {}

    public List<FAIngestaNativaDTO> getAll() throws Exception {
        List<FAIngestaNativaDTO> lst = faIngestaNativaDAO.readAll();
        for (FAIngestaNativaDTO faIngestaNativaDTO : lst) 
            faIngestaNativaDTO.setNombreIngestaNativa(faIngestaNativaDTO.getNombreIngestaNativa().toUpperCase());
        return lst;
    }

    public FAIngestaNativaDTO getBy(int codigoIngestaNativa) throws Exception {
        faIngestaNativaDTO = faIngestaNativaDAO.readBy(codigoIngestaNativa);
        return faIngestaNativaDTO;
    }

    public boolean add(FAIngestaNativaDTO faIngestaNativaDTO) throws Exception {   
        return faIngestaNativaDAO.create(faIngestaNativaDTO);
    }

    public boolean update(FAIngestaNativaDTO faIngestaNativaDTO) throws Exception {
        return faIngestaNativaDAO.update(faIngestaNativaDTO);
    }

    public boolean delete(int codigoIngestaNativa) throws Exception {
        return faIngestaNativaDAO.delete(codigoIngestaNativa);
    }
}


