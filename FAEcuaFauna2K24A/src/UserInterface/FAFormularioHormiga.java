package UserInterface;

import java.awt.*;
import javax.swing.*;

public class FAFormularioHormiga extends JFrame {

    // Variables globales estáticas
    private static final String FA_CEDULA = "1753043460";
    private static final String FA_NOMBRES = "Alegria Farinango";

    // Declaración de componentes
    private JLabel faNombreHormigaLabel;
    private JTextField faNombreHormigaField;
    private JLabel faTipoHormigaLabel;
    private JComboBox<String> faTipoHormigaComboBox;
    private JLabel faSexoLabel;
    private JComboBox<String> faSexoComboBox;
    private JLabel faEstadoLabel;
    private JComboBox<String> faEstadoComboBox;
    private JLabel faProvinciaLabel;
    private JComboBox<String> faProvinciaComboBox;
    private JLabel faAlimentoLabel;
    private JComboBox<String> faAlimentoComboBox;
    private JButton faGuardarButton;
    private JButton faCancelarButton;

    // Etiquetas para cédula y nombres
    private JLabel faCedulaLabel;
    private JLabel faNombresLabel;

    public FAFormularioHormiga() {
        // Configuración básica del JFrame
        setTitle("Formulario de Hormigas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 10, 10)); // GridLayout con 9 filas y 2 columnas

        // Inicialización de componentes
        faNombreHormigaLabel = new JLabel("Nombre de Hormiga:");
        faNombreHormigaField = new JTextField();

        faTipoHormigaLabel = new JLabel("Tipo de Hormiga:");
        faTipoHormigaComboBox = new JComboBox<>(new String[]{"Larva", "Soldado", "Rastrera", "Reina"});

        faSexoLabel = new JLabel("Sexo:");
        faSexoComboBox = new JComboBox<>(new String[]{"Macho", "Hembra", "Asexual"});

        faEstadoLabel = new JLabel("Estado:");
        faEstadoComboBox = new JComboBox<>(new String[]{"Huevo", "Larva", "Pupa", "Adulta"});

        faProvinciaLabel = new JLabel("Provincia:");
        faProvinciaComboBox = new JComboBox<>(new String[]{
            "El Oro", "Esmeraldas", "Guayas", "Los Ríos", "Manabí", 
            "Santa Elena", "Santo Domingo de los Tsáchilas", "Azuay", 
            "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", 
            "Imbabura", "Loja", "Pichincha", "Tungurahua", "Morona Santiago", 
            "Napo", "Orellana", "Pastaza", "Sucumbíos", "Zamora Chinchipe", "Galápagos"
        });

        faAlimentoLabel = new JLabel("Alimento:");
        faAlimentoComboBox = new JComboBox<>(new String[]{"Carne", "Hierbas", "Insectos", "Frutas"});

        faGuardarButton = new JButton("Guardar");
        faCancelarButton = new JButton("Cancelar");

        // Etiquetas para cédula y nombres
        faCedulaLabel = new JLabel("Cédula: " + FA_CEDULA);
        faNombresLabel = new JLabel("Nombres: " + FA_NOMBRES);

        // Agregar componentes al JFrame
        add(faCedulaLabel);
        add(new JLabel()); // Espacio vacío
        add(faNombresLabel);
        add(new JLabel()); // Espacio vacío
        add(faNombreHormigaLabel);
        add(faNombreHormigaField);
        add(faTipoHormigaLabel);
        add(faTipoHormigaComboBox);
        add(faSexoLabel);
        add(faSexoComboBox);
        add(faEstadoLabel);
        add(faEstadoComboBox);
        add(faProvinciaLabel);
        add(faProvinciaComboBox);
        add(faAlimentoLabel);
        add(faAlimentoComboBox);
        add(faGuardarButton);
        add(faCancelarButton);
    }

    public static void main(String[] args) {
        // Ejecutar el formulario
        FAFormularioHormiga formulario = new FAFormularioHormiga();
        formulario.setVisible(true);
    }
}

