public class CostosDeViaje {

    // Define un valor que representa el infinito, asegurándose de que no cause
    // desbordamiento
    private static final int INF = 1000000000;

    public static void floydWarshall(int[][] T, int n) {
        // C es la matriz de costos donde almacenamos los costos mínimos
        int[][] C = new int[n][n];

        // Inicialización de la matriz C con los valores de T
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    C[i][j] = 0; // El costo de ir del embarcadero a sí mismo es 0
                } else if (T[i][j] == Integer.MAX_VALUE) {
                    C[i][j] = INF; // Si no hay tarifa directa, lo representamos como infinito
                } else {
                    C[i][j] = T[i][j]; // Usamos el costo directo desde T
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Evitar desbordamiento al sumar INF
                    if (C[i][k] != INF && C[k][j] != INF && C[i][j] > C[i][k] + C[k][j]) {
                        C[i][j] = C[i][k] + C[k][j]; // Actualizamos con el camino más corto
                    }
                }
            }
        }

        // Imprimir la matriz de costos
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (C[i][j] == INF) {
                    System.out.print("∞ "); // Representamos el infinito como ∞
                } else {
                    System.out.print(C[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de la tabla de tarifas (matriz T)
        int[][] T = {
                { 0, 2, 5, 9, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE, 6 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1, 4 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 7 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 }
        };

        int n = T.length;

        // Llamar al algoritmo de Floyd-Warshall para encontrar los costos mínimos
        floydWarshall(T, n);
    }
}
