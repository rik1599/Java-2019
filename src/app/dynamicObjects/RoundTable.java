package app.dynamicObjects;

import app.lib.SList;

public class RoundTable {
    private int[] tav;
    private int num, pos;

    public RoundTable(int n) {
        tav = new int[2*n-1];
        for (int i = 0; i < n; i++) {
            tav[i] = i + 1;
        }
        num = n;
        pos = 0;
    }

    public int numeroCav() {
        return num;
    }

    public int chiHaLaBrocca() {
        return tav[pos];
    }

    public void esceCavEPassaBrocca() {
       int j = pos + num;
       tav[j] = tav[pos];
       pos = pos + 2;
       num = num - 1;
    }
}
