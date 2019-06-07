package app;

public class PreEsame {

    private static final int UNKNOWN = -1;
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
