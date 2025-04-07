public static int moda2(int array[]) {
    int first = 0; // Índice del primer elemento del arreglo
    int p = 0; // Índice para el elemento actual en el proceso de búsqueda
    int end = array.length - 1; // Índice del último elemento del arreglo
    int moda = array[0]; // Moda inicialmente es el primer elemento
    int frec = 1; // Frecuencia del elemento actual
    int maxfrec = 0; // Frecuencia máxima encontrada

    // Se recorre el arreglo hasta que se llegue al final
    while (first <= end) {
        // Si el elemento actual es igual al elemento en la posición 'first', se
        // incrementa la frecuencia
        if (array[p] == array[first]) {
            frec++; // Incrementa la frecuencia
            first++; // Mueve el índice al siguiente elemento
        } else {
            // Si la frecuencia actual es mayor que la frecuencia máxima encontrada hasta
            // ahora,
            // se actualiza la moda y la frecuencia máxima
            if (frec > maxfrec) {
                maxfrec = frec; // Actualiza la frecuencia máxima
                moda = array[p]; // Actualiza la moda
            }
            // Se actualiza el índice 'p' al siguiente elemento y se reinicia la frecuencia
            p = first; // 'p' apunta al siguiente elemento
            first = p + 1; // Mueve 'first' al siguiente elemento
            frec = 1; // Reinicia la frecuencia a 1
        }
    }
    return moda; // Se devuelve la moda encontrada
}
