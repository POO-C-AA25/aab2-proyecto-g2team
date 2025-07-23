package Modelo;
// Producto de categoria Alimentacion, con su logica de promocion particular

public class ProductoAlimentacion extends Producto {

    public ProductoAlimentacion(int codigo, String nombre, int dia, int mes, int anio, double precioNormal, int stock) {
        super(codigo, nombre, dia, mes, anio, precioNormal, stock, "ALIMENTACION");
    }

    // True si caduca en 20 dias o stock mayor a 50
    @Override
    public boolean esPrecioPromo() {
        return estaProximaCaducidad() || stock > 50;
    }

    // True si caduca en menos de 20 dias (desde una fecha fija)
    @Override
    public boolean estaProximaCaducidad() {
        int hoyDia = 23, hoyMes = 7, hoyAnio = 2025;
        return (anioCaduca == hoyAnio && mesCaduca == hoyMes && (diaCaduca - hoyDia) <= 20 && (diaCaduca - hoyDia) >= 0);
    }

    // Aplica 15% de descuento si es promocion, sino precio normal
    @Override
    public double obtenerPrecioAplicado() {
        return esPrecioPromo() ? precioNormal * 0.85 : precioNormal;
    }
}
