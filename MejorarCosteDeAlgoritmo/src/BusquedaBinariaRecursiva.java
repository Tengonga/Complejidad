public class BusquedaBinariaRecursiva {
    public static void main(String[] args) {
        // Definimos las dimensiones de la matriz aleatoria que vamos a crear
        int m = 3; // filas
        int n = 3; // columnas

        // Creamos una matriz ordenada de tamaño mxn
        int[][] miMatrix2 = generarMatrizOrdenada(m, n);

        // Imprimimos la matriz generada
        System.out.println("Matriz generada:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(miMatrix2[i][j] + " ");
            }
            System.out.println();
        }

        // Valor a buscar en la matriz
        int valor = 20;

        // Realizamos la búsqueda binaria
        int[] resultado = binaryMatSearch(miMatrix2, valor, 0, m * n - 1,0);

        // Imprimimos el resultado de la búsqueda recursiva
        if (resultado[0] != -1) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Valor "+valor+" encontrado en la posición: (" + resultado[0] + ", " + resultado[1] + ")"+" tras "+resultado[2]+" iteraciones");
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Valor "+valor+"  no encontrado en la matriz tras "+resultado[2]+" iteraciones");
            System.out.println("------------------------------------------------------------");
        }
    }

    // Función de búsqueda binaria recursiva en la matriz
    public static int[] binaryMatSearch(int[][] matrix, int valor, int indexIni, int indexFin, int iteraciones) {
        int numColumnas = matrix[0].length;
        int midIndex = indexIni + (indexFin - indexIni) / 2;
        int fila = midIndex / numColumnas;
        int columna = midIndex % numColumnas;
        int midValue = matrix[fila][columna];

        // Incrementar el contador de iteraciones
        iteraciones++;

        // Caso base: valor no encontrado o encontrado a la primera.
        if (indexIni > indexFin) {
            return new int[]{-1, -1, iteraciones};
        }

        if (midValue == valor) {
            return new int[]{fila, columna, iteraciones}; // Valor encontrado
        }else if (midValue < valor) {// Caso General
            return binaryMatSearch(matrix, valor, midIndex + 1, indexFin, iteraciones); // Buscar en la mitad derecha
        } else {
            return binaryMatSearch(matrix, valor, indexIni, midIndex - 1, iteraciones); // Buscar en la mitad izquierda
        }
    }

    // Función para generar una matriz ordenada de tamaño mxn
    public static int[][] generarMatrizOrdenada(int m, int n) {
        int[][] matrix = new int[m][n];
        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value += (int)(Math.random() * 10) + 1; // Incremento aleatorio entre 1 y 10
                matrix[i][j] = value;
            }
        }
        return matrix;
    }
}
