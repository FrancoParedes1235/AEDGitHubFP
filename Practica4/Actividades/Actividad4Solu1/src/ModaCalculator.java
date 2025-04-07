public class ModaCalculator {
    public static void main(String[] args) {
        // Crear un arreglo de ejemplo
        int[] array = {1, 2, 3, 2, 4, 2, 5, 2, 6};
        
        // Calcular la moda utilizando el algoritmo "Moda1"
        int moda = moda1(array);
        
        // Imprimir el resultado
        System.out.println("La moda es: " + moda);
    }

    /**
     * Algoritmo "Moda1" para calcular la moda de un arreglo.
     * Complejidad: O(n^2), donde n es el tamaño del arreglo.
     *
     * @param array el arreglo del cual se desea calcular la moda
     * @return la moda del arreglo
     */
    public static int moda1(int array[]) {
        // Inicializar los índices del rango a analizar
        int first = 0;
        int end = array.length - 1;

        // Si el arreglo tiene un solo elemento, devolver ese elemento
        if (first == end)
            return array[first];

        // Inicializar la moda y la frecuencia máxima
        int moda = array[first];
        int maxfrec = frecuencia(array, first, end, moda);

        // Iterar a través del arreglo a partir del segundo elemento
        for (int i = first + 1; i < end; i++) {
            // Calcular la frecuencia del elemento actual
            int frec = frecuencia(array, i, end, array[i]);
            
            // Si la frecuencia actual es mayor que la máxima, actualizar la moda y la frecuencia máxima
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i];
            }
        }

        // Devolver la moda
        return moda;
    }

    /**
     * Función auxiliar para calcular la frecuencia de un elemento en un rango del arreglo.
     * Complejidad: O(n), donde n es el tamaño del rango.
     *
     * @param array el arreglo a analizar
     * @param first el índice inicial del rango
     * @param end el índice final del rango
     * @param ele el elemento cuya frecuencia se desea calcular
     * @return la frecuencia del elemento en el rango
     */
    private static int frecuencia(int[] array, int first, int end, int ele) {
        // Si el rango es vacío, devolver 0
        if (first > end)
            return 0;
        
        // Inicializar el contador de frecuencia
        int suma = 0;
        
        // Iterar a través del rango y contar las apariciones del elemento
        for (int i = first; i <= end; i++) {
            if (array[i] == ele)
                suma++;
        }
        
        // Devolver la frecuencia
        return suma;
    }
}
