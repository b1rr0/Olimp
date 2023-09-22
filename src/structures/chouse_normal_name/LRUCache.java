package structures.chouse_normal_name;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
    private class Node {
        public Node(Node prev, Node next, int key, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
            this.key = key;
        }

        Node prev;
        Node next;
        int val, key;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val && key == node.key && Objects.equals(prev, node.prev)
                    && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(prev, next, val, key);
        }
    }

    Map<Integer, Node> nodeMap = new HashMap<>();
    Node start;
    Node finish;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        start = new Node(null, null, -1, -1);
        finish = new Node(null, null, -1, -1);
        start.next = finish;
        finish.prev = start;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            var v = nodeMap.get(key);

            dellNode(v);
            add(v.key, v.val);
            return v.val;
        }
        return -1;
    }

    public void add(int key, int val) {
        var node = new Node(null, null, key, val);
        var p = finish.prev;
        finish.prev.next = node;
        node.prev = p;
        node.next = finish;
        finish.prev = node;
        nodeMap.put(key, node);
    }

    public void dellNode(Node node) {
        var prev = node.prev;
        var n = node.next;
        prev.next = n;
        n.prev = prev;
        nodeMap.remove(node.key);
    }

    public void put(int key, int value) {

        if (nodeMap.containsKey(key)) {
            var v = nodeMap.get(key);
            dellNode(v);
        }

        if (nodeMap.size() == capacity) {
            dellNode(start.next);
        }
        add(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
