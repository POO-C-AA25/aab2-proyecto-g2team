package proyectobimestralgrupal.Modelo;

import java.util.ArrayList;

public class Factura {
    public DatosCliente datosCliente;
    public ArrayList<Producto> productosComprados;
    public double IVA;
    public double total;
    public double[] totalesPorCategoria;

    public Factura() {
        productosComprados = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cliente: " + datosCliente + ", Total: $" + total;
    }
}