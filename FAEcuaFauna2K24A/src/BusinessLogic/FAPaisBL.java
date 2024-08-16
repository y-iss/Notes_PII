package BusinessLogic;

import java.util.List;

import DataAccess.FAPaisDAO;
import DataAccess.DTO.FAPaisDTO;

public class FAPaisBL {
    private FAPaisDTO faPaisDTO;
    private FAPaisDAO faPaisDAO = new FAPaisDAO();

    public FAPaisBL(){}

    public List<FAPaisDTO> getAll() throws Exception{
        List<FAPaisDTO> lst = faPaisDAO.readAll();
        for (FAPaisDTO faPaisDTO : lst) 
            faPaisDTO.setNombrePais(faPaisDTO.getNombrePais().toUpperCase());
        return lst;
    }
    
    public FAPaisDTO getBy(int faCodigoPais) throws Exception{
        faPaisDTO = faPaisDAO.readBy(faCodigoPais);
        return faPaisDTO;
    }
    
    public boolean add(FAPaisDTO faPaisDTO) throws Exception{   
        return faPaisDAO.create(faPaisDTO);
    }
    
    public boolean update(FAPaisDTO faPaisDTO) throws Exception{
        return faPaisDAO.update(faPaisDTO);
    }
    
    public boolean delete(int faCodigoPais) throws Exception{
        return faPaisDAO.delete(faCodigoPais);
    }
}
