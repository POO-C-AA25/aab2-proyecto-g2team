package Modelo;
// Producto de categoria Vivienda, con su logica de promocion particular
public class ProductoVivienda extends Producto {
    public ProductoVivienda(int codigo, String nombre, int dia, int mes, int anio, double precioNormal, int stock) {
        super(codigo, nombre, dia, mes, anio, precioNormal, stock, "VIVIENDA");
    }

    // Retorna true si el stock es alto o si esta proximo a caducar (promo)
    @Override
    public boolean esPrecioPromo() {
        return stock > 80 || estaProximaCaducidad();
    }

    // Determina si el producto caduca en menos de 30 dias (desde una fecha fija)
    @Override
    public boolean estaProximaCaducidad() {
        int hoyDia = 4, hoyMes = 6, hoyAnio = 2025;
        return (anioCaduca == hoyAnio && mesCaduca == hoyMes && (diaCaduca - hoyDia) <= 30 && (diaCaduca - hoyDia) >= 0);
    }

    // Aplica 10% de descuento si es promocion, sino devuelve el precio normal
    @Override
    public double obtenerPrecioAplicado() {
        return esPrecioPromo() ? precioNormal * 0.90 : precioNormal;
    }
}


