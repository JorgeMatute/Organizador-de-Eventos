package eventos;

import java.util.Calendar;

public class Religioso extends Eventos {

    //Se cobra 2000 lempiras fijos de seguro por el desgaste de la grama.
    //Máximo gente = 30k.
    
    public String eventoReligioso[] = new String[1000];
    
    public int posicionRelioso[] = new int[1000];
    public int posicionArreglo;
        
    
    public Religioso(String codigoUnico, String tituloEvento, String descripcionEvento,
            Calendar fechaEvento, double montoRenta, int MaximoGente, boolean futuro, boolean cancelado) {
        
        super(codigoUnico, tituloEvento, descripcionEvento, fechaEvento, montoRenta + 2000, MaximoGente, futuro, cancelado);
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
