
package buses;

import java.util.LinkedList;

public class Bus {
private String plaza;
private LinkedList<Personas> pasajeros;
private LinkedList<Integer> Dinero;
private String Identificador;
private int Mayor_Deuda;
private int cambio_un_bs;
private int maximo_vuelto;
private int timefirst;
private int timeend;

    public Bus(String plaza, String Identificador) {
        this.plaza = plaza;
        this.Identificador = Identificador;
        this.pasajeros = new LinkedList();
        this.Dinero = new LinkedList();
        this.cambio_un_bs = 0;
    }

    public Bus() {
        this.plaza = "";
        this.Identificador = "";
        this.pasajeros = new LinkedList();
        this.Dinero = new LinkedList();
        this.Mayor_Deuda = 0;
        this.cambio_un_bs = 0;
        this.maximo_vuelto = 0;
        this.timefirst = 0;
        this.timeend = 0;
    }

    public int getTimefirst() {
        return timefirst;
    }

    public int getTimeend() {
        return timeend;
    }

    public void setTimefirst(int timefirst) {
        this.timefirst = timefirst;
    }

    public void setTimeend(int timeend) {
        this.timeend = timeend;
    }

    public void setMaximo_vuelto(int maximo_vuelto) {
        this.maximo_vuelto = maximo_vuelto;
    }

    public int getMaximo_vuelto() {
        return maximo_vuelto;
    }

    public void setCambio_un_bs(int cambio_un_bs) {
        this.cambio_un_bs = cambio_un_bs;
    }

    public int getCambio_un_bs() {
        return cambio_un_bs;
    }

    public void setMayor_Deuda(int Mayor_Deuda) {
        this.Mayor_Deuda = Mayor_Deuda;
    }

    public int getMayor_Deuda() {
        return Mayor_Deuda;
    }

    public String getPlaza() {
        return plaza;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public LinkedList<Personas> getPasajeros() {
        return pasajeros;
    }

    public LinkedList<Integer> getDinero() {
        return Dinero;
    }
    
    

    public void addPasajeros(Personas p) {
        this.pasajeros.push(p);
    }
    
    
    
}
