public class ModaFuerzaBruta {

    // Función principal para encontrar la moda
    public static int moda1(int array[]) {
        int first = 0;
        int end = array.length - 1;

        if (first == end) {
            return array[first]; // Si hay un solo elemento, ese es la moda
        }

        int moda = array[first];
        int maxfrec = frecuencia(array, first, end, moda); // Frecuencia inicial

        // Recorre el arreglo desde el segundo elemento
        for (int i = first + 1; i <= end; i++) {
            int frec = frecuencia(array, first, end, array[i]);
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i]; // Actualiza la moda si encuentra una frecuencia mayor
            }
        }

        return moda;
    }

    // Función auxiliar para contar cuántas veces aparece 'ele' entre 'first' y
    // 'end'
    private static int frecuencia(int[] array, int first, int end, int ele) {
        if (first > end) {
            return 0;
        }
        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == ele) {
                suma++;
            }
        }
        return suma;
    }

    // Prueba del método
    public static void main(String[] args) {
        int[] arreglo = { 3, 1, 2, 3, 2, 3, 1, 3, 2 };
        int resultado = moda1(arreglo);
        System.out.println("Moda del arreglo: " + resultado);
    }
}
