package Modelo;
// Clase abstracta para definir la estructura comun de cualquier producto
public abstract class Producto {
    public int codigo;
    public String nombre;
    public int diaCaduca, mesCaduca, anioCaduca;
    public double precioNormal;
    public int stock;
    public String categoria;

    // Constructor: inicializa todos los campos de un producto
    public Producto(int codigo, String nombre, int dia, int mes, int anio, double precioNormal, int stock, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.diaCaduca = dia;
        this.mesCaduca = mes;
        this.anioCaduca = anio;
        this.precioNormal = precioNormal;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Metodo abstracto: debe ser implementado por cada subclase para saber si aplica promocion
    public abstract boolean esPrecioPromo();

    // Metodo abstracto: debe ser implementado para saber si el producto esta proximo a caducar
    public abstract boolean estaProximaCaducidad();

    // Metodo abstracto: calcula el precio final a cobrar por el producto
    public abstract double obtenerPrecioAplicado();

    // Devuelve la fecha de caducidad como texto
    public String getFechaCaducidad() {
        return diaCaduca + "/" + mesCaduca + "/" + anioCaduca;
    }

    // Devuelve la representacion completa del producto como texto
    @Override
    public String toString() {
        return codigo + ". " + nombre + " | $" + precioNormal + " | Stock: " + stock +
                " | Vence: " + getFechaCaducidad() + " | " + categoria +
                (esPrecioPromo() ? " [PROMO]" : "");
    }
}


