package huffman_project;

public class Frame {
    public final int stato;
    public final HNode node;

    public Frame(int stato, HNode node) {
        this.stato = stato;
        this.node = node;
    }
}
