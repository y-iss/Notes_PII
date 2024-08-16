package BusinessLogic;

import java.util.List;

import DataAccess.FATipoHormigaDAO;
import DataAccess.DTO.FATipoHormigaDTO;

public class FATipoHormigaBL {
    private FATipoHormigaDTO faTipoHormigaDTO;
    private FATipoHormigaDAO faTipoHormigaDAO = new FATipoHormigaDAO();

    public FATipoHormigaBL(){}

    public List<FATipoHormigaDTO> getAll() throws Exception{
        List<FATipoHormigaDTO> lst = faTipoHormigaDAO.readAll();
        for (FATipoHormigaDTO faTipoHormigaDTO : lst) 
            faTipoHormigaDTO.setNombreTipoHormiga(faTipoHormigaDTO.getNombreTipoHormiga().toUpperCase());
        return lst;
    }
    
    public FATipoHormigaDTO getBy(int faCodigoTipoHormiga) throws Exception{
        faTipoHormigaDTO = faTipoHormigaDAO.readBy(faCodigoTipoHormiga);
        return faTipoHormigaDTO;
    }
    
    public boolean add(FATipoHormigaDTO faTipoHormigaDTO) throws Exception{   
        return faTipoHormigaDAO.create(faTipoHormigaDTO);
    }
    
    public boolean update(FATipoHormigaDTO faTipoHormigaDTO) throws Exception{
        return faTipoHormigaDAO.update(faTipoHormigaDTO);
    }
    
    public boolean delete(int faCodigoTipoHormiga) throws Exception{
        return faTipoHormigaDAO.delete(faCodigoTipoHormiga);
    }
}

