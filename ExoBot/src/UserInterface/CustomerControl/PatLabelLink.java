package UserInterface.CustomerControl;

import javax.swing.ImageIcon;

import UserInterface.IAStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PatLabelLink extends PatLabel implements MouseListener {

    PatLabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    PatLabelLink(String text, String iconPath){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(IAStyle.COLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(IAStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(IAStyle.CURSOR_DEFAULT);
    }
}
