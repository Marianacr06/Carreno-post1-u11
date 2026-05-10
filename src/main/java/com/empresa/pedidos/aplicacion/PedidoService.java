package com.empresa.pedidos.aplicacion;

import com.empresa.pedidos.dominio.CodigoDescuento;
import com.empresa.pedidos.dominio.DatosCliente;
import com.empresa.pedidos.dominio.LineaPedido;
import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.repositorio.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final PedidoRepository repo;
    private final NotificacionService notificacion;

    public PedidoService(PedidoRepository repo, NotificacionService notificacion) {
        this.repo = repo;
        this.notificacion = notificacion;
    }

    public String procesarPedido(DatosCliente cliente, LineaPedido[] lineas, String metodoPago,
                                 boolean esUrgente, CodigoDescuento descuento) {
        double total = calcularTotal(lineas);
        double totalConDescuento = aplicarDescuento(total, descuento);
        notificacion.notificarPedido(cliente, esUrgente);
        return persistirPedido(cliente, totalConDescuento);
    }

    private double calcularTotal(LineaPedido[] lineas) {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.getPrecioUnitario() * linea.getCantidad();
        }
        return total;
    }

    private double aplicarDescuento(double total, CodigoDescuento descuento) {
        if (descuento == null) {
            return total;
        }
        return total * (1 - descuento.getPorcentaje());
    }

    private String persistirPedido(DatosCliente cliente, double totalConDescuento) {
        Pedido pedido = new Pedido(1L, cliente.getNombre(), totalConDescuento);
        Pedido guardado = repo.save(pedido);
        return "OK_" + guardado.getId();
    }
}
