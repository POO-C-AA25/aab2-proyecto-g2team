package Modelo;
// Clase que guarda los datos de un cliente
public class DatosCliente {
    public String nombre;
    public String cedula;
    public String direccion;
    public String telefono;

    // Constructor que inicializa los datos del cliente
    public DatosCliente(String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Devuelve los datos del cliente como texto
    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Cedula: " + cedula + " | Direccion: " + direccion + " | Telefono: " + telefono;
    }
}
