# Patrones de Diseno de Software - U11 Post 1

## Objetivo
Eliminar code smells tipo Bloater (Long Method, Large Class, Primitive Obsession) aplicando Extract Method, Extract Class y Value Objects. Verificar la reduccion de complejidad con SonarQube.

## Estructura
- src/
- img/ (capturas)

## Tecnicas aplicadas
- Value Object: `DatosCliente` y `Direccion` para eliminar Data Clumps.
- Extract Method: `calcularTotal`, `aplicarDescuento`, `persistirPedido`.
- Extract Class: `NotificacionService` separado de `PedidoService`.
- Inyeccion por constructor.

## Ejecucion
```bash
mvn clean verify
mvn verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.token=TU_TOKEN -Dsonar.projectKey=refactoring-u11
```

## Tabla comparativa (completar)
| Metrica | Antes | Despues |
| --- | --- | --- |
| CC procesarPedido | | |
| Code Smells | | |
| TDR | | |

## Evidencias
- img/sonarqube-antes.png
- img/sonarqube-despues.png

## Notas
El metodo `procesarPedido()` queda con pocas lineas y delega a metodos con CC baja.
