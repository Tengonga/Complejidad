import java.util.Random;

public class AlgoritmoBusqueda21 {
    public static void main(String[] args) {

        // Definimos las dimensiones de la matriz aleatoria que vamos a crear
        int m = 10; //filas
        int n = 10; //columnas

        // Creamos una matriz ordenada de tamaño nxm
        int[][] miMatrix2 = generarMatrizOrdenada(m, n);

        //valor a buscar en las matrices
        int valor = 3;

        // Llamada al método de búsqueda
        int[] resultado = buscarValor(miMatrix2, valor);

        // Imprimimos la matriz generada
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(miMatrix2[i][j] + " ");
            }
            System.out.println();
        }
        // Imprimir resultados
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-15s %-8s %-12s %-12s\n", "Descripcion", "Talla", "Iteraciones", "Resultado");
        if (resultado[0] != -1 && resultado[1] != -1) {
            System.out.printf("%-15s  %dx%d     %-12d  %-12s\n", "Valor2: "+valor, m, n, resultado[2], "[" + resultado[0] + "][" + resultado[1] + "]");
        } else {
            System.out.printf("%-15s  %dx%d     %-12d  %-12s\n", "Valor2: "+valor, m, n, resultado[2], "[-1][-1]");
        }
        /*VALOR PROMEDIO ITERACIONES*/
        // Calcular el promedio de iteraciones para buscar todos los valores de la matriz
        int sumarIteracion = 0;
        int numValores = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                resultado = buscarValor(miMatrix2, miMatrix2[i][j]);
                sumarIteracion += resultado[2];
            }
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%s;%d;%s\n", "Promedio Iteraciones", sumarIteracion / ((numValores)-1), "");
        System.out.println("------------------------------------------------------------");
    }

    //Metodo Para buscar el elemento en matriz
    public static int[] buscarValor(int[][] miMatrix2, int valor){
        int counter = 0;
        int[] result = { -1, -1, counter }; //Valores por defecto del resultado
        int x = miMatrix2.length; // filas
        int y = miMatrix2[0].length; // columnas

        for(int fila = 0 ; fila < x ; fila++){
            for(int col=0 ; col < y ; col++){
                result[2]++; // Guardamos el número total de iteraciones++;
                if (miMatrix2[fila][col] == valor){
                    result[0] = fila;
                    result[1] = col;
                    return result;
                }
            }
        }
        return result;
    }
    // Función para generar una matriz ordenada de tamaño mxn
    public static int[][] generarMatrizOrdenada(int m, int n) {
        Random rand = new Random();
        int[][] matrix = new int[m][n];
        int value = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                value +=rand.nextInt(9)+1; //Inc. aleatorio entre 1 y 10
                matrix[i][j] = value;
            }
        }
        return matrix;

    }
}
