package app;

import app.staticObjects.RoundTable;

public class Knuth {
    public static void main(String[] args) {
        System.out.println(conta(1000));
    }

    public static int conta(int n) {
        RoundTable t = new RoundTable(n);
        while (t.numeroCav() >  1) {
            t = t.esceCavEPassaBrocca();
        }
        return t.chiHaLaBrocca();
    }
}
