# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UD3.ACT10

---

## 📖 Descripción
Programa cliente-servidor que intercambia un objeto serializado mediante UDP y lo modifica en el servidor.

---

## 📂 Estructura

### 1. Código fuente

📁 /src

✅ Tenista.java  → Clase que define el objeto Tenista serializable con sus atributos y métodos.

✅ Cliente.java  → Programa cliente UDP que envía un objeto Tenista y recibe el objeto modificado.

✅ Servidor.java → Programa servidor UDP que recibe, modifica y devuelve un objeto Tenista.

---

### 2. Bibliotecas adicionales (si las hubiera)
No se han utilizado bibliotecas adicionales.


## ⚠️ Solución de problemas

✅ Envío de objetos por UDP → Se solucionó implementando la interfaz Serializable en la clase Tenista y utilizando streams de objetos para convertir el objeto a bytes.

✅ Tamaño del buffer del datagrama → Se estableció un buffer suficientemente grande (1024 bytes) para evitar pérdidas de datos durante la recepción.

✅ Orden de ejecución cliente-servidor → Se resolvió iniciando siempre primero el servidor antes de ejecutar el cliente.


---

## ⚙️ Requisitos de ejecución

✅ Lenguaje: Java (JDK 8 o superior)

✅ IDE utilizado: IntelliJ IDEA / Eclipse / NetBeans

✅ Sistema operativo probado: Windows

✅ Dependencias externas: No se requieren


---

## 🚀 Instalación y ejecución

✅ Paso 1: Abrir el proyecto en el IDE o situarse en el directorio /src desde la terminal.

✅ Paso 2: Compilar las clases Java si es necesario.

✅ Paso 3: Ejecutar primero la clase Servidor.

✅ Paso 4: Ejecutar a continuación la clase Cliente.

El servidor debe estar en ejecución antes de lanzar el cliente para garantizar la correcta recepción del
datagrama.
---

## ✨ Autor/a

```plaintext
👤 Xiker Garcia De Albeniz