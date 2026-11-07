# Algoritmos de Ordenamiento y Búsqueda

## Descripción

Proyecto desarrollado en Java para el curso de Estructuras de Datos.

El programa permite crear un arreglo de palabras, cuyo tamaño es definido por el usuario, y ordenarlo alfabéticamente mediante uno de cinco algoritmos de ordenamiento. Posteriormente, permite buscar una palabra dentro del arreglo ordenado utilizando búsqueda binaria.

## Algoritmos implementados

**Ordenamiento:**
- Selección (Selection Sort)
- Inserción (Insertion Sort)
- Burbuja (Bubble Sort)
- Mezcla (Merge Sort)
- Rápido (Quick Sort)

**Búsqueda:**
- Búsqueda binaria (Binary Search)

Adicionalmente, el código incluye comentarios explicativos sobre los algoritmos Radix Sort y Shell Sort.

## Funcionamiento

1. El usuario ingresa la cantidad de palabras que desea almacenar.
2. El programa solicita las palabras y las guarda en un arreglo.
3. Se presenta un menú con cinco algoritmos de ordenamiento.
4. El usuario selecciona un algoritmo y el programa muestra las palabras ordenadas alfabéticamente.
5. Se solicita una palabra para realizar una búsqueda binaria.
6. El programa indica si la palabra fue encontrada y, en ese caso, muestra su posición dentro del arreglo.

## Complejidad temporal

| Algoritmo | Complejidad temporal |
|---|---|
| Selección | O(n²) |
| Inserción | O(n²) |
| Burbuja | O(n²) |
| Mezcla | O(n log n) |
| Rápido | O(n log n) promedio; O(n²) peor caso |
| Búsqueda binaria | O(log n) |

## Tecnologías utilizadas

- Java
- Arreglos
- Métodos
- Recursividad
- Estructuras de control

## Ejecución

El código fuente se encuentra en `src/Main.java`.

Para ejecutar el programa se requiere tener instalado Java. Desde la carpeta raíz del repositorio se pueden utilizar los siguientes comandos:

```bash
javac src/Main.java
java -cp src Main
```

## Referencias

- Sedgewick, R., & Wayne, K. *Algorithms, 4th Edition*. Princeton University. https://algs4.cs.princeton.edu/
- GeeksforGeeks. *Radix Sort*. https://www.geeksforgeeks.org/dsa/radix-sort/
- GeeksforGeeks. *Shell Sort*. https://www.geeksforgeeks.org/dsa/shell-sort/
