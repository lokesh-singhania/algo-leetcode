package algo.string.prefix.tree;

public class Iterative extends Trie {

    public Iterative() {
        super();
    }

    public void insert(String word) {
        Node node = root;
        for(char c:word.toCharArray()){
            int ci= c - 'a';
            if(node.next[ci] == null){
                node.next[ci] = new Node();
            }
            node = node.next[ci];
        }
        node.end = true;
    }

    @Override
    protected Node prefixSearch(String prefix){
        Node node = root;
        for(char c: prefix.toCharArray()){
            node = node.next[c-'a'];
            if(node==null) return null;
        }
        return node;
    }

}
