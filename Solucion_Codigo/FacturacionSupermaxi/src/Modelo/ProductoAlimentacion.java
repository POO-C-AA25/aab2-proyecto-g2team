package Modelo;
import java.util.ArrayList;

public class ProductoAlimentacion extends Producto {
    public ArrayList<ProductoAlimentacion> productosAlimentacion;

    public ProductoAlimentacion() {
        productosAlimentacion = new ArrayList<>();
    }

    public ProductoAlimentacion(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                                int mesCaducaInt, int anioCaducaInt, double precioNormal, String categoria, int stock) {
        super(codigo, nombre, diaCaduca, mesCaduca, anioCaduca, mesCaducaInt, anioCaducaInt, precioNormal, categoria, stock);
        productosAlimentacion = new ArrayList<>();
    }

    @Override
    public boolean esPrecioPromo() { return false; }
    @Override
    public boolean estaProximaCaducidad() { return false; }
    @Override
    public double obtenerPrecioAplicado() { return precioNormal; }
}


