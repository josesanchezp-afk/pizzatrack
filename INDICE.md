# 📑 ÍNDICE Y NAVEGACIÓN - PIZZATRACK

## 🎯 Inicio Rápido

### Para usuarios finales:
1. Leer: [README.md](README.md)
2. Ejecutar: `cd src && javac *.java && java Main`
3. Consultar: [GUIA_EJECUCION.md](GUIA_EJECUCION.md)

### Para desarrolladores:
1. Leer: [README.md](README.md) + [MANUAL_TECNICO.md](MANUAL_TECNICO.md)
2. Revisar: [ANALISIS_ARQUITECTURA.md](ANALISIS_ARQUITECTURA.md)
3. Explorar código: [src/](src/)
4. Si hay dudas: [RESUMEN_CORRECCIONES.md](RESUMEN_CORRECCIONES.md)

---

## 📚 Documentación Completa

### 1. **README.md** - Resumen General
**Para qué**: Primera lectura, descripción del proyecto  
**Contiene**:
- Qué es PizzaTrack
- Cómo compilar y ejecutar
- Estructura del proyecto
- Características principales
- Requisitos del sistema

**Leer primero si**: Nunca has visto el proyecto

---

### 2. **MANUAL_TECNICO.md** - Análisis Completo
**Para qué**: Entender en detalle cada componente  
**Contiene**:
- Descripción de cada clase
- Patrones de diseño
- Guía de uso completa
- Errores encontrados y corregidos
- Mejoras implementadas
- Complejidad de algoritmos
- Pruebas sugeridas

**Leer si**: Necesitas información técnica detallada

---

### 3. **ANALISIS_ARQUITECTURA.md** - Diseño del Sistema
**Para qué**: Entender la arquitectura y estructura  
**Contiene**:
- Diagrama de capas
- Diagrama UML de clases
- Flujo de datos
- Estructura de memoria
- Patrones aplicados
- Principios SOLID
- Casos de prueba
- Extensiones futuras

**Leer si**: Quieres entender cómo funciona internamente

---

### 4. **RESUMEN_CORRECCIONES.md** - Cambios Realizados
**Para qué**: Ver qué se corrigió  
**Contiene**:
- Errores en cada archivo
- Soluciones aplicadas
- Estadísticas de corrección
- Validaciones implementadas
- Checklist final

**Leer si**: Quieres saber qué errores había originalmente

---

### 5. **GUIA_EJECUCION.md** - Instrucciones Prácticas
**Para qué**: Ejecutar el proyecto y resolver problemas  
**Contiene**:
- Pasos de ejecución
- Salida esperada
- Troubleshooting (errores comunes)
- Pruebas manuales
- Cómo modificar código
- Debugging avanzado

**Leer si**: Tienes problemas al ejecutar

---

### 6. **INDICE.md** - Este Archivo
**Para qué**: Navegar toda la documentación  

---

## 📂 Estructura de Carpetas

```
pizzatrack/
│
├── 📄 README.md ................................ Inicio general
├── 📄 MANUAL_TECNICO.md ........................ Análisis técnico
├── 📄 ANALISIS_ARQUITECTURA.md ................ Diseño del sistema
├── 📄 RESUMEN_CORRECCIONES.md ................. Cambios realizados
├── 📄 GUIA_EJECUCION.md ........................ Instrucciones prácticas
├── 📄 INDICE.md ................................ Este archivo
│
├── 📁 src/
│   ├── Main.java .............................. Punto de entrada
│   ├── Pizza.java ............................. Modelo de datos
│   ├── Nodo.java .............................. Estructura enlazada
│   ├── PilaManual.java ........................ Estructura de pila
│   └── GestionPedidos.java .................... Lógica de negocio
│
├── 📁 bin/ ..................................... (Archivos compilados)
└── 📁 lib/ ..................................... (Dependencias)
```

---

## 🔍 Búsqueda Rápida por Tema

### Quiero entender...

| Pregunta | Documento | Sección |
|----------|-----------|---------|
| ¿Qué es PizzaTrack? | README.md | Descripción |
| ¿Cómo compilo? | README.md / GUIA_EJECUCION.md | Inicio rápido |
| ¿Cómo executo? | GUIA_EJECUCION.md | Pasos |
| Tengo error... | GUIA_EJECUCION.md | Troubleshooting |
| ¿Cómo funciona Pizza.java? | MANUAL_TECNICO.md | Estructura de clases |
| ¿Cómo funciona PilaManual.java? | MANUAL_TECNICO.md | Estructura de clases |
| ¿Qué es una pila LIFO? | MANUAL_TECNICO.md / ANALISIS_ARQUITECTURA.md | Patrones |
| ¿Cómo agregar pedidos? | README.md / MANUAL_TECNICO.md | Ejemplo de uso |
| ¿Cuál es la complejidad? | MANUAL_TECNICO.md / ANALISIS_ARQUITECTURA.md | Análisis |
| ¿Qué errores había? | RESUMEN_CORRECCIONES.md | Errores encontrados |
| ¿Qué se mejoró? | RESUMEN_CORRECCIONES.md | Mejoras |
| ¿Cómo debuggear? | GUIA_EJECUCION.md | Debugging avanzado |
| ¿Qué pruebas hacer? | MANUAL_TECNICO.md / GUIA_EJECUCION.md | Pruebas |
| ¿Cómo expandir? | ANALISIS_ARQUITECTURA.md | Extensiones futuras |

---

## 👥 Por Perfil de Usuario

### 👨‍🏫 Profesor/Estudiante

**Leer en este orden**:
1. README.md - Entender qué es
2. MANUAL_TECNICO.md - Ver detalles de cada clase
3. Ejecutar Main.java - Ver demostración
4. ANALISIS_ARQUITECTURA.md - Entender diseño
5. Modificar Main.java - Hacer ejercicios

**Archivos clave**: Main.java, PilaManual.java

---

### 👨‍💻 Desarrollador Junior

**Leer en este orden**:
1. README.md - Contexto
2. GUIA_EJECUCION.md - Aprender a ejecutar
3. MANUAL_TECNICO.md - Entender cada clase
4. ANALISIS_ARQUITECTURA.md - Ver diseño
5. Código fuente - Analizar línea por línea

**Archivos clave**: Todos

---

### 👨‍🏭 Ingeniero Senior/Arquitecto

**Leer en este orden**:
1. ANALISIS_ARQUITECTURA.md - Diseño general
2. MANUAL_TECNICO.md - Patrones y principios
3. RESUMEN_CORRECCIONES.md - Calidad
4. Código fuente - Validar implementación

**Enfoque**: Arquitectura, escalabilidad, SOLID

---

### 🧪 QA/Tester

**Leer en este orden**:
1. README.md - Qué es
2. GUIA_EJECUCION.md - Cómo ejecutar
3. MANUAL_TECNICO.md - Pruebas sugeridas
4. ANALISIS_ARQUITECTURA.md - Casos de prueba

**Enfoque**: Validación, casos de prueba, errores

---

## 🎓 Rutas de Aprendizaje

### Ruta 1: Entendimiento Básico (1 hora)
1. Leer README.md (10 min)
2. Ejecutar programa (5 min)
3. Leer GUIA_EJECUCION.md primeras secciones (20 min)
4. Revisar Main.java (15 min)
5. Revisar Pizza.java (10 min)

### Ruta 2: Aprendizaje Profundo (3 horas)
1. Leer README.md (15 min)
2. Ejecutar y experimenty (20 min)
3. Leer MANUAL_TECNICO.md (60 min)
4. Leer ANALISIS_ARQUITECTURA.md (60 min)
5. Revisar todo el código (30 min)
6. Pruebas manuales (15 min)

### Ruta 3: Revisión de Código (2 horas)
1. Leer RESUMEN_CORRECCIONES.md (20 min)
2. Leer ANALISIS_ARQUITECTURA.md (40 min)
3. Revisar cada archivo de src/ (60 min)

---

## 📊 Matriz de Referencias Cruzadas

### Pizza.java está documentado en:
- README.md: Características
- MANUAL_TECNICO.md: Detalles completos
- RESUMEN_CORRECCIONES.md: Errores corregidos
- ANALISIS_ARQUITECTURA.md: Relaciones UML

### PilaManual.java está documentado en:
- README.md: Características
- MANUAL_TECNICO.md: Implementación LIFO
- ANALISIS_ARQUITECTURA.md: Estructura de memoria
- GUIA_EJECUCION.md: Ejemplos de uso

### GestionPedidos.java está documentado en:
- MANUAL_TECNICO.md: Métodos principales
- ANALISIS_ARQUITECTURA.md: Flujo de datos
- GUIA_EJECUCION.md: Cómo usar

### Main.java está documentado en:
- README.md: Punto de entrada
- GUIA_EJECUCION.md: Cómo ejecutar
- MANUAL_TECNICO.md: Demostración

---

## ✅ Checklist de Lectura

**Lectura Mínima** (para ejecutar):
- [ ] README.md - Sección "Inicio Rápido"
- [ ] GUIA_EJECUCION.md - Secciones "Inicio Rápido" y "Salida Esperada"

**Lectura Recomendada** (para entender):
- [ ] README.md - Completo
- [ ] MANUAL_TECNICO.md - Primeras 3 secciones
- [ ] GUIA_EJECUCION.md - Completo

**Lectura Completa** (para dominar):
- [ ] README.md - Completo
- [ ] MANUAL_TECNICO.md - Completo
- [ ] ANALISIS_ARQUITECTURA.md - Completo
- [ ] RESUMEN_CORRECCIONES.md - Completo
- [ ] GUIA_EJECUCION.md - Completo
- [ ] Código fuente - Todo

---

## 🚀 Próximos Pasos

Después de leer la documentación:

1. **Ejecutar el programa**
   ```bash
   cd src
   javac *.java
   java Main
   ```

2. **Modificar Main.java**
   - Agregar nuevas pizzas
   - Probar diferentes operaciones

3. **Extender funcionalidad**
   - Agregar búsqueda
   - Agregar reportes
   - Ver ANALISIS_ARQUITECTURA.md para ideas

4. **Estudiar cada clase**
   - Pizza.java
   - Nodo.java
   - PilaManual.java
   - GestionPedidos.java
   - Main.java

---

## 💡 Tips y Trucos

- **Compilar con UTF-8**: `javac -encoding UTF-8 *.java`
- **Ver output detallado**: Agregar `System.out.println()` en el código
- **Debuggear**: Usar VS Code Debug (F5)
- **Limpiar**: `del *.class` (Windows) o `rm *.class` (Unix)

---

## 📞 Resumen de Documentos

| Documento | Páginas | Temas | Para Quién |
|-----------|---------|-------|-----------|
| README.md | 3 | General, inicio | Todos |
| MANUAL_TECNICO.md | 10 | Técnico, detallado | Desarrolladores |
| ANALISIS_ARQUITECTURA.md | 8 | Diseño, patrones | Arquitectos |
| RESUMEN_CORRECCIONES.md | 6 | Cambios, calidad | Code Reviewers |
| GUIA_EJECUCION.md | 8 | Práctico, troubleshooting | Usuarios finales |

**Total**: 35+ páginas de documentación completa

---

## 🎉 ¡Comienza Ahora!

1. Abre README.md → Lee sección "Inicio Rápido"
2. Ejecuta el programa
3. Vuelve a este índice si tienes dudas
4. Consulta el documento específico que necesites

---

**Documentación Completa**: ✅  
**Proyecto**: ✅ Listo para usar  
**Última actualización**: 17 de Mayo de 2026  

¡**Bienvenido a PizzaTrack!** 🍕
