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
    public RoundTable(int n) {

    }

    public int numeroCav() {
        return 0;
    }

    public int chiHaLaBrocca() {
        return 0;
    }

    public IntSList cavalieriUsciti() {
        return IntSList.NULL_INTLIST;
    }

    public boolean servitoCav() {
        return true;
    }

    public int cavASinistra() {
        return 0;
    }

    public RoundTable esceCavaliere() {
        return new RoundTable(0);
    }

    public RoundTable passaBrocca() {
        return new RoundTable(0);
    }

    public boolean ultimoCav() {
        return true;
    }
}
