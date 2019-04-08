package app;

import java.util.function.BiPredicate;

/**
 * Board b = new Board(n)
 * b.size()                     -> int
 * b.queensOn()                 -> int
 * b.underAttack(int i, int j)  -> boolean
 * b.addQueen(int i, int j)     -> Queens
 * b.arrangement()              -> String
 */

public class Board {

    private static final String COL = " abcdefghijklmno";
    private static final String ROW = " 123456789ABCDEF";

    private int size;
    private int queens;

    //Funzione booleana di due interi
    private BiPredicate<Integer, Integer> threat;

    private String config;

    public Board(int n) {
        size = n;
        queens = 0;
        threat = (u, v) -> false;     // (lambda (u v) false)
        config = " ";
    }

    private Board(Board b, int i, int j) {
        size = b.size();
        queens = b.queensOn() + 1;
        threat = (u, v) -> ( (u == i) || (v == j) || (u-v == i-j) || (u+v == i+j) || b.underAttack(u, v) );
        config = b.arrangement() + COL.charAt(j) + ROW.charAt(i) + " ";
    }

    public int size() {
        return size;
    }

    public int queensOn() {
        return queens;
    }

    public boolean underAttack(int i, int j) {
        return threat.test(i, j);   // (threat i j)
    }

    public Board addQueen(int i, int j) {
        return new Board(this, i, j);
    }

    public String arrangement() {
        return config;
    }

    @Override
    public String toString() {
        return "[" + arrangement() + "]";
    }
}
