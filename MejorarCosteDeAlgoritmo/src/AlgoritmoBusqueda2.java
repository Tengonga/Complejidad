public class AlgoritmoBusqueda2 {
    public static void main(String[] args) {

        // Definimos las dimensiones de la matriz aleatoria que vamos a crear
        int m = 4; //filas
        int n = 3; //columnas

        // Creamos una matriz ordenada de tamaño nxm
        int[][] miMatrix2 = generarMatrizOrdenada(m, n);

        //valor a buscar en las matrices
        int valor = 10;

        // Llamada al método de búsqueda
        int[] resultado = buscarValor(miMatrix2, valor);

        // Imprimir resultados
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(miMatrix2[i][j] + " ");
            }
            System.out.println(",");
        }
        // Imprimir resultados
        System.out.printf("%-15s %-8s %-12s %-12s\n", "Descripcion", "Talla", "Iteraciones", "Resultado");
        if (resultado[0] != -1 && resultado[1] != -1) {
            System.out.printf("%-15s  %dx%d     %-12d  %-12s\n", "buscarValor", m, n, resultado[2], "[" + resultado[0] + "][" + resultado[1] + "]");
        } else {
            System.out.printf("%-15s  %dx%d     %-12d  %-12s\n", "buscarValor", m, n, resultado[2], "[-1][-1]");
        }
    }

    //Metodo Para buscar el elemento en matriz
    public static int[] buscarValor(int[][] miMatrix2, int valor){
        int counter = 0;
        int[] result = { -1, -1, counter }; //Valores por defecto del resultado
        int x = miMatrix2.length; // filas
        int y = miMatrix2[0].length; // columnas

        for(int fila = 0 ; fila < x ; fila++){
            for(int col=0 ; col < y ; col++){
                counter++;
                if (miMatrix2[fila][col] == valor){
                    result[0] = fila;
                    result[1] = col;
                    result[2] = counter; // Guardamos el número total de iteraciones
                }
            }
        }
        return result;
    }
    // Función para generar una matriz ordenada de tamaño mxn
    public static int[][] generarMatrizOrdenada(int m, int n) {
        var rand = (int)(Math.random()*10);
        int[][] matrix = new int[m][n];
        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value += rand +1; // Inc. aleatorio entre 1 y 10
                matrix[i][j] = value;
            }
        }
        return matrix;

    }


}
