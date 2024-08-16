package UserInterface.GUI;

import java.awt.*;
import javax.swing.*;

public class FAStyle {

    public static void FAEstilizarPanel(JPanel panel) {
        panel.setBackground(Color.LIGHT_GRAY);
    }

    public static void FAEstilizarLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    public static void FAEstilizarLabel(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(Color.WHITE);
    }

    public static void FAEstilizarBoton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
    }
}
