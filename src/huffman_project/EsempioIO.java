package huffman_project;

import huffman_toolkit.*;

public class EsempioIO {

    public static void main(String[] args) {
        copia("src/huffman_project/EsempioIO.java", "src/huffman_project/Copia.txt");
    }

    public static void copia(String tf1, String tf2) {
        InputTextFile itf = new InputTextFile(tf1);
        OutputTextFile otf = new OutputTextFile(tf2);

        while (itf.textAvailable()) {
            String txt = itf.readTextLine();
            otf.writeTextLine(txt);
        }

        itf.close();
        otf.close();
    }

    public static int copiaLinee(String tf1, String tf2) {
        InputTextFile itf = new InputTextFile(tf1);
        OutputTextFile otf = new OutputTextFile(tf2);

        int count = 0;

        while (itf.textAvailable()) {
            String txt = itf.readTextLine();
            otf.writeTextLine(txt);
            count++;
        }

        itf.close();
        otf.close();
        return count;
    }
}
