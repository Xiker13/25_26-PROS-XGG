# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UD2.ACT14

---

## 📖 Descripción
Programa que elimina un deadlock entre dos hilos sincronizando el acceso a recursos.* "Programa que calcula el salario neto de un trabajador aplicando retenciones fiscales."

---

## 📂 Estructura

### 1. Código fuente
Ubicación y descripción de los archivos principales del programa.

```plaintext
📁 /src
    ✅ Actividad14.java → Clase principal que crea los recursos y lanza los hilos.
    ✅ Hilo.java → Clase que implementa la lógica sincronizada sobre los recursos.
    ✅ Recurso.java → Clase vacía usada como recurso compartido para la sincronización.

```

### 2. Bibliotecas adicionales (si las hubiera)
No se han utilizado bibliotecas adicionales.

---

## ⚠️ Solución de problemas

✅ Deadlock entre hilos → Se resolvió pasando los recursos en el mismo orden
a ambos hilos (a, b) en lugar de (a, b) y (b, a). Esto evita que cada hilo
bloquee un recurso diferente y espere por el otro, eliminando el bloqueo mutuo.

---

## ⚙️ Requisitos de ejecución

✅ Lenguaje: Java 8 o superior
✅ IDE o compilador usado: Eclipse / IntelliJ / VSCode / javac
✅ Sistema operativo probado: Windows 10 (válido también para Linux y macOS)
✅ Dependencias externas: No requiere ninguna


---

## 🚀 Instalación y ejecución

✅ Paso 1: Compilar el programa
javac Actividad14.java Hilo.java Recurso.java

✅ Paso 2: Ejecutar el programa
java Actividad14

✅ Paso 3: Observación de salida
Deben mostrarse los mensajes de inicio y fin de cada hilo sin bloquearse.


## ✨ Autor/a

```plaintext
👤 Xiker Garcia de Albeniz
