/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobimestralgrupal.Modelo;

import java.util.ArrayList;

public class ProductoSalud extends Producto {
    public static ArrayList<ProductoSalud> productosSalud = new ArrayList<>();

    public ProductoSalud() {}

    public ProductoSalud(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                         double precioNormal, String categoria, int stock) {
        super(codigo, nombre, diaCaduca, mesCaduca, anioCaduca, precioNormal, categoria, stock);
    }

    @Override
    public boolean estaEnPromocion() {
        // Ejemplo de regla: promoción si stock > 10 o caduca este año
        return stock > 10 || anioCaduca <= java.time.LocalDate.now().getYear();
    }

    @Override
    public double obtenerPrecioLiquidado() {
        return estaEnPromocion() ? precioNormal * 0.9 : precioNormal;
    }
}