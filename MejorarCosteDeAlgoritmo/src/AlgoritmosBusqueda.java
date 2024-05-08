
public class AlgoritmosBusqueda {
    public static void main(String[] args) {
        /*Defino la matriz*/
        int[][] miMatrix = {{8,2,4 },
                           { 5,7,3 },
                           { 6,0,9 }};

        //valor a buscar en las matrices
        int valor = 3;

        // Llamada al método de búsqueda
        int[] resultado = buscarValor(miMatrix, valor);

        /*Imprimir resultados*/
        if (resultado[0]!=-1 && resultado[1]!=-1){
            System.out.print("El elemento " + valor + " se encuentra en la posición [" + resultado[0] + "][" + resultado[1] + "] con " + resultado[2] + " iteraciones.");
        }else {
            System.out.println("El elemento " + valor + " no se encuentra en la Matriz");
            System.out.println("Se encuentra en la posición [" + resultado[0] + "][" + resultado[1] + "] con " + resultado[2] + " iteraciones.");
        }
    }
    //Metodo Para buscar el elemento en matriz
    public static int[] buscarValor(int[][] miMatrix, int valor){
        int counter = 0;
        int[] result = { -1, -1, counter }; //Valores por defecto del resultado
        int x = miMatrix.length; // filas
        int y = miMatrix[0].length; // columnas

        for(int fila = 0 ; fila < x ; fila++){
            for(int col=0 ; col < y ; col++){
                counter++;
                if (miMatrix[fila][col] == valor){
                    result[0] = fila;
                    result[1] = col;
                    result[2] = counter; // Guardamos el número total de iteraciones
                }
            }
        }
        return result;
    }
}
