package ventanasmenuprincipal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AdministrarUsers extends JPanel {
    
    //Atributos/objetos.
    public JButton botonCrear = new JButton("CREAR USUARIO");
    public JButton botonEditar = new JButton("EDITAR USUARIO");
    public JButton botonBorrar = new JButton("BORRAR USUARIO");
    public JButton botonRegresar = new JButton("REGRESAR");
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 25);
    
    public AdministrarUsers(){
        
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        
        //Establecer la fuente de la letra de los botones.
        botonCrear.setFont(fuenteBotones);
        botonEditar.setFont(fuenteBotones);
        botonBorrar.setFont(fuenteBotones);
        botonRegresar.setFont(fuenteBotones);
        
        //Establecer el color de la letra.
        botonCrear.setForeground(Color.ORANGE);
        botonEditar.setForeground(Color.ORANGE);
        botonBorrar.setForeground(Color.ORANGE);
        botonRegresar.setForeground(Color.ORANGE);
        
        //Establecer el color de los botones.
        botonCrear.setBackground(Color.RED);
        botonEditar.setBackground(Color.RED);
        botonBorrar.setBackground(Color.RED);
        botonRegresar.setBackground(Color.RED);
        
        //Establecer la ubicación en el JPanel.
        botonCrear.setBounds(150, 50, 500, 70);
        botonEditar.setBounds(150, 200, 500, 70);
        botonBorrar.setBounds(150, 350, 500, 70);
        botonRegresar.setBounds(150, 500, 500, 70);
        
        add(botonCrear);
        add(botonEditar);
        add(botonBorrar);
        add(botonRegresar);
        
    }
            
    
}
