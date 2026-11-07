import java.util.Scanner;

/*
 * Ordenamiento por radix (Radix Sort):
 * Es un algoritmo de ordenamiento que no compara directamente
 * los elementos completos, sino que los organiza según sus
 * dígitos o caracteres, procesándolos posición por posición.
 *
 * En su variante LSD, distribuye repetidamente los elementos
 * en grupos según el valor de cada dígito, comenzando por el
 * menos significativo (unidades) y avanzando hacia el más
 * significativo (decenas, centenas, etc.).
 *
 * Para cada posición utiliza un algoritmo estable, como
 * Counting Sort, que conserva el orden relativo de los
 * elementos con valores iguales. Después de procesar todas
 * las posiciones, el arreglo queda ordenado.
 *
 * Complejidad temporal:
 * O(W * (n + R)), donde W es la cantidad de posiciones
 * procesadas, n es el número de elementos y R es la cantidad
 * de valores posibles por posición.
 * Cuando W y R son constantes, la complejidad es O(n),
 * es decir, lineal.
 *
 * https://www.geeksforgeeks.org/dsa/radix-sort/
 */



/*
 * Ordenamiento Shell (Shell Sort):
 * Es un algoritmo de ordenamiento por comparación que mejora
 * el método de inserción (Insertion Sort). Ordena los elementos
 * dentro del mismo arreglo, sin necesitar uno adicional.
 *
 * Su principal ventaja es que permite mover elementos a
 * distancias mayores durante las primeras etapas, reduciendo
 * la cantidad de intercambios necesarios para ordenarlos.
 *
 * Primero, establece una secuencia de intervalos (gap),
 * generalmente n/2, n/4, ..., 1. En cada pasada, utiliza
 * el método de inserción para ordenar los elementos separados
 * por el intervalo correspondiente.
 *
 * El intervalo disminuye progresivamente hasta llegar a 1,
 * momento en el que se realiza una última pasada de inserción
 * para completar el ordenamiento del arreglo.
 *
 * Complejidad temporal:
 * Depende de la secuencia de intervalos utilizada.
 * Con la secuencia n/2, n/4, ..., 1, el peor caso puede
 * alcanzar O(n^2). Otras secuencias pueden mejorar
 * el rendimiento del algoritmo.
 *
 * https://www.geeksforgeeks.org/dsa/shell-sort/
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos a crear un arreglo de palabras del tamaño que vos elijas y luego lo vamos a ordenar utilizando el algoritmo que prefieras.");
        int cantidad;

        do {
            System.out.print("Ingrese la cantidad de palabras: ");

            if (sc.hasNextInt()) {
                cantidad = sc.nextInt();

                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor que cero.");
                }

            } else {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                sc.nextLine();
                cantidad = 0;
            }

        } while (cantidad <= 0);

        String[] palabras = new String[cantidad];
        sc.nextLine();

        for (int i = 0; i < cantidad; i++) {

            System.out.print("Ingrese la palabra " + (i + 1) + ": ");

            palabras[i] = sc.nextLine();
        }

        System.out.println("\nPalabras ingresadas:");

        for (int i = 0; i < cantidad; i++) {
            System.out.println(palabras[i]);
        }


        int opcion;

        do {
            System.out.println("\nSeleccione un algoritmo de ordenamiento:");
            System.out.println("1. Selección");
            System.out.println("2. Inserción");
            System.out.println("3. Burbuja");
            System.out.println("4. Mezcla");
            System.out.println("5. Rápido");
            System.out.println("0. Salir");

            System.out.print("Ingrese una opción: ");

            if (sc.hasNextInt()) { //Verificar que sea entero
                opcion = sc.nextInt();

                if (opcion < 0 || opcion > 5) {
                    System.out.println("Opción inválida. Ingrese un número del 0 al 5.");
                }

            } else {
                System.out.println("Entrada inválida. Debe ingresar un número entero.");
                sc.nextLine(); // Se descarta la entrada incorrecta
                opcion = -1;
            }

        } while (opcion < 0 || opcion > 5);

        switch (opcion) {

            case 0:
                System.out.println("Gracias por utilizar el programa. ¡Hasta pronto!");
                break;

            case 1:


                System.out.println("¡Vamos a ordenar el arreglo con el algoritmo de selección!\n");

                ordenamientoSeleccion(palabras);

                System.out.println("Palabras ordenadas por selección:");

                for (int i = 0; i < palabras.length; i++) {
                    System.out.println(palabras[i]);
                }

                break;

            case 2:
                System.out.println("¡Vamos a ordenar el arreglo con el algoritmo de inserción!\n");

                // Se ordena el arreglo utilizando el algoritmo de inserción
                ordenamientoInsercion(palabras);

                // Se muestran las palabras ordenadas
                System.out.println("Palabras ordenadas por inserción:");

                for (int i = 0; i < palabras.length; i++) {
                    System.out.println(palabras[i]);
                }

                break;

            case 3:
                System.out.println("¡Vamos a ordenar el arreglo con el algoritmo de burbuja!\n");

                ordenamientoBurbuja(palabras);

                System.out.println("Palabras ordenadas por burbuja:");

                for (int i = 0; i < palabras.length; i++) {
                    System.out.println(palabras[i]);
                }

                break;

            case 4:
                System.out.println("¡Vamos a ordenar el arreglo con el algoritmo de mezcla!\n");

                ordenamientoMezcla(palabras, 0, palabras.length - 1);

                System.out.println("Palabras ordenadas por mezcla:");

                for (int i = 0; i < palabras.length; i++) {
                    System.out.println(palabras[i]);
                }

                break;

            case 5:

                System.out.println("¡Vamos a ordenar el arreglo con el algoritmo rápido!\n");

                ordenamientoRapido(palabras, 0, palabras.length - 1);

                System.out.println("Palabras ordenadas por el algoritmo rápido:");

                for (int i = 0; i < palabras.length; i++) {
                    System.out.println(palabras[i]);
                }

                break;

            default:
                System.out.println("Opción inválida.");
                break;
        }


        if (opcion != 0) {

            sc.nextLine();

            System.out.println("Vamos a verificar si la palabra que ingresas está en el arreglo!");
            System.out.print("\nIngrese la palabra que desea buscar: ");
            String buscada = sc.nextLine();

            int posicion = busquedaBinaria(palabras, buscada);

            if (posicion != -1) {
                System.out.println("La palabra '" + buscada
                        + "' se encuentra en la posición " + posicion + ".");
            }
        }

    }

    public static void ordenamientoSeleccion(String[] palabras) {

        // Complejidad temporal: O(n^2).
        // El algoritmo utiliza dos ciclos for anidados.
        // Por lo tanto, la cantidad de comparaciones crece de forma
        // cuadrática con respecto al tamaño del arreglo.

        int n = palabras.length;
        int menor;
        String temp;

        // Escoge un elemento y ese lo compara con el resto del arreglo mediate el ciclo interno
        for (int i = 0; i < n - 1; i++) {

            menor = i;

            // El ciclo interno recorre la porción restante del arreglo,
            // omitiendo las posiciones ya ordenadas, para buscar
            // la palabra que va primero alfabéticamente.
            for (int j = i + 1; j < n; j++) {
                //Identifica el valor menor entre todos los elementos
                if (palabras[j].compareToIgnoreCase(palabras[menor]) < 0) {
                    menor = j;
                }
            }

            // Solo se intercambian las palabras si el elemento menor
            // se encuentra en una posición diferente a la actual.
            if (menor != i) {
                temp = palabras[i];// El índice que estamos analizando va a tener el menor valor del subarray que se analiza
                palabras[i] = palabras[menor];
                palabras[menor] = temp;// El espacio donde estaba el menor se reemplaza por el valor que estaba en el espacio que estábamos evaluando.
            }
        }
    }


    public static void ordenamientoInsercion(String[] palabras) {

        // Complejidad temporal: O(n^2).
        // El algoritmo recorre las palabras del arreglo original y,
        // para cada una, puede recorrer las palabras ya insertadas
        // para encontrar su posición y desplazarlas.
        // Por lo tanto, en el peor caso, la cantidad de operaciones
        // crece de forma cuadrática con respecto al tamaño del arreglo.

        int n = palabras.length;
        String[] palabrasNuevo = new String[n];
        int posicionInsertar = 0;
        int cantidadInsertados = 0;

        // El ciclo externo recorre el arreglo original.
        for (int i = 0; i < n; i++) {

            if (i == 0) {
                //Tenemos un array nuevo (indirecto), el primer valor que llenamos es el mismo que el del array original
                palabrasNuevo[i] = palabras[i];

            } else {

                // Se determina la posición del arreglo nuevo
                // en la que debe insertarse la siguiente palabra.
                posicionInsertar = cantidadInsertados;

                for (int j = 0; j < cantidadInsertados; j++) {

                    if (palabras[i].compareToIgnoreCase(palabrasNuevo[j]) <= 0) {
                        posicionInsertar = j;
                        break;
                    }
                }

                // Se desplazan hacia adelante las palabras
                // para dejar espacio a la nueva palabra.
                for (int k = cantidadInsertados; k > posicionInsertar; k--) {
                    palabrasNuevo[k] = palabrasNuevo[k - 1];
                }

                // Se inserta la nueva palabra.
                palabrasNuevo[posicionInsertar] = palabras[i];
            }

            // Se actualizan las variables de control.
            posicionInsertar = 0;
            cantidadInsertados++;
        }

        // Se copia el arreglo ordenado al arreglo original.
        for (int c = 0; c < palabras.length; c++) {
            palabras[c] = palabrasNuevo[c];
        }
    }


    public static void ordenamientoBurbuja(String[] palabras) {

        // Complejidad temporal: O(n^2).
        // Se utilizan dos ciclos for anidados.
        // La cantidad de comparaciones crece
        // de forma cuadrática con el tamaño del arreglo.

        int n = palabras.length;
        String temp;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (palabras[j].compareToIgnoreCase(palabras[j + 1]) > 0) {

                    temp = palabras[j];
                    palabras[j] = palabras[j + 1];
                    palabras[j + 1] = temp;
                }
            }
        }
    }


    public static void ordenamientoMezcla(String[] palabras, int inicio, int fin) {

        if (inicio < fin) {

            int medio = inicio + (fin - inicio) / 2;

            // Se ordena recursivamente la mitad izquierda.
            ordenamientoMezcla(palabras, inicio, medio);

            // Se ordena recursivamente la mitad derecha.
            ordenamientoMezcla(palabras, medio + 1, fin);

            // Se combinan las dos mitades ordenadas.
            mezclar(palabras, inicio, medio, fin);
        }
    }


    public static void mezclar(String[] palabras, int inicio, int medio, int fin) {
        /*
        * Ordenamiento por mezcla (Merge Sort):
        * Utiliza la técnica de divide y vencerás. Divide recursivamente
        * el arreglo en dos mitades hasta obtener elementos individuales
        * y luego combina las partes en orden.
        */
        //https://algs4.cs.princeton.edu/22mergesort/

        // Complejidad temporal: O(n log n).
        // El algoritmo divide recursivamente el arreglo en dos mitades,
        // generando aproximadamente log2(n) niveles de división.
        // En cada nivel se procesan n elementos para combinar las mitades.
        // Por lo tanto, la complejidad temporal es O(n log n).

        // Se crea un arreglo auxiliar para almacenar las palabras ordenadas.
        String[] auxiliar = new String[fin - inicio + 1];

        // Se inicializan los índices de ambas mitades y del arreglo auxiliar.
        int i = inicio;
        int j = medio + 1;
        int k = 0;

        // Se comparan las palabras de ambas mitades mientras
        // queden elementos disponibles en las dos.
        while (i <= medio && j <= fin) {

            if (palabras[i].compareToIgnoreCase(palabras[j]) <= 0) {

                auxiliar[k] = palabras[i];
                i++;

            } else {

                auxiliar[k] = palabras[j];
                j++;
            }

            k++;
        }

        // Se copian las palabras restantes de la mitad izquierda.
        while (i <= medio) {
            auxiliar[k] = palabras[i];
            i++;
            k++;
        }

        // Se copian las palabras restantes de la mitad derecha.
        while (j <= fin) {
            auxiliar[k] = palabras[j];
            j++;
            k++;
        }

        // Se copia el arreglo auxiliar ordenado al arreglo original.
        for (int c = 0; c < auxiliar.length; c++) {
            palabras[inicio + c] = auxiliar[c];
        }
    }


    public static void ordenamientoRapido(String[] palabras, int inicio, int fin) {

        /*
        * Ordenamiento rápido (Quick Sort):
        * Utiliza la técnica de divide y vencerás. Selecciona un pivote
        * y reorganiza el arreglo, colocando los elementos menores a su
        * izquierda y los mayores a su derecha. Luego ordena ambas
        * partes recursivamente.
        */
        //https://algs4.cs.princeton.edu/23quicksort/

        // Complejidad temporal:
        // Caso promedio: O(n log n), porque las particiones suelen dividir
        // el arreglo en partes relativamente equilibradas, generando
        // aproximadamente log n niveles y procesando n elementos por nivel.
        // Peor caso: O(n^2), cuando las particiones son muy desiguales.

        // Si la sección tiene más de un elemento, se ordena.
        if (inicio < fin) {

            // Se reorganizan las palabras alrededor de un pivote.
            int posicionPivote = particionar(palabras, inicio, fin);

            // Se ordena recursivamente la parte izquierda.
            ordenamientoRapido(palabras, inicio, posicionPivote - 1);

            // Se ordena recursivamente la parte derecha.
            ordenamientoRapido(palabras, posicionPivote + 1, fin);
        }

    }


    public static int particionar(String[] palabras, int inicio, int fin) {

        // Se selecciona la última palabra como pivote.
        String pivote = palabras[fin];

        // Se inicializa el índice de los elementos menores al pivote.
        int i = inicio - 1;

        // Se recorren las palabras para compararlas con el pivote.
        for (int j = inicio; j < fin; j++) {

            // Si la palabra es menor o igual al pivote,
            // se coloca en la parte izquierda.
            if (palabras[j].compareToIgnoreCase(pivote) <= 0) {

                i++;

                // Se intercambian las palabras.
                String temp = palabras[i];
                palabras[i] = palabras[j];
                palabras[j] = temp;
            }
        }

        // Se coloca el pivote en su posición definitiva.
        String temp = palabras[i + 1];
        palabras[i + 1] = palabras[fin];
        palabras[fin] = temp;

        // Se devuelve la posición definitiva del pivote.
        return i + 1;
    }


    public static int busquedaBinaria(String[] coleccion, String valor) {

        // Complejidad temporal: O(log n).
        // En cada iteración se descarta aproximadamente la mitad
        // del arreglo, reduciendo la cantidad de comparaciones.

        if (coleccion.length == 0) {
            System.out.println("El arreglo está vacío.");
            return -1;
        }

        int izq = 0;
        int der = coleccion.length - 1;
        int pivote = (izq + der) / 2;

        while (coleccion[pivote].compareToIgnoreCase(valor) != 0) {

            if (coleccion[pivote].compareToIgnoreCase(valor) > 0) {
                der = pivote - 1;
            } else {
                izq = pivote + 1;
            }

            if (izq > der) {
                System.out.println("La palabra buscada no está en el arreglo.\n");
                return -1;
            }

            pivote = (izq + der) / 2;
        }

        return pivote;
    }

}
