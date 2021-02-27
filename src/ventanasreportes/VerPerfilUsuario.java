package ventanasreportes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VerPerfilUsuario extends JPanel {
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("PERFIL DEL USUARIO");
    
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 20);
    Font fuenteEtiquetas = new Font("Arial", 0, 10);

    public JLabel datosUsuario1 = new JLabel("");
    public JLabel datosUsuario2 = new JLabel("");
    public JLabel datosUsuario3 = new JLabel("");
    public JLabel datosUsuario4 = new JLabel("");
    
    
    //Creación del JList.
    public DefaultListModel modelo = new DefaultListModel();
    public JList lista = new JList(modelo);
    public JScrollPane scroll = new JScrollPane(lista);
    
    
    public JLabel etiquetaEventosCreados = new JLabel("EVENTOS CREADOS");
    
    
    public VerPerfilUsuario(){
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        etiquetaEventosCreados.setForeground(Color.BLUE);
        etiquetaEventosCreados.setFont(fuenteTitulo);
        etiquetaEventosCreados.setBounds(270, 290, 400, 100);
        add(etiquetaEventosCreados);
        
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
        
        
        datosUsuario1.setFont(fuenteTitulo);
        datosUsuario2.setFont(fuenteTitulo);
        datosUsuario3.setFont(fuenteTitulo);
        datosUsuario4.setFont(fuenteTitulo);
        
        
        datosUsuario1.setForeground(Color.WHITE);
        datosUsuario2.setForeground(Color.WHITE);
        datosUsuario3.setForeground(Color.WHITE);
        datosUsuario4.setForeground(Color.WHITE);
        
        
        datosUsuario1.setBounds(30, 150, 800, 30);
        datosUsuario2.setBounds(30, 250, 800, 30);
        datosUsuario3.setBounds(30, 350, 800, 30);
        datosUsuario4.setBounds(30, 450, 800, 30);
        
        add(datosUsuario1);
        add(datosUsuario2);
        add(datosUsuario3);
        add(datosUsuario4);
        
        lista.setBounds(20,360,750,200);
        add(lista);
        
        scroll.setBounds(20,360,750,200);
        add(scroll);
        
        
    }
    
   
}
