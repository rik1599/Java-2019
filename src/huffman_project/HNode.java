package huffman_project;

public class HNode implements Comparable<HNode>{
    private final char character;
    private final int weight;
    private final HNode left;
    private final HNode right;

    public HNode(char c, int w) {
        character = c;
        weight = w;
        left = null;
        right = null;
    }

    public HNode(HNode l, HNode r) {
        character = (char) 0;
        weight = l.getWeight() + r.getWeight();
        left = l;
        right = r;
    }

    public boolean isLeaf() {
        return (left == null) || (right == null);
    }

    public int getWeight() {
        return weight;
    }

    public char getCharacter() {
        return character;
    }

    public HNode getLeft() {
        return left;
    }

    public HNode getRight() {
        return right;
    }

    @Override
    public int compareTo(HNode o) {
        return  Integer.compare(weight, o.getWeight());
    }

    @Override
    public String toString() {
        return Integer.toString(weight);
    }
}
