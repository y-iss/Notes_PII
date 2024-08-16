package BusinessLogic;

import java.util.List;

import DataAccess.FAGenoAlimentoDAO;
import DataAccess.DTO.FAGenoAlimentoDTO;

public class FAGenoAlimentoBL {
    private FAGenoAlimentoDTO faGenoAlimentoDTO;
    private FAGenoAlimentoDAO faGenoAlimentoDAO = new FAGenoAlimentoDAO();

    public FAGenoAlimentoBL() {}

    public List<FAGenoAlimentoDTO> getAll() throws Exception {
        List<FAGenoAlimentoDTO> lst = faGenoAlimentoDAO.readAll();
        for (FAGenoAlimentoDTO faGenoAlimentoDTO : lst) 
            faGenoAlimentoDTO.setNombreGenoAlimento(faGenoAlimentoDTO.getNombreGenoAlimento().toUpperCase());
        return lst;
    }

    public FAGenoAlimentoDTO getBy(int codigoGenoAlimento) throws Exception {
        faGenoAlimentoDTO = faGenoAlimentoDAO.readBy(codigoGenoAlimento);
        return faGenoAlimentoDTO;
    }

    public boolean add(FAGenoAlimentoDTO faGenoAlimentoDTO) throws Exception {   
        return faGenoAlimentoDAO.create(faGenoAlimentoDTO);
    }

    public boolean update(FAGenoAlimentoDTO faGenoAlimentoDTO) throws Exception {
        return faGenoAlimentoDAO.update(faGenoAlimentoDTO);
    }

    public boolean delete(int codigoGenoAlimento) throws Exception {
        return faGenoAlimentoDAO.delete(codigoGenoAlimento);
    }
}
