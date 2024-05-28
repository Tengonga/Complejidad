import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.io.FileNotFoundException;

public class CosteBusLineal {
    public static void main(String[] args) {

        final int INIT_SIZE = 100000; // Talla inicial
        final int MAX_SIZE = 1000000; // Talla final
        final int STEP = 100000; // A cada medida, incrementamos la talla en STEP
        final int REPS = 1000; // / Repeticiones para una media más fiable
        int size;
        PrintStream csvPrintStream = null;

        // Intentar abrir el archivo de salida CSV
        try {
            csvPrintStream = new PrintStream(new FileOutputStream("output.csv"));
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo abrir archivo CSV: " + e.getMessage());
        }
        // Encabezados de las columnas
        if (csvPrintStream != null) {
            csvPrintStream.printf("%10s;%10s;%10s;%10s\n", "Talla", "Mejor", "Peor", "Promedio");
        }
        System.out.printf("%10s;%10s;%10s;%10s\n", "Talla", "Mejor", "Peor", "Promedio");

        for (size = INIT_SIZE; size <= MAX_SIZE; size += STEP) {
            int[] array = generarArrayOrdenado(size);
            int arraySize = array.length;

            // Caso mejor: el valor está en la primera posición
            int vBest = array[0];
            long timeStart = System.nanoTime();
            for (int rep = 0; rep < REPS; rep++) {
                int[] result = linealSearchIterative(array, vBest);
            }
            long timeEnd = System.nanoTime();
            long tBest = (timeEnd - timeStart) / REPS;

            // Caso peor: el valor está en la última posición
            int vWorst = array[arraySize - 1];
            timeStart = System.nanoTime();
            for (int rep = 0; rep < REPS; rep++) {
                int[] result = linealSearchIterative(array, vWorst);
            }
            timeEnd = System.nanoTime();
            long tWorst = (timeEnd - timeStart) / REPS;

            // Caso promedio: buscar valores aleatorios
            Random rand = new Random();
            long totalAvrTime = 0;
            for (int rep = 0; rep < REPS; rep++) {
                int randomValue = array[rand.nextInt(arraySize)];
                timeStart = System.nanoTime();
                int[] result = linealSearchIterative(array, randomValue);
                timeEnd = System.nanoTime();
                totalAvrTime += (timeEnd - timeStart);
            }
            long tAvr = totalAvrTime / REPS;

            // Imprimir resultados
            if (csvPrintStream != null) {
                csvPrintStream.printf("%10d;%10d;%10d;%10d\n", size, tBest, tWorst, tAvr);
            }
            System.out.printf("%10d;%10d;%10d;%10d\n", size, tBest, tWorst, tAvr);
        }
        // Cerrar el archivo CSV
        if (csvPrintStream != null) {
            csvPrintStream.close();
    }

        // Implementación del algoritmo de búsqueda lineal en un array
        System.out.println("------------------------------------------------------------");
        int valorArray = 1000;
        int[] array = generarArrayOrdenado(1000); // Crear un array para la búsqueda de ejemplo
        int[] resultadoArray = linealSearchIterative(array, valorArray);
        if (resultadoArray[0] != -1) {
            System.out.printf("Valor a buscar: %d encontrado en la posición %d después de %d iteraciones\n",
                    valorArray, resultadoArray[0], resultadoArray[1]);
        } else {
            System.out.printf("Valor a buscar: %d no encontrado después de %d iteraciones\n",
                    valorArray, resultadoArray[1]);
        }
        System.out.println("------------------------------------------------------------");
    }

    //Generar un array
    public static int[] generarArrayOrdenado(int size) {
        Random rand = new Random();
        int[] Array = new int[size];
        int value = 0;
            for (int j = 0; j < size; j++) {
                value += rand.nextInt(9) + 1; // Inc. aleatorio entre 1 y 10
                Array[j] = value;
            }
        return Array;
    }

    // Implementación del algoritmo de búsqueda lineal en un array
    public static int[] linealSearchIterative(int[] array, int valor) {
        int pos = -1;
        int iterations = 0;
        boolean encontrado = false;
        for (int i = 0; i < array.length && !encontrado; i++) {
            iterations++;
            if (valor == array[i]) {
                pos = i;
                encontrado = true;
            }
        }
        return new int[]{pos, iterations};
    }
}
