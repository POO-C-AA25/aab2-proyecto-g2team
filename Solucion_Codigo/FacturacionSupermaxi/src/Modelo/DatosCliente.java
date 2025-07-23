package Modelo;
public class DatosCliente {
    public String nombre;
    public String cedula;
    public String direccion;
    public String telefono;

    public DatosCliente() {}

    public DatosCliente(String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " | " + cedula + " | " + direccion + " | " + telefono;
    }
}

