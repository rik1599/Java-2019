package app;

// questa riga serve a importare la classe BiPredicate,
// che viene usata per fare quella roba strana
import java.util.function.BiPredicate;

public class Board {

    // Codifica secondo le convenzioni scacchistiche (massima dimensione: 15 x 15)
    // (queste constanti globali hanno serviranno per "generare" config)
    private static final String ROWS = " 123456789ABCDEF";  // cifre esadecimali
    // da 1 a F (=15)
    private static final String COLS = " abcdefghijklmno";  // lettere minuscole
    // da 'a' ad 'o'

    // size()       ->  int
    // queensOn()   ->  int
    // underAttack(i,j) ->  bool
    // b.addQueen(i,j)  ->  Board
    // arrangement()    ->  String (con le coodrinate delle regine)
    //                      es. "b1 d2 a3 c4"

    private final int size;     // dim scacchiera
    private final int queens;   // n regine in campo

    private final String config;    // disposizione delle regine, espressa mediante
    // stringa del tipo "a1 d6 g2 ecc..."
    // dove, per ogni coppia, la prima cifra
    // rappresenta la colonna e la seconda la riga

    private final BiPredicate<Integer, Integer> threat; // predicato che indica se
    // una posizione è minacciata
    // (VEDI SOTTO PER SPIEGAZIONE
    // DI CHE COS'E' BiPredicate)

    // costruttore di scacchiera vuota con n*n caselle
    // (n <- intero compreso tra 1 e 15)
    public Board(int n) {

        this.size = n;
        this.queens = 0;    // (la scacchiera è vuota, non ci sono regine)
        this.threat = (u, v) -> false;  // per ogni u e v, non c'è pericolo
        // (la scacchiera è vuota)
        this.config = " ";  // (la scacchiera è vuota, non ci sono regine)
    }

    // costruttore di scacchiera come "board" ma con una
    // regina in più nelle coordinate (i,j)
    public Board(Board board, int i, int j) {

        this.size = board.size();   // la dim. è la stessa di board
        this.queens = board.queensOn() + 1; // incremento le regine

        // DA QUANTO HO CAPITO, QUESTO PARTICOLARE TIPO DI DATO
        // MI CONSENTE DI COSTRUIRE ESPRESSIONI BINARIE BASATE SU
        // DUE PARAMETRI INTERI (ALL'INTERNO DELL'ESPRESSIONE
        // PARE SI POSSANO USARE ANCHE TUTTE LE ALTRE VARIABILI
        // GIA DICHIARATE, in questo caso i, j e addirittura board)

        // LA SINTASSI E': input -> output

        // (NOTA PERSONALE: mai vista na roba simile in 3 anni di java)

        // una cella è minacciata se si verifica una delle seguenti situazioni:
        this.threat = (u, v) -> (
                (u == i) ||  // stessa riga della nuova regina
                        (v == j) ||  // stessa colonna della nuova regina
                        (u - v == i - j) ||  // stessa diagonale della nuova regina
                        (u + v == i + j) ||  // stessa diagonale della nuova regina
                        board.underAttack(u, v)     // minacciata da una delle regine
                // messe in precedenza
                // (controllo "ricorsivo")
        );

        // la nuova configurazione è la precedente + una nuova coppia
        // colonna-riga che rappresenta la nuova regina
        this.config = board.config + COLS.charAt(j) + ROWS.charAt(i) + " ";
    }

    // ritorna all'esterno la dim. della scacchiera
    public int size() {
        return this.size;
    }

    // ritorna all'esterno il num. di regine
    public int queensOn() {
        return this.queens;
    }

    // controllo se una casella è sotto attacco
    public boolean underAttack(int i, int j) {

        return this.threat.test(i, j);   // VEDI SOPRA PER CAPIRE COSA VUOL DIRE
    }

    // genera una nuova Board a partire da questa a cui si aggiunge
    // una nuova regina nelle coordinate (i,j)
    public Board addQueen(int i, int j) {
        return new Board(this, i, j);
    }

    // ritorna all'esterno l'attuale configurazione sotto forma di stringa
    public String arrangement() {
        return this.config;
    }

    // metodo toString usato come standar in java per rappresentare
    // testualmente un oggetto
    public String toString() {
        return "[" + this.config + "]";
    }
}