package UserInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FAHormigaApp {

    private static int FAsecuencia = 1; // Para generar numeros secuenciales
    private static DefaultTableModel FAmodelo;

    public static void main(String[] args) {
        JFrame FAframe = new JFrame("Gestión de Hormigas");
        FAframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FAframe.setSize(800, 600);

        // Crear modelo de la tabla
        FAmodelo = new DefaultTableModel();
        FAmodelo.setColumnIdentifiers(new Object[]{"RegNro", "TipoHormiga", "Ubicación", "Sexo", "GenoAlimento", "IngestaNativa", "Estado"});
        JTable FAtabla = new JTable(FAmodelo);

        JScrollPane FAscrollPane = new JScrollPane(FAtabla);
        FAframe.add(FAscrollPane, BorderLayout.CENTER);

        JPanel FApanel = new JPanel();
        FAframe.add(FApanel, BorderLayout.SOUTH);

        // Botón "Crear Hormiga Larva"
        JButton FAcrearLarvaBtn = new JButton("Crear Hormiga Larva");
        FAcrearLarvaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FAconfirm = JOptionPane.showConfirmDialog(FAframe, "¿Está seguro de crear una Hormiga larva?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (FAconfirm == JOptionPane.YES_OPTION) {
                    String FAubicacion = getRandomProvincia();
                    FAmodelo.addRow(new Object[]{FAsecuencia++, "Larva", FAubicacion, "Asexual", "", "VIVA"});
                }
            }
        });
        FApanel.add(FAcrearLarvaBtn);

        // Botón "Alimentar con GenoAlimento"
        JButton FAalimentarGenoBtn = new JButton("Alimentar con GenoAlimento");
        FAalimentarGenoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Seleccionar la fila de la hormiga a alimentar
                int FAselectedRow = FAtabla.getSelectedRow();
                if (FAselectedRow == -1) {
                    JOptionPane.showMessageDialog(FAframe, "Por favor, seleccione una hormiga de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Obtener el tipo de GenoAlimento
                String FAgenoAlimento = JOptionPane.showInputDialog(FAframe, "Ingrese el GenoAlimento:");

                if (FAgenoAlimento != null && !FAgenoAlimento.trim().isEmpty()) {
                    FAmodelo.setValueAt(FAgenoAlimento, FAselectedRow, 4); // Asignar GenoAlimento a la columna correspondiente
                    FAmodelo.setValueAt("ALIMENTADA", FAselectedRow, 6); // Cambiar estado a ALIMENTADA
                } else {
                    JOptionPane.showMessageDialog(FAframe, "Debe ingresar un GenoAlimento válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        FApanel.add(FAalimentarGenoBtn);

        // Botón "Alimentar con Ingesta Nativa"
        JButton FAalimentarIngestaBtn = new JButton("Alimentar con Ingesta Nativa");
        FAalimentarIngestaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Seleccionar la fila de la hormiga a alimentar
                int FAselectedRow = FAtabla.getSelectedRow();
                if (FAselectedRow == -1) {
                    JOptionPane.showMessageDialog(FAframe, "Por favor, seleccione una hormiga de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Obtener el tipo de Ingesta Nativa
                String FAingestaNativa = JOptionPane.showInputDialog(FAframe, "Ingrese la Ingesta Nativa:");

                if (FAingestaNativa != null && !FAingestaNativa.trim().isEmpty()) {
                    FAmodelo.setValueAt(FAingestaNativa, FAselectedRow, 5); // Asignar Ingesta Nativa a la columna correspondiente
                    FAmodelo.setValueAt("ALIMENTADA", FAselectedRow, 6); // Cambiar estado a ALIMENTADA
                } else {
                    JOptionPane.showMessageDialog(FAframe, "Debe ingresar una Ingesta Nativa válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        FApanel.add(FAalimentarIngestaBtn);

        FAframe.setVisible(true);
    }

    // Método para seleccionar una provincia aleatoria
    private static String getRandomProvincia() {
        String[] FAprovincias = {"Loja", "Guayaquil", "Quito"};
        Random FArand = new Random();
        return FAprovincias[FArand.nextInt(FAprovincias.length)];
    }
}


