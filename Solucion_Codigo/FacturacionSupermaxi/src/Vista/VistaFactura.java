package Vista;

import Modelo.Factura;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaFactura {
    public Scanner sc = new Scanner(System.in);

    public void Menu() {
        // Menú principal (implementa según tus necesidades)
    }

    public void mostrarFacturaProductos(ArrayList<Factura> facturas) {
        for (Factura f : facturas) {
            System.out.println(f);
        }
    }
}


