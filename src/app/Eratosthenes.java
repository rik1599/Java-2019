package app;
import java.util.Vector;

public class Eratosthenes {
    public static Vector<Integer> eratosthenes(int n){
        boolean[] crivello = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            crivello[i] = true;
        }
        Vector<Integer> primi = new Vector<>();

        int p = 2;

        while (p <= n) {
            if (crivello[p]) {
                primi.add(p);
                for (int m = 2*p; m <= n; m+=p) {
                    crivello[m] = false;
                }
            }
            p++;
        }

        return primi;
    }

}
