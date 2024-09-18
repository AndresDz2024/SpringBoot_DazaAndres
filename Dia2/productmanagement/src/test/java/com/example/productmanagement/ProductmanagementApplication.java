package com.example.productmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.productmanagement.Model.Producto;
import com.example.productmanagement.Model.Establecimiento;

import java.util.Scanner;

@SpringBootApplication
public class ProductmanagementApplication {

    public static void main(String[] args) {
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);

        Establecimiento establecimiento = new Establecimiento("Siu");
        Producto productito = new Producto("Jijiji", "S", "ropa");
        establecimiento.addProduct(productito);

        while (menu) {

            System.out.println("--- Bienvenido a establecimiento: " + establecimiento.getNombre() + " ---\n" +
                    "1. Ver items disponibles\n" +
                    "2. Agregar items\n" +
                    "3. Modificar items\n" +
                    "4. Eliminar items\n" +
                    "5. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1 -> {
                    System.out.println("--- Ver productos ---\n");
                    establecimiento.readItems();
                }

                case 2 -> {
                    System.out.println("--- Agregar items ---\n");
                    System.out.println("Ingrese los datos para el item a continuación.");
                    Producto p = new Producto();
                    System.out.println("Nombre:");
                    String name = scanner.nextLine();
                    p.setNombre(name);
                    System.out.println("Talla:");
                    String size = scanner.nextLine();
                    p.setTalla(size);
                    System.out.println("Tipo:");
                    String type = scanner.nextLine();
                    p.setTipo(type);
                    establecimiento.addProduct(p);
                }

                case 3 -> {
                    System.out.println("--- Modificar items ---\n");
                    establecimiento.readItems();
                    System.out.println("Ingrese el número del item a modificar:");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline left-over
                    if (index >= 0 && index < establecimiento.getProductos().size()) {
                        Producto p = new Producto();
                        System.out.println("Nombre nuevo:");
                        String name = scanner.nextLine();
                        p.setNombre(name);
                        System.out.println("Talla nueva:");
                        String size = scanner.nextLine();
                        p.setTalla(size);
                        System.out.println("Tipo nuevo:");
                        String type = scanner.nextLine();
                        p.setTipo(type);
                        if (establecimiento.updateProduct(index, p)) {
                            System.out.println("Item modificado exitosamente.");
                        } else {
                            System.out.println("No se pudo modificar el item.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }

                case 4 -> {
                    System.out.println("--- Eliminar items ---\n");
                    establecimiento.readItems();
                    System.out.println("Ingrese el número del item a eliminar:");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline left-over
                    if (establecimiento.removeProduct(index)) {
                        System.out.println("Item eliminado exitosamente.");
                    } else {
                        System.out.println("No se pudo eliminar el item.");
                    }
                }

                case 5 -> {
                    System.out.println("--- Cerrando sesión ---\n");
                    menu = false;
                }

                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
