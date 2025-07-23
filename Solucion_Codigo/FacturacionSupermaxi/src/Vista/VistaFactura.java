package Vista;

import Modelo.*;
import java.util.Scanner;
import java.util.ArrayList;

// Clase que interactua con los usuarios
public class VistaFactura {

    public Scanner entrada = new Scanner(System.in);

    // Muestra el menu principal y devuelve la opcion elegida
    public int mostrarMenuPrincipal() {
        System.out.println("---------------------------");
        System.out.println("|        SUPERMAXI        |");
        System.out.println("---------------------------");
        System.out.println("[1] CREAR FACTURA");
        System.out.println("[2] AGREGAR/GESTIONAR PRODUCTOS");
        System.out.println("[3] MOSTRAR FACTURAS");
        System.out.println("[4] MOSTRAR ESTADISTICAS");
        System.out.println("[0] Salir");
        System.out.print("Seleccione una opcion: ");
        int opcion = entrada.nextInt();
        entrada.nextLine(); // Limpiar salto de linea pendiente
        return opcion;
    }

    // Menu para facturacion
    public int mostrarMenuFactura() {
        System.out.println("[1] DATOS CLIENTE");
        System.out.println("[2] COMPRAR PRODUCTOS");
        System.out.println("[3] GENERAR FACTURA");
        System.out.println("[0] Volver");
        System.out.print("Seleccione una opcion: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        return opcion;
    }

    // Menu para productos
    public int mostrarMenuProducto() {
        System.out.println("[1] AGREGAR PRODUCTOS NUEVOS A STOCK");
        System.out.println("[2] ELIMINAR PRODUCTOS");
        System.out.println("[3] MOSTRAR PRODUCTOS");
        System.out.println("[0] Volver");
        System.out.print("Seleccione una opcion: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        return opcion;
    }

    // Muestra la lista de productos en consola
    public void mostrarListaProductos(ArrayList<Producto> listaProductos) {
        System.out.println("---------- Lista de productos ----------");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }

    // Muestra la lista de facturas en consola
    public void mostrarFacturas(ArrayList<Factura> listaFacturas) {
        if (listaFacturas.isEmpty()) {
            System.out.println("No existen facturas generadas en este momento.");
        } else {
            System.out.println("------- FACTURAS DEL DIA --------");
            for (Factura f : listaFacturas) {
                System.out.println(f);
            }
        }
    }

    // Muestra cualquier mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Solicita texto al usuario (responde en la misma linea)
    public String pedirTexto(String mensaje) {
        System.out.print(mensaje + " ");
        return entrada.nextLine();
    }

    // Solicita un entero al usuario
    public int pedirEntero(String mensaje) {
        System.out.print(mensaje + " ");
        int valor = entrada.nextInt();
        entrada.nextLine(); // limpiar salto de linea
        return valor;
    }

    // Solicita un numero decimal al usuario
    public double pedirDouble(String mensaje) {
        System.out.print(mensaje + " ");
        double valor = entrada.nextDouble();
        entrada.nextLine();
        return valor;
    }
}
