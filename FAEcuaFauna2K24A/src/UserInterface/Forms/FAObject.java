package UserInterface.forms;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.style.FAStyle;

public class FAObject extends JPanel {

    public static JFrame jfrObject;

    public JLabel
        lblFranja = new JLabel(),
        lblCedula = new JLabel("Cédula:"),
        lblNombre = new JLabel("Nombres:"),
        lblTitulo = new JLabel("Hormiguero Virtual"),
        lblLogo = new JLabel();

    public TextField
        tfCedula = new TextField("  1725987749-0"),
        tfNombre = new TextField("  Your Daddy");

    public JButton
        btnCrear = new JButton("Crear hormiga larva"),
        btnAlimentarG = new JButton("Alimentar con GenoAlimento"),
        btnAlimentarI = new JButton("Alimentar con Ingesta Nativa"),
        btnEliminar = new JButton("Eliminar"),
        btnGuardar = new JButton("Guardar");

    private JComboBox<String> cbGeno = new JComboBox<>(new String[] {"<GenoAlimento>", "X", "XX", "XY"});
    private JComboBox<String> cbIngesta = new JComboBox<>(new String[] {"<IngestaNativa>", "Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro"});

    public FAObject() {
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(null);

        ImageIcon imgLogo = new ImageIcon(FAStyle.URL_LOGO);
        lblLogo.setIcon(imgLogo);

        try {
            // COLOR
            lblTitulo.setForeground(FAStyle.COLOR_TITLE);
            btnCrear.setForeground(FAStyle.COLOR_BUTTON);
            btnAlimentarG.setForeground(FAStyle.COLOR_BUTTON);
            btnAlimentarI.setForeground(FAStyle.COLOR_BUTTON);
            btnCrear.setBackground(FAStyle.COLOR_BUTTON_U);
            btnAlimentarG.setBackground(FAStyle.COLOR_BUTTON_U);
            btnAlimentarI.setBackground(FAStyle.COLOR_BUTTON_U);
            btnGuardar.setBackground(FAStyle.COLOR_BUTTON_D);
            btnEliminar.setBackground(FAStyle.COLOR_BUTTON_D);
            cbGeno.setBackground(Color.WHITE);
            cbIngesta.setBackground(Color.WHITE);
            lblFranja.setOpaque(true);
            lblFranja.setBackground(Color.WHITE);

            // FUENTES
            lblCedula.setFont(FAStyle.FONT_BOLD);
            lblNombre.setFont(FAStyle.FONT_BOLD);
            tfCedula.setFont(FAStyle.FONT_TEXT);
            tfNombre.setFont(FAStyle.FONT_TEXT);
            lblTitulo.setFont(FAStyle.FONT_TITLE);

            // UBICACIONES
            lblCedula.setBounds(200, 25, 100, 20);
            tfCedula.setBounds(450, 25, 150, 25);
            lblNombre.setBounds(200, 50, 100, 20);
            tfNombre.setBounds(450, 50, 150, 25);
            lblLogo.setBounds(50, 100, 45, 57);
            lblTitulo.setBounds(125, 110, 200, 40);
            btnCrear.setBounds(450, 125, 200, 40);
            cbGeno.setBounds(150, 400, 200, 40);
            cbIngesta.setBounds(150, 450, 200, 40);
            btnAlimentarG.setBounds(450, 400, 200, 40);
            btnAlimentarI.setBounds(450, 450, 200, 40);
            btnGuardar.setBounds(450, 500, 200, 40);
            btnEliminar.setBounds(150, 500, 200, 40);
            lblFranja.setBounds(0, 180, 800, 200);

        } catch (Exception e) {
            e.printStackTrace();
        }

        add(lblFranja);
        add(lblCedula);
        add(lblNombre);
        add(lblLogo);
        add(lblTitulo);
        add(tfCedula);
        add(tfNombre);
        add(btnCrear);
        add(btnAlimentarG);
        add(btnAlimentarI);
        add(btnEliminar);
        add(btnGuardar);
        add(cbGeno);
        add(cbIngesta);
    }
}

