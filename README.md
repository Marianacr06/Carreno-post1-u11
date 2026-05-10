# Patrones de Diseno de Software - U11 Post 1

# Patrones de Diseño de Software - U11 Post 1
**Refactorización Avanzada y Clean Code Profundo**  


---

## Objetivo

Identificar y eliminar code smells tipo **Bloater** (Long Method, Large Class, Primitive Obsession) en un servicio Spring Boot, aplicando las técnicas Extract Method, Extract Class e introducción de Value Objects. Se verifica la mejora con SonarCloud.

---

## Code Smells Identificados

### 1. Long Method
El método `procesarPedido()` original tenía más de 40 líneas y realizaba múltiples responsabilidades: validar cliente, calcular total, aplicar descuento, notificar y persistir, todo en un solo método.

### 2. Large Class
`PedidoService` concentraba lógica de validación, cálculo, notificación y persistencia, violando el Principio de Responsabilidad Única (SRP).

### 3. Primitive Obsession / Data Clump
El método recibía 12 parámetros primitivos en lugar de objetos con significado de dominio.

### 4. Field Injection
Uso de `@Autowired` en campo en lugar de inyección por constructor.

---

## Técnicas Aplicadas

### Value Object — `DatosCliente` y `Direccion`
Se agruparon los parámetros de cliente en un Value Object inmutable con validaciones en el constructor.

### Extract Method
Se dividió `procesarPedido()` en métodos con responsabilidad única:
- `calcularTotal()`
- `aplicarDescuento()`
- `persistirPedido()`

### Extract Class — `NotificacionService`
La lógica de notificación se extrajo a una clase independiente inyectada por constructor.

### Inyección por Constructor
Se eliminó `@Autowired` en campo mejorando la testabilidad.

---

## Tabla Comparativa de Métricas SonarCloud

| Métrica | ANTES | DESPUÉS | Mejora |
|---|---|---|---|
| Reliability (issues) | 1 | 0 | ✅ -100% |
| Maintainability (issues) | 7 | 3 | ✅ -57% |
| Security (issues) | 0 | 0 | ✅ Sin cambio |

---

## Evidencias SonarCloud

### Dashboard ANTES
![Dashboard Antes](img/sonarcloud-antes.png)

### Dashboard DESPUÉS
![Dashboard Después](img/sonarcloud-despues.png)

---