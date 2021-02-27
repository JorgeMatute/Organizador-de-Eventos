package eventos;

import java.util.Calendar;

public class Deportivo extends Eventos {
    
    public enum TipoDeporte{
    FUTBOL, TENIS, RUGBY, BASEBALL;
    }
    
    public String nombresEquipos;

    
    
    public String eventoDeportivo[] = new String[1000];
    
    public int posicionDeportivo[] = new int[1000];
    public int posicionArreglo;
    
    
    
    public Deportivo(TipoDeporte deporteEscogido, String nombresEquipos, String codigoUnico, String tituloEvento,
            String descripcionEvento, Calendar fechaEvento, double montoRenta, int MaximoGente, boolean futuro, boolean cancelado) {
        
        super(codigoUnico, tituloEvento, descripcionEvento, fechaEvento, montoRenta, MaximoGente, futuro, cancelado);
        
        this.nombresEquipos = nombresEquipos;
        
    }
    
    
    public String getDetallesEquipos(){
        return nombresEquipos;
    }
    
    

    
    
    
    
    @Override
    public String toString() {
        return "Nombre de los equipos: "+nombresEquipos+"        --         Código: "+codigoUnico+"          --          Título del evento: "+tituloEvento;
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
