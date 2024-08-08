package UserInterface.CustomerControl;


import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LayoutEjemplos {

    private PatLabel  
            lblTitulo = new PatLabel("SEXO"          ), //, Color.BLACK, new Font("MesloLGL Nerd Font", Font.BOLD ,  20)),
            lblIdSexo = new PatLabel("Codigo:      " ),
            lblNombre = new PatLabel("Descripción: " ),
            lblTotalReg=new PatLabel("  0 de 0  "    );
    private TextField  
            txtIdSexo = new TextField (" ",20),
            txtNombre = new TextField (" ",20);
    private PatButton
            btnIni = new PatButton(" |< "), 
            btnAnt = new PatButton(" << "),            
            btnSig = new PatButton(" >> "),
            btnFin = new PatButton(" >| ");
    private JButton
            btnNuevo = new JButton("Nuevo"),            
            btnGuardar = new JButton("Guardar"),
            btnCancelar= new JButton("Cancelar"),
            btnEliminar= new JButton("Eliminar");
    private JPanel 
            pnlTabla  = new JPanel(),
            pnlBtnCRUD= new JPanel(new FlowLayout()),
            pnlBtnPage= new JPanel(new FlowLayout());
    private Font 
            fontTilte = new Font("MesloLGL Nerd Font", Font.BOLD ,  20),
            fontBoton = new Font("MesloLGL Nerd Font", Font.BOLD | Font.CENTER_BASELINE,  11),
            fontPanel = new Font("MesloLGL Nerd Font", Font.LAYOUT_LEFT_TO_RIGHT | Font.PLAIN, 12);
    
             private Border line             = new LineBorder(Color.lightGray);
    private Border margin           = new EmptyBorder(5, 5, 5, 5);
    private Border border           = new CompoundBorder(line, margin);
    private Panel pnl = new Panel();
    private void  addControls(){
        //Customize:
        lblTitulo.setFont(fontTilte);         
        lblIdSexo.setFont(fontPanel); 
        lblNombre.setFont(fontPanel); 
        lblTotalReg.setFont(fontPanel); 

        txtIdSexo.setFont(fontPanel); 
        txtNombre.setFont(fontPanel); 
        txtIdSexo.setEditable( false );
        txtIdSexo.setForeground (Color.darkGray);
        txtNombre.setForeground (Color.darkGray);

        btnNuevo.setFont(fontBoton);         
        btnGuardar.setFont(fontBoton); 
        btnCancelar.setFont(fontBoton); 
        btnEliminar.setFont(fontBoton); 

        pnlBtnCRUD.add(btnIni);       
        pnlBtnCRUD.add(btnAnt);  
        pnlBtnCRUD.add(new JLabel("\u11A2"));      
        pnlBtnCRUD.add(lblTotalReg);        
        pnlBtnCRUD.add(new JLabel("\u11A2"));      
        pnlBtnCRUD.add(btnSig);
        pnlBtnCRUD.add(btnFin);
        pnlBtnCRUD.add(new JLabel("\u11A2"));      
        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        //pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(border);

        pnlTabla.setBounds(0,0,500,500);
        pnlTabla.setBorder(border);
        
        //Grillado
        pnl.setLayout( new GridBagLayout() );
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets=new Insets(5,5,5,5);     // espacio entre componentes

        gbc.gridwidth = GridBagConstraints.REMAINDER; //merge cel
        pnl.add( lblTitulo, gbc);
        gbc.gridwidth = GridBagConstraints.BOTH; 

        gbc.gridy = 1;          // Fila : 1
        pnl.add(lblIdSexo,  gbc);   // gbc.gridx = 0;
        pnl.add(txtIdSexo,  gbc);   // gbc.gridx = 1;

        gbc.gridy = 2;  
        pnl.add(lblNombre, gbc);
        pnl.add(txtNombre, gbc);
      
        gbc.gridy = 3; 
        gbc.insets    = new Insets(30,0,0,0); 
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        pnl.add(pnlBtnCRUD, gbc);

        gbc.gridy = 4; 
        gbc.weighty = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        pnl.add(pnlTabla, gbc);
    }
    private void  addControls2(){
        //Customize:
        lblTitulo.setFont(fontTilte);         
        lblIdSexo.setFont(fontPanel); 
        lblNombre.setFont(fontPanel); 
        lblTotalReg.setFont(fontPanel); 

        txtIdSexo.setFont(fontPanel); 
        txtNombre.setFont(fontPanel); 
        txtIdSexo.setEditable( false );
        txtIdSexo.setForeground (Color.darkGray);
        txtNombre.setForeground (Color.darkGray);

        btnNuevo.setFont(fontBoton);         
        btnGuardar.setFont(fontBoton); 
        btnCancelar.setFont(fontBoton); 
        btnEliminar.setFont(fontBoton); 
        btnNuevo.setContentAreaFilled(false);
        btnGuardar.setContentAreaFilled(false);
        btnCancelar.setContentAreaFilled(false);
        btnEliminar.setContentAreaFilled(false);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(border);

        pnlBtnPage.add(btnIni);       
        pnlBtnPage.add(btnAnt);  
        pnlBtnPage.add(new JLabel("\u11A2"));      
        pnlBtnPage.add(lblTotalReg);        
        pnlBtnPage.add(new JLabel("\u11A2"));      
        pnlBtnPage.add(btnSig);
        pnlBtnPage.add(btnFin);
        pnlBtnPage.setBorder(border);

        pnlTabla.setBounds(0,0,400,400);
        pnlTabla.add(new JLabel("Loading...",10));
        pnlTabla.setBorder(border);
        
        //Grillado
        pnl.setLayout( new GridBagLayout() );
        GridBagConstraints gbc=new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets=new Insets(5,5,5,5);     // espacio entre componentes

        gbc.weightx = 1.0;
        pnl.add( new JLabel(""), gbc); 
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnl.add( new JLabel(""), gbc); 


        gbc.gridy       = 1;   //gbc.gridx = 0;
        // gbc.gridwidth   = 2;   //merge cel
        gbc.weightx = 0.0;
        pnl.add( lblTitulo, gbc);

        //gbc.fill        = GridBagConstraints.BOTH;//Expansion vertical y horizontal
        //gbc.gridheight  = 2;//Numero de filas que llenara el boton
        //gbc.gridwidth   = 3;

        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;      //make this component tall
        //gbc.weightx = 1;
        //gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        
        //gbc.weightx     = 1;
        // gbc.gridy       = 2; gbc.gridx = 0;
        // gbc.weighty     = 1; 
        // gbc.gridwidth   = 2;
        // gbc.gridwidth   = GridBagConstraints.REMAINDER; 
        pnl.add(pnlTabla, gbc);

        gbc.gridy       = 3; 
       //  gbc.gridwidth = 0;
        gbc.gridheight  = 0;
       // gbc.insets      = new Insets(0,0,0,0); 
       //gbc.gridwidth   = GridBagConstraints.REMAINDER; 
       pnl.add(pnlBtnPage, gbc);
       
       gbc.fill = GridBagConstraints.BOTH;
        
        gbc.gridy       = 4;   gbc.gridx = 0; 
       gbc.weightx = 0.5;   
        gbc.gridwidth   = GridBagConstraints.REMAINDER;
        //gbc.gridwidth   = GridBagConstraints.BOTH; 
        pnl.add(lblIdSexo,  gbc);   // gbc.gridx = 0;
        pnl.add(txtIdSexo,  gbc);   // gbc.gridx = 1;

        gbc.gridy       = 5;  
        pnl.add(lblNombre, gbc);
        pnl.add(txtNombre, gbc);
      
        // gbc.anchor = GridBagConstraints.PAGE_END; 
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.gridwidth = 2;  
        pnl.add(pnlBtnCRUD, gbc);

        // gbc.gridy       = 4; 
        // gbc.weighty     = 1;
        // gbc.gridwidth   = GridBagConstraints.REMAINDER; 
        // add(pnlTabla, gbc);

    
    }

    private void ejemploAddControls() {
        pnl.setLayout( new GridBagLayout() );
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets=new Insets(5,5,5,5);  

        gbc.weightx = 1.0;
        pnl.add( new JButton( "Botón 0" ), gbc );
        pnl.add( new JButton( "Botón 1" ) , gbc);
        pnl.add( new JButton( "Botón 2" ), gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnl.add( new JButton( "Botón 3" ), gbc);

        gbc.weightx = 0.0;
        pnl.add( new JButton( "Botón 4" ), gbc);

        gbc.gridwidth = GridBagConstraints.RELATIVE;
        pnl.add( new JButton( "Botón 5" ), gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnl.add( new JButton( "Botón 6" ), gbc);

        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weighty = 1.0;
        pnl.add( new JButton( "Botón 7" ), gbc);

        gbc.weighty = 0.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        pnl.add( new JButton( "Botón 8" ), gbc);
        pnl.add( new JButton( "Botón 9" ), gbc);

        // TextField txtNombre = new TextField( "Nombre:",25 );
        // gbc.gridwidth = GridBagConstraints.RELATIVE;   a continuacion
        // gridbag.setConstraints( txtNombre,gbc );
        // add( txtNombre );
 
        //4ta FILA 
        // TextArea txtComent = new TextArea( 3,25 );
        // txtComent.setEditable( true );
        // txtComent.setText( "Comentarios:" );
        // add( txtComent ,gbc);

        // JScrollPane scrollPane = new JScrollPane() {
        //     public Dimension getPreferredSize () { return new Dimension(getWidth(),getHeight()); } };
        //     public Dimension getPreferredSize () { return new Dimension(getWidth(),getHeight()); } };
        //     @Override public Dimension getPreferredSize () { return super.getPreferredSize().heightToWidthRatio(1);} };
        //     @Override public Dimension getPreferredSize () { return new Dimension(getWidth(),getHeight()); } };

    }

    public void addComponentsToPane() {
        //setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        // if (shouldFill) {
        // //natural height, maximum width
        // c.fill = GridBagConstraints.HORIZONTAL;
        // }

        // if (shouldWeightX) {
        // c.weightx = 0.5;
        // }
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        pnl.add(new JButton("Button 1"), c);

        // c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;          // tamaño respecto del otros controles
        pnl.add(new JButton("Button 2"), c);

        // c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        pnl.add(new JButton("Button 3"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;        //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        pnl.add(new JButton("Long-Named Button 4"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 60;        //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = GridBagConstraints.RELATIVE; 
        pnl.add(new JButton("Long-Named Button X"), c);

        c.gridy = 3;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        pnl.add(new JButton("Button 11"), c);
        pnl.add(new JButton("Button 22"), c);
        pnl.add(new JButton("Button 33"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;         //reset to default
        c.weighty = 1.0;     //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0); //top ppnl.adding
        c.gridx = 1;             //aligned with button 2
        c.gridwidth = 2;        //2 columns wide
        c.gridy = 4;            //third row
        pnl.add( new JButton("5"), c);
    }

    public void controls() {
        Panel panelBotones = new Panel();
        
        // for (int i = 1; i < 5; i++) {
        //     JButton btn = new JButton("buton ".concat(String.valueOf(i)));
        //     btn.setSize(80, 20);
        //     btn.setLocation(2, i*30);
        //     add(btn);
        // }
        PatLabel 
        titulo      =new PatLabel("Compre algo ahora"),
        nombre      =new PatLabel("Nombre:"),
        direccion   =new PatLabel("Dirección:"),
        pago        =new PatLabel("Método de pago:"),
        telefono    =new PatLabel("Teléfono:"),
        ciudad      =new PatLabel("Ciudad:"),
        provincia   =new PatLabel("Provincia:"); //Color.DARK_GRAY,
                                //     new Font("MesloLGL Nerd Font", Font.BOLD | Font.LAYOUT_RIGHT_TO_LEFT, 12));

        JTextField 
        textNombre      =new JTextField("",20),
        textDireccion   =new JTextField("",20),
        textCiudad      =new JTextField("",20),
        textProvincia   =new JTextField("",20);

        Choice chPago=new Choice();

        Button btnPago=new Button();
        Button btnCancelar=new Button();

        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
         
        btnPago.setLabel("Comprar");
        btnCancelar.setLabel("Cancelar");

        chPago.add("Visa");
        chPago.add("MasterCard");
        chPago.add("Caja Ahorros");

        
//diseño:
        pnl.setLayout(gbl);
        
 //primera fila - título
        gbc.insets      = new Insets(0,0,10,0);
        gbc.anchor      = GridBagConstraints.NORTH;
        gbc.gridwidth   = GridBagConstraints.REMAINDER;     //indica ultimo control
        pnl.add(titulo, gbc);

        gbc.fill        = GridBagConstraints.BOTH;
        gbc.gridwidth   = GridBagConstraints.REMAINDER;
        pnl.add(new JLabel("Sección de datos:"), gbc);

        gbc.ipady = 150;        //tamaño del espacio a usar
        gbc.ipadx = 500;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        pnlTabla.add(new PatLabel("Loading data..."));
        pnl.add(pnlTabla, gbc);

        //Limpiar grid
        gbc.ipady = 0; 
        gbc.ipadx = 0;//
        //gbc.weightx = 1.0;
        gbc.fill=GridBagConstraints.BOTH;

        gbc.insets=new Insets(0,0,10,0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        pnl.add(new JLabel("Sección de resgistro:"), gbc);

//segunda fila - nombre
        
        //gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        gbc.insets=new Insets(0,0,0,0);
        pnl.add(nombre, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnl.add(textNombre, gbc);


//tercera fila - dirección
        gbc.gridwidth = 1;
        pnl.add(direccion, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnl.add(textDireccion, gbc);

//cuarta fila - ciudad   - provincia

        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        pnl.add(ciudad, gbc);
        pnl.add(textCiudad, gbc);
        pnl.add(provincia, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnl.add(textProvincia, gbc);
//quinta fila - pago
        gbc.gridwidth = 1;
        pnl.add(pago, gbc);
        gbc.insets=new Insets(5,0,5,0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill=GridBagConstraints.NONE;
        pnl.add(chPago, gbc);
//panel de los botones
		panelBotones.setLayout(new FlowLayout());
        panelBotones.add(btnPago);
        panelBotones.add(btnCancelar);

        gbc.anchor=GridBagConstraints.SOUTH;
        gbc.insets=new Insets(15,0,0,0);
        pnl.add(panelBotones, gbc);
    }

}
