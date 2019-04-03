package app;

/**
 * Board b = new Board(n)
 * b.size()                     -> int
 * b.queensOn()                 -> int
 * b.underAttack(int i, int j)  -> boolean
 * b.addQueen(int i, int j)     -> Queens
 * b.arrangement()              -> String
 */

public class Board {
    public Board(int n) {

    }

    public int size() {
        return 0;
    }

    public int queensOn() {
        return 0;
    }

    public boolean underAttack(int i, int j) {
        return false;
    }

    public Board addQueen(int i, int j) {
        return new Board(i+j);
    }
}
