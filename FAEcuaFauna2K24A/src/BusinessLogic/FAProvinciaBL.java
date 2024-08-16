package BusinessLogic;

import java.util.List;

import DataAccess.FAProvinciaDAO;
import DataAccess.DTO.FAProvinciaDTO;

public class FAProvinciaBL {
    private FAProvinciaDTO faProvinciaDTO;
    private FAProvinciaDAO faProvinciaDAO = new FAProvinciaDAO();

    public FAProvinciaBL() {}

    public List<FAProvinciaDTO> getAll() throws Exception {
        List<FAProvinciaDTO> lst = faProvinciaDAO.readAll();
        for (FAProvinciaDTO faProvinciaDTO : lst) 
            faProvinciaDTO.setNombreProvincia(faProvinciaDTO.getNombreProvincia().toUpperCase());
        return lst;
    }

    public FAProvinciaDTO getBy(int codigoProvincia) throws Exception {
        faProvinciaDTO = faProvinciaDAO.readBy(codigoProvincia);
        return faProvinciaDTO;
    }

    public boolean add(FAProvinciaDTO faProvinciaDTO) throws Exception {   
        return faProvinciaDAO.create(faProvinciaDTO);
    }

    public boolean update(FAProvinciaDTO faProvinciaDTO) throws Exception {
        return faProvinciaDAO.update(faProvinciaDTO);
    }

    public boolean delete(int codigoProvincia) throws Exception {
        return faProvinciaDAO.delete(codigoProvincia);
    }
}
