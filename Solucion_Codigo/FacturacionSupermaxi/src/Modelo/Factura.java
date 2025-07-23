package Modelo;
import java.util.ArrayList;

public class Factura {
    public DatosCliente datosCliente;
    public ArrayList<Producto> productosComprados;
    public int IVA;
    public double total;
    public double[] totalesPorCategoria;

    public Factura() {}

    @Override
    public String toString() {
        return "Factura de: " + datosCliente;
    }
}


