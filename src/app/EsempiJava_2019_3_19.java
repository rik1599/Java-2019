package app;

import app.lib.IntSList;
import app.staticObjects.Complex;

/**
 * EsempiJava_2019_3_19
 * Vedi IntSList
 */
public class EsempiJava_2019_3_19 {

    public static void main(String[] args) {
        System.out.println(new Complex(3, 1).div(new Complex(4, -3)));
    }

    public static IntSList range(int inf, int sup) {
        if (inf > sup) {
            return IntSList.NULL_INTLIST;   // Chiamata all'attributo statico BOARD_S_LIST della classe IntSList
        } else {
            return range(inf + 1, sup).cons(inf);
        }
    }
}