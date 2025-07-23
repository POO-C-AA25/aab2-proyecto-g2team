package Controlador;

import Modelo.*;
import Vista.VistaFactura;
import java.util.ArrayList;

public class ControladorFactura {
    public ArrayList<Factura> listaFacturas = new ArrayList<>();
    public VistaFactura vista = new VistaFactura();
    public Inventario inventario = new Inventario();
    public CarritoDeCompras carrito = new CarritoDeCompras();

    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public void agregarProductoACarrito(int codigo, int cantidad) {
        Producto producto = inventario.buscarProductoPorCodigo(codigo);
        if (producto != null && producto.stock >= cantidad) {
            carrito.agregarProducto(producto, cantidad);
            producto.stock -= cantidad;
        }
    }

    public void eliminarProductoDeLaLista(int codigo) {
        carrito.eliminarProducto(codigo);
    }

    public void mostrarFacturas() {
        vista.mostrarFacturaProductos(listaFacturas);
    }

    public void generarFactura(DatosCliente cliente) {
        Factura factura = new Factura();
        factura.datosCliente = cliente;
        factura.productosComprados = new ArrayList<>(carrito.productosCarrito);
        factura.IVA = 15; // Ejemplo, podrías calcularlo según el subtotal
        factura.total = carrito.calcularTotal();
        factura.totalesPorCategoria = carrito.calcularTotalesPorCategoria();
        agregarFactura(factura);
        carrito.limpiarCarrito();
    }
}
