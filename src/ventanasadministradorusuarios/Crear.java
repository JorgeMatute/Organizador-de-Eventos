package ventanasadministradorusuarios;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import usuarios.UsuarioAdministrador;
import usuarios.UsuarioContenido;
import usuarios.UsuarioLimitado;

public class Crear extends JPanel {
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JButton botonCrearUsuario = new JButton("CREAR USUARIO");
    public JLabel titulo = new JLabel("CREAR USUARIO");
    public JTextField espacioUsuario = new JTextField();
    public JTextField espacioContraseña = new JTextField();
    public JLabel etiquetaUsuario = new JLabel("Nuevo usuario: ");
    public JLabel etiquetaContraseña = new JLabel("Contraseña: ");
    public JLabel etiquetaSeleccionarUsuario = new JLabel("Seleccione el tipo de usuario a crear: ");
    
    //Etiquetas por el ingreso de usuarios repetidos.
    public JLabel userRepetido = new JLabel("¡El usuario que ha solicitado ya existe!");
    
    
   
    public String tipoUsuario[] = {"Usuario Limitado","Usuario de Contenido","Usuario Administrador"};
    public JComboBox opcionUsuario = new JComboBox(tipoUsuario); 
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 25);
    Font fuenteEtiquetas = new Font("Elephant", 0 , 15);
    
    
    //Objetos de las clases de los diferentes tipos de usuarios que ayudan para la creación de nuevos usuarios.
    public UsuarioAdministrador claseUserAdmin = new UsuarioAdministrador();
    public int posicionUsuarioAdmin = 0;
    
    public UsuarioContenido claseUserContenido = new UsuarioContenido();
    public int posicionUsuarioContenido = 0;
    
    public UsuarioLimitado claseUsuarioLimitado = new UsuarioLimitado();
    public int posicionUsuarioLimitado = 0;
    
    
    
    //Objetos para los nombres y edad de un usuario.
    public JLabel edadUsuario = new JLabel("Edad: ");
    public JLabel nombreUsuario = new JLabel("Nombre completo: ");
    
    public JTextField edadUsuarioEspacio = new JTextField();
    public JTextField nombreUsuarioEspacio = new JTextField();
    
    
   
    
    
    public Crear(){
        
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
        
        //Espacios y etiquetas para escribir el usuario y contraseña nuevo.
        espacioUsuario.setBounds(400, 150, 200, 50);
        add(espacioUsuario);
        
        espacioContraseña.setBounds(400, 220, 200, 50);
        add(espacioContraseña);
        
        etiquetaUsuario.setBounds(150, 150, 200, 50);
        etiquetaContraseña.setBounds(150, 220, 230, 50);
        etiquetaUsuario.setFont(fuenteBotones);
        etiquetaContraseña.setFont(fuenteBotones);
        etiquetaUsuario.setForeground(Color.ORANGE);
        etiquetaContraseña.setForeground(Color.ORANGE);
        add(etiquetaUsuario);
        add(etiquetaContraseña);
        
        //Botón para crear el usuario.
        botonCrearUsuario.setFont(fuenteBotones);
        botonCrearUsuario.setForeground(Color.ORANGE);
        botonCrearUsuario.setBackground(Color.RED);
        botonCrearUsuario.setBounds(450, 600, 250, 50);
        add(botonCrearUsuario);
        
        
        //JComboBox y lo relacionado.
        etiquetaSeleccionarUsuario.setForeground(Color.ORANGE);
        etiquetaSeleccionarUsuario.setFont(fuenteBotones);
        etiquetaSeleccionarUsuario.setBounds(190, 430, 500, 50);
        add(etiquetaSeleccionarUsuario);
        
        opcionUsuario.setBounds(300, 500, 200, 40);   
        add(opcionUsuario);       
        
        
        //Etiqueta de usuario existente.
        userRepetido.setFont(fuenteEtiquetas);
        userRepetido.setForeground(Color.RED);
        userRepetido.setVisible(false);
        userRepetido.setBounds(245, 550, 400, 40);
        add(userRepetido);
        
        
        //Etiquetas para edad y nombre completo.
        edadUsuario.setFont(fuenteBotones);
        nombreUsuario.setFont(fuenteBotones);
        
        nombreUsuario.setBounds(150, 370, 230, 50);
        edadUsuario.setBounds(150, 290, 230, 50);
        
        nombreUsuario.setForeground(Color.ORANGE);
        edadUsuario.setForeground(Color.ORANGE);
        
        add(nombreUsuario);
        add(edadUsuario);
        
        
        edadUsuarioEspacio.setBounds(400, 290, 200, 50);
        nombreUsuarioEspacio.setBounds(400, 360, 200, 50);
        
        add(edadUsuarioEspacio);
        add(nombreUsuarioEspacio);
        
    }
}
