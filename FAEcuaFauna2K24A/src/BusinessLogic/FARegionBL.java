package BusinessLogic;

import java.util.List;

import DataAccess.FARegionDAO;
import DataAccess.DTO.FARegionDTO;

public class FARegionBL {
    private FARegionDTO faRegionDTO;
    private FARegionDAO faRegionDAO = new FARegionDAO();

    public FARegionBL(){}

    public List<FARegionDTO> getAll() throws Exception{
        List<FARegionDTO> lst = faRegionDAO.readAll();
        for (FARegionDTO faRegionDTO : lst) 
            faRegionDTO.setNombreRegion(faRegionDTO.getNombreRegion().toUpperCase());
        return lst;
    }
    
    public FARegionDTO getBy(int faCodigoRegion) throws Exception{
        faRegionDTO = faRegionDAO.readBy(faCodigoRegion);
        return faRegionDTO;
    }
    
    public boolean add(FARegionDTO faRegionDTO) throws Exception{   
        return faRegionDAO.create(faRegionDTO);
    }
    
    public boolean update(FARegionDTO faRegionDTO) throws Exception{
        return faRegionDAO.update(faRegionDTO);
    }
    
    public boolean delete(int faCodigoRegion) throws Exception{
        return faRegionDAO.delete(faCodigoRegion);
    }
}

