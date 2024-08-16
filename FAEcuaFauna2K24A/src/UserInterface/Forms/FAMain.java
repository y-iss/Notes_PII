package UserInterface.Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UserInterface.style.FAStyle;

public class FAMain extends JFrame {

    private JPanel pnlMain = new JPanel();
    private FAObject pnlObject = new FAObject();
    private JFrame jfrRaya = new JFrame();

    public FAMain(String titleInterface) {
        customizeComponent(titleInterface);

        pnlObject.getBtnCrear().addActionListener(e -> System.exit(0));
        pnlObject.getBtnAlimentarG().addActionListener(e -> System.exit(0));
        pnlObject.getBtnAlimentarI().addActionListener(e -> System.exit(0));
        pnlObject.getBtnEliminar().addActionListener(e -> System.exit(0));
        pnlObject.getBtnGuardar().addActionListener(e -> System.exit(0));
    }

    private void customizeComponent(String titleInterface) {
        setBackground(FAStyle.COLOR_INTERFACE);
        setTitle(titleInterface);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlObject);
        setVisible(true);
    }
}

