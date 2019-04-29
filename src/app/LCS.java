package app;

import javax.swing.plaf.SliderUI;

public class LCS {
    public static void main(String[] args) {
        System.out.println(llcsDP("ortolanovicentino", "astrolabiobabilonese"));
        System.out.println(allLCS("ortolanovicentino", "astrolabiobabilonese"));
    }

    //#region LLCS
    private static final int UNKNOWN = -1;

    public static int llcs(String u, String v) {
        if (u.equals("") || v.equals("")) {
            return 0;
        } else if (u.charAt(0) == v.charAt(0)) {
            return 1 + llcs(u.substring(1), v.substring(1));
        } else {
            return Math.max(
                    llcs(u.substring(1), v),
                    llcs(u, v.substring(1))
            );
        }
    }

    public static int llcsDyn (String u, String v) {
        int i = u.length();
        int j = v.length();

        int[][] h = new int[i + 1][j + 1];
        for (int x = 0; x <= i; x++) {
            for (int y = 0; y <= j; y++) {
                h[x][y] = UNKNOWN;
            }
        }

        return llcsRec(u, v, h);
    }

    private static int llcsRec(String u, String v, int[][] h) {
        int i = u.length();
        int j = v.length();
        if (h[i][j] == UNKNOWN) {
            if (u.equals("") || v.equals("")) {
                h[i][j] = 0;
            } else if (u.charAt(0) == v.charAt(0)) {
                h[i][j] = 1 + llcsRec(u.substring(1), v.substring(1), h);
            } else {
                h[i][j] = Math.max(
                        llcsRec(u.substring(1), v, h),
                        llcsRec(u, v.substring(1), h)
                );
            }
        }
        return h[i][j];
    }

    public static int llcsDP (String u, String v) {
        int m = u.length();
        int n = v.length();

        int[][] h = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            h[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            h[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (u.charAt(m-i) == v.charAt(n-j)) {
                    h[i][j] = h[i-1][j-1] + 1;
                } else {
                    h[i][j] = Math.max(h[i-1][j], h[i][j-1]);
                }
            }
        }
        return h[m][n];
    }

    //#endregion

    //#region LCS
    public static String lcs(String strA, String strB) {
        int m = strA.length();
        int n = strB.length();

        String[][] h = new String[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            h[0][j] = "";
        }

        for (int i = 1; i <= m; i++) {
            h[i][0] = "";
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (strA.charAt(m-i) == strB.charAt(n-j)) {
                    h[i][j] = strA.charAt(m-i) + h[i-1][j-1];
                } else {
                    h[i][j] = h[i-1][j].length() > h[i][j-1].length() ? h[i-1][j] : h[i][j-1];
                }
            }
        }
        return h[m][n];
    }

    public static SList<String> allLCS(String strA, String strB) {
        int m = strA.length();
        int n = strB.length();

        String[][] h = new String[m + 1][n + 1];

        return allLCSRec(strA, strB, h, 1, 1);
    }

    private static SList<String> allLCSRec(String strA, String strB, String[][] h, int x, int y) {
        return new SList<>();
    }

    /*private static SList<String> allAppend(String u, SList<String> s) {
        if (s.nullList()) {
            return new SList<String>();
        } else {
            return allAppend(u, s.cdr()).cons(u + s.car());
        }
    }

    private static SList<String> allLonger(SList<String> x, SList<String> y) {
        int u = x.car().length();
        int v = y.car().length();
        if (u < v) {
            return y;
        } else if (u > v) {
            return x;
        } else {
            return x.append(y);
        }
    }*/
    //#endregion
}
