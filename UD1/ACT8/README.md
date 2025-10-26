# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UDn.ACT8

---

## 📖 Descripción
Programa en C que crea tres procesos (abuelo, hijo y nieto) y comunica mensajes entre ellos utilizando **dos pipes**, siguiendo un flujo bidireccional. Se muestra el envío y recepción de mensajes respetando el orden de jerarquía.

---

## 📂 Estructura

### 1. Código fuente

No se han utilizado bibliotecas adicionales.  
El programa se encuentra en la carpeta `/src`:

- **actividad8.c** → Crea procesos abuelo, hijo y nieto, enviando mensajes entre ellos mediante pipes.


### 2. Bibliotecas adicionales (si las hubiera)
Archivos de librerías creados por ti o necesarios para la actividad.

✅ Comunicación entre procesos → Se utilizaron dos pipes para enviar y recibir mensajes en ambas direcciones.  
✅ Evitar bloqueos → Se cerraron correctamente los extremos de los pipes que no se utilizan en cada proceso.  
✅ Control de secuencia → Se respetó el orden: Abuelo → Hijo → Nieto → Hijo → Abuelo.  
✅ Evitar pérdida de mensajes → Se sincronizó la lectura/escritura con printf() para que la salida en terminal sea clara.



## ⚙️ Requisitos de ejecución

✅ Lenguaje: C (GCC recomendado 9 o superior)  
✅ IDE o compilador: GCC / Terminal Linux  
✅ Sistema operativo probado: Ubuntu / Linux  
✅ Dependencias externas: Ninguna

## 🚀 Instalación y ejecución

Describe los pasos para compilar y/o ejecutar el programa:

## 🚀 Instalación y ejecución

1. Abrir terminal en la carpeta del proyecto.
2. Compilar el programa:
   gcc -o actividad8 actividad8.c
3. Ejecutar el programa:
   ./actividad8

## ✨ Autor/a

```plaintext
👤 Xiker Garcia de Albeniz