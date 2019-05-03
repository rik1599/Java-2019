package app;

import app.lib.SList;
import app.staticObjects.Board;

public class Queens {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(numberOfSolutions(n));
        System.out.println(listOfSolutions(n));
    }

    public static SList<Integer> numberOfSolutions(int n) {
        SList<Integer> il = new SList<>();
        Board b = new Board(n);
        for (int j = n; j >= 1; j--) {
            int k = numberOfCompletitions(b.addQueen(1, j));
            il = il.cons(k);
        }
        return il;
    };

    private static int numberOfCompletitions(Board b) {
        int n = b.size();
        int q = b.queensOn();

        if (q == n) {
            return 1;
        } else {
            int i = q + 1;
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    count += numberOfCompletitions(b.addQueen(i, j));
                }
            }
            return count;
        }
    }

    public static SList<Board> listOfSolutions(int n) {
        return listOfCompletitions(new Board(n));
    }

    private static final SList<Board> NULL_BL = new SList<Board>();

    private static SList<Board> listOfCompletitions(Board b) {
        int n = b.size();
        int q = b.queensOn();

        if (q == n) {
            return NULL_BL.cons(b);
        } else {
            int i = q + 1;
            SList<Board> solutions = NULL_BL;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    solutions = solutions.append(listOfCompletitions(b.addQueen(i, j)));
                }
            }
            return solutions;
        }
    }
}
