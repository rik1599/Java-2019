package app;

import app.dynamicObjects.RoundTable;

public class Knuth {
    public static void main(String[] args) {
        System.out.println(conta(25));
    }

    public static int conta(int n) {
        RoundTable t = new RoundTable(n);
        while (t.numeroCav() >  1) {
            t.esceCavEPassaBrocca();
        }
        return t.chiHaLaBrocca();
    }
}
