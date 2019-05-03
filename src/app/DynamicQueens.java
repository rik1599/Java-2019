package app;

import app.dynamicObjects.Board;
import app.lib.SList;

public class DynamicQueens {

    public static final SList<String> BOARD_LIST = new SList<>();

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfSolutions(n));
        System.out.println(listOfAllSolutions(n));
        System.out.println(numberOfCompletions(new Board(n)));
    }

    public static SList<String> listOfAllSolutions(int n) {
        return listOfCompletions(new Board(n));
    }

    public static SList<String> listOfCompletions(Board b) {
        int n = b.size();
        int q = b.queensOn();

        if (q == n) {
            return BOARD_LIST.cons(b.toString());
        } else {
            int i = q + 1; //riga
            SList<String> sol = BOARD_LIST;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    b.addQueen(i, j);
                    sol = sol.append(listOfCompletions(b));
                    b.removeQueen(i, j);
                }
            }
            return sol;
        }
    }

    public static SList<Integer> numberOfSolutions(int n) {
        SList<Integer> il = new SList<>();
        Board b = new Board(n);
        for (int j = n; j >= 1; j = j - 1) {
            int k = numberOfCompletions(b);
            il = il.cons(k);
        }
        return il;
    }

    public static int numberOfCompletions(Board b) {
        int n = b.size();
        int q = b.queensOn();

        if (q == n) {
            return 1;
        } else {
            int i = q + 1; //riga
            int sol = 0;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    b.addQueen(i, j);
                    sol += numberOfCompletions(b);
                    b.removeQueen(i, j);
                }
            }
            return sol;
        }
    }

}