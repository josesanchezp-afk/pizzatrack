# GUÍA DE EJECUCIÓN Y TROUBLESHOOTING - PIZZATRACK

## 🚀 Inicio Rápido

### Requisitos
- Java JDK 8 o superior
- VS Code con extensión Java
- Terminal (PowerShell, cmd, bash)

### Pasos para ejecutar

#### Opción 1: Terminal (Recomendado)

```bash
# 1. Navegar a la carpeta src
cd c:\Users\keiro\Desktop\pizzatrack\pizzatrack\src

# 2. Compilar todos los archivos
javac *.java

# 3. Ejecutar la aplicación
java Main
```

#### Opción 2: VS Code (con Extension Pack for Java)

1. Abrir proyecto en VS Code
2. Click en el botón "Run" encima del método `main()` en Main.java
3. Ver salida en la terminal integrada

---

## 📊 Salida Esperada

```
===== BIENVENIDO A PIZZATRACK =====

--- Agregando pedidos ---
Pedido agregado: Margherita
Pedido agregado: Pepperoni
Pedido agregado: Hawaiana

=== Pedidos Activos ===
[1] Pizza: Hawaiana
Ingredientes: jamon, pina, queso
Precio: $11.99

[2] Pizza: Pepperoni
Ingredientes: queso, pepperoni, cebolla
Precio: $10.99

[3] Pizza: Margherita
Ingredientes: tomate, queso, oregano
Precio: $8.99

--- Deshaciendo un pedido ---
Pedido deshecho: Hawaiana

=== Pedidos Activos ===
[1] Pizza: Pepperoni
Ingredientes: queso, pepperoni, cebolla
Precio: $10.99

[2] Pizza: Margherita
Ingredientes: tomate, queso, oregano
Precio: $8.99

=== Pedidos Completados ===
[1] Pizza: Hawaiana
Ingredientes: jamon, pina, queso
Precio: $11.99

--- Rehaciendo un pedido ---
Pedido rehecho: Hawaiana

=== Pedidos Activos ===
[1] Pizza: Hawaiana
Ingredientes: jamon, pina, queso
Precio: $11.99

[2] Pizza: Pepperoni
Ingredientes: queso, pepperoni, cebolla
Precio: $10.99

[3] Pizza: Margherita
Ingredientes: tomate, queso, oregano
Precio: $8.99

--- Estado final ---
Hay pedidos activos: true
Hay pedidos para rehacer: false

===== FIN DEL PROGRAMA =====
```

---

## 🔧 Troubleshooting

### ❌ Error: "javac no se reconoce"

**Causa**: Java no está en el PATH del sistema

**Solución**:
```bash
# Verificar si Java está instalado
java -version

# Si no funciona, instalar JDK desde:
# https://www.oracle.com/java/technologies/downloads/

# Agregar Java al PATH (Windows):
# 1. Presionar Win + X
# 2. Seleccionar "Configuración del sistema"
# 3. Variables de entorno
# 4. Path
# 5. Agregar ruta de Java: C:\Program Files\Java\jdk-[version]\bin
```

---

### ❌ Error: "Main class not found"

**Causa**: Archivos no compilados o nombre de clase incorrecto

**Solución**:
```bash
# Asegurarse de estar en directorio src
cd src

# Eliminar archivos compilados antiguos
del *.class

# Recompilar
javac *.java

# Ejecutar
java Main
```

---

### ❌ Error: "RuntimeException: La pila está vacía"

**Causa**: Intento de pop() o peek() en pila vacía

**Solución**: Verificar que hayPedidosActivos() sea true antes de deshacer

```java
if (gestor.hayPedidosActivos()) {
    gestor.deshacerPedido();
} else {
    System.out.println("No hay pedidos para deshacer");
}
```

---

### ❌ Error: "IllegalArgumentException: Se requieren máximo 3 ingredientes"

**Causa**: Array de ingredientes con más de 3 elementos

**Solución**:
```java
// ❌ INCORRECTO
String[] ingredientes = {"queso", "jamon", "pina", "extra"}; // 4 elementos

// ✅ CORRECTO
String[] ingredientes = {"queso", "jamon", "pina"}; // 3 elementos
```

---

### ❌ Error: "NullPointerException"

**Causa**: Referencia nula siendo utilizada

**Solución**: Verificar que los objetos estén inicializados
```java
// ✅ CORRECTO
gestionpedidos gestor = new gestionpedidos();
String[] ingredientes = {"queso", "jamon", "pina"};
pizza p = new pizza("Hawaiana", 11.99, ingredientes);
gestor.agregarpedido(p);
```

---

### ❌ Caracteres especiales (ñ, á) no se ven correctamente

**Causa**: Encoding incorrecto

**Solución**:
```bash
# Compilar con UTF-8
javac -encoding UTF-8 *.java

# Ejecutar
java Main
```

---

### ⚠️ Programa lento o se congela

**Posible causa**: Loop infinito accidental

**Solución**:
```bash
# Presionar Ctrl+C en la terminal para detener
# Revisar el código en Main.java
```

---

## 🧪 Pruebas Manuales

### Test 1: Agregar y visualizar pedidos

```java
gestionpedidos gestor = new gestionpedidos();
String[] ing = {"queso", "tomate", "oregano"};
pizza p = new pizza("Margherita", 8.99, ing);
gestor.agregarpedido(p);
gestor.mostrarPedidosActivos();
// Resultado esperado: Debe mostrar Margherita
```

### Test 2: Deshacer operación

```java
gestor.deshacerPedido();
gestor.mostrarPedidosActivos();
// Resultado esperado: Lista vacía
gestor.mostrarPedidosCompletados();
// Resultado esperado: Muestra Margherita
```

### Test 3: Rehacer operación

```java
gestor.rehacerPedido();
gestor.mostrarPedidosActivos();
// Resultado esperado: Vuelve a mostrar Margherita
```

### Test 4: Validación de ingredientes

```java
try {
    // Intentar crear pizza con 4 ingredientes
    String[] ing = {"queso", "jamon", "pina", "extra"};
    pizza p = new pizza("Test", 10.0, ing);
    System.out.println("ERROR: Debería haber lanzado excepción");
} catch (IllegalArgumentException e) {
    System.out.println("OK: Excepción capturada: " + e.getMessage());
}
// Resultado esperado: "Se requieren máximo 3 ingredientes"
```

### Test 5: Manejo de pila vacía

```java
gestionpedidos gestor2 = new gestionpedidos();
gestor2.mostrarPedidosActivos();
// Resultado esperado: "No hay pedidos activos."
gestor2.deshacerPedido();
// Resultado esperado: "No hay pedidos para deshacer."
```

---

## 📝 Modificar el Código

### Agregar una nueva pizza en Main.java

```java
// Ejemplo: Agregar nueva línea en main()
String[] ingredientes4 = {"champiñones", "carne", "cebolla"};
pizza p4 = new pizza("Champiñones", 9.99, ingredientes4);
gestor.agregarpedido(p4);
```

### Modificar lógica de GestionPedidos

```java
// Ejemplo: Agregar método para contar pedidos
public int contarPedidosActivos() {
    return pedidosActivos.size();
}

public int contarPedidosCompletados() {
    return pedidosCompletados.size();
}
```

### Cambiar formato de salida

En `PilaManual.java`, método `mostrartodos()`:

```java
// Versión mejorada con más detalles
public void mostrartodos() {
    if (isEmpty()) {
        System.out.println("  [Lista vacía]");
        return;
    }
    nodo actual = cima;
    int posicion = 1;
    while (actual != null) {
        System.out.printf("[%d] %s%n", posicion, actual.pizza);
        actual = actual.siguiente;
        posicion++;
    }
}
```

---

## 🔍 Debugging Avanzado

### Usar System.out.println para rastreo

```java
public void agregarpedido(pizza pizza) {
    System.out.println("DEBUG: Agregando pizza - " + pizza.getNombre());
    pedidosActivos.push(pizza);
    System.out.println("DEBUG: Tamaño de pila - " + pedidosActivos.size());
}
```

### Ver contenido de memoria (Variables Watch)

En VS Code, con el debugger:
1. F5 para iniciar debug
2. Presionar F1 y buscar "Debug: Add to Watch"
3. Escribir nombre de variable
4. Ver valor en tiempo real

---

## 📦 Empaquetar como JAR

```bash
# Compilar
javac -d bin src/*.java

# Crear JAR con Main manifest
jar cvfe pizzatrack.jar Main -C bin .

# Ejecutar JAR
java -jar pizzatrack.jar
```

---

## 🐛 Reportar Bugs

Si encuentras un bug:

1. **Reproducir**: Anotar pasos exactos
2. **Error**: Copiar mensaje de error completo
3. **Contexto**: 
   - Versión de Java
   - Sistema operativo
   - Entrada que causa el error
4. **Solución esperada**: Qué debería suceder

---

## ✅ Checklist Pre-Ejecución

- ✅ Archivos .java presentes en `src/`
- ✅ Java JDK instalado (verificar con `java -version`)
- ✅ Archivo Main.java contiene `public static void main(String[] args)`
- ✅ Terminal en directorio correcto (`cd src`)
- ✅ Sin archivos .class antiguos (limpiar con `del *.class`)
- ✅ Sintaxis correcta (javac sin errores)

---

## 🎓 Recursos Adicionales

- [Documentación oficial de Java](https://docs.oracle.com/en/java/)
- [Tutorial de pilas en programación](https://www.w3schools.com/java/)
- [Debugging en VS Code](https://code.visualstudio.com/docs/languages/java)

---

## 📞 Soporte

Si necesitas ayuda:
1. Revisar este documento
2. Consultar `MANUAL_TECNICO.md`
3. Revisar `RESUMEN_CORRECCIONES.md`
4. Revisar `ANALISIS_ARQUITECTURA.md`

---

**Última actualización**: 17 de Mayo de 2026  
**Versión**: 1.0  
**Estado**: Verificado ✅
