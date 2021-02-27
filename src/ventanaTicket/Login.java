package ventanaTicket;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel 
{
    JButton botonLogin = new JButton("Login");
    JTextField campoUsuario = new JTextField();
    JPasswordField campoContraseña = new JPasswordField();
    JLabel etiquetaLogin = new JLabel();
    JLabel etiquetaUsuario = new JLabel();
    JLabel etiquetaContraseña = new JLabel();
    Font fuenteLogin = new Font("Elephant", Font.BOLD, 50);
    Font usuarioContraseña = new Font("Elephant", Font.BOLD, 30);
    Font fuenteEtiquetas = new Font("Elephant", 0 , 15); 
    //Objetos para las imágenes.
    ImageIcon imagenDeporte = new ImageIcon(getClass().getResource("/imagenes/deporte.png"));
    ImageIcon imagenReligion = new ImageIcon(getClass().getResource("/imagenes/religion.jfif"));
    ImageIcon imagenMusica = new ImageIcon(getClass().getResource("/imagenes/musica.png"));
    ImageIcon imagenEstadio = new ImageIcon(getClass().getResource("/imagenes/estadio.jfif"));
        
    JLabel etiquetaDeporte = new JLabel();
    JLabel etiquetaReligion = new JLabel();
    JLabel etiquetaMusica = new JLabel();
    JLabel etiquetaEstadio = new JLabel();
    
    //Etiqueta de aviso que el usuario ingresado, no existe/equivocado.
    public JLabel noExisteEquivocado  = new JLabel("El usuario/contraseña que ha ingresado no existe o lo ha ingresado mal.");
   
    
    public Login()
    {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        //Boton Login
        add(botonLogin);
        botonLogin.setBounds(350,550,100,50);
        botonLogin.setBackground(Color.RED);
        botonLogin.setFont(new Font("Elephant", Font.BOLD, 20));
        botonLogin.setForeground(Color.ORANGE);
        
        //Escritos.
        etiquetaLogin.setText("LOGIN");
        etiquetaUsuario.setText("Usuario: ");
        etiquetaContraseña.setText("Contraseña");
        
        etiquetaLogin.setForeground(Color.ORANGE);
        etiquetaUsuario.setForeground(Color.ORANGE);
        etiquetaContraseña.setForeground(Color.ORANGE);
        
        etiquetaLogin.setBounds(285, 20, 300, 100);
        etiquetaUsuario.setBounds(100, 200, 300, 100);
        etiquetaContraseña.setBounds(100, 400, 300, 100);
        
        etiquetaLogin.setFont(fuenteLogin);
        etiquetaUsuario.setFont(usuarioContraseña);
        etiquetaContraseña.setFont(usuarioContraseña);
        
        add(etiquetaLogin);
        add(etiquetaUsuario);
        add(etiquetaContraseña);
        
        //Espacio para escribiri la contraseña y usuario.
        campoUsuario.setBounds(320, 225, 200, 50);
        campoContraseña.setBounds(320, 425, 200, 50);
        
        add(campoUsuario);
        add(campoContraseña);
        
        //Colocar imágenes.
        etiquetaDeporte.setBounds(10, 500, 150, 150);
        etiquetaReligion.setBounds(625, 10, 150, 150);
        etiquetaMusica.setBounds(625, 500, 150, 150);
        etiquetaEstadio.setBounds(10, 10, 150, 150);
        
        etiquetaDeporte.setIcon(new ImageIcon(imagenDeporte.getImage().getScaledInstance(etiquetaDeporte.getWidth(), etiquetaDeporte.getHeight(), Image.SCALE_SMOOTH)));
        etiquetaReligion.setIcon(new ImageIcon(imagenReligion.getImage().getScaledInstance(etiquetaReligion.getWidth(), etiquetaReligion.getHeight(), Image.SCALE_SMOOTH)));
        etiquetaMusica.setIcon(new ImageIcon(imagenMusica.getImage().getScaledInstance(etiquetaMusica.getWidth(), etiquetaMusica.getHeight(), Image.SCALE_SMOOTH)));
        etiquetaEstadio.setIcon(new ImageIcon(imagenEstadio.getImage().getScaledInstance(etiquetaEstadio.getWidth(), etiquetaEstadio.getHeight(), Image.SCALE_SMOOTH)));
       
        
        //Colocar aviso.
        noExisteEquivocado.setFont(fuenteEtiquetas);
        noExisteEquivocado.setForeground(Color.RED);
        noExisteEquivocado.setVisible(false);
        noExisteEquivocado.setBounds(160, 160, 600, 40);
        
         
        add(etiquetaDeporte);
        add(etiquetaReligion);
        add(etiquetaMusica);
        add(etiquetaEstadio);
        add(noExisteEquivocado);
    }

   

}
