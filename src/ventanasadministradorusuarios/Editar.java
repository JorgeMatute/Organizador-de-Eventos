package ventanasadministradorusuarios;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Editar extends JPanel {               
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("EDITAR USUARIO");
        
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 25);
    Font fuenteEtiquetas = new Font("Elephant", 0, 17);
    
    
    //Todos los objetos para la edición de un usario.
    public JLabel escribirUsuario = new JLabel("Escriba el usuario que desea editar: ");
    public JLabel usuarioNoEncontrado = new JLabel("El usuario que ha ingresado, no existe.");
    public JLabel usuarioModificado = new JLabel("Se ha modificado exitosamente el usuario.");
    public JLabel instruccionPresionarBoton = new JLabel("Presione el botón \"EDITAR\" para terminar de editar el usuario.");

    public JButton botonModificarUsuario = new JButton("EDITAR");

    public JLabel usuarioNuevo = new JLabel("Nuevo usuario:");
    public JLabel contraseñaNueva = new JLabel("Nueva contraseña:");
    public JLabel nuevaEdad = new JLabel("Nueva edad:");
    public JLabel nuevoNombre = new JLabel("Nuevo nombre: ");
    
    public JTextField espacioCambioUser = new JTextField();
    public JTextField espacioCambioPass = new JTextField();
    public JTextField espacioCambioNombre = new JTextField();
    public JTextField espacioCambioEdad = new JTextField();
    
    public JTextField usuarioSolicitudCambio = new JTextField();
    
    public Editar(){
        
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
        
        
        //Todas las etiquetas relacionadas a la edición del usuario.
        escribirUsuario.setFont(fuenteEtiquetas);
        usuarioNoEncontrado.setFont(fuenteEtiquetas);
        usuarioModificado.setFont(fuenteEtiquetas);
        instruccionPresionarBoton.setFont(fuenteEtiquetas);
        usuarioNuevo.setFont(fuenteEtiquetas);
        contraseñaNueva.setFont(fuenteEtiquetas);
        nuevaEdad.setFont(fuenteEtiquetas);
        nuevoNombre.setFont(fuenteEtiquetas);
        
        escribirUsuario.setForeground(Color.ORANGE);
        usuarioNoEncontrado.setForeground(Color.RED);
        usuarioModificado.setForeground(Color.GREEN);
        instruccionPresionarBoton.setForeground(Color.ORANGE);
        usuarioNuevo.setForeground(Color.ORANGE);
        contraseñaNueva.setForeground(Color.ORANGE);
        nuevaEdad.setForeground(Color.ORANGE);
        nuevoNombre.setForeground(Color.ORANGE);
        
        escribirUsuario.setBounds(265, 90, 600, 100);
        usuarioNoEncontrado.setBounds(265, 200, 600, 100);
        usuarioModificado.setBounds(275, 570, 600, 100);
        instruccionPresionarBoton.setBounds(160, 450, 700, 100);
        usuarioNuevo.setBounds(50, 255, 200, 100);
        contraseñaNueva.setBounds(50, 390, 200, 100);
        nuevaEdad.setBounds(400, 255, 200, 100);
        nuevoNombre.setBounds(400, 390, 200, 100 );
        
        usuarioNoEncontrado.setVisible(false);
        usuarioModificado.setVisible(false);
        
        add(escribirUsuario);
        add(usuarioNoEncontrado);
        add(usuarioModificado);
        add(instruccionPresionarBoton);
        add(usuarioNuevo);
        add(contraseñaNueva);
        add(nuevaEdad);
        add(nuevoNombre);
        
        
        botonModificarUsuario.setFont(fuenteBotones);
        botonModificarUsuario.setBackground(Color.RED);
        botonModificarUsuario.setForeground(Color.ORANGE);
        botonModificarUsuario.setBounds(338, 550, 180, 50);
        add(botonModificarUsuario);
        
        
        espacioCambioUser.setBounds(200, 290, 150, 30);
        espacioCambioEdad.setBounds(515, 290, 150, 30 );
        espacioCambioPass.setBounds(217, 425, 150, 30 );
        espacioCambioNombre.setBounds(535, 425, 150, 30);
        
               
        add(espacioCambioUser);
        add(espacioCambioNombre);
        add(espacioCambioPass);
        add(espacioCambioEdad);
        
        
        
        usuarioSolicitudCambio.setBounds(330, 180, 150, 30);
        add(usuarioSolicitudCambio);
        
        
        
    }
}
