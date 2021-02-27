package ventanasmenuprincipal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AdministrarEventos extends JPanel {
    
     //Atributos y objetos.
     public JButton botonCrearEvento = new JButton("CREAR EVENTO");
     public JButton botonEliminarEvento = new JButton("ELIMINAR EVENTO");
     public JButton botonEditarEvento = new JButton("EDITAR EVENTO");
     public JButton botonVerEvento = new JButton("VER EVENTO");
     public JButton botonRegresarMenu = new JButton("REGRESAR");
    
     Font fuenteBotones = new Font("Elephant", Font.BOLD, 25);
     
    public AdministrarEventos(){
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        //Establecemos la misma fuente para todos los botones.
        botonCrearEvento.setFont(fuenteBotones);
        botonEliminarEvento.setFont(fuenteBotones);
        botonEditarEvento.setFont(fuenteBotones);
        botonVerEvento.setFont(fuenteBotones);
        botonRegresarMenu.setFont(fuenteBotones);
        
        //Darle ubicación a cada botón.
        botonCrearEvento.setBounds(150, 40, 500, 70);
        botonEliminarEvento.setBounds(150, 160, 500, 70);
        botonEditarEvento.setBounds(150, 280, 500, 70);
        botonVerEvento.setBounds(150, 400, 500, 70);
        botonRegresarMenu.setBounds(150, 520, 500, 70);
        
        //Darle el color a los botones.
        botonCrearEvento.setBackground(Color.RED);
        botonEliminarEvento.setBackground(Color.RED);
        botonEditarEvento.setBackground(Color.RED);
        botonVerEvento.setBackground(Color.RED);
        botonRegresarMenu.setBackground(Color.RED);
        
        //Darle el color a las letras de los botones.
        botonCrearEvento.setForeground(Color.ORANGE);
        botonEliminarEvento.setForeground(Color.ORANGE);
        botonEditarEvento.setForeground(Color.ORANGE);
        botonVerEvento.setForeground(Color.ORANGE);
        botonRegresarMenu.setForeground(Color.ORANGE);
        
        //Agregamos todos los botones al JPanel.
        add(botonCrearEvento);
        add(botonEliminarEvento);
        add(botonEditarEvento);
        add(botonVerEvento);
        add(botonRegresarMenu);
        
    }
    
    
}
