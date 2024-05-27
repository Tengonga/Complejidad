public class BusquedaBinaria1 {
    public static void main(String[] args) {
        // Definimos las dimensiones de la matriz aleatoria que vamos a crear
        int m = 3; //filas
        int n = 3; //columnas

        // Creamos una matriz ordenada de tamaño nxm
        int[][] miMatrix2 = generarMatrizOrdenada(m, n);

        //valor a buscar en las matrices
        int valor = 9;

        // Imprimimos la matriz generada
        System.out.println("Matriz generada:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(miMatrix2[i][j] + " ");
            }
            System.out.println();
        }

        // Realizamos la búsqueda binaria
        int[] resultado = binaryMatSearch(miMatrix2, valor);

        // Imprimimos el resultado de la búsqueda
        if (resultado[0] != -1) {
            System.out.println("Valor encontrado en la posición: (" + resultado[0] + ", " + resultado[1] + ")");
        } else {
            System.out.println("Valor no encontrado en la matriz.");
        }

    }


    //Función de busqueda binaria
    public static int[] binaryMatSearch(int[][] miMatrix2, int valor) {
        // Obtener número de filas y columnas
        int numFilas = miMatrix2.length;
        int numColumnas = miMatrix2[0].length;

        // Índices de inicio y fin para la búsqueda binaria
        int indexIni = 0;
        int indexFin = numFilas * numColumnas - 1;

        // Realizar la búsqueda binaria
        while (indexIni <= indexFin) {
            int midIndex = indexIni + (indexFin - indexIni) / 2;

            // Obtener la posición bidimensional desde el índice unidimensional
            int fila = midIndex / numColumnas;
            int columna = midIndex % numColumnas;
            int midValue = miMatrix2[fila][columna];

            // Verificar si se encontró el valor
            if (midValue == valor) {
                return new int[]{fila, columna}; // Devolver la posición del valor encontrado
            } else if (midValue < valor) {
                indexIni = midIndex + 1; // Ajustar el índice inicial para descartar la mitad inferior
            } else {
                indexFin = midIndex - 1; // Ajustar el índice final para descartar la mitad superior
            }
        }
        // Si no se encuentra el valor, devolver [-1, -1]
        return new int[]{-1, -1};
    }

    // Función para generar una matriz ordenada de tamaño mxn
    public static int[][] generarMatrizOrdenada(int m, int n) {
        var rand = (int)(Math.random()*9);
        int[][] matrix = new int[m][n];
        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value += rand+1; // Inc. aleatorio entre 1 y 10
                matrix[i][j] = value;
            }
        }
        return matrix;

    }
}
