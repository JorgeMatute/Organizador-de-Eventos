package ventanasreportes;

import eventos.JNumberField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IngresoGeneradoFecha extends JPanel {
 
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("INGRESO GENERADO HASTA LA FECHA");
    
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 20);
    Font fuenteEtiquetas2 = new Font("Arial", 0, 10);
    Font fuentePrincipal = new Font("Arial", 0, 16);
    
    
    //Fecha inicial.
    //Espacios y escritos para la fecha. Recordar restarle 1 al mes.
    public JLabel etiquetaFechaInicial = new JLabel("Ingrese la fecha inicial: ");
    public JLabel etiquetaDiaInicial = new JLabel("Día:");
    public JNumberField espacioDiaInicial = new JNumberField();
    
    public JLabel etiquetaMesInicial = new JLabel("Mes:");
    public JNumberField espacioMesInicial = new JNumberField();
    
    public JLabel etiquetaAñoInicial = new JLabel("Año:");
    public JNumberField espacioAñoInicial = new JNumberField();
    
    
    //Fecha final.
    public JLabel etiquetaFechaFinal = new JLabel("Ingrese la fecha final: ");
    public JLabel etiquetaDiaFinal  = new JLabel("Día:");
    public JNumberField espacioDiaFinal  = new JNumberField();
    
    public JLabel etiquetaMesFinal  = new JLabel("Mes:");
    public JNumberField espacioMesFinal  = new JNumberField();
    
    public JLabel etiquetaAñoFinal  = new JLabel("Año:");
    public JNumberField espacioAñoFinal  = new JNumberField();
    
    
    //Etiqueta que mostrará los ingresos.
    public JLabel montoEntreFechas = new JLabel("");
    
    public JButton botonVerIngresos = new JButton("VER INGRESOS");
    
    public JLabel cantidadDeportivos = new JLabel("");
    public JLabel cantidadMusicales = new JLabel("");
    public JLabel cantidadReligiosos = new JLabel("");
    
    
    
    
    public IngresoGeneradoFecha(){
        
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        cantidadDeportivos.setBounds(280,580, 500, 50);
        cantidadMusicales.setBounds(280, 600, 500, 50);
        cantidadReligiosos.setBounds(280, 620, 500, 50);
        
        cantidadDeportivos.setForeground(Color.ORANGE);
        cantidadMusicales.setForeground(Color.ORANGE);
        cantidadReligiosos.setForeground(Color.ORANGE);
        
        add(cantidadDeportivos);
        add(cantidadMusicales);
        add(cantidadReligiosos);
        
        
        //Colocación de la fecha inicial.
        etiquetaFechaInicial.setForeground(Color.yellow);
        etiquetaFechaInicial.setFont(fuenteTitulo);
        etiquetaFechaInicial.setBounds(100, 200, 300, 30);
        add(etiquetaFechaInicial);
        
        etiquetaDiaInicial.setForeground(Color.yellow);
        etiquetaDiaInicial.setFont(fuentePrincipal);
        etiquetaDiaInicial.setBounds(100, 230, 100, 30);
        add(etiquetaDiaInicial);
        
        espacioDiaInicial.setBounds(100, 270, 50, 30);
        add(espacioDiaInicial);
        
        
        etiquetaMesInicial.setForeground(Color.yellow);
        etiquetaMesInicial.setFont(fuentePrincipal);
        etiquetaMesInicial.setBounds(200, 230, 100, 30);
        add(etiquetaMesInicial);
        
        espacioMesInicial.setBounds(200, 270, 50, 30);
        add(espacioMesInicial);
        
        
        etiquetaAñoInicial.setForeground(Color.yellow);
        etiquetaAñoInicial.setFont(fuentePrincipal);
        etiquetaAñoInicial.setBounds(300, 230, 100, 30);
        add(etiquetaAñoInicial);
        
        espacioAñoInicial.setBounds(300, 270, 50, 30);
        add(espacioAñoInicial);
        
        
        //Colocación de la fecha final.
        etiquetaFechaFinal.setForeground(Color.yellow);
        etiquetaFechaFinal.setFont(fuenteTitulo);
        etiquetaFechaFinal.setBounds(480, 200, 300, 30);
        add(etiquetaFechaFinal);
        
        etiquetaDiaFinal.setForeground(Color.yellow);
        etiquetaDiaFinal.setFont(fuentePrincipal);
        etiquetaDiaFinal.setBounds(480, 230, 100, 30);
        add(etiquetaDiaFinal);
        
        espacioDiaFinal.setBounds(480, 270, 50, 30);
        add(espacioDiaFinal);
        
        
        etiquetaMesFinal.setForeground(Color.yellow);
        etiquetaMesFinal.setFont(fuentePrincipal);
        etiquetaMesFinal.setBounds(580, 230, 100, 30);
        add(etiquetaMesFinal);
        
        
        espacioMesFinal.setBounds(580, 270, 50, 30);
        add(espacioMesFinal);
        
        
        etiquetaAñoFinal.setForeground(Color.yellow);
        etiquetaAñoFinal.setFont(fuentePrincipal);
        etiquetaAñoFinal.setBounds(680, 230, 100, 30);
        add(etiquetaAñoFinal);
        
        espacioAñoFinal.setBounds(680, 270, 50, 30);
        add(espacioAñoFinal);
        
        //Botón de regresar.
        botonRegresar.setFont(fuenteBotones);
        botonRegresar.setForeground(Color.ORANGE);
        botonRegresar.setBackground(Color.RED);
        botonRegresar.setBounds(60, 600, 180, 50);
        add(botonRegresar);
        
        //Título de la ventana.
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(Color.ORANGE);
        titulo.setBounds(150, 20, 550, 100);
        add(titulo);
        
        
        //Colocación del botón.
        botonVerIngresos.setForeground(Color.ORANGE);
        botonVerIngresos.setBackground(Color.RED);
        botonVerIngresos.setFont(fuenteBotones);
        botonVerIngresos.setBounds(280, 400, 250, 50);
        add(botonVerIngresos);
        
        
        montoEntreFechas.setFont(fuentePrincipal);
        montoEntreFechas.setForeground(Color.GREEN);
        montoEntreFechas.setBounds(270, 445, 600, 100);
        add(montoEntreFechas);
        
    }
}
