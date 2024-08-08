/*---------------------------------------------------\
|  Copyright (©) 2K24 EPN-FIS. All rights reserved.  |
|  pat_mic@hotmail.com  PROPRIETARY/CONFIDENTIAL.    |
|  Use is subject to license terms.       pat_mic    |
\---------------------------------------------------*/

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import BusinessLogic.SexoBL;
import BusinessLogic.Entities.Exoesqueleto.EstadoCivilBL;
import BusinessLogic.Entities.Exoesqueleto.PersonaTipoBL;
import DataAccess.EstadoCivilDAO;
import DataAccess.PersonaTipoDAO;
import DataAccess.SexoDAO;
import DataAccess.DTO.EstadoCivilDTO;
import DataAccess.DTO.PersonaTipoDTO;
import DataAccess.DTO.SexoDTO;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        // Whiterun oWhiterun= new Whiterun();
        // oWhiterun.iniciar();

        // DACExoBot ex = new DACExoBot();
        // DACSexo  sx = new DACSexo();
        // ResultSet rs = sx.getAllSexo();
        // while (rs.next()) {
        //     System.out.println( rs.getString(1) + " " + rs.getString(2) + " "+ rs.getString(3));
        // }
        
        // SexoDTO s = new SexoDTO();
        // s.setIdSexo(3);
        // s.setNombre("Hibrido");
        // s.setFechaModifica("2023-05-18 17:39:46");
        // SexoDAO oS = new SexoDAO();
        // // oS.create(s);
        // oS.update(s);
        // System.out.println(oS.readBy(3).toString());

        // for (SexoDTO s  : oS.readAll()) {
        //     System.out.println(s.toString());
        //     //  System.out.println( s.getNombre() + " " + s.getFechaCrea() );
        // }
        // SexoBL sBl = new SexoBL();
        // sBl.update(5, "Macho Alpha");
        // sBl.delete(5);
        // for (SexoDTO s : sBl.getAll()) {
        //     System.out.println(s.toString());
        // }
        // Ventana v = new Ventana();

            // LocalidadDAO l = new LocalidadDAO();
            // System.out.println(l.readBy(2).toString());
            // for (LocalidadDTO loca : l.readAll()) {
            //     System.out.println(loca.toString());
            // }

            // LocalidadBL lBL= new LocalidadBL();
            // for (LocalidadDTO l : lBL.getAllCanton()) {
            //     System.out.println(l.toString());
            // }


        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } 
    
       SplashScreenForm.show();
       MainForm frmMain = new MainForm("IABot");

    //   testing: DAO
    //    try {
    //         SexoDAO sDao = new SexoDAO();
    //         for (SexoDTO s : sDao.readAll()) 
    //             System.out.println(s.toString());

    //         System.out.println("-------------------------");

    //         EstadoCivilDAO ecDAO = new EstadoCivilDAO();
    //         for (EstadoCivilDTO reg : ecDAO.readAll()) 
    //             System.out.println(reg.toString());

    //         System.out.println("-------------------------");

    //         PersonaTipoDAO pDAO = new PersonaTipoDAO();
    //         for (PersonaTipoDTO reg : pDAO.readAll()) 
    //             System.out.println(reg.toString());

                    
    //    } catch (Exception e) {
    //         System.out.println(e.toString());
    //    }
       
    //   testing: BL
    //     try {
    //         int a[] ={10,0}, b=10;

    //         try {
    //             int resultadoA =a[1]/b;
    //             int resultadoB = b / a[0];
    //             throw new Exception("Te quiero fregar la vida");
    //         }   
    //         catch (ArithmeticException  e) {
    //             System.out.println("El denominado no deber cero"); // + e.getMessage());
    //         }   
    //         catch (ArrayIndexOutOfBoundsException e) {
    //             System.out.print("Esta fuera de rango"); //+ e.getMessage());
    //         }   
    //         catch (Exception e) {
    //             System.out.println("Ups... lo siento ocurrio un error: " + e.getMessage());
    //         } finally {
    //             b=10;
    //             //System.out.println("finally : Ejecucion con o sin error");
    //         }
           


    //         SexoBL sBL = new SexoBL();
    //         //sBL.add(new SexoDTO(0,0,"nuevo sexo","prueba",null,null,null));
    //         for (SexoDTO s : sBL.getAll()) 
    //             System.out.println(s.toString());

    //         System.out.println("-------------------------");

    //         EstadoCivilBL ecBL = new EstadoCivilBL();
    //         for (EstadoCivilDTO reg : ecBL.getAll()) 
    //             System.out.println(reg.toString());

    //         System.out.println("-------------------------");

    //         PersonaTipoBL pBL = new PersonaTipoBL();
    //         for (PersonaTipoDTO reg : pBL.getAll()) 
    //             System.out.println(reg.toString());

                    
    //    } catch (Exception e) {
    //         System.out.println(e.toString());
    //    }  
    }
}
