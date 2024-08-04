package UserInterface.Form;

import java.awt.BorderLayout;
import java.net.URL;

import java.swing.ImagenIcon;
import java.swing.JFrame;
import java.swing.JLabel;
import java.swing.JProgressBar;

public abstract class SplashScreenFOrm {
    private static JFrame           frmSplash;
    private static JProgressBar     prloaging;
    private static ImagenIcon       icoImagen;
    private static JLabel           lblSplash;

    public static void show(){
        icoImagen   = new ImagenIcon(IAStyle.URL_SPLASH);
        lblSplash   = new JLabel (icoImagen);
        prbloaging  = new JProgressBar (0,100);

        prbloaging.setStringPainted(true);

        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbloaging,BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.gtIconHeigh());

        frmSplash.setVisible(true);
        
        fro (int i = 0; i <= 100; i++){
            try{
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            prbloaging.setValue(i);
        }
        frmSplash.setVisible(false);
    }
}
