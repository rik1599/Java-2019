package app;

/**
 * EsempiJava_2019_3_19
 * Vedi IntSList
 */
public class EsempiJava_2019_3_19 {

    public static void main(String[] args) {
        IntSList s = range(1, 10);
        System.out.println(s.append(range(11, 15)).reverse().length());
    }

    public static IntSList range(int inf, int sup) {
        if (inf > sup) {
            return IntSList.NULL_INTLIST;   // Chiamata all'attributo statico NULL_INTLIST della classe IntSList
        } else {
            return range(inf + 1, sup).cons(inf);
        }
    }
}