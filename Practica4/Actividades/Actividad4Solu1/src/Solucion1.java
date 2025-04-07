import java.util.HashMap;
import java.util.Map;

public class Solucion1 {
    // Método para encontrar la moda en un arreglo de enteros
    public static int moda1(int array[]) {
        if (array.length == 0) {
            throw new IllegalArgumentException("El arreglo está vacío");
        }

        Map<Integer, Integer> frecuencias = new HashMap<>();
        int moda = array[0];
        int maxfrec = 0;

        // Se cuentan las frecuencias de cada elemento
        for (int num : array) {
            int frec = frecuencias.getOrDefault(num, 0) + 1;
            frecuencias.put(num, frec);

            // Se verifica si la nueva frecuencia es mayor que la máxima
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = num;
            }
        }
        return moda; // Se devuelve la moda encontrada
    }
}
