public class CostosDeViaje {

    private static final int INF = 1000000000;

    public static void floydWarshall(int[][] T, int n) {
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    C[i][j] = 0;
                } else if (T[i][j] == Integer.MAX_VALUE) {
                    C[i][j] = INF;
                } else {
                    C[i][j] = T[i][j]; 
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (C[i][k] != INF && C[k][j] != INF && C[i][j] > C[i][k] + C[k][j]) {
                        C[i][j] = C[i][k] + C[k][j];
                    }
                }
            }
        }

        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (C[i][j] == INF) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(C[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] T = {
                { 0, 2, 5, 9, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE, 6 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1, 4 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 7 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 }
        };

        int n = T.length;

        floydWarshall(T, n);
    }
}
