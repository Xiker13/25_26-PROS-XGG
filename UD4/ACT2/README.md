# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UD4.ACT2

---

## 📖 Descripción
Programa en Java que se conecta a un servidor FTP y crea una estructura de directorios personalizada con subcarpetas html, imagenes y css.

---

## 📂 Estructura

### 1. Código fuente
Ubicación y descripción de los archivos principales del programa.

```plaintext
📁 /src
    ✅ Actividad2.java → Clase principal que gestiona la conexión FTP, login, creación de directorios y cierre de sesión.
```

### 2. Bibliotecas adicionales (si las hubiera)
Archivos de librerías creados por ti o necesarios para la actividad.

📁 /libs
No se han utilizado bibliotecas adicionales.

Se utiliza la librería Apache Commons Net para gestionar la conexión FTP, incluida como dependencia de Maven.

> ✏️ *Si no usas bibliotecas externas, indícalo con la siguiente frase: "No se han utilizado bibliotecas adicionales."*

---

## ⚠️ Solución de problemas

✅ Problema con la conexión FTP desde Docker → Se resolvió mapeando correctamente el puerto del contenedor y usando 127.0.0.1 como host.
✅ Error al crear directorios → Se solucionó verificando los permisos del usuario dinux dentro del contenedor.

---

## ⚙️ Requisitos de ejecución


```plaintext
✅ Lenguaje: Java 11 o superior
✅ IDE o compilador: IntelliJ IDEA, Eclipse, NetBeans o terminal con javac
✅ Sistema operativo probado: Windows, Linux
✅ Dependencias externas: Apache Commons Net (Maven: commons-net 3.9.0)
```

---

## 🚀 Instalación y ejecución

```plaintext
✅ Paso 1: Descargar el proyecto y añadir la dependencia Apache Commons Net si no está incluida.
✅ Paso 2: Abrir el proyecto en un IDE o compilar desde terminal:
        javac -cp .;commons-net-3.9.0.jar Actividad2.java
✅ Paso 3: Ejecutar el programa:
        java -cp .;commons-net-3.9.0.jar Actividad2
✅ Paso 4: Verificar la creación de los directorios en el servidor FTP (por ejemplo, usando FileZilla con usuario: dinux y contraseña: 1234).

```

---

## ✨ Autor/a

```plaintext
👤 Xiker Garcia de Albeniz
