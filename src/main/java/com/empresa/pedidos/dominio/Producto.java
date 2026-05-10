package com.empresa.pedidos.dominio;

public class Producto {
    private Long id;
    private double precio;

    public Producto(Long id, double precio) {
        this.id = id;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }
}
