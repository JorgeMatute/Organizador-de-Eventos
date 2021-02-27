package ventanaTicket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class MenuPrincipal extends JPanel {
    
    JButton botonAdministrarEventos = new JButton();
    JButton botonAdministrarUsers = new JButton();
    JButton botonReportes = new JButton();
    JButton botonCerrarSesion = new JButton();
    JButton botonSalir = new JButton("SALIR");
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 25);
    
    public MenuPrincipal(){
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        //Botón para administrar los eventos.
        botonAdministrarEventos.setText("ADMINISTRAR EVENTOS");
        botonAdministrarEventos.setFont(fuenteBotones);
        botonAdministrarEventos.setForeground(Color.ORANGE);
        botonAdministrarEventos.setBackground(Color.RED);
        botonAdministrarEventos.setBounds(150, 50, 500, 70);
        add(botonAdministrarEventos);
        
        //Botón para administrar los usuarios.
        botonAdministrarUsers.setText("ADMINISTRAR USUARIOS");
        botonAdministrarUsers.setFont(fuenteBotones);
        botonAdministrarUsers.setBackground(Color.RED);
        botonAdministrarUsers.setForeground(Color.ORANGE);
        botonAdministrarUsers.setBounds(150, 170, 500, 70);
        add(botonAdministrarUsers);
        
        //Botón para reportes.
        botonReportes.setText("REPORTES");
        botonReportes.setFont(fuenteBotones);
        botonReportes.setBackground(Color.RED);
        botonReportes.setForeground(Color.ORANGE);
        botonReportes.setBounds(150, 290, 500, 70);
        add(botonReportes);
        
        //Botón para cerrar sesión.
        botonCerrarSesion.setText("CERRAR SESIÓN");
        botonCerrarSesion.setFont(fuenteBotones);
        botonCerrarSesion.setForeground(Color.ORANGE);
        botonCerrarSesion.setBackground(Color.RED);
        botonCerrarSesion.setBounds(150, 410, 500, 70);
        add(botonCerrarSesion);
        
        //Botón para cerrar sesión.
        botonSalir.setFont(fuenteBotones);
        botonSalir.setForeground(Color.ORANGE);
        botonSalir.setBackground(Color.RED);
        botonSalir.setBounds(150, 530, 500, 70);
        add(botonSalir);
        
    }
    
    
}
