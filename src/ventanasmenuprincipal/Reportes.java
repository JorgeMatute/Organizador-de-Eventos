package ventanasmenuprincipal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Reportes extends JPanel {
    
    //Atributos/objetos.
    public JButton botonEventosRealizados = new JButton("EVENTOS REALIZADOS");
    public JButton botonEventosFuturos = new JButton("EVENTOS FUTUROS");
    public JButton botonEventosCancelados = new JButton("EVENTOS CANCELADOS");
    public JButton botonIngresosFecha = new JButton("INGRESO GENERADO POR FECHA");
    public JButton botonVerPerfil = new JButton("VER PERFIL DEL USUARIO");
    public JButton botonRegresar = new JButton("REGRESAR");
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    
    public Reportes(){
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        //Establecemos la fuente para cada botón.
        botonEventosRealizados.setFont(fuenteBotones);
        botonEventosFuturos.setFont(fuenteBotones);
        botonEventosCancelados.setFont(fuenteBotones);
        botonIngresosFecha.setFont(fuenteBotones);
        botonVerPerfil.setFont(fuenteBotones);
        botonRegresar.setFont(fuenteBotones);
        
        //Establecemos el color para las letras.
        botonEventosRealizados.setForeground(Color.ORANGE);
        botonEventosFuturos.setForeground(Color.ORANGE);
        botonEventosCancelados.setForeground(Color.ORANGE);
        botonIngresosFecha.setForeground(Color.ORANGE);
        botonVerPerfil.setForeground(Color.ORANGE);
        botonRegresar.setForeground(Color.ORANGE);
        
        //Establecemos el color a los botones.
        botonEventosRealizados.setBackground(Color.RED);
        botonEventosFuturos.setBackground(Color.RED);
        botonEventosCancelados.setBackground(Color.RED);
        botonIngresosFecha.setBackground(Color.RED);
        botonVerPerfil.setBackground(Color.RED);
        botonRegresar.setBackground(Color.RED);
        
        //Ubicamos a cada botón en el JPanel.
        botonEventosRealizados.setBounds(150, 40, 500, 70);
        botonEventosFuturos.setBounds(150, 140, 500, 70);
        botonEventosCancelados.setBounds(150,240 , 500, 70);
        botonIngresosFecha.setBounds(150, 340, 500, 70);
        botonVerPerfil.setBounds(150, 440, 500, 70);
        botonRegresar.setBounds(150, 540, 500, 70);
        
        add(botonEventosRealizados);
        add(botonEventosFuturos);
        add(botonEventosCancelados);
        add(botonIngresosFecha);
        add(botonVerPerfil);
        add(botonRegresar);
        
        
        
    }
}
