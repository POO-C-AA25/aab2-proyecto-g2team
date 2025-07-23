package Modelo;
import java.util.ArrayList;

public class ProductoVestimenta extends Producto {
    public ArrayList<ProductoVestimenta> productosVestimenta;

    public ProductoVestimenta() {
        productosVestimenta = new ArrayList<>();
    }

    public ProductoVestimenta(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                              int mesCaducaInt, int anioCaducaInt, double precioNormal, String categoria, int stock) {
        super(codigo, nombre, diaCaduca, mesCaduca, anioCaduca, mesCaducaInt, anioCaducaInt, precioNormal, categoria, stock);
        productosVestimenta = new ArrayList<>();
    }

    @Override
    public boolean esPrecioPromo() { return false; }
    @Override
    public boolean estaProximaCaducidad() { return false; }
    @Override
    public double obtenerPrecioAplicado() { return precioNormal; }
}


