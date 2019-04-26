package app;

public class LCS {
    public static void main(String[] args) {
        System.out.println(llcsDyn("ortolanovicentino", "astrolabiobabilonese"));
        System.out.println(llcsDP("ortolanovicentino", "astrolabiobabilonese"));
    }

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

}
