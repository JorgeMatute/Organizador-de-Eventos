package ventanasadministracioneventos;

import eventos.Deportivo;
import static eventos.Deportivo.TipoDeporte.FUTBOL;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerEvento extends JPanel {
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("VER EVENTOS");
    
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 25);
    Font fuenteEtiquetas = new Font("Arial", 0, 10);
    
    
    public JLabel ingresarCodigo = new JLabel("Ingrese el código del evento: ");
    public JTextField espacioCodigo = new JTextField();
    
    public JLabel datosEvento = new JLabel("");
    public JLabel datosEvento2 = new JLabel("");
    public JLabel datosEvento3 = new JLabel("");
    public JLabel datosEvento4 = new JLabel("");
    
    public JButton botonVerEvento = new JButton("VER EVENTO");

    public JLabel eventoNoEncontrado = new JLabel("Evento no encontrado");

    
    public VerEvento(){
        
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
        
        
        ingresarCodigo.setForeground(Color.ORANGE);
        ingresarCodigo.setFont(fuenteBotones);
        ingresarCodigo.setBounds(240, 150, 500, 100);
        add(ingresarCodigo);
        
        espacioCodigo.setBounds(300, 285, 200, 40);
        add(espacioCodigo);
        
        
        botonVerEvento.setForeground(Color.ORANGE);
        botonVerEvento.setBackground(Color.RED);
        botonVerEvento.setFont(fuenteBotones);
        botonVerEvento.setBounds(520, 600, 210, 50);
        add(botonVerEvento);
        
        
        eventoNoEncontrado.setForeground(Color.RED);
        eventoNoEncontrado.setFont(fuenteBotones);
        eventoNoEncontrado.setBounds(275, 500, 300, 100);
        eventoNoEncontrado.setVisible(false);
        add(eventoNoEncontrado);
        
        
        
        
        datosEvento.setFont(fuenteEtiquetas);
        datosEvento2.setFont(fuenteEtiquetas);
        datosEvento3.setFont(fuenteEtiquetas);
        datosEvento4.setFont(fuenteEtiquetas);
        
        
        datosEvento.setForeground(Color.WHITE);
        datosEvento.setForeground(Color.WHITE);
        datosEvento2.setForeground(Color.WHITE);
        datosEvento3.setForeground(Color.WHITE);
        datosEvento4.setForeground(Color.WHITE);
        
        
        datosEvento.setBounds(30, 250, 800, 30);
        datosEvento.setBounds(30, 300, 800, 30);
        datosEvento.setBounds(30, 350, 800, 30);
        datosEvento2.setBounds(30, 400, 800, 30);
        datosEvento3.setBounds(30, 450, 800, 30);
        datosEvento4.setBounds(30, 500, 800, 30);
        
        add(datosEvento);
        add(datosEvento2);
        add(datosEvento3);
        add(datosEvento4);
        
        
        
    }
}
