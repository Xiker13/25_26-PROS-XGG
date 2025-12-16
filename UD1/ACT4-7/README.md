# 📌 IDENTIFICACIÓN DE LA ACTIVIDAD: UD1.ACT4-7

---

## 📖 Descripción
Programas en C que gestionan procesos mediante fork(), mostrando PID y jerarquía de ejecución. Incluye manipulación de variables y control de orden de ejecución.

---

## 📂 Estructura y Código Fuente

No se han utilizado bibliotecas adicionales.  
Todos los programas se encuentran en la carpeta `/src`:

1. **actividad4.c**: Crea un proceso padre y 3 hijos, mostrando el PID de cada uno y del padre.
2. **actividad5.c**: Genera una cadena lineal de procesos hasta n hijos, con control de orden.
3. **actividad6.c**: Crea tres hijos con un orden específico de impresión de PIDs y manejo de jerarquía.
4. **actividad7.c**: Crea un proceso padre y un hijo; cada proceso modifica una variable independiente.

---

## ⚠️ Solución de problemas

✅ Orden de impresión de hijos → Se utilizó wait() en combinación con fork() para controlar la secuencia correcta.  
✅ Variables independientes → Se verificó que la variable modificada por padre e hijo es local a cada proceso.  
✅ Evitar creación de procesos no deseados → Se controló la ejecución de los bucles con break y wait().

---

## ⚙️ Requisitos de ejecución

✅ Lenguaje: C (GCC recomendado 9 o superior)  
✅ IDE o compilador: GCC / Terminal Linux  
✅ Sistema operativo probado: Ubuntu / Linux  
✅ Dependencias externas: Ninguna

---

## 🚀 Instalación y ejecución

1. Abrir terminal en la carpeta del proyecto.
2. Compilar cada programa:
```bash
gcc -o actividad4 actividad4.c
gcc -o actividad5 actividad5.c
gcc -o actividad6 actividad6.c
gcc -o actividad7 actividad7.c

./actividad4
./actividad5
./actividad6
./actividad7
```
---

## ✨ Autor/a

```plaintext
👤 Xiker Garcia de Albeniz