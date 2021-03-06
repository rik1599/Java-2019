package huffman_project;

import huffman_toolkit.*;

import java.util.PriorityQueue;
import java.util.Stack;

public class Huffman {

    public static final String _PATH = "src/huffman_project/";

    public static void main(String[] args) {

    }

    //#region COMPRIMI
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

    public static void creaCoda(int[] tab) {
        PriorityQueue<HNode> q = new PriorityQueue<>();
        for (int i = 0; i<tab.length; i++) {
            if (tab[i] > 0) {
                HNode n = new HNode((char) i, tab[i]);
                q.add(n);
            }
        }

        while (q.size() > 0) {
            HNode n = q.poll();
            System.out.println("" + n);
        }

        System.out.println();
    }

    public static HNode hAlbero(int[] tab) {
        PriorityQueue<HNode> q = new PriorityQueue<>();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > 0) {
                HNode n = new HNode((char) i, tab[i]);
                q.add(n);
            }
        }
        while (q.size() > 1) {
            HNode n1 = q.poll();
            HNode n2 = q.poll();
            HNode n = new HNode(n1, n2);
            q.add(n);
        }
        return q.poll();
    }

    public static String codAlberoRec(HNode n) {
        if (n.isLeaf()) {
            char c = n.getCharacter();
            if ((c == '@') || (c == '\\')) {
                return "\\" + c;
            } else {
                return "" + c;
            }
        } else {
            String s1 = codAlbero(n.getLeft());
            String s2 = codAlbero(n.getRight());
            return "@" + s1 + s2;
        }
    }

    public static String codAlbero(HNode n) {

        Stack<HNode> s = new Stack<>();
        s.push(n);
        String cod = new String();

        while (!s.empty()) {
            n = s.pop();

            if (n.isLeaf()) {
                char c = n.getCharacter();
                if ((c == '@') || (c == '\\')) {
                    cod = cod + "\\" + c;
                } else {
                    cod += c;
                }
            } else {
                cod += "@";
                s.push(n.getRight());
                s.push(n.getLeft());
            }
        }
        return cod;
    }

    public static String[] tabCodici(HNode n) {
        String[] tabc = new String[InputTextFile.CHARS];

        Stack<Pair> s = new Stack<>();
        s.push(new Pair(n, ""));

        while (!s.empty()) {
            Pair cp = s.pop();
            n = cp.node;

            if (n.isLeaf()) {
                char c = n.getCharacter();
                tabc[c] = cp.pre;
            } else {
                s.push(new Pair(n.getRight(), cp.pre.concat("1")));
                s.push(new Pair(n.getLeft(), cp.pre.concat("0")));
            }

        }

        return tabc;
    }

    public static String[] tabCodiciRec(HNode n) {
        String[] tabc = new String[InputTextFile.CHARS];
        tabCodRec(n, "", tabc);
        return tabc;
    }

    private static void tabCodRec(HNode t, String pre, String[] tabc) {
        if (t.isLeaf()) {
            char c = t.getCharacter();
            tabc[c] = pre;
        } else {
            tabCodRec(t.getLeft(), pre + "0", tabc);
            tabCodRec(t.getRight(), pre + "1", tabc);
        }
    }

    public static void comprimi(String doc, String com) {
        int[] tab = tabOccorrenze(doc);
        HNode t = hAlbero(tab);
        int count = t.getWeight();
        String[] codes = tabCodici(t);

        InputTextFile itf = new InputTextFile(doc);
        OutputTextFile otf = new OutputTextFile(com);

        otf.writeTextLine("" + t.getWeight());
        otf.writeTextLine(codAlbero(t));

        for (int i = 0; i < count; i++) {
            char c = itf.readChar();
            otf.writeCode(codes[c]);
        }
        itf.close();
        otf.close();
    }
    //#endregion

    //#region DECOMPRIMI
    public static HNode ripristinaAlberoRec(InputTextFile in) {
        char c = in.readChar();

        if (c == '@') {
            HNode n1 = ripristinaAlbero(in);
            HNode n2 = ripristinaAlbero(in);

            return new HNode(n1, n2);
        } else {
            if (c == '\\') {
                c = in.readChar();
            }
            return new HNode(c, 0);
        }
    }

    public static HNode ripristinaAlbero(InputTextFile in) {

        Stack<Frame> s = new Stack<>();
        s.push(new Frame(0, null));
        HNode n = null;
        while (!s.empty()) {
            Frame f = s.pop();
            if (f.stato == 0) {
                char c = in.readChar();
                if (c == '@') {
                    s.push(new Frame(1, null));
                    s.push(new Frame(0, null));
                } else {
                    if (c == '\\') {
                        c = in.readChar();
                    }
                    n = new HNode(c, 0);
                }
            } else if (f.stato == 1) {
                s.push(new Frame(2, n));
                s.push(new Frame(0, null));
            } else {
                n = new HNode(f.node, n);
            }
        }
        return n;
    }

    public static void decomprimi (String com, String dec) {
        InputTextFile in = new InputTextFile(com);
        OutputTextFile out = new OutputTextFile(dec);

        String num = in.readTextLine();
        int count = Integer.parseInt(num);

        HNode t = ripristinaAlbero(in);

        String dummy = in.readTextLine();

        for (int i = 0; i < count; i++) {
            HNode n = t;
            while (!n.isLeaf()) {
                int bit = in.readBit();
                if (bit == 0) {
                    n = n.getLeft();
                } else {
                    n = n.getRight();
                }
            }
            char c = n.getCharacter();
            out.writeChar(c);
        }

        in.close();
        out.close();
    }
    //#endregion
}
