package app;

public class DynProg {
    public static void main(String[] args) {
        System.out.println(fib(100));
        System.out.println(manh(2, 3));
    }

    private static final int UNKNOWN = 0;

    //#region fibonacci
    public static long fib(int n) {
        long[] h = new long[n+1];
        for (int i = 0; i < n; i++) {
            h[i] = UNKNOWN;
        }
        return fibR(n, h);
    }

    public static long fibR(int n, long[] h) {
        if (h[n] == UNKNOWN) {
            if (n < 2) {
                h[n] = 1;
            } else {
                h[n] = fibR(n-2, h) + fibR(n-1, h);
            }
        }
        return h[n];
    }
    //#endregion

    //#region manhattan
    public static long manh(int i, int j) {     //versione iterativa con matrice calcolata
        long[][] h = new long[i+1][j+1];

        for (int x = 0; x <= i; x++) {
            h[x][0] = 1;
        }

        for (int y = 0; y <= j; y++) {
            h[0][y] = 1;
        }

        for (int x = 1; x <= i; x++) {
            for (int y = 1; y <= j; y++) {
                h[x][y] = h[x-1][y] + h[x][y-1];
            }
        }
        //return manhR(i, j, h);
        return h[i][j];
    }

    public static long manhR(int i, int j, long[][] h) {        //versione ricorsiva con matrice dei risultati
        if (h[i][j] == UNKNOWN || h[j][i] == UNKNOWN) {         //simmetria
            if ((i == 0) || (j == 0)) {
                h[i][j] = 1;
            } else {
                h[i][j] = manhR(i-1, j, h) + manhR(i, j-1, h);
            }
        }
        return h[i][j];
    }


    //#endregion
}
