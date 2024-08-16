// package UserInterface;

// import java.awt.*;
// import javax.swing.*;

// public class FAFormularioHormiga extends JFrame {

//     // Variables globales estáticas
//     private static final String CEDULA = "1753043460";
//     private static final String NOMBRES = "Alegria Farinango";

//     // Declaración de componentes
//     private JButton faCrearLarvaButton;
//     private JButton faAlimentarGenoAlimentoButton;
//     private JButton faAlimentarIngestaNativaButton;
//     private JComboBox<String> faGenoAlimentoComboBox;
//     private JComboBox<String> faIngestaNativaComboBox;
//     private JButton faEliminarButton;
//     private JButton faGuardarButton;
    
//     // Grilla de hormigas (3x6)
//     private JPanel faHormigueroPanel;
//     private JButton[][] faHormigaSlots;

//     // Etiquetas para cédula y nombres
//     private JLabel faCedulaLabel;
//     private JLabel faNombresLabel;

//     public FAFormularioHormiga() {
//         // Configuración básica del JFrame
//         setTitle("EcuaFauna 2k24A");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         // Estilo de los botones
//         Font buttonFont = new Font("Arial", Font.BOLD, 14);
//         Color buttonColor = new Color(173, 216, 230); // Azul claro
//         Color buttonTextColor = Color.BLACK;
//         Color panelBackground = new Color(192, 192, 192); // Gris
//         Color topPanelBackground = new Color(240, 240, 240); // Gris muy claro

//         // Panel superior para cédula y nombres
//         JPanel faTopPanel = new JPanel(new GridLayout(2, 1, 10, 10));
//         faTopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//         faTopPanel.setBackground(topPanelBackground);

//         faCedulaLabel = new JLabel("Cédula: " + CEDULA);
//         faCedulaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         faCedulaLabel.setForeground(Color.BLACK);

//         faNombresLabel = new JLabel("Nombres: " + NOMBRES);
//         faNombresLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         faNombresLabel.setForeground(Color.BLACK);

//         faTopPanel.add(faCedulaLabel);
//         faTopPanel.add(faNombresLabel);

//         // Panel central para el hormiguero
//         faHormigueroPanel = new JPanel(new GridLayout(3, 6, 10, 10));
//         faHormigueroPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//         faHormigueroPanel.setBackground(panelBackground);

//         faHormigaSlots = new JButton[3][6];
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 6; j++) {
//                 faHormigaSlots[i][j] = new JButton("Vacío");
//                 faHormigaSlots[i][j].setFont(buttonFont);
//                 faHormigaSlots[i][j].setBackground(buttonColor);
//                 faHormigaSlots[i][j].setForeground(buttonTextColor);
//                 faHormigaSlots[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
//                 faHormigaSlots[i][j].setPreferredSize(new Dimension(50, 50)); // Tamaño de botón ajustado a 50x50
//                 faHormigaSlots[i][j].setMargin(new Insets(0, 0, 0, 0)); // Ajustar el margen
//                 faHormigueroPanel.add(faHormigaSlots[i][j]);
//             }
//         }

//         // Panel inferior para las acciones
//         JPanel faBottomPanel = new JPanel(new GridLayout(3, 3, 10, 10));
//         faBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//         faBottomPanel.setBackground(panelBackground);

//         faCrearLarvaButton = new JButton("Crear Hormiga Larva");
//         faCrearLarvaButton.setFont(buttonFont);
//         faCrearLarvaButton.setBackground(buttonColor);
//         faCrearLarvaButton.setForeground(buttonTextColor);

//         faGenoAlimentoComboBox = new JComboBox<>(new String[]{"XY"});
//         faGenoAlimentoComboBox.setFont(new Font("Arial", Font.PLAIN, 14));

//         faAlimentarGenoAlimentoButton = new JButton("Alimentar con GenoAlimento");
//         faAlimentarGenoAlimentoButton.setFont(buttonFont);
//         faAlimentarGenoAlimentoButton.setBackground(buttonColor);
//         faAlimentarGenoAlimentoButton.setForeground(buttonTextColor);

//         faIngestaNativaComboBox = new JComboBox<>(new String[]{"Omnivoro"});
//         faIngestaNativaComboBox.setFont(new Font("Arial", Font.PLAIN, 14));

//         faAlimentarIngestaNativaButton = new JButton("Alimentar con Ingesta Nativa");
//         faAlimentarIngestaNativaButton.setFont(buttonFont);
//         faAlimentarIngestaNativaButton.setBackground(buttonColor);
//         faAlimentarIngestaNativaButton.setForeground(buttonTextColor);

//         faEliminarButton = new JButton("Eliminar");
//         faEliminarButton.setFont(buttonFont);
//         faEliminarButton.setBackground(Color.RED);
//         faEliminarButton.setForeground(buttonTextColor);

//         faGuardarButton = new JButton("Guardar");
//         faGuardarButton.setFont(buttonFont);
//         faGuardarButton.setBackground(Color.BLUE);
//         faGuardarButton.setForeground(buttonTextColor);

//         faBottomPanel.add(faCrearLarvaButton);
//         faBottomPanel.add(faGenoAlimentoComboBox);
//         faBottomPanel.add(faAlimentarGenoAlimentoButton);
//         faBottomPanel.add(faIngestaNativaComboBox);
//         faBottomPanel.add(faAlimentarIngestaNativaButton);
//         faBottomPanel.add(faEliminarButton);
//         faBottomPanel.add(faGuardarButton);

//         // Agregar paneles al JFrame
//         add(faTopPanel, BorderLayout.NORTH);
//         add(faHormigueroPanel, BorderLayout.CENTER);
//         add(faBottomPanel, BorderLayout.SOUTH);
//     }

//     public static void main(String[] args) {
//         // Ejecutar el formulario
//         FAFormularioHormiga formulario = new FAFormularioHormiga();
//         formulario.setVisible(true);
//     }
// }








