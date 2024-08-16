package UserInterface.GUI;

import UserInterface.Form.FAUser;

import javax.swing.*;
import java.awt.*;

public class FAEcuaFauna2K24A extends JFrame {

    // Instancia de FAUser para manejar los datos del alumno
    private FAUser FAalumno;

    // Constructor para inicializar el formulario
    public FAEcuaFauna2K24A() {
        FAalumno = new FAUser("110121233 - 5", "Perez Marcia");

        setTitle("EcuaFauna 2K24A");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior para cédula y nombres
        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 5, 5));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        FAStyle.FAEstilizarPanel(panelSuperior);

        JLabel labelCedula = new JLabel("Cédula:");
        FAStyle.FAEstilizarLabel(labelCedula);
        JTextField textCedula = new JTextField(FAalumno.getFACedula());
        textCedula.setEditable(false);
        FAStyle.FAEstilizarLabel(textCedula);

        JLabel labelNombres = new JLabel("Nombres:");
        FAStyle.FAEstilizarLabel(labelNombres);
        JTextField textNombres = new JTextField(FAalumno.getFANombres());
        textNombres.setEditable(false);
        FAStyle.FAEstilizarLabel(textNombres);

        panelSuperior.add(labelCedula);
        panelSuperior.add(textCedula);
        panelSuperior.add(labelNombres);
        panelSuperior.add(textNombres);

        // Panel central para el hormiguero virtual
        JPanel panelHormiguero = new JPanel(new GridLayout(3, 3, 5, 5));
        panelHormiguero.setBorder(BorderFactory.createTitledBorder("Hormiguero Virtual"));
        FAStyle.FAEstilizarPanel(panelHormiguero);

        for (int i = 0; i < 9; i++) {
            JLabel labelHormiga = new JLabel();
            FAStyle.FAEstilizarLabel(labelHormiga);
            panelHormiguero.add(labelHormiga); // Placeholder para la hormiga
        }

        JButton btnCrearHormiga = new JButton("Crear Hormiga Larva");
        FAStyle.FAEstilizarBoton(btnCrearHormiga);

        // Panel para los selectores y botones de alimentación
        JPanel panelAlimentacion = new JPanel(new GridLayout(2, 3, 5, 5));
        FAStyle.FAEstilizarPanel(panelAlimentacion);

        String[] genoAlimentoOptions = {"GenoAlimento 1", "GenoAlimento 2", "GenoAlimento 3"};
        JComboBox<String> comboGenoAlimento = new JComboBox<>(genoAlimentoOptions);

        String[] ingestaNativaOptions = {"IngestaNativa 1", "IngestaNativa 2", "IngestaNativa 3"};
        JComboBox<String> comboIngestaNativa = new JComboBox<>(ingestaNativaOptions);

        JButton btnAlimentarGenoAlimento = new JButton("Alimentar con GenoAlimento");
        FAStyle.FAEstilizarBoton(btnAlimentarGenoAlimento);

        JButton btnAlimentarIngestaNativa = new JButton("Alimentar con Ingesta Nativa");
        FAStyle.FAEstilizarBoton(btnAlimentarIngestaNativa);

        panelAlimentacion.add(comboGenoAlimento);
        panelAlimentacion.add(btnAlimentarGenoAlimento);
        panelAlimentacion.add(new JLabel()); // Placeholder
        panelAlimentacion.add(comboIngestaNativa);
        panelAlimentacion.add(btnAlimentarIngestaNativa);
        panelAlimentacion.add(new JLabel()); // Placeholder

        // Panel inferior para botones de eliminar y guardar
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        FAStyle.FAEstilizarPanel(panelInferior);

        JButton btnEliminar = new JButton("Eliminar");
        FAStyle.FAEstilizarBoton(btnEliminar);

        JButton btnGuardar = new JButton("Guardar");
        FAStyle.FAEstilizarBoton(btnGuardar);

        panelInferior.add(btnEliminar);
        panelInferior.add(btnGuardar);

        // Añadir los paneles al marco principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelHormiguero, BorderLayout.CENTER);
        add(panelAlimentacion, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FAEcuaFauna2K24A::new);
    }
}
