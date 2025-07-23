package Modelo;
import java.util.ArrayList;

public class ProductoEducacion extends Producto {
    public ArrayList<ProductoEducacion> productosEducacion;

    public ProductoEducacion() {
        productosEducacion = new ArrayList<>();
    }

    public ProductoEducacion(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                             int mesCaducaInt, int anioCaducaInt, double precioNormal, String categoria, int stock) {
        super(codigo, nombre, diaCaduca, mesCaduca, anioCaduca, mesCaducaInt, anioCaducaInt, precioNormal, categoria, stock);
        productosEducacion = new ArrayList<>();
    }

    @Override
    public boolean esPrecioPromo() { return false; }
    @Override
    public boolean estaProximaCaducidad() { return false; }
    @Override
    public double obtenerPrecioAplicado() { return precioNormal; }
}

