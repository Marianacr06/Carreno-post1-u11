package com.empresa.pedidos.repositorio;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.Producto;

public interface PedidoRepository {
    Producto findProductoById(Long id);

    Pedido save(Pedido pedido);
}
