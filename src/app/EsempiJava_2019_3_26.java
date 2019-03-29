package app;

public class EsempiJava_2019_3_26 {
    public static void main(String[] args) {
        System.out.println(conta(12));
    }

    public static int conta(int n) {
        RoundTable t = new RoundTable(n);
        while (!t.ultimoCav()) {
            t = t.esceCavaliere();
            t = t.passaBrocca();
        }
        return t.chiHaLaBrocca();
    }
}
