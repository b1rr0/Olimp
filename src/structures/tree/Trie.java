package structures.tree;

import java.util.HashMap;

public class Trie {
    public Trie() {
        root = new Node();
    }

    Node root;

    public boolean add(String word) {
        var chars = word.toCharArray();
        return add(chars, 0, root);
    }


    public boolean isPresent(String word) {
        var chars = word.toCharArray();
        return isPresent(chars, 0, root);
    }

    private boolean isPresent(char[] chars, int index, Node node) {
        if (chars.length == index) return node.isWord;

        var nextNode = node.children.get(chars[index]);
        return nextNode != null && isPresent(chars, index + 1, nextNode);
    }

    private boolean add(char[] chars, int index, Node node) {
        if (chars.length <= index) {
            if (node.isWord) {
                return false;
            }
            node.isWord = true;
            return true;
        }

        char curChar = chars[index];
        var nextNode = node.children.get(curChar);
        if (nextNode == null) {
            nextNode = new Node();
            node.children.put(curChar, nextNode);
        }
        return add(chars, index + 1, nextNode);
    }


    private class Node {
        public Node() {
            children = new HashMap<>();  // Char -> Node
            isWord = false;
        }

        private final HashMap<Character, Node> children;

        private boolean isWord;

    }

    public static void main(String[] args) {
        Trie t = new Trie();
        System.out.println(t.add("asd"));
        System.out.println(t.add("awsd"));
        System.out.println(t.add("qwek"));
        System.out.println(t.add("asd"));
        System.out.println("=========");
        System.out.println(t.isPresent("asd"));
        System.out.println(t.isPresent("a"));
        System.out.println(t.isPresent("as"));
        System.out.println(t.isPresent("awsd"));
        System.out.println(t.isPresent("asde"));
    }
}
