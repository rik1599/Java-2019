package app;

/**
 * EsempiJava_2019_3_19
 * Vedi IntSList
 */
public class EsempiJava_2019_3_19 {

  public static void main(String[] args) {
    IntSList s = range(1, 100);
    while (!s.nullList()) {
      System.out.println(s.car());
      s = s.cdr();
    }
  }

  public static IntSList range(int inf, int sup) {
    return inf > sup ? new IntSList() : range(inf + 1, sup).cons(inf);
  }


}