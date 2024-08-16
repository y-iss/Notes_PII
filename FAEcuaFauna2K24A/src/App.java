import DataAccess.DTO.FAHormigaDTO;
import DataAccess.FAHormigaDAO;

public class App {
    public static void main(String[] args)  {
    
    // testing: DAO 
    try { 
        FAHormigaDAO sDAO = new FAHormigaDAO();
        for(FAHormigaDTO s : sDAO.readAll())
        System.out.println(s.toString());
    } catch (Exception e ) {
        System.out.println(e.toString());
    }
    
    }
}
