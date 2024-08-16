package BusinessLogic;

import java.util.List;

import DataAccess.FAEstadoDAO;
import DataAccess.DTO.FAEstadoDTO;

public class FAEstadoBL {
    private FAEstadoDTO faEstadoDTO;
    private FAEstadoDAO faEstadoDAO = new FAEstadoDAO();

    public FAEstadoBL(){}

    public List<FAEstadoDTO> getAll() throws Exception{
        List<FAEstadoDTO> lst = faEstadoDAO.readAll();
        for (FAEstadoDTO faEstadoDTO : lst) 
            faEstadoDTO.setNombreEstado(faEstadoDTO.getNombreEstado().toUpperCase());
        return lst;
    }
    
    public FAEstadoDTO getBy(int faCodigoEstado) throws Exception{
        faEstadoDTO = faEstadoDAO.readBy(faCodigoEstado);
        return faEstadoDTO;
    }
    
    public boolean add(FAEstadoDTO faEstadoDTO) throws Exception{   
        return faEstadoDAO.create(faEstadoDTO);
    }
    
    public boolean update(FAEstadoDTO faEstadoDTO) throws Exception{
        return faEstadoDAO.update(faEstadoDTO);
    }
    
    public boolean delete(int faCodigoEstado) throws Exception{
        return faEstadoDAO.delete(faCodigoEstado);
    }
}

