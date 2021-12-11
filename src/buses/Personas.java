
package buses;

import java.util.LinkedList;
import java.util.Random;

public class Personas {
    private String Bus; 
    private String Identificador;
    public static LinkedList<Integer> Dinero = new LinkedList();
    public int Vuelto;
    public int tiempoinicial;
    public int tiempofinal;

    public Personas(String Bus, String Identificador) {
        this.Bus = Bus;        
        this.Identificador = Identificador;
        Billetes_aleatorios();
    }
    
    public Personas() {
        this.Bus="";
        this.Identificador="";
        Billetes_aleatorios();
        tiempoinicial = 0;
        tiempofinal = 0;
    }

    public void setTiempoinicial(int tiempoinicial) {
        this.tiempoinicial = tiempoinicial;
    }

    public void setTiempofinal(int tiempofinal) {
        this.tiempofinal = tiempofinal;
    }

    public int getTiempoinicial() {
        return tiempoinicial;
    }

    public int getTiempofinal() {
        return tiempofinal;
    }

    public String getBus() {
        return Bus;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setBus(String Bus) {
        this.Bus = Bus;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public static LinkedList<Integer> DINEROS() {
        return Dinero;
    }

    

    public static void setDinero(LinkedList<Integer> Dinero) {
        Personas.Dinero = Dinero;
    }

    
    
    public void Billetes_aleatorios(){
        Random r = new Random();
        int valorDado = r.nextInt(8) + 1;
        switch (valorDado) {
            case 1 -> {   
                this.Dinero.add(10);
                this.Dinero.add(10);
                this.Dinero.add(5);
                this.Vuelto=0;
            }
            case 2 -> {      
                this.Dinero.add(10);
                this.Dinero.add(10);
                this.Dinero.add(1);
                this.Dinero.add(1);
                this.Dinero.add(1);
                this.Dinero.add(1);
                this.Dinero.add(1);                
                this.Vuelto=0;
            }
            case 3 -> {          
                this.Dinero.add(5);
                this.Dinero.add(5);
                this.Dinero.add(5);
                this.Dinero.add(5);
                this.Dinero.add(5);
                this.Vuelto=0;
            }
            case 4 -> {
                this.Dinero.add(20);
                this.Dinero.add(5);
                this.Vuelto=0;
            }
            case 5 -> {   
                this.Dinero.add(20);
                this.Dinero.add(1);
                this.Dinero.add(1);
                this.Dinero.add(1);
                this.Dinero.add(1);
                this.Dinero.add(1); 
                this.Vuelto=0;
            }
            case 6 -> {                                                                
                this.Dinero.add(20);
                this.Dinero.add(20);
                this.Vuelto=15;
            }
            case 7 -> {       
                this.Dinero.add(10);
                this.Dinero.add(10);
                this.Dinero.add(10);
                this.Vuelto=30;
            }
            case 8 -> {
                this.Dinero.add(50);
                this.Vuelto=25;
            }
            default -> {
            }
        }
    }
    
    public void setVuelto(int Pasaje) {
        this.Vuelto = Vuelto;
    }

    public int getVuelto() {
        return this.Vuelto;
    } 
    
    
    
}

