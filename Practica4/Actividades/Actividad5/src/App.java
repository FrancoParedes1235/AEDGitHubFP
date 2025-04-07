public class dpSolution {
    static int getValue(int[] values, int rodLength) {
        // Crear un arreglo para almacenar las soluciones de los subproblemas
        int[] subSolutions = new int[rodLength + 1];

        // Inicializar el primer elemento del arreglo en 0
        subSolutions[0] = 0;

        // Calcular las soluciones de los subproblemas
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            for (int j = 0; j < i; j++) {
                // Calcular el máximo valor entre vender la pieza de longitud j
                // y el valor de la solución del subproblema de longitud i-j-1
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            }
            subSolutions[i] = tmpMax;
        }

        // Devolver el valor máximo para la longitud de la varilla
        return subSolutions[rodLength];
    }

    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length;
        System.out.println("El valor máximo: " + getValue(values, rodLength));
    }
}
