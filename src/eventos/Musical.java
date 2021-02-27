package eventos;

import java.util.Calendar;

public class Musical extends Eventos {
    
    public enum TipoMusica{
        POP, ROCK, RAP, CLASICA, REGGAETON, OTRO;
    }
    
    
    public String eventoMusical[] = new String[1000];
    
    public int posicionMusical[] = new int[1000];
    public int posicionArreglo;
    
    //Seguro de grama del 30%...
    //Máximo de gente 25k.

    public Musical(TipoMusica generoEscogido, String codigoUnico, String tituloEvento,
            String descripcionEvento, Calendar fechaEvento, double montoRenta, int MaximoGente, boolean futuro, boolean cancelado) {
      
        super(codigoUnico, tituloEvento, descripcionEvento, fechaEvento, montoRenta+(montoRenta*0.30), MaximoGente, futuro, cancelado);
    }
    
    
    
    
    
 
    @Override
    public String toString() {
        return "Código: "+codigoUnico+"          --          Título del evento: "+tituloEvento;
    }
    
    @Override
    public String toString2(){
        return "Descripción del evento: "+descripcionEvento+"          --          Fecha del evento: "+fechaEvento.getTime();
    }
    
    @Override
    public String toString3(){
        return "Costo de la renta (costos adicionales añadidos): "+montoRenta+"             --         Cantidad de personas que asistirán: "+maximoGente;
    }
    
    @Override
    public String toString4(){
        return canceladoONo();
    }
    
}
