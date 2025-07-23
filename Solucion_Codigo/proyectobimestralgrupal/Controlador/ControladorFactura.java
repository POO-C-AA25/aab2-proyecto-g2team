package proyectobimestralgrupal.Controlador;

import proyectobimestralgrupal.Modelo.*;
import proyectobimestralgrupal.Vista.VistaFactura;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ControladorFactura {
    
    
    public ArrayList<Factura> listaFacturas = new ArrayList<>();
    public VistaFactura vista = new VistaFactura();

    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public Producto obtenerProducto() {
        return vista.pedirDatosProducto();
    }

    public DatosCliente obtenerCliente() {
        return vista.pedirDatosCliente();
    }

    public ArrayList<Producto> obtenerProductosCarrito() {
        return new CarritoDeCompras().productosCarrito;
    }

    public void eliminarProductosRepetidos() {
        // Implementación básica de limpieza si es necesario
    }
}