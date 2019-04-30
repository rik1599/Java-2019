package app.lib;

/**
 * IntSList s = new IntSList();   (list)
 *
 * s.nullList()     -> boolean    (null? s)
 * s.car()          -> int        (car s)
 * s.cdr()          -> IntSList   (cdr s)
 * s.cons(int n)    -> IntSList   (cons s n)
 *
 * s.length()               -> int          (length s)
 * s.listRef(int i)         -> int          (list-ref s i)
 * s.append(IntSList r)     -> IntSList     (append s r)
 * s.reverse()              -> IntSList     (reverse s)
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

    public int length() {
        if (this.nullList()) {
            return 0;
        }
        else {
            return 1 + this.cdr().length();
        }
    }

    public int listRef(int i) {
        if (i==0) {
            return this.car();
        } else {
            return this.cdr().listRef(i-1);
        }
    }

    public IntSList append(IntSList r) {
        if (this.nullList()) {
            return r;
        } else {
            return this.cdr().append(r).cons(this.car());
        }
    }

    public IntSList reverse() {
        return reverseRec(NULL_INTLIST);
    }

    private IntSList reverseRec(IntSList r) {
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
            IntSList q = rest;
            do {
                v = v + ", " + q.car();
                q = q.cdr();
            } while (!q.nullList());
            return v + ")";
        }
    }
    
    public boolean equals( IntSList il ) {   // contronto di liste
                                           // Scheme: equal?
    if ( nullList() || il.nullList() ) {
      return ( nullList() && il.nullList() );
    } else if ( car() == il.car() ) {
      return cdr().equals( il.cdr() );
    } else {
      return false;
    }
  }
    //#endregion
}
