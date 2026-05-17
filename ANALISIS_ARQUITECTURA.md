# ANÁLISIS DE ARQUITECTURA - PIZZATRACK

## 🏗️ Arquitectura del Sistema

### Capas de la Aplicación

```
┌─────────────────────────────────┐
│   CAPA DE PRESENTACIÓN          │
│   (Main.java)                   │
│   - Interfaz de usuario         │
│   - Punto de entrada            │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   CAPA DE LÓGICA DE NEGOCIO    │
│   (GestionPedidos.java)         │
│   - Gestión de pedidos          │
│   - Control de estado           │
│   - Operaciones UNDO/REDO       │
└──────────────┬──────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│   CAPA DE ESTRUCTURA DE DATOS  │
│   (PilaManual.java)             │
│   - Implementación de Pila      │
│   - Operaciones push/pop        │
│   - Gestión de nodos            │
└──────────────┬──────────────────┘
               │
      ┌────────┴─────────┐
      ▼                  ▼
┌──────────────┐    ┌──────────────┐
│ CAPA DE DATOS│    │ CAPA DE DATOS│
│ (Pizza.java) │    │ (Nodo.java)  │
│ - Atributos  │    │ - Nodo       │
│ - Validación │    │ - Referencias│
└──────────────┘    └──────────────┘
```

---

## 📊 Diagrama de Relaciones (UML)

```
┌──────────────────────────────┐
│        Main                  │
├──────────────────────────────┤
│ - main(String[] args): void  │
└────────────────┬─────────────┘
                 │ usa
                 ▼
┌──────────────────────────────┐
│    GestionPedidos            │
├──────────────────────────────┤
│ - pedidosActivos: PilaManual │
│ - pedidosCompletados: Pila   │
├──────────────────────────────┤
│ + agregarpedido(pizza)       │
│ + deshacerPedido()           │
│ + rehacerPedido()            │
│ + mostrarPedidosActivos()    │
│ + mostrarPedidosCompletados()│
│ + vaciarPedidos()            │
│ + hayPedidosActivos()        │
│ + hayPedidosParaRehacer()    │
└─┬──────────────────────────┬─┘
  │ contiene 2x              │
  ▼                          ▼
┌──────────────────────┐  (mismo tipo)
│   PilaManual<T>      │
├──────────────────────┤
│ - cima: Nodo         │
│ - tamaño: int        │
├──────────────────────┤
│ + push(pizza)        │
│ + pop(): pizza       │
│ + peek(): pizza      │
│ + isEmpty(): boolean │
│ + size(): int        │
│ + mostrartodos()     │
└────────────┬─────────┘
             │ usa
             ▼
       ┌──────────────┐
       │    Nodo      │
       ├──────────────┤
       │ - pizza      │◄──┐
       │ - siguiente  │   │
       └──────────────┘   │
                          │ referencias
                          │
       ┌──────────────┐   │
       │    Pizza     │───┘
       ├──────────────┤
       │ - nombre     │
       │ - precio     │
       │ - ingredientes
       ├──────────────┤
       │ + getNombre()│
       │ + getPrecio()│
       │ + getIngredientes()
       │ + toString() │
       └──────────────┘
```

---

## 🔄 Flujo de Datos

### Operación: Agregar Pedido

```
Usuario
  │
  ├─ Crea Pizza
  │  └─ String[] ingredientes = {...}
  │     pizza p = new pizza("Nombre", 10.99, ingredientes)
  │
  ├─ Llama agregarpedido(p)
  │  └─ pedidosActivos.push(p)
  │     └─ new Nodo(p)
  │        │
  │        └─ nuevoNodo.siguiente = cima (anterior)
  │        └─ cima = nuevoNodo (nuevo es cima)
  │        └─ tamaño++
  │
  └─ Resultado: Pedido en la cima de pedidosActivos
```

### Operación: Deshacer Pedido

```
Usuario llama deshacerPedido()
  │
  ├─ Verifica si pedidosActivos.isEmpty()
  │  └─ Si está vacía: Mostrar error y salir
  │  └─ Si tiene elementos: Continuar
  │
  ├─ pizza p = pedidosActivos.pop()
  │  └─ Obtiene elemento de cima
  │  └─ cima = cima.siguiente (sube en la pila)
  │  └─ tamaño--
  │  └─ Retorna elemento
  │
  ├─ pedidosCompletados.push(p)
  │  └─ Agrega a pila de completados
  │
  └─ Mostrar: "Pedido deshecho: [nombre]"
```

### Operación: Rehacer Pedido

```
Usuario llama rehacerPedido()
  │
  ├─ Verifica si pedidosCompletados.isEmpty()
  │  └─ Si está vacía: Mostrar error y salir
  │  └─ Si tiene elementos: Continuar
  │
  ├─ pizza p = pedidosCompletados.pop()
  │  └─ Obtiene de pila de completados
  │
  ├─ pedidosActivos.push(p)
  │  └─ Vuelve a agregar a activos
  │
  └─ Mostrar: "Pedido rehecho: [nombre]"
```

---

## 💾 Estructura de Memoria

### Estado Inicial (Vacío)

```
pedidosActivos
├─ cima: null
└─ tamaño: 0

pedidosCompletados
├─ cima: null
└─ tamaño: 0
```

### Después de 3 push()

```
pedidosActivos
├─ cima: ┌─────────────────┐
│        │ Nodo[3]         │
│        ├─ pizza: p3      │
│        ├─ siguiente: ─┐  │
│        └─────────────┼┼──┘
│                      ││
│        ┌─────────────┼┼────┐
│        │ Nodo[2]     │ │   │
│        ├─ pizza: p2  │ │   │
│        ├─ siguiente: ─┼┼┐  │
│        └──────────────┼┼┼──┘
│                       │││
│        ┌──────────────┼┼┼────┐
│        │ Nodo[1]      │ │ │  │
│        ├─ pizza: p1   │ │ │  │
│        ├─ siguiente: null
│        └──────────────────┘
│
└─ tamaño: 3
```

### Después de pop() [LIFO]

```
pizzaRetornada = p3  (último en entrar, primero en salir)

pedidosActivos
├─ cima: ┌─────────────┐
│        │ Nodo[2]     │
│        ├─ pizza: p2  │
│        └─ siguiente: ───┐
│                         │
│        ┌─────────────┐  │
│        │ Nodo[1]     │  │
│        ├─ pizza: p1  │  │
│        └─ siguiente: null
│
└─ tamaño: 2

pedidosCompletados
├─ cima: ┌─────────────┐
│        │ Nodo[3']    │
│        ├─ pizza: p3  │
│        └─ siguiente: null
│
└─ tamaño: 1
```

---

## 🎯 Patrones y Principios Aplicados

### 1. Patrón Pila (Stack)
- **LIFO**: Last In First Out
- **Casos de uso**: 
  - Undo/Redo (Ctrl+Z, Ctrl+Y)
  - Análisis sintáctico
  - Expresiones matemáticas
  - Gestión de historial

### 2. Estructura de Datos Enlazada
- **Ventajas**:
  - Tamaño dinámico (sin límite predefinido)
  - O(1) para inserción/eliminación en cima
  - Memoria flexible
- **Desventajas**:
  - Acceso lineal O(n) para elementos intermedios
  - Overhead de memoria por punteros

### 3. Principio SOLID

#### S - Single Responsibility
- `Pizza`: Responsable solo de datos de pizza
- `Nodo`: Responsable solo de estructura de nodo
- `PilaManual`: Responsable solo de operaciones de pila
- `GestionPedidos`: Responsable solo de lógica de negocio

#### O - Open/Closed
- `PilaManual<T>` genérica: Abierta para extensión a otros tipos

#### L - Liskov Substitution
- Métodos heredan comportamiento esperado

#### I - Interface Segregation
- Cada clase expone solo métodos relevantes

#### D - Dependency Inversion
- `GestionPedidos` depende de abstracción `PilaManual`

### 4. Encapsulación
- Todos los atributos `private`
- Métodos `public` controlados
- Getters para acceso a datos
- Copias defensivas de arreglos

---

## 📈 Análisis de Complejidad

### Operaciones de Pila

| Operación | Complejidad | Justificación |
|-----------|-------------|--------------|
| `push(x)` | O(1) | Crear nodo + 2 asignaciones |
| `pop()` | O(1) | 1 lectura + 1 asignación |
| `peek()` | O(1) | Lectura directa |
| `isEmpty()` | O(1) | Comparación simple |
| `mostrartodos()` | O(n) | Iterar n nodos |

### Operaciones de Gestión

| Operación | Complejidad | Justificación |
|-----------|-------------|--------------|
| `agregarpedido()` | O(1) | Llama push() |
| `deshacerPedido()` | O(1) | pop() + push() |
| `mostrarPedidosActivos()` | O(n) | Llama mostrartodos() |
| `vaciarPedidos()` | O(n) | n pop() en ambas pilas |

---

## 🧪 Casos de Prueba

### Test 1: Verificar LIFO
```
push(A), push(B), push(C)
pop() → Retorna C ✓
pop() → Retorna B ✓
pop() → Retorna A ✓
```

### Test 2: Deshacer/Rehacer
```
agregarpedido(A), agregarpedido(B)
deshacerPedido()
  → pedidosActivos contiene: A
  → pedidosCompletados contiene: B
rehacerPedido()
  → pedidosActivos contiene: A, B
  → pedidosCompletados vacío
```

### Test 3: Excepciones
```
PilaManual vacía
pop() → RuntimeException("La pila está vacía")
peek() → RuntimeException("La pila está vacía")
```

### Test 4: Validación
```
Pizza con >3 ingredientes
  → IllegalArgumentException("Se requieren máximo 3 ingredientes")
Pizza con ingredientes nulos
  → IllegalArgumentException("Los ingredientes no pueden ser nulos")
```

---

## 🔐 Consideraciones de Seguridad

1. **Validación de entrada**
   - Verificar que ingredientes no sean nulos
   - Verificar cantidad de ingredientes
   - Verificar que no estén vacíos

2. **Manejo de excepciones**
   - RuntimeException para pilas vacías
   - IllegalArgumentException para entrada inválida

3. **Encapsulación**
   - Atributos privados
   - Copias defensivas de arreglos en getters

4. **Recursos**
   - Sin recursos externos (archivos, BD)
   - Garbage collection automático

---

## 📚 Extensiones Futuras

### 1. Persistencia
```java
public void guardarPedidos(String archivo) {
    // Serializar pilas a JSON/XML
    // Guardar en archivo
}

public void cargarPedidos(String archivo) {
    // Leer archivo
    // Deserializar a pilas
}
```

### 2. Notificaciones
```java
public interface PedidoListener {
    void onPedidoAgregado(pizza pizza);
    void onPedidoDeshecho(pizza pizza);
    void onPedidoRehecho(pizza pizza);
}
```

### 3. Búsqueda
```java
public List<pizza> buscarPorNombre(String nombre) {
    // Buscar en pilas
}

public List<pizza> buscarPorPrecio(double min, double max) {
    // Filtrar por rango de precio
}
```

### 4. Estadísticas
```java
public double calcularTotalVentas() {
    // Sumar precios de pedidos activos
}

public int contarPedidosPorTipo() {
    // Agrupar por nombre de pizza
}
```

### 5. Concurrencia
```java
public synchronized void agregarpedido(pizza pizza) {
    // Thread-safe
}
```

---

## 🚀 Optimizaciones Posibles

1. **Cache de búsqueda**: Indexar pizzas por nombre
2. **Lazy loading**: Cargar datos bajo demanda
3. **Connection pooling**: Si se agrega BD
4. **Batch operations**: Agregar/remover múltiples a la vez
5. **Memory optimization**: Pool de nodos reutilizables

---

## 📋 Checklist de Calidad

- ✅ Código compilable
- ✅ Nombres significativos
- ✅ Documentación JavaDoc
- ✅ Validación de entrada
- ✅ Manejo de excepciones
- ✅ Encapsulación correcta
- ✅ Separación de responsabilidades
- ✅ DRY (Don't Repeat Yourself)
- ✅ KISS (Keep It Simple, Stupid)
- ✅ Ejemplos funcionales

---

**Documento de Análisis Técnico**  
**PizzaTrack v1.0**  
**Generado: 17 de Mayo de 2026**
