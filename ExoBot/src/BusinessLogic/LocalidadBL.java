package BusinessLogic;

import java.util.List;

import DataAccess.LocalidadDAO;
import DataAccess.DTO.LocalidadDTO;

public class LocalidadBL {
    private LocalidadDAO lDAO= new LocalidadDAO();
    
    public LocalidadBL() {}

    public List<LocalidadDTO> getAll() throws Exception{
        return lDAO.readAll();
    }
    
    public List<LocalidadDTO> getAllProvincia() throws Exception{
        return lDAO.readAllEstructura("Provincia");
    }
    
    public List<LocalidadDTO> getAllCanton() throws Exception{
        return lDAO.readAllEstructura("Cantón");
    }

    public LocalidadDTO getById(int id) throws Exception{
        return lDAO.readBy(id);
    }
}
