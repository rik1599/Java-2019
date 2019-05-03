package app.dynamicObjects;

/**
 * Board b = new Board(n)
 * b.size()                     -> int
 * b.queensOn()                 -> int
 * b.underAttack(int i, int j)  -> boolean
 * b.addQueen(int i, int j)     -> Queens
 * b.arrangement()              -> String
 */

public class Board {
    
    /*
        row, col     array size = board size
        diag1, diag2 array size = 2(board size) -1
        *diag1 (i-j), diag2 (i+j)

        row[i], col[i], diag1[i], diag2[i]:
             = 1 --> yes under attack
             = 0 --> not under attack

        from board to 
            - row col --> i - 1, j - 1
            - diag1 --> i - j + n -1
            - diag2 --> i + j - 2
    */

    private static final String COL = " abcdefghijklmno";
    private static final String ROW = " 123456789ABCDEF";

    private final int size;
    private int queens;

    private int[] row, col, diag1, diag2;

    private String config;

    public Board(int n) {
        size = n;
        queens = 0;
        row = new int[n];
        col = new int[n];
        diag1 = new int[2*n-1];
        diag2 = new int[2*n-1];
        config = " ";
    }

    public void addQueen(int i, int j)
    {
        int n = size;
        queens ++;
        row[i-1] ++;
        col[j-1] ++;
        diag1[i-j+n-1] ++;
        diag2[i+j-2] ++;
        config = config + COL.charAt(j) + ROW.charAt(i) + " ";
    }

    public void removeQueen(int i, int j)
    {
        int n = size;
        queens--;
        row[i-1]--;
        col[j-1]--;
        diag1[i-j+n-1]--;
        diag2[i+j-2]--;

        String queen = "" + COL.charAt(j) + ROW.charAt(i);
        int k = config.indexOf(queen);
        config = config.substring(0, k) + config.substring(k+3);
    }

    public int size() {
        return size;
    }

    public int queensOn() {
        return queens;
    }

    public boolean underAttack(int i, int j) {
        int n = size;
        return ((row[i-1] > 0) || (col[j-1] > 0) || (diag1[i-j+n-1] > 0) || (diag2[i+j-2] > 0));        
    }

    public String arrangement() {
        return config;
    }

    @Override
    public String toString() {
        return "[" + arrangement() + "]";
    }
}