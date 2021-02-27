package ventanasadministracioneventos;

import eventos.Deportivo;
import eventos.JNumberField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CrearEvento extends JPanel {
    
    //Acumulador.
    public int posicionEventoDeportivo = 0;
    public int posicionEventoMusical = 0;
    public int posicionEventoReligioso = 0;
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("CREAR EVENTO");
    
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 25);
    Font fuenteEtiquetas = new Font("Elephant", 0, 18);
    Font fuenteEtiquetas2 = new Font("Arial", 0, 10);
    
    JLabel instruccionSeleccionar = new JLabel("Seleccione el tipo de evento que quiere crear: ");
    
    public String tipoEventos[] = {"Deportivo", "Musical", "Religioso"};
    public JComboBox seleccionCombo = new JComboBox(tipoEventos);
   
    
    //JTextFields y etiquetas en común de cada evento.
    public JLabel etiquetaCodigo = new JLabel("Código único de evento:");
    public JTextField espacioCodigo = new JTextField();
    
    public JLabel etiquetaTitulo = new JLabel("Título del evento:");
    public JTextField espacioTitulo = new JTextField();
    
    public JLabel etiquetaDescripcion = new JLabel("Descripcion del evento:");
    public JTextArea espacioDescripcion = new JTextArea();
    
    public JLabel etiquetaFecha = new JLabel("Fecha del evento:");
    //JDateChooser calendario = new JDateChooser();
    
    public JLabel etiquetaMonto = new JLabel("Monto(luego se añaden costos):");
    public JNumberField espacioMonto = new JNumberField();
    
    public JLabel etiquetaMaximoPersonas = new JLabel("Cantidad de personas:");
    public JNumberField espacioMaximoPersonas = new JNumberField();
    
    
    
    //JTextFields y etiquetas de los eventos deportivos.
    public JLabel etiquetaDeporteEscogido = new JLabel("Deporte(FUTBOL-BASEBALL-TENIS-RUGBY):");
    public JTextField espacioDeporteEscogido = new JTextField();
    
    public JLabel etiquetaNombresEquipos = new JLabel("Nombres de los equipos:");
    public JTextField espacioNombresEquipos = new JTextField();
    
    
    //JTextFields y etiquetas para los eventos regiosos.
    public JLabel etiquetaGeneroEscogido = new JLabel("Género(POP-ROCK-RAP-REGGAETON-CLASICA-OTRO):");
    public JTextField espacioGeneroEscogido = new JTextField();
    
    
    
    //Espacios y escritos para la fecha. Recordar restarle 1 al mes.
    public JLabel etiquetaDia = new JLabel("Día:");
    public JNumberField espacioDia = new JNumberField();
    
    public JLabel etiquetaMes = new JLabel("Mes:");
    public JNumberField espacioMes = new JNumberField();
    
    public JLabel etiquetaAño = new JLabel("Año:");
    public JNumberField espacioAño = new JNumberField();
    
    
    //Botón de crear.
    public JButton botonCrear = new JButton("CREAR");
    
    
   
    public CrearEvento(){
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        //Botón de regresar.
        botonRegresar.setFont(fuenteBotones);
        botonRegresar.setForeground(Color.ORANGE);
        botonRegresar.setBackground(Color.RED);
        botonRegresar.setBounds(60, 600, 180, 50);
        add(botonRegresar);
        
        //Título de la ventana.
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(Color.ORANGE);
        titulo.setBounds(275, 20, 300, 100);
        add(titulo);
        
        //Ubicar la instrucción de seleccionar.
        instruccionSeleccionar.setFont(fuenteEtiquetas);
        instruccionSeleccionar.setForeground(Color.ORANGE);
        instruccionSeleccionar.setBounds(207, 80, 450, 100);
        add(instruccionSeleccionar);
        
        //Ubicar el ComboBox.
        seleccionCombo.setBounds(305, 160, 200, 30);
        add(seleccionCombo);
        
        
        etiquetaCodigo.setForeground(Color.ORANGE);
        etiquetaTitulo.setForeground(Color.ORANGE);
        etiquetaDescripcion.setForeground(Color.ORANGE);
        etiquetaFecha.setForeground(Color.ORANGE);
        etiquetaMonto.setForeground(Color.ORANGE);
        etiquetaMaximoPersonas.setForeground(Color.ORANGE);
        
        etiquetaCodigo.setFont(fuenteEtiquetas2);
        etiquetaTitulo.setFont(fuenteEtiquetas2);
        etiquetaDescripcion.setFont(fuenteEtiquetas2);
        etiquetaFecha.setFont(fuenteEtiquetas2);
        etiquetaMonto.setFont(fuenteEtiquetas2);
        etiquetaMaximoPersonas.setFont(fuenteEtiquetas2);
        
        etiquetaCodigo.setBounds(100, 200, 300, 50);
        etiquetaTitulo.setBounds(100, 250, 300, 50);
        etiquetaMaximoPersonas.setBounds(100, 300, 300, 50);
        etiquetaMonto.setBounds(100, 350, 300, 50);
        etiquetaDescripcion.setBounds(100, 400, 300, 50);
        
        add(etiquetaCodigo);
        add(etiquetaTitulo);
        add(etiquetaDescripcion);
        add(etiquetaFecha);
        add(etiquetaMonto);
        add(etiquetaMaximoPersonas);
        
        
        
        espacioCodigo.setBounds(250, 220, 150, 20);
        espacioTitulo.setBounds(250, 270, 150, 20);
        espacioMaximoPersonas.setBounds(250, 320, 150, 20);
        espacioMonto.setBounds(250, 370, 150, 20);
        espacioDescripcion.setBounds(250, 420, 230, 50);
        
        add(espacioCodigo);
        add(espacioTitulo);
        add(espacioMaximoPersonas);
        add(espacioMonto);
        add(espacioDescripcion);
        
        
        
        
        //Colocación de etiquetas y espacios para escribir - Música.
        etiquetaGeneroEscogido.setFont(fuenteEtiquetas2);
        etiquetaGeneroEscogido.setForeground(Color.ORANGE);
        etiquetaGeneroEscogido.setBounds(100, 500, 300, 50);
        //espacioGeneroEscogido.setBounds(380, 515, 150, 20);
        comboMusica.setBounds(380, 515, 150, 20);
        
        etiquetaGeneroEscogido.setVisible(false);
        //espacioGeneroEscogido.setVisible(false);
        comboMusica.setVisible(false);
        
        add(etiquetaGeneroEscogido);
        //add(espacioGeneroEscogido);
        add(comboMusica);
        
        //Colocación de etiquetas y espacios para escribir - Deporte.
        etiquetaDeporteEscogido.setFont(fuenteEtiquetas2);
        etiquetaNombresEquipos.setFont(fuenteEtiquetas2);
        etiquetaDeporteEscogido.setForeground(Color.ORANGE);
        etiquetaNombresEquipos.setForeground(Color.ORANGE);
        
        etiquetaDeporteEscogido.setBounds(100, 500, 300, 50);
        etiquetaNombresEquipos.setBounds(100, 530, 300, 50);
                
        //espacioDeporteEscogido.setBounds(330, 515, 150, 20);
        comboDeporte.setBounds(330, 515, 150, 20);
        espacioNombresEquipos.setBounds(260, 550, 200, 20);
        
        etiquetaDeporteEscogido.setVisible(true);
        //espacioDeporteEscogido.setVisible(false);
        comboDeporte.setVisible(true);
        etiquetaNombresEquipos.setVisible(true);
        espacioNombresEquipos.setVisible(true);
        
        add(etiquetaDeporteEscogido);
        //add(espacioDeporteEscogido);
        add(comboDeporte);
        add(etiquetaNombresEquipos);
        add(espacioNombresEquipos);
        
        
        etiquetaDia.setForeground(Color.ORANGE);
        etiquetaDia.setFont(fuenteEtiquetas);
        etiquetaDia.setBounds(600, 250, 300, 50);
        espacioDia.setBounds(600, 290, 50, 30);
        add(etiquetaDia);
        add(espacioDia);
        
        etiquetaFecha.setBounds(560, 210, 200, 50);
        etiquetaFecha.setFont(fuenteEtiquetas);
        add(etiquetaFecha);
        
        etiquetaMes.setFont(fuenteEtiquetas);
        etiquetaMes.setForeground(Color.ORANGE);
        etiquetaMes.setBounds(600, 310, 300, 50);
        espacioMes.setBounds(600, 350, 50, 30);
        add(etiquetaMes);
        add(espacioMes);
        
        etiquetaAño.setFont(fuenteEtiquetas);
        etiquetaAño.setForeground(Color.ORANGE);
        etiquetaAño.setBounds(600, 370, 300, 50);
        espacioAño.setBounds(600, 410, 50, 30);
        add(etiquetaAño);
        add(espacioAño);
        
        
        //Colocar el botón de crear el evento.
        botonCrear.setForeground(Color.ORANGE);
        botonCrear.setBackground(Color.RED);
        botonCrear.setFont(fuenteBotones);
        botonCrear.setBounds(570, 600, 180, 50);
        add(botonCrear);
        
        eventoCreado.setForeground(Color.GREEN);
        eventoCreado.setFont(fuenteBotones);
        eventoCreado.setBounds(275, 600, 300, 50);
        eventoCreado.setVisible(false);
        add(eventoCreado);
        
        
        eventoNoCreado.setForeground(Color.RED);
        eventoNoCreado.setFont(fuenteEtiquetas);
        eventoNoCreado.setBounds(250,600,400,50);
        eventoNoCreado.setVisible(false);
        add(eventoNoCreado); 
        
        
        codigoRepetido.setForeground(Color.RED);
        fechaIncorrecta.setForeground(Color.RED);
        cantidadPersonasIncorrecta.setForeground(Color.RED);
        
        codigoRepetido.setFont(fuenteEtiquetas2);
        fechaIncorrecta.setFont(fuenteEtiquetas2);
        cantidadPersonasIncorrecta.setFont(fuenteEtiquetas2);
        
        codigoRepetido.setBounds(500, 550, 200, 20);
        fechaIncorrecta.setBounds(500, 560, 200, 20);
        cantidadPersonasIncorrecta.setBounds(500, 540, 200, 20);
        
        add(codigoRepetido);
        add(fechaIncorrecta);
        add(cantidadPersonasIncorrecta);
                
        
    }
    
    
    //Advertencias de error.
    public JLabel codigoRepetido = new JLabel("Ingresó un código existente.");
    public JLabel fechaIncorrecta = new JLabel("Ingresó una fecha incorrecta/que ya pasó.");
    public JLabel cantidadPersonasIncorrecta = new JLabel("Máxima cantidad de personas superada.");
    
    String tipoDeporte[] = {"Futbol","Baseball","Tenis","RUGBY"};
    public JComboBox comboDeporte = new JComboBox(tipoDeporte);
    
    String tipoMusica[] = {"POP","ROCK","CLASICA","RAP","REGGAETON","OTRO"};
    public JComboBox comboMusica = new JComboBox(tipoMusica);
    
    
     //Creado exitosamente.
    public JLabel eventoCreado = new JLabel("¡Se ha creado el evento!");
    public JLabel eventoNoCreado = new JLabel("¡Has ingresado un dato incorrecto!");
    
    
    
}
