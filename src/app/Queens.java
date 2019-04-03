package app;

public class Queens {
    public static void main(String[] args) {
        System.out.println(numberOfSolutions(12));
    }

    public static int numberOfSolutions(int n) {
        return numberOfCompletitions(new Board(n));
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

    private static final BoardSList NULL_BL = new BoardSList();

    private static BoardSList listOfCompletitions(Board b) {
        int n = b.size();
        int q = b.queensOn();

        if (q == n) {
            NULL_BL.cons(b);
        } else {
            int i = q + 1;
            BoardSList solutions = NULL_BL;
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    solutions = solutions.append(listOfCompletitions(b.addQueen(i, j)));
                }
            }
            return solutions;
        }
    }
}
