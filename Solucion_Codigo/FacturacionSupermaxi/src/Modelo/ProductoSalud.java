package Modelo;
import java.util.ArrayList;

public class ProductoSalud extends Producto {
    public ArrayList<ProductoSalud> productosSalud;

    public ProductoSalud() {
        productosSalud = new ArrayList<>();
    }

    public ProductoSalud(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                         int mesCaducaInt, int anioCaducaInt, double precioNormal, String categoria, int stock) {
        super(codigo, nombre, diaCaduca, mesCaduca, anioCaduca, mesCaducaInt, anioCaducaInt, precioNormal, categoria, stock);
        productosSalud = new ArrayList<>();
    }

    @Override
    public boolean esPrecioPromo() { return false; }
    @Override
    public boolean estaProximaCaducidad() { return false; }
    @Override
    public double obtenerPrecioAplicado() { return precioNormal; }
}
