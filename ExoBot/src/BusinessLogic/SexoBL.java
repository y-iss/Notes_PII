package BusinessLogic;

import java.util.List;

import DataAccess.SexoDAO;
import DataAccess.DTO.SexoDTO;

public class SexoBL {
    private SexoDTO sexo;
    private SexoDAO sDAO = new SexoDAO();

    public SexoBL(){}

    public List<SexoDTO> getAll() throws Exception{
        List<SexoDTO> lst = sDAO.readAll();
        for (SexoDTO sexoDTO : lst) 
            sexoDTO.setNombre(sexoDTO.getNombre().toUpperCase());
        return lst;
    }
    public SexoDTO getBy(int idSexo) throws Exception{
        sexo = sDAO.readBy(idSexo);
        return sexo;
    }
    public boolean add(SexoDTO sexoDTO) throws Exception{   
        return sDAO.create(sexoDTO);
    }
    public boolean update(SexoDTO sexoDTO) throws Exception{
        return sDAO.update(sexoDTO);
    }
    public boolean delete(int idSexo) throws Exception{
        return sDAO.delete(idSexo);
    }
    public Integer getRowCount() throws Exception{
        return sDAO.getRowCount();
    }
}
