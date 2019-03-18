package app;

/**
 * EsempiJava_2019_3_12
 */
public class EsempiJava_2019_3_12 {

  public static String binRep(int n) {
    String lsb = ((n % 2) == 0) ? "0" : "1";

    if (n < 2) {
      return lsb;
    } else {
      return binRep(n / 2) + lsb;
    }
  }

  private static int bitVal(char bit) {
    return bit == '0' ? 0 : 1;
  }

  public static int binVal(String b) {
    int l = b.length();
    char lsb = b.charAt(l - 1);
    String pr = b.substring(0, l - 1);

    if (l == 1) {
      return bitVal(lsb);
    } else {
      return (2 * (binVal(pr)) + bitVal(lsb));
    }
  }
}