package app;

/**
 * EsempiJava_2019_3_15
 */
public class EsempiJava_2019_3_15 {

  public static void main(String[] args) {

  }

  public static int gcd(int x, int y) {
    while (x != y) {
      if (x < y) {
        y = y - x;
      } else {
        x = x - y;
      }
    }
    return x;
  }

  public static int mcm(int x, int y) {
    int z = x;
    while ((z % y) > 0) {
      z = z + x;
    }
    return z;
  }

  /**
   * TRADUCI IN JAVA 
   *    (define ufo 
   *        (lambda (n) 
   *            (cond [(= n 1) 1]
   *                  [(even? n) (- (* 2 (ufo (quotient n 2)) 1))]
   *                  [else (+ (* 2 (ufo (quotient n 2)) 1))]
   *      )))
   */
  public static int ufo(int n) {
    int[] s = new int[n];
    int i = 0;

    while (n > 1) {
      s[i] = n;
      i++; // i = i + 1;
      n = n / 2;
    }

    int v = 1;
    for (int j = i - 1; j >= 0; j--) { // j-- => j = j - 1
      if (s[j] % 2 == 0) {
        v = 2 * v - 1;
      } else {
        v = 2 * v + 1;
      }
    }
    return v;
  }
}