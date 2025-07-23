package Modelo;
import java.util.ArrayList;

public abstract class Producto {
    public int codigo;
    public String nombre;
    public int diaCaduca, mesCaduca, anioCaduca;
    public int mesCaducaInt, anioCaducaInt;
    public double precioNormal;
    public String categoria;
    public int stock;
    public ArrayList<Producto> listaProductos;

    public Producto() {}

    public Producto(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                    int mesCaducaInt, int anioCaducaInt, double precioNormal, String categoria, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.diaCaduca = diaCaduca;
        this.mesCaduca = mesCaduca;
        this.anioCaduca = anioCaduca;
        this.mesCaducaInt = mesCaducaInt;
        this.anioCaducaInt = anioCaducaInt;
        this.precioNormal = precioNormal;
        this.categoria = categoria;
        this.stock = stock;
        this.listaProductos = new ArrayList<>();
    }

    public abstract boolean esPrecioPromo();
    public abstract boolean estaProximaCaducidad();
    public abstract double obtenerPrecioAplicado();

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - $" + precioNormal + " - Stock: " + stock;
    }
}

