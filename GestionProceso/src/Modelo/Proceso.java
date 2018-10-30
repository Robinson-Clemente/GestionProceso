
package Modelo;

import java.io.Serializable;


public class Proceso implements Serializable {
    
    private String nombre;
    private int llegada;
    private int proceso;   
    private int prioridad;
    
    
    
    public Proceso(){
    
    }
    
    public Proceso (String nombre, int llegada, int proceso, int prioridad){
    
        this.nombre = nombre;
        this.llegada = llegada;
        this.proceso = proceso;
        this.prioridad = prioridad;
    
    
    
    }
    
    
    public void setNombre(String nombre){    
        this.nombre = nombre;    
    }
    
    public String getNombre(){    
    return nombre;        
    }

    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    public int getProceso() {
        return proceso;
    }

    public void setProceso(int proceso) {
        this.proceso = proceso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
    
    
}
