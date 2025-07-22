/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobimestralgrupal.Modelo;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ProductoVivienda extends Producto {
    public static ArrayList<ProductoVivienda> productosVivienda = new ArrayList<>();

    public ProductoVivienda() {}

    public ProductoVivienda(int codigo, String nombre, int diaCaduca, int mesCaduca, int anioCaduca,
                            double precioNormal, String categoria, int stock) {
        super(codigo, nombre, diaCaduca, mesCaduca, anioCaduca, precioNormal, categoria, stock);
    }

    public boolean estaEnPromocion() {
        return stock > 30 || anioCaduca <= 2025;
    }

    public double obtenerPrecioLiquidado() {
        return estaEnPromocion() ? precioNormal * 0.8 : precioNormal;
    }
}