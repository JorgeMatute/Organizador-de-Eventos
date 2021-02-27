package ventanasadministracioneventos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EliminarEvento extends JPanel {
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("ELIMINAR EVENTOS");
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 20);
    Font fuenteEtiquetas = new Font("Elephant", 0, 20);
   
    public JLabel ingresarCodigo = new JLabel("Ingrese el código del evento a borrar: ");
    public JTextField espacioCodigo = new JTextField();
    public JButton botonConfirmarBorrar = new JButton("BORRAR");
    public JLabel eventoNoEncontrado = new JLabel("Evento no encontrado");
    public JLabel borradoExitoso = new JLabel("¡El evento se ha borrado exitosamente!");

    
    
    public EliminarEvento(){
        
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
        
        
        //Espacio y etiqueta para ingresar el código.
        ingresarCodigo.setForeground(Color.ORANGE);
        ingresarCodigo.setFont(fuenteBotones);
        ingresarCodigo.setBounds(200, 150, 500, 100);
        add(ingresarCodigo);
        
        espacioCodigo.setBounds(300, 285, 200, 40);
        add(espacioCodigo);
        
        
        botonConfirmarBorrar.setFont(fuenteBotones);
        botonConfirmarBorrar.setBackground(Color.RED);
        botonConfirmarBorrar.setForeground(Color.ORANGE);
        botonConfirmarBorrar.setBounds(310, 400, 180, 50);
        add(botonConfirmarBorrar);
        
        
        //Avsio de evento no encontrado.
        eventoNoEncontrado.setForeground(Color.RED);
        eventoNoEncontrado.setFont(fuenteBotones);
        eventoNoEncontrado.setBounds(275, 500, 300, 100);
        eventoNoEncontrado.setVisible(false);
        add(eventoNoEncontrado);
        
        //Confirmación de que se ha borrado el evento exitosamente.
        borradoExitoso.setFont(fuenteEtiquetas);
        borradoExitoso.setForeground(Color.GREEN);
        borradoExitoso.setBounds(220, 445, 600, 100);
        borradoExitoso.setVisible(false); 
        add(borradoExitoso);
    }
}
