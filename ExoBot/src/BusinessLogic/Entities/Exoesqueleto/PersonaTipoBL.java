package BusinessLogic.Entities.Exoesqueleto;

import java.util.List;

import DataAccess.PersonaTipoDAO;
import DataAccess.DTO.PersonaTipoDTO;

public class PersonaTipoBL {
    private PersonaTipoDTO ptDTO;
    private PersonaTipoDAO ptDAO = new PersonaTipoDAO();

    public PersonaTipoBL(){}

    public List<PersonaTipoDTO> getAll() throws Exception{
        return ptDAO.readAll();
    }
    public PersonaTipoDTO getBy(int idReg) throws Exception{
        ptDTO = ptDAO.readBy(idReg);
        return ptDTO;
    }
    public boolean add(PersonaTipoDTO regDTO) throws Exception{   
        return ptDAO.create(regDTO);
    }
    public boolean update(PersonaTipoDTO regDTO) throws Exception{
        return ptDAO.update(regDTO);
    }
    public boolean delete(int idReg) throws Exception{
        return ptDAO.delete(idReg);
    }
    public Integer getRowCount() throws Exception{
        return ptDAO.getRowCount();
    }
}
