package huffman_project;

import huffman_toolkit.InputTextFile;
import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) {
        creaCoda(tabOccorrenze("src/huffman_project/Huffman.java"));
    }

    public static int[] tabOccorrenze(String doc) {
        InputTextFile itf = new InputTextFile(doc);

        int[] tab = new int[InputTextFile.CHARS];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 0;
        }

        while (itf.textAvailable()) {
            char c = itf.readChar();
            tab[c] = tab[c] + 1;
        }

        itf.close();
        return tab;
    }

    public static HNode creaCoda(int[] tab) {
        PriorityQueue<HNode> q = new PriorityQueue<>();
        for (int i = 0; i<tab.length; i++) {
            if (tab[i] > 0) {
                HNode n = new HNode((char) i, tab[i]);
                q.add(n);
            }
        }

        while (q.size() > 1) {

            HNode n = q.poll();
        }

        return q.poll();
    }
}
