package app;

public class Lezione_190503 {
    
    public static final SList<String> Board_new_S_LIST = new SList<String>();

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfSolutions(n));
        System.out.println(listOfAllSolutions(n));
        System.out.println(numberOfCompletions(new Board_new(n)));
    }
    
    public static SList<String> listOfAllSolutions(int n)
    {
        return listOfCompletions(new Board_new(n));
    }

    public static SList<String> listOfCompletions(Board_new b)
    {
        int n = b.size();
        int q = b.queensOn();

        if(q == n)
        { return Board_new_S_LIST.cons(b.toString()); }
        else
        {
            int i = q + 1; //riga
            SList<String> sol = Board_new_S_LIST;
            for (int j=1; j<=n; j++)
            {
                if(!b.underAttack(i,j))
                { 
                    b.addQueen(i, j);
                    sol = sol.append(listOfCompletions(b)); 
                    b.removeQueen(i, j);
                }
            }
            return sol;
        }
    }
    
    public static SList<Integer> numberOfSolutions(int n)
    {
        SList<Integer> il = new SList<Integer>();
        Board_new b = new Board_new(n);
        for (int j=n; j>=1; j=j-1)
        {
            int k = numberOfCompletions(b);
            il = il.cons(k);
        }
        return il;
    }

    public static int numberOfCompletions(Board_new b)
    {
        int n = b.size();
        int q = b.queensOn();

        if(q == n)
        { return 1; }
        else
        {
            int i = q + 1; //riga
            int sol = 0;
            for (int j=1; j<=n; j++)
            {
                if(!b.underAttack(i,j))
                { 
                    b.addQueen(i, j);
                    sol += numberOfCompletions(b); 
                    b.removeQueen(i, j);
                }
            }
            return sol;
        }
    }

}