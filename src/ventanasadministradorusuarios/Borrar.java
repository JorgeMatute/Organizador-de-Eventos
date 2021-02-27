package ventanasadministradorusuarios;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Borrar extends JPanel {
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("BORRAR USUARIO");
    public JLabel usuarioABorrar = new JLabel("Escriba el usuario que desea borrar: ");
    public JLabel usuarioYaEscrito = new JLabel("Una vez escrito el usuario, presione el botón \"BORRAR\"");
    public JLabel usuarioNoEncontrado = new JLabel("El usuario que solicitó borrar no se encontró.");
    public JLabel borradoExitoso = new JLabel("¡El usuario se ha borrado exitosamente!");
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 25);
    Font fuenteEtiquetas = new Font("Elephant", 0, 20);
    
    public JTextField espacioUsuarioBorrar = new JTextField();
    public JButton botonConfirmarBorrar = new JButton("BORRAR");
    
    
    public Borrar(){
        
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
        
        //Colocar la instrucción.
        usuarioABorrar.setFont(fuenteEtiquetas);
        usuarioABorrar.setForeground(Color.ORANGE);
        usuarioABorrar.setBounds(220, 150, 600, 100);
        add(usuarioABorrar);
        
        
        //Espacio donde escribirá el usuario a borrar.
        espacioUsuarioBorrar.setBounds(310, 250, 200, 50);
        add(espacioUsuarioBorrar);
        
        usuarioYaEscrito.setFont(fuenteEtiquetas);
        usuarioYaEscrito.setForeground(Color.ORANGE);
        usuarioYaEscrito.setBounds(150, 300, 600, 100);
        add(usuarioYaEscrito);
        
        botonConfirmarBorrar.setFont(fuenteBotones);
        botonConfirmarBorrar.setBackground(Color.RED);
        botonConfirmarBorrar.setForeground(Color.ORANGE);
        botonConfirmarBorrar.setBounds(310, 400, 180, 50);
        add(botonConfirmarBorrar);
        
        
        usuarioNoEncontrado.setFont(fuenteEtiquetas);
        usuarioNoEncontrado.setForeground(Color.RED);
        usuarioNoEncontrado.setBounds(185, 445, 600, 100);
        usuarioNoEncontrado.setVisible(false);
        add(usuarioNoEncontrado);
        
        //Confirmación que se ha borrado exitosamente el usuario.
        borradoExitoso.setFont(fuenteEtiquetas);
        borradoExitoso.setForeground(Color.GREEN);
        borradoExitoso.setBounds(220, 445, 600, 100);
        borradoExitoso.setVisible(false); 
        add(borradoExitoso);
        
        
    }
}
