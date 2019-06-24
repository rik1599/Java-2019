package app;

public class PreEsame {

    private static final int UNKNOWN = -1;

    //Es 1 12/6/2013
    public static String[] lcsx(String u, String v) {
        int ul = u.length();
        int vl = v.length();
        String[][][] h = new String[ul+1][vl+1][];
        for (int i = 0; i <= ul+1; i++) {
            for (int j = 0; j <= vl+1; j++) {
                h[i][j] = null;
            }
        }
        return lcsxRec(u, v, h);
    }

    private static String[] lcsxRec(String u, String v, String[][][] h) {
        int ul = u.length();
        int vl = v.length();
        if (h[ul][vl] == null) {
            if (u.equals("") && v.equals("")) {
                h[ul][vl] = new String[] {"", ""};
            } else if (u.equals("")) {
                String[] pair = lcsxRec(u, v.substring(1), h);
                h[ul][vl] = new String[] {'_' + pair[0], v.charAt(0) + pair[1]};
            } else if (v.equals("")) {
                String[] pair = lcsxRec(u.substring(1), v, h);
                h[ul][vl] = new String[] {u.charAt(0) + pair[0], '_' + pair[1]};
            } else if (u.charAt(0) == v.charAt(0)) {
                String[] pair = lcsxRec(u.substring(1), v.substring(1), h);
                h[ul][vl] = new String[] {u.charAt(0) + pair[0], v.charAt(0) + pair[1]};
            } else {
                String[] pair1 = lcsxRec(u.substring(1), v, h);
                String[] pair2 = lcsxRec(u, v.substring(1), h);
                h[ul][vl] = better(
                        new String[] {u.charAt(0) + pair1[0], '_' + pair1[1]},
                        new String[] {'_' + pair2[0], v.charAt(0) + pair2[1]}
                );
            }
        }
        return h[ul][vl];
    }

    private static String[] better(String[] pair1, String[] pair2) {
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < pair1[0].length(); i++) {
            if (pair1[0].charAt(i) == pair1[1].charAt(i)) {
                n1++;
            }
        }
        for (int i = 0; i < pair2[0].length(); i++) {
            if (pair2[0].charAt(i) == pair2[1].charAt(i)) {
                n2++;
            }
        }
        if (n1 < n2) {
            return pair2;
        } else if (n1 > n2) {
            return pair1;
        } else if (Math.random() < 0.5) {
            return pair2;
        } else {
            return pair1;
        }
    }

    // Es 4 13/6/2011
    public static long f(int x, int y) {
        long[][] h =  new long[x+1][];
        for (int i = 0; i <=x; i++) {
            h[i] = new long[x+y+1-i];
            h[i][0] = 0;    // y < 2
            h[i][1] = i;
        }

        for (int i = 2; i <= x + y; i++) {
            h[0][i] = 0;    // x = 0;
        }

        for (int i = 2; i <= x + y - 1; i++) {
            h[1][i] = i;    // x = 1;
        }

        for (int i = 2; i <= x; i++) {
            for (int j = 2; j <= x + y - i; j++) {
                h[i][j] = h[i][j-1] + h[i-2][j] + h[i-1][j+1];
            }
        }

        return h[x][y];
    }

    // Es 2 13/6/2016
    public static long q(int i, int j, String x) {
        int u = x.length();
        long[][][] h = new long[i+1][j+1][u+1];
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l <= j; l++) {
                for (int m = 0; m <=u; m++) {
                    h[k][l][m] = UNKNOWN;
                }
            }
        }
        return qRec(i, j, x, h);
    }

    public static long qRec(int i, int j, String x, long[][][] h) {
        int u = x.length();
        if (h[i][j][u] == UNKNOWN) {
            if (i+j < u) {
                h[i][j][u] = 0;
            } else if (i+j == 0) {
                h[i][j][u] = 1;
            } else {
                long k = 0;
                if (i > 0) {
                    if ((u > 0) && (x.charAt(0) == '0')) {
                        k = k + qRec(i-1, j, x.substring(1), h);
                    } else {
                        k = k + qRec(i-1, j, x, h);
                    } }
                if (j > 0) {
                    if ((u > 0) && (x.charAt(0) == '1')) {
                        k = k + qRec(i, j-1, x.substring(1), h);
                    } else {
                        k = k + qRec(i, j-1, x, h);
                    } }
                h[i][j][u] = k;
            }
        }
        return h[i][j][u];
    }

    public static int q( int[] s ) { // s.length > 0
        int n = s.length;
        int[] t = new int[ n ]; t[0] = s[0];
        for ( int k=1; k<n; k=k+1 ) {
            int i=k-1;
            while ( (i >= 0) && (t[i] > s[k]) ) {
                t[i+1] = t[i]; i = i - 1;
            }
            t[i+1] = s[k];
        }
        int[][] h = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                h[i][j]=UNKNOWN;
            }
        }
        return qRec( s, t, n, 0, 0, h);
    }

    private static int qRec( int[] s, int[] t, int n, int i, int j, int[][] h) {
        if(h[i][j] == UNKNOWN){
            if ((i == n) || (j == n)) {
                h[i][j] = 0;
            } else if (s[i] == t[j]) {
                h[i][j] = 1 + qRec(s, t, n, i + 1, j + 1, h);
            } else {
                h[i][j] = Math.max(qRec(s, t, n, i + 1, j, h), qRec(s, t, n, i, j + 1, h));
            }
        }
        return h[i][j];
    }

}
