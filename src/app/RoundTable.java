package app;

/**
 * RoundTable t
 * t.numeroCav()            -> int
 * t.chiHaLaBrocca()        -> cavaliere (int)
 * t.cavalieriUsciti()      -> IntSList
 * t.servitoCav()           -> boolean
 * t.cavASinistra()         -> cavaliere (int)
 * t.esceCavaliere()        -> RoundTable
 * t.passaBrocca()          -> RoundTable
 * t.ultimoCav()            -> boolean
 */
public class RoundTable {

    private final IntSList tav;
    private final IntSList usc;
    private final boolean serv;

    public RoundTable(int n) {
        this.tav = range(1, n);
        this.usc = IntSList.NULL_INTLIST;
        serv = false;
    }

    private RoundTable(IntSList t, IntSList u, boolean s) {
        this.tav = t;
        this.usc = u;
        this.serv = s;
    }

    private static IntSList range (int inf, int sup) {
        IntSList il = IntSList.NULL_INTLIST;
        while (inf <= sup) {
            il = il.cons(sup);
            sup = sup - 1;
        }
        return il;
    }

    public int numeroCav() {
        return tav.length();
    }

    public int chiHaLaBrocca() {
        return tav.car();
    }

    public IntSList cavalieriUsciti() {
        return this.usc;
    }

    public boolean servitoCav() {
        return serv;
    }

    public int cavASinistra() {
        return tav.cdr().car();
    }

    public RoundTable esceCavaliere() {
        return new RoundTable(0);
    }

    public RoundTable passaBrocca() {
        return new RoundTable(0);
    }

    public boolean ultimoCav() {
        return tav.length() == 1;
    }
}
