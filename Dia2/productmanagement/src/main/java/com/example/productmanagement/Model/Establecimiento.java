package com.example.productmanagement.Model;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {
    private String nombre;  
    private List<Producto> productos;

    public Establecimiento(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addProduct(Producto producto) {
        productos.add(producto);
    }

    public void readItems() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i));
            }
        }
    }

    public boolean updateProduct(int index, Producto newProducto) {
        if (index >= 0 && index < productos.size()) {
            productos.set(index, newProducto);
            return true;
        }
        return false;
    }

    public boolean removeProduct(int index) {
        if (index >= 0 && index < productos.size()) {
            productos.remove(index);
            return true;
        }
        return false;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
