# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UD3.ACT6-7

---

## 📖 Descripción
Actividad 6:
Programa que implementa comunicación mediante sockets TCP entre un servidor y un cliente.
El cliente envía un número entero y el servidor devuelve ese número elevado al cuadrado. Ambos programas muestran mensajes de estado, gestionan excepciones y cierran correctamente los streams y sockets.

Actividad 7:
Programa con sockets TCP donde un servidor atiende 3 clientes.
A cada cliente se le envía un mensaje personalizado de saludo.
A partir del cuarto cliente, la conexión es rechazada.
Todos los clientes visualizan mensajes de estado y el servidor muestra su proceso de espera y atención.
---

## 📂 Estructura

### 1. Código fuente
Ubicación y descripción de los archivos principales del programa.

```plaintext
📁 UD3/ACT6-7/act6
    ✅ Servidor.java → Servidor TCP que recibe un número y devuelve su cuadrado.
    ✅ Cliente.java → Cliente TCP que envía un número y muestra la respuesta del servidor.

📁 UD3/ACT6-7/act7
    ✅ Servidor.java → Servidor TCP que atiende exactamente a 3 clientes enviando saludos.
    ✅ Cliente.java → Cliente TCP que recibe y muestra el saludo del servidor.

```

### 2. Bibliotecas adicionales (si las hubiera)
No se han utilizado bibliotecas adicionales.

---

## ⚠️ Solución de problemas

Crear todos los archivos en la misma carpeta ha dado fallos al crear las clases servidor y cliente del 7
La solucion a este problema ha sido crear una carpeta individual para cada actividad

---

## ⚙️ Requisitos de ejecución

Lenguaje: Java 8 o superior
IDE o compilador: IntelliJ / Eclipse / VSCode / javac
Sistema operativo probado: Windows 7 64-bit
Dependencias externas: Ninguna

---

## 🚀 Instalación y ejecución

Actividad6
cd UD3/ACT6-7/act6
javac Servidor.java
javac Cliente.java

# En una terminal
java Servidor

# En otra terminal
java Cliente


Actividad7
cd UD3/ACT6-7/act7
javac Servidor.java
javac Cliente.java

# En una terminal (servidor)
java Servidor

# En otras terminales (los clientes)
java Cliente
java Cliente
java Cliente



## ✨ Autor/a

```plaintext
👤 Xiker Garcia de Albeniz
