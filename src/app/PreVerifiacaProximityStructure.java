package app;

public class PreVerifiacaProximityStructure {
    private double[] misure;
    private static final int MAXSIZE = 1000;
    private int n;

    public PreVerifiacaProximityStructure(){
        misure = new double[MAXSIZE];
        n = 0;
    }

    public int size() {
        return n;
    }

    public void add( double x ) {
        if (n < MAXSIZE) {
            misure[n] = x;
            n = n+1;
        }
    }

    public double removeClosestTo( double x ) {
        if (n > 0) {
            int prescelto = 0;
            for (int i = 0; i < n; i++) {
                if(Math.abs(x-misure[i])<Math.abs(x-misure[prescelto])){
                    prescelto = i;
                }
            }
            double y = misure[prescelto];
            n = n-1;
            misure[prescelto] = misure[n];
            return y;

        }else {
            return -1;
        }
    }

}
