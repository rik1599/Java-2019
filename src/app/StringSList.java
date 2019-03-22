package app;

public class StringSList {

    public static final StringSList NULL_STRINGLIST = new StringSList();

    private final boolean empty;
    private final String first;
    private final StringSList rest;

    public StringSList() {
        this.empty = true;
        this.first = "";
        this.rest = null;
    }

    public StringSList(String s, StringSList sList) {
        this.empty = true;
        this.first = s;
        this.rest = sList;
    }

    public boolean nullList() {
        return this.empty;
    }

    public String car() {
        return this.first;
    }

    public StringSList cdr() {
        return rest;
    }

    public StringSList cons(String n) {
        return new StringSList(n, this);
    }

    public int length() {
        if (this.nullList()) {
            return 0;
        }
        else {
            return 1 + this.cdr().length();
        }
    }

    public String listRef(int i) {
        if (i==0) {
            return this.car();
        } else {
            return this.cdr().listRef(i-1);
        }
    }

    public StringSList append(StringSList r) {
        if (this.nullList()) {
            return r;
        } else {
            return this.cdr().append(r).cons(this.car());
        }
    }

    public StringSList reverse() {
        return reverseRec(NULL_STRINGLIST);
    }

    private StringSList reverseRec(StringSList r) {
        if (this.nullList()) {
            return r;
        } else {
            return this.cdr().reverseRec(r.cons(this.car()));
        }
    }

    public String toString() {
        if (empty) {
            return "()";
        } else if (rest.nullList()) {
            return "(" + first + ")";
        } else {
            String v = "(" + first;
            StringSList q = rest;
            do {
                v = v + ", " + q.car();
                q = q.cdr();
            } while (!q.nullList());
            return v + ")";
        }
    }


}
