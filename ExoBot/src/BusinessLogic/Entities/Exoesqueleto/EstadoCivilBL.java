package BusinessLogic.Entities.Exoesqueleto;

import java.util.List;

import DataAccess.EstadoCivilDAO;
import DataAccess.SexoDAO;
import DataAccess.DTO.EstadoCivilDTO;
import DataAccess.DTO.SexoDTO;

public class EstadoCivilBL {
    private EstadoCivilDTO ecDTO;
    private EstadoCivilDAO esDAO = new EstadoCivilDAO();

    public EstadoCivilBL(){}

    public List<EstadoCivilDTO> getAll() throws Exception{
        List<EstadoCivilDTO> lst = esDAO.readAll();
        for (EstadoCivilDTO sDTO : lst) 
            sDTO.setNombre(sDTO.getNombre().toUpperCase());
        return lst;
    }
    public EstadoCivilDTO getBy(int idReg) throws Exception{
        ecDTO = esDAO.readBy(idReg);
        return ecDTO;
    }
    public boolean add(EstadoCivilDTO regDTO) throws Exception{   
        return esDAO.create(regDTO);
    }
    public boolean update(EstadoCivilDTO regDTO) throws Exception{
        return esDAO.update(regDTO);
    }
    public boolean delete(int idReg) throws Exception{
        return esDAO.delete(idReg);
    }
    public Integer getRowCount() throws Exception{
        return esDAO.getRowCount();
    }
}
