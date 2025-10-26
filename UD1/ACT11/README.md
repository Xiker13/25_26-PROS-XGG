# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UDn.ACT10

---

## 📖 Descripción
Programa en Java que muestra la prioridad del hilo principal y de dos hilos secundarios, controlando el 
orden de ejecución de forma sincronizada.
---

## 📂 Estructura

### 1. Código fuente
📁 /src
✅ Actividad10.java → Clase principal que gestiona la ejecución de los hilos y muestra sus prioridades.
✅ Hilo.java → Clase que hereda de Thread y ejecuta las frases "Ejecutando…" con el mensaje recibido.


### 2. Bibliotecas adicionales (si las hubiera)
No se han utilizado bibliotecas adicionales.

---

## ⚠️ Solución de problemas

Orden de ejecución de hilos → Se resolvió usando join() para sincronizar la impresión de los mensajes y garantizar el resultado esperado.

---

## ⚙️ Requisitos de ejecución

✅ Lenguaje: Java 23 (Valhalla EA)
✅ IDE: IntelliJ IDEA 2025.2.1
✅ Sistema operativo: Windows 10/11
✅ Dependencias externas: Ninguna


---

## 🚀 Instalación y ejecución

✅ Paso 1: Abrir IntelliJ IDEA y crear un nuevo proyecto Java.
✅ Paso 2: Crear los archivos Actividad10.java y Hilo.java dentro de src y pegar el código correspondiente.
✅ Paso 3: Ejecutar la clase Actividad10 (clic derecho → Run 'Actividad10.main()').
✅ Paso 4: Verificar que la salida sea:

main tiene la prioridad 5
Thread-0 tiene la prioridad 3
Thread-1 tiene la prioridad 7
Ejecutando Hilo-prioridad 7
Final programa
Ejecutando Hilo-prioridad 3

---

## ✨ Autor/a

```plaintext
👤 Xiker Garcia De Albeniz