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
        int valor = 9;

        // Realizamos la búsqueda binaria
        int[] resultado = binaryMatSearch(miMatrix2, valor, 0, m * n - 1);

        // Imprimimos el resultado de la búsqueda
        if (resultado[0] != -1) {
            System.out.println("Valor encontrado en la posición: (" + resultado[0] + ", " + resultado[1] + ")");
        } else {
            System.out.println("Valor no encontrado en la matriz.");
        }
    }

    // Función de búsqueda binaria recursiva en la matriz
    public static int[] binaryMatSearch(int[][] matrix, int valor, int indexIni, int indexFin) {
        // Caso base: valor no encontrado o encontrado a la primera.
        if (indexIni > indexFin) {
            return new int[]{-1, -1};
        }

        int numColumnas = matrix[0].length;
        int midIndex = indexIni + (indexFin - indexIni) / 2;
        int fila = midIndex / numColumnas;
        int columna = midIndex % numColumnas;
        int midValue = matrix[fila][columna];

        if (midValue == valor) {
            return new int[]{fila, columna}; // Valor encontrado
        }else if (midValue < valor) {// Caso General
            return binaryMatSearch(matrix, valor, midIndex + 1, indexFin); // Buscar en la mitad derecha
        } else {
            return binaryMatSearch(matrix, valor, indexIni, midIndex - 1); // Buscar en la mitad izquierda
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
