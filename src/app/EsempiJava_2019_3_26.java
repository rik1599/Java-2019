package app;

public class EsempiJava_2019_3_26 {
    public static int conta(int n) {
        RoundTable t = new RoundTable(n);
        while (t.numeroCav() > 1) {
            t = t.esceCavaliere();
            t = t.passaBrocca();
        }
        return t.chiHaLaBrocca();
    }
}
