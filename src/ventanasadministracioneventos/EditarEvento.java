package ventanasadministracioneventos;

import eventos.JNumberField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditarEvento extends JPanel {
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("EDITAR EVENTO");
    
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 25);
    Font fuenteEtiquetas = new Font("Elephant", 0, 18);
    Font fuenteEtiquetas2 = new Font("Arial", 0, 10);
    Font fuentePrincipal = new Font("Arial", 0, 16);
    
    
    //public JButton botonCrearUsuario = new JButton("EDITAR USUARIO");
    
    JLabel instruccionSeleccionar = new JLabel("Seleccione a  qué tipo de evento quiere cambiarlo: ");
    
    public String tipoEventos[] = {"Deportivo", "Musical", "Religioso"};
    public JComboBox seleccionCombo = new JComboBox(tipoEventos);
   
    
    //JTextFields y etiquetas en común de cada evento.
    public JLabel etiquetaCodigo = new JLabel("Edite el código:");
    public JTextField espacioCodigo = new JTextField();
    
    public JLabel etiquetaTitulo = new JLabel("Título del evento:");
    public JTextField espacioTitulo = new JTextField();
    
    public JLabel etiquetaDescripcion = new JLabel("Descripcion del evento:");
    public JTextArea espacioDescripcion = new JTextArea();
    
    public JLabel etiquetaFecha = new JLabel("Fecha del evento:");
    
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
    
    String opcionSiNo[] = {"Si", "No"};
    public JComboBox comboSiNo = new JComboBox(opcionSiNo);
    public JLabel etiquetaSiNo = new JLabel("¿Desea cancelar el evento?");
    
    
    //Espacios y escritos para la fecha. Recordar restarle 1 al mes.
    public JLabel etiquetaDia = new JLabel("Día:");
    public JNumberField espacioDia = new JNumberField();
    
    public JLabel etiquetaMes = new JLabel("Mes:");
    public JNumberField espacioMes = new JNumberField();
    
    public JLabel etiquetaAño = new JLabel("Año:");
    public JNumberField espacioAño = new JNumberField();
    
    
    //Botón de crear.
    public JButton botonEditar = new JButton("EDITAR");
    
    
     //Advertencias de error.
    public JLabel codigoIncorrecto = new JLabel("Ingresó un código incorrecto.");
    public JLabel fechaIncorrecta = new JLabel("Ingresó una fecha incorrecta/que ya pasó.");
    public JLabel cantidadPersonasIncorrecta = new JLabel("Máxima cantidad de personas superada.");
    
    String tipoDeporte[] = {"Futbol","Baseball","Tenis","RUGBY"};
    public JComboBox comboDeporte = new JComboBox(tipoDeporte);
    
    String tipoMusica[] = {"POP","ROCK","CLASICA","RAP","REGGAETON","OTRO"};
    public JComboBox comboMusica = new JComboBox(tipoMusica);
    
    
     //Editado exitosamente.
    public JLabel eventoEditado = new JLabel("¡Se ha editado el evento!");
    public JLabel eventoNoEditado = new JLabel("¡Has ingresado un dato incorrecto!");
    
    
    //Espacio para escribir el código a cambiar.
    public JLabel escribaCodigo = new JLabel("Escriba el código del evento a modificar: ");
    public JTextField espacioCodigoVerificar = new JTextField();
    
    
    public JLabel indicarJugadoresEquipo1 = new JLabel("Jugadores equipo 1:");
    public JTextArea espacioJugadoresEquipo1 = new JTextArea();
    
    public JLabel indicarJugadoresEquipo2 = new JLabel("Jugadores equipo 2:");
    public JTextArea espacioJugadoresEquipo2 = new JTextArea();
    
    public JLabel indicarMusicos = new JLabel("Participantes de la banda:");
    public JTextArea espacioMusicos = new JTextArea();
    
    public JLabel indicarPersonasConvertidas = new JLabel("Cantidad de personas convertidas:");
    public JNumberField espacioPersonasConvertidas = new JNumberField();
    
    
    
    public EditarEvento(){
    
        indicarJugadoresEquipo1.setFont(fuenteEtiquetas2);
        indicarJugadoresEquipo2.setFont(fuenteEtiquetas2);
        indicarMusicos.setFont(fuenteEtiquetas2);
        indicarPersonasConvertidas.setFont(fuenteEtiquetas2);
        
        indicarJugadoresEquipo1.setForeground(Color.ORANGE);
        indicarJugadoresEquipo2.setForeground(Color.ORANGE);
        indicarMusicos.setForeground(Color.ORANGE);
        indicarPersonasConvertidas.setForeground(Color.ORANGE);
        
        indicarJugadoresEquipo1.setBounds(530, 330, 300, 50);
        indicarJugadoresEquipo2.setBounds(650, 330, 300, 50);
        espacioJugadoresEquipo1.setBounds(530, 370, 90, 150);
        espacioJugadoresEquipo2.setBounds(650, 370, 90, 150);
        
        indicarJugadoresEquipo1.setVisible(true);
        indicarJugadoresEquipo2.setVisible(true);
        espacioJugadoresEquipo1.setVisible(true);
        espacioJugadoresEquipo2.setVisible(true);
        
        indicarMusicos.setBounds(600, 330, 300, 50);
        espacioMusicos.setBounds(600, 370, 125, 150 );
        
        indicarMusicos.setVisible(false);
        espacioMusicos.setVisible(false);
        
        indicarPersonasConvertidas.setBounds(530, 330, 300, 50);
        espacioPersonasConvertidas.setBounds(530, 370, 170, 30);
        
        indicarPersonasConvertidas.setVisible(false);
        espacioPersonasConvertidas.setVisible(false);
        
        add(indicarJugadoresEquipo1);
        add(indicarJugadoresEquipo2);
        add(indicarMusicos);
        add(indicarPersonasConvertidas);
        add(espacioJugadoresEquipo1);
        add(espacioJugadoresEquipo2);
        add(espacioMusicos);
        add(espacioPersonasConvertidas);
        
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
       
        escribaCodigo.setFont(fuentePrincipal);
        escribaCodigo.setForeground(Color.WHITE);
        escribaCodigo.setBounds(400, 80, 450, 100);
        add(escribaCodigo);
        
        espacioCodigoVerificar.setBounds(445, 150, 150, 30);
        add(espacioCodigoVerificar);
        
        //Botón de regresar.
        botonRegresar.setFont(fuenteBotones);
        botonRegresar.setForeground(Color.ORANGE);
        botonRegresar.setBackground(Color.RED);
        botonRegresar.setBounds(60, 600, 180, 50);
        add(botonRegresar);
        
        comboSiNo.setBounds(360, 620, 100, 30);
        add(comboSiNo);
        
        etiquetaSiNo.setFont(fuenteEtiquetas2);
        etiquetaSiNo.setForeground(Color.ORANGE);
        etiquetaSiNo.setBounds(340, 590, 200, 30);
        add(etiquetaSiNo);
        
        //Título de la ventana.
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(Color.ORANGE);
        titulo.setBounds(275, 20, 300, 100);
        add(titulo);
        
        //Ubicar la instrucción de seleccionar.
        instruccionSeleccionar.setFont(fuenteEtiquetas2);
        instruccionSeleccionar.setForeground(Color.ORANGE);
        instruccionSeleccionar.setBounds(100, 80, 450, 100);
        add(instruccionSeleccionar);
        
        //Ubicar el ComboBox.
        seleccionCombo.setBounds(115, 150, 200, 30);
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
        comboMusica.setBounds(380, 515, 150, 20);
        
        etiquetaGeneroEscogido.setVisible(false);
        comboMusica.setVisible(false);
        
        add(etiquetaGeneroEscogido);
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
        etiquetaDia.setBounds(580, 250, 200, 50);
        espacioDia.setBounds(580, 290, 50, 30);
        add(etiquetaDia);
        add(espacioDia);
        
        etiquetaFecha.setBounds(575, 210, 200, 50);
        etiquetaFecha.setFont(fuenteEtiquetas);
        add(etiquetaFecha);
        
        etiquetaMes.setFont(fuenteEtiquetas);
        etiquetaMes.setForeground(Color.ORANGE);
        etiquetaMes.setBounds(640, 250, 200, 50);
        espacioMes.setBounds(640, 290, 50, 30);
        add(etiquetaMes);
        add(espacioMes);
        
        etiquetaAño.setFont(fuenteEtiquetas);
        etiquetaAño.setForeground(Color.ORANGE);
        etiquetaAño.setBounds(700, 250, 300, 50);
        espacioAño.setBounds(700, 290, 50, 30);
        add(etiquetaAño);
        add(espacioAño);
        
        
        //Colocar el botón de crear el evento.
        botonEditar.setForeground(Color.ORANGE);
        botonEditar.setBackground(Color.RED);
        botonEditar.setFont(fuenteBotones);
        botonEditar.setBounds(570, 600, 180, 50);
        add(botonEditar);
        
        eventoEditado.setForeground(Color.GREEN);
        eventoEditado.setFont(fuenteBotones);
        eventoEditado.setBounds(275, 600, 300, 50);
        eventoEditado.setVisible(false);
        add(eventoEditado);
        
        
        eventoNoEditado.setForeground(Color.RED);
        eventoNoEditado.setFont(fuenteEtiquetas);
        eventoNoEditado.setBounds(250,600,400,50);
        eventoNoEditado.setVisible(false);
        add(eventoNoEditado); 
        
        
        codigoIncorrecto.setForeground(Color.RED);
        fechaIncorrecta.setForeground(Color.RED);
        cantidadPersonasIncorrecta.setForeground(Color.RED);
        
        codigoIncorrecto.setFont(fuenteEtiquetas2);
        fechaIncorrecta.setFont(fuenteEtiquetas2);
        cantidadPersonasIncorrecta.setFont(fuenteEtiquetas2);
        
        codigoIncorrecto.setBounds(500, 550, 200, 20);
        fechaIncorrecta.setBounds(500, 560, 200, 20);
        cantidadPersonasIncorrecta.setBounds(500, 540, 200, 20);
        
        codigoIncorrecto.setVisible(false);
        fechaIncorrecta.setVisible(false);
        cantidadPersonasIncorrecta.setVisible(false);
        
        add(codigoIncorrecto);
        add(fechaIncorrecta);
        add(cantidadPersonasIncorrecta);
                
    }
    

    
}
