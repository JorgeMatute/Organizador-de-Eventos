package eventos;

import java.util.Calendar;

public abstract class Eventos {
    
    public String codigoUnico;
    public String tituloEvento;
    public String descripcionEvento;
    public Calendar fechaEvento;
    public double montoRenta;
    public boolean futuro;
    public boolean cancelado;
    
    public int maximoGente;
    
    
    public Eventos(String codigoUnico, String tituloEvento, String descripcionEvento, Calendar fechaEvento, double montoRenta, int MaximoGente, boolean futuro, boolean cancelado){
        this.codigoUnico = codigoUnico;
        this.tituloEvento = tituloEvento;
        this.descripcionEvento = descripcionEvento;
        this.fechaEvento = fechaEvento;
        this.montoRenta = montoRenta;
        this.maximoGente = maximoGente;
        this.futuro = futuro;
        this.cancelado = cancelado;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public Calendar getFechaEvento() {
        return fechaEvento;
    }

    public double getMontoRenta() {
        return montoRenta;
    }

    public int getMaximoGente() {
        return maximoGente;
    }
    
    
    //Aplicamos la función final para que ésta no pueda ser modificada porque no tiene razón para serlo.
    public final String canceladoONo(){
        if (cancelado==false) {
            return "No ha sido cancelado.";
        }else{
            return "Ha sido cancelado";
        }
    }
    
    @Override
    public abstract String toString(); 
    
    
    public abstract String toString2();

    
    public abstract String toString3();

    
    public abstract String toString4();
      
    
    
    
    
}
