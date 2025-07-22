package proyectobimestralgrupal.Modelo;

public abstract class Producto {
    public int codigo;
    public String nombre;
    public int diaCaduca;
    public int mesCaduca;
    public int anioCaduca;
    public double precioNormal;
    public String categoria;
    public int stock;

    public Producto() {}

    public Producto(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                    double precioNormal, String categoria, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.diaCaduca = diaCaduca;
        this.mesCaduca = mesCaduca;
        this.anioCaduca = anioCaduca;
        this.precioNormal = precioNormal;
        this.categoria = categoria;
        this.stock = stock;
    }

    public abstract boolean estaEnPromocion();

    public abstract double obtenerPrecioLiquidado();

    public String toString() {
        return codigo + " - " + nombre + " - $" + precioNormal;
    }
}