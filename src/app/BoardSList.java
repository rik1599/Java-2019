package app;

public class BoardSList {
    //#region attributi
    public static final BoardSList BOARD_S_LIST = new BoardSList();     // Attributo statico (riferito alla classe)

    private final boolean empty;
    private final Board  first;
    private final BoardSList rest;
    //#endregion

    //#region metodi
    public BoardSList() {
        this.empty = true;
        this.first = new Board(0);
        this.rest = null;
    }

    public BoardSList(Board n, BoardSList s) {
        this.empty = false;
        this.first = n;
        this.rest = s;
    }

    public boolean nullList() {
        return this.empty;
    }

    public Board car() {
        return first;
    }

    public BoardSList cdr() {
        return rest;
    }

    public BoardSList cons(Board b) {
        return new BoardSList(b, this);
    }

    public int length() {
        if (this.nullList()) {
            return 0;
        }
        else {
            return 1 + this.cdr().length();
        }
    }

    public Board listRef(int i) {
        if (i==0) {
            return this.car();
        } else {
            return this.cdr().listRef(i-1);
        }
    }

    public BoardSList append(BoardSList r) {
        if (this.nullList()) {
            return r;
        } else {
            return this.cdr().append(r).cons(this.car());
        }
    }

    public BoardSList reverse() {
        return reverseRec(BOARD_S_LIST);
    }

    private BoardSList reverseRec(BoardSList r) {
        if (this.nullList()) {
            return r;
        } else {
            return this.cdr().reverseRec(r.cons(this.car()));
        }
    }

    @Override
    public String toString() {
        if (empty) {
            return "()";
        } else if (rest.nullList()) {
            return "(" + first + ")";
        } else {
            String v = "(" + first;
            BoardSList q = rest;
            do {
                v = v + ", " + q.car();
                q = q.cdr();
            } while (!q.nullList());
            return v + ")";
        }
    }
    //#endregion
}
