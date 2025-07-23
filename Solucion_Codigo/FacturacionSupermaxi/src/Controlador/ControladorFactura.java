// Controlador/ControladorFactura.java
package Controlador;

import java.util.ArrayList;
import Modelo.*;
import Vista.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Clase que coordina la logica del sistema (menu, operaciones)
public class ControladorFactura {

    public ArrayList<Factura> listaFacturas = new ArrayList<>();
    public VistaFactura vista = new VistaFactura();
    public Inventario inventario = new Inventario();
    public CarritoDeCompras carrito = new CarritoDeCompras();
    public DatosCliente cliente = null;

    // Controla el ciclo principal del menu
    public void ejecutarMenu() {
        inventario.cargarProductos();
        boolean salir = false;
        while (!salir) {
            int op = vista.mostrarMenuPrincipal();
            switch (op) {
                case 1:
                    menuFactura();
                    break;
                case 2:
                    menuProductos();
                    break;
                case 3:
                    vista.mostrarFacturas(listaFacturas);
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }
    }

    // Menu para el proceso de facturacion
    public void menuFactura() {
        int op;
        do {
            op = vista.mostrarMenuFactura();
            switch (op) {
                case 1:
                    cliente = pedirDatosCliente();
                    break;
                case 2:
                    agregarProductoACarrito();
                    break;
                case 3:
                    if (cliente == null) {
                        vista.mostrarMensaje("Primero ingrese los datos del cliente.");
                    } else if (carrito.productosCarrito.isEmpty()) {
                        vista.mostrarMensaje("El carrito esta vacio.");
                    } else {
                        // 1) Creo la factura
                        Factura nueva = new Factura(cliente, carrito.getProductosCarrito());
                        // 2) Llamada externa a calcularTotales() para reiniciar y sumar
                        nueva.calcularTotales();
                        // 3) Agrego y muestro
                        listaFacturas.add(nueva);
                        vista.mostrarMensaje("Factura generada correctamente:");
                        vista.mostrarMensaje(nueva.toString());
                        // 4) Limpio el carrito
                        carrito.limpiarCarrito();
                    }
                    break;
            }
        } while (op != 0);
    }

    // Menu para gestion de productos
    public void menuProductos() {
        int op;
        do {
            op = vista.mostrarMenuProducto();
            switch (op) {
                case 1:
                    Producto nuevo = pedirProductoNuevo();
                    if (nuevo != null) {
                        inventario.agregarProducto(nuevo);
                    }
                    break;
                case 2:
                    eliminarProductoDeLista();
                    break;
                case 3:
                    vista.mostrarListaProductos(inventario.getListaProductos());
                    break;
            }
        } while (op != 0);
    }

    // Solicita los datos del cliente por consola
    public DatosCliente pedirDatosCliente() {
        String nombre = vista.pedirTexto("Ingrese nombre del cliente:");
        String cedula = vista.pedirTexto("Ingrese cedula del cliente:");
        String direccion = vista.pedirTexto("Ingrese direccion del cliente:");
        String telefono = vista.pedirTexto("Ingrese telefono del cliente:");
        return new DatosCliente(nombre, cedula, direccion, telefono);
    }

    // Solicita y construye un nuevo producto
    public Producto pedirProductoNuevo() {
        String nombre = vista.pedirTexto("Ingrese el nombre del producto:");
        int dia = vista.pedirEntero("Ingrese dia de caducidad:");
        int mes = vista.pedirEntero("Ingrese mes de caducidad:");
        int anio = vista.pedirEntero("Ingrese anio de caducidad:");
        double precioNormal = vista.pedirDouble("Ingrese el precio normal:");
        int stock = vista.pedirEntero("Ingrese el stock:");
        String categoria = vista.pedirTexto(
                "Ingrese la categoria (VIVIENDA, SALUD, EDUCACION, ALIMENTACION, VESTIMENTA):"
        ).toUpperCase();

        int codigo = inventario.getListaProductos().isEmpty()
                ? 1
                : inventario.getListaProductos().get(
                        inventario.getListaProductos().size() - 1
                ).codigo + 1;

        switch (categoria) {
            case "VIVIENDA":
                return new ProductoVivienda(codigo, nombre, dia, mes, anio, precioNormal, stock);
            case "SALUD":
                return new ProductoSalud(codigo, nombre, dia, mes, anio, precioNormal, stock);
            case "EDUCACION":
                return new ProductoEducacion(codigo, nombre, dia, mes, anio, precioNormal, stock);
            case "ALIMENTACION":
                return new ProductoAlimentacion(codigo, nombre, dia, mes, anio, precioNormal, stock);
            case "VESTIMENTA":
                return new ProductoVestimenta(codigo, nombre, dia, mes, anio, precioNormal, stock);
            default:
                vista.mostrarMensaje("Categoria invalida.");
                return null;
        }
    }

    // Permite agregar un producto al carrito de compras
    public void agregarProductoACarrito() {
        vista.mostrarListaProductos(inventario.getListaProductos());
        int codigo = vista.pedirEntero(
                "Ingrese el codigo del producto que desea agregar al carrito:"
        );
        Producto producto = inventario.buscarProductoPorCodigo(codigo);
        if (producto == null) {
            vista.mostrarMensaje("Producto no encontrado.");
        } else {
            int cantidad = vista.pedirEntero("Ingrese la cantidad que desea agregar:");
            if (cantidad > producto.stock) {
                vista.mostrarMensaje("No hay suficiente stock disponible.");
            } else {
                carrito.agregarProducto(producto, cantidad);
                vista.mostrarMensaje("Producto agregado al carrito correctamente.");
            }
        }
    }

    // Permite eliminar un producto de la lista del inventario
    public void eliminarProductoDeLista() {
        vista.mostrarListaProductos(inventario.getListaProductos());
        int codigo = vista.pedirEntero("Ingrese el codigo del producto a eliminar:");
        inventario.eliminarProductoPorCodigo(codigo);
    }

    // Calcula y muestra las estadisticas de ventas por categoria y total del dia
    public void mostrarEstadisticas() {
        double[] totalPorCat = new double[5];
        double totalDia = 0;
        String[] categorias = {
            "Vivienda", "Educacion", "Alimentacion", "Vestimenta", "Salud"
        };

        // Acumular datos
        for (Factura f : listaFacturas) {
            double[] totales = f.getTotalesPorCategoria();
            for (int i = 0; i < 5; i++) {
                totalPorCat[i] += totales[i];
            }
            totalDia += f.getTotalConIva();
        }

        // Construir el texto del informe
        StringBuilder sb = new StringBuilder();
        sb.append("=== ESTADISTICAS DEL DIA ===\n");
        sb.append(String.format("Total vendido: $%.2f%n", totalDia));
        for (int i = 0; i < 5; i++) {
            sb.append(String.format("%s: $%.2f%n", categorias[i], totalPorCat[i]));
        }
        String reporte = sb.toString();

        // Mostrar por consola
        vista.mostrarMensaje(reporte);

        // Serializar a archivo de texto
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("estadisticas.txt"))) {
            bw.write(reporte);
            vista.mostrarMensaje("Estadisticas guardadas en estadisticas.txt");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al escribir estadisticas: " + e.getMessage());
        }
    }
}
