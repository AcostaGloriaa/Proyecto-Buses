
package buses;

public class Dinero {
    public int Cantidad;

    public Dinero(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    public Dinero() {
        this.Cantidad = 0;
    }
    
    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int tipo) {
        this.Cantidad = tipo;
    }    
}
