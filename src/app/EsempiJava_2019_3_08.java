package app;

public class EsempiJava_2019_3_08 {
    public static void main(String[] args) {

    }

    // Volume del cilindro
    public static double supToTCil(double r, double h) {
        return (2 * Math.PI * r) * (h + r);
    }

    // Sostantivo femminile plurale
    public static String sfPlurale(String p) {
        return p.substring(0, p.length() - 1) + "e";
    }

    static final double S0 = Math.pow(2, (double) 1 / 4) * 100;
    static final double S1 = Math.pow(2, (double) -1 / 4) * 100;

    public static double s(int k) {
        if (k >= 2) {
            return s(k - 2) / 2;
        } else if (k >= 1) {
            return S1;
        } else {
            return S0;
        }
    }

    public static double sTernario(int k) {
        return ((k >= 2) ? s(k - 2) / 2 : ((k >= 1) ? S1 : S0));
    }

    public static String compl(String bit) {
        if (bit.equals("0")) {
            return "1";
        } else {
            return "0";
        }
    }

    public static String complA1(String seq) {
        if (seq.length() > 0) {
            return compl(seq.substring(0, 1)) + complA1(seq.substring(1));
        } else {
            return "";
        }
    }

}
