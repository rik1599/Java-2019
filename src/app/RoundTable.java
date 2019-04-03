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

    private final IntSList tav, cod, usc;
    private final int num;
    private final boolean serv;

    public RoundTable(int n) {
        tav = range(1, n);
        usc = IntSList.NULL_INTLIST;
        serv = false;
        num = n;
        cod = IntSList.NULL_INTLIST;
    }

    private RoundTable(IntSList t, IntSList c, int n, IntSList u, boolean s) {
        tav = t;
        cod = c;
        usc = u;
        num = n;
        serv = s;
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
        return num;
    }

    public int chiHaLaBrocca() {
        return tav.car();
    }

    public IntSList cavalieriUsciti() {
        return usc;
    }

    public boolean servitoCav() {
        return serv;
    }

    public RoundTable esceCavEPassaBrocca() {

        IntSList u = tav.cdr();
        IntSList v = cod.cons(tav.car());

        if (tav.cdr().nullList()) {
            IntSList r = v.reverse();
            return new RoundTable(r.cdr(), IntSList.NULL_INTLIST, num - 1, usc.cons(r.car()), true);
        } else if (tav.cdr().cdr().nullList()) {
            return new RoundTable(v.reverse(), IntSList.NULL_INTLIST, num - 1, usc.cons(u.car()), true);
        } else {
            return new RoundTable(u.cdr(), v, num - 1, usc.cons(tav.cdr().car()), true);
        }
    }

    public boolean ultimoCav() {
        return num == 1;
    }

   /* public int cavASinistra() {
        return tav.cdr().car();
    }*/

    /*public RoundTable esceCavaliere() {
        return new RoundTable(
                tav.cdr().cdr().cons(tav.car()),
                usc.cons(tav.cdr().car()),
                true
        );
    }*/

    /*public RoundTable passaBrocca() {
        return new RoundTable(
                tav.cdr().append(IntSList.BOARD_S_LIST.cons(tav.car())),
                usc,
                false
        );
    }*/
}
