# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UD4.ACT1

---

## 📖 Descripción
Programa cliente FTP en Java que conecta a ftp.rediris.es, muestra el directorio actual y crea DM2PROS si es posible.

---

## 📂 Estructura

### 1. Código fuente
📁 /src  
    ✅ Actividad1.java → Clase principal que realiza la conexión FTP, el login, la creación del directorio DM2PROS, el logout y la desconexión.

### 2. Bibliotecas adicionales (si las hubiera)
📁 /libs
    ✅ commons-net-3.12.0.jar → Librería Apache Commons Net que proporciona la clase FTPClient para gestionar la conexión y operaciones FTP.
    ✅ commons-io-2.21.0.jar → Librería Apache Commons IO para utilidades de entrada/salida usadas en la gestión de flujos o tratamiento de datos.


---

## ⚠️ Solución de problemas

No se han encontrado problemas en esta actividad.

---

## ⚙️ Requisitos de ejecución

✅ Lenguaje: Java 8 o superior
✅ IDE o compilador utilizado: IntelliJ IDEA / Eclipse / NetBeans / javac
✅ Sistema operativo probado: Windows 10/11
✅ Dependencias externas: Conexión a Internet y acceso al servidor ftp.rediris.es
✅ Bibliotecas: commons-net-3.12.0.jar y commons-io-2.21.0.jar añadidas al classpath

---

## 🚀 Instalación y ejecución

✅ Paso 1: Colocar commons-net-3.12.0.jar y commons-io-2.21.0.jar en la carpeta /libs o configurarlas como dependencias en el proyecto.
✅ Paso 2: Compilar el programa con el IDE o, desde terminal:
javac -cp.; libs/commons-net-3.12.0.jar; libs/commons-io-2.21.0.jar Actividad1.java (Windows)
javac -cp.:libs/commons-net-3.12.0.jar:libs/commons-io-2.21.0.jar Actividad1.java (Linux/Mac)
✅ Paso 3: Ejecutar el programa:
java -cp.; libs/commons-net-3.12.0.jar; libs/commons-io-2.21.0.jar Actividad1 (Windows)
java -cp.:libs/commons-net-3.12.0.jar:libs/commons-io-2.21.0.jar Actividad1 (Linux/Mac)
✅ Paso 4: Observar en la consola los mensajes de conexión, login, directorio actual, creación de DM2PROS, logout y desconexión.

## ✨ Autor/a

```plaintext
👤 Xiker Garcia de Albeniz