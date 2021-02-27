package ventanasreportes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListarEventosRealizados extends JPanel {
    
    //Objetos/Atributos.
    public JButton botonRegresar = new JButton("REGRESAR");
    public JLabel titulo = new JLabel("EVENTOS REALIZADOS");
    
    
    Font fuenteBotones = new Font("Elephant", Font.BOLD, 20);
    Font fuenteTitulo = new Font("Elephant", Font.BOLD, 20);
    Font fuenteEtiquetas2 = new Font("Arial", 0, 10);

    //Creación del JList.
    public DefaultListModel modelo = new DefaultListModel();
    public JList lista = new JList(modelo);
    public JScrollPane scroll = new JScrollPane(lista);
    
    public JLabel cantidadDeportivos = new JLabel("");
    public JLabel cantidadMusicales = new JLabel("");
    public JLabel cantidadReligiosos = new JLabel("");
    
    public ListarEventosRealizados(){
        
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
        
        cantidadDeportivos.setFont(fuenteEtiquetas2);
        cantidadMusicales.setFont(fuenteEtiquetas2);
        cantidadReligiosos.setFont(fuenteEtiquetas2);
        cantidadDeportivos.setForeground(Color.yellow);
        cantidadMusicales.setForeground(Color.yellow);
        cantidadReligiosos.setForeground(Color.yellow);
        
        cantidadDeportivos.setBounds(280,580, 500, 50);
        cantidadMusicales.setBounds(280, 600, 500, 50);
        cantidadReligiosos.setBounds(280, 620, 500, 50);
        
        add(cantidadDeportivos);
        add(cantidadMusicales);
        add(cantidadReligiosos);
        
        add(cantidadDeportivos);
        add(cantidadMusicales);
        add(cantidadReligiosos);
        
        lista.setBounds(20,150,750,400);
        add(lista);
        
        scroll.setBounds(20,150,750,400);
        add(scroll);
    }
    
}
