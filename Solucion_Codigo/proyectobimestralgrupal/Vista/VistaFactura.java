package proyectobimestralgrupal.Vista;

import java.util.Scanner;

public class VistaFactura {
    Scanner entrada = new Scanner(System.in);

    public void menu() {
        System.out.println("1. Crear producto");
        System.out.println("2. Ingresar cliente");
        System.out.println("3. Seleccionar producto");
    }

    public DatosCliente pedirDatosCliente() {
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Cédula: ");
        String cedula = entrada.nextLine();
        System.out.print("Dirección: ");
        String direccion = entrada.nextLine();
        System.out.print("Teléfono: ");
        String telefono = entrada.nextLine();
        return new DatosCliente(nombre, cedula, direccion, telefono);
    }

    public Producto pedirDatosProducto() {
        System.out.print("Código: ");
        int codigo = entrada.nextInt(); entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Día/Mes/Año de caducidad: ");
        int dia = entrada.nextInt();
        int mes = entrada.nextInt();
        int anio = entrada.nextInt();
        System.out.print("Precio: ");
        double precio = entrada.nextDouble(); entrada.nextLine();
        System.out.print("Categoría: ");
        String cat = entrada.nextLine();
        System.out.print("Stock: ");
        int stock = entrada.nextInt(); entrada.nextLine();

        return new ProductoVivienda(codigo, nombre, dia, mes, anio, precio, cat, stock); // Ejemplo
    }

    public void mostrarFactura(Factura factura) {
        System.out.println(factura);
    }
}