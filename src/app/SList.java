package app;

public class SList<T> {

    //#region attributi
    private final boolean empty;
    private final T first;
    private final SList<T> rest;
    //#endregion

    //#region metodi
    public SList() {
        this.empty = true;
        this.first = null;
        this.rest = null;
    }

    public SList(T e, SList<T> s) {
        this.empty = false;
        this.first = e;
        this.rest = s;
    }

    public boolean nullList() {
        return empty;
    }

    public T car() {
        return first;
    }

    public SList<T> cdr() {
        return rest;
    }

    public SList<T> cons(T e) {
        return new SList<T>(e, this);
    }

    public int length() {
        if (nullList()) {
            return 0;
        }
        else {
            return 1 + cdr().length();
        }
    }

    public T listRef(int i) {
        if (i==0) {
            return car();
        } else {
            return cdr().listRef(i-1);
        }
    }

    public SList<T> append(SList<T> r) {
        if (nullList()) {
            return r;
        } else {
            return cdr().append(r).cons(car());
        }
    }

    public SList<T> reverse() {
        return reverseRec(new SList<T>());
    }

    private SList<T> reverseRec(SList<T> r) {
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
            SList<T> q = rest;
            do {
                v = v + ", " + q.car();
                q = q.cdr();
            } while (!q.nullList());
            return v + ")";
        }
    }

    public boolean equals( SList<T> il ) {   // contronto di liste
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
