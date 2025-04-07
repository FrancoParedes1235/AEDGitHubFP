public class naiveSolution {
    // Método para obtener el valor máximo posible al cortar la varilla
    static int getValue(int[] values, int length) {
        if (length <= 0)
            return 0; // Caso base: si la longitud es 0 o negativa, el valor máximo es 0
        int tmpMax = -1; // Inicializa el valor temporal máximo como -1
        for (int i = 0; i < length; i++) {
            // Calcula el máximo entre el valor actual y la suma del valor actual y la solución recursiva para la varilla restante
            tmpMax = Math.max(tmpMax, values[i] + getValue(values, length - i - 1));
        }
        return tmpMax; // Devuelve el valor máximo posible al cortar la varilla de longitud dada
    }

    public static void main(String[] args) {
        int[] values = new int[] { 3, 7, 1, 3, 9 }; // Valores asociados a cortes de varilla de diferentes longitudes
        int rodLength = values.length; // Longitud de la varilla
        System.out.println("El valor máximo: " + getValue(values, rodLength)); // Imprime el valor máximo posible al cortar la varilla
    }
}
