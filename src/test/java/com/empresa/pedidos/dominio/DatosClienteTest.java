package com.empresa.pedidos.dominio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DatosClienteTest {
    @Test
    void constructor_valida_nombre() {
        Direccion direccion = new Direccion("Calle 1", "Ciudad", "0001");

        assertThrows(IllegalArgumentException.class,
            () -> new DatosCliente("", "correo@ejemplo.com", "123", direccion));
    }

    @Test
    void constructor_valida_email() {
        Direccion direccion = new Direccion("Calle 1", "Ciudad", "0001");

        assertThrows(IllegalArgumentException.class,
            () -> new DatosCliente("Ana", "correo", "123", direccion));
    }
}
