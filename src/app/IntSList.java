package app;

/**
 * IntSList s = new IntSList();   (list)
 *
 * s.nullList()     -> boolean    (null? s)
 * s.car()          -> int        (car s)
 * s.cdr()          -> IntSList   (cdr s)
 * s.cons(int n)    -> IntSList   (cons s n)
 */
public class IntSList {

    //#region attributi
    public static final IntSList NULL_INTLIST = new IntSList();     // Attributo statico (riferito alla classe)

    private final boolean empty;
    private final int  first;
    private final IntSList rest;
    //#endregion

    //#region metodi
    public IntSList() {
        this.empty = true;
        this.first = 0;
        this.rest = null;
    }

    public IntSList(int n, IntSList s) {
        this.empty = false;
        this.first = n;
        this.rest = s;
    }

    public boolean nullList() {
        return this.empty;
    }

    public int car() {
        return this.first;
    }

    public IntSList cdr() {
        return rest;
    }

    public IntSList cons(int n) {
        return new IntSList(n, this);
    }

    public String toString() {
        if (empty) {
            return "()";
        } else if (rest.nullList()) {
            return "(" + first + ")";
        } else {
            String v = "(" + first;
            IntSList q = rest;
            do {
                v = v + ", " + q.car();
                q = q.cdr();
            } while (!q.nullList());
            return v + ")";
        }
    }
    //#endregion
}