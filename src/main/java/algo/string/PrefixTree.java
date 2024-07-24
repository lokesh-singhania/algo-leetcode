package algo.string;

public interface PrefixTree {
    void insert(String word);

    boolean search(String word);

    boolean startsWith(String prefix);
}
