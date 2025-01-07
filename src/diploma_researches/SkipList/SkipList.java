package diploma_researches.SkipList;

import java.util.Random;

public class SkipList<K extends Comparable<K>, V> {
    private static final int MAX_LEVEL = 16;
    private final Node<K, V> head = new Node<>(null, null, MAX_LEVEL);
    private final Random random = new Random();

    static class Node<K, V> {
        final K key;
        V value;
        final Node<K, V>[] forward;

        Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.forward = new Node[level + 1];
        }
    }

    public void show() {
        Node<K, V> x = head.forward[0];
        while (x != null) {
            System.out.println("Key: " + x.key + ", Value: " + x.value);
            x = x.forward[0];
        }
    }

    public void put(K key, V value) {
        Node<K, V>[] update = new Node[MAX_LEVEL + 1];
        Node<K, V> x = head;

        for (int i = MAX_LEVEL; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key.compareTo(key) < 0) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];

        if (x != null && x.key.compareTo(key) == 0) {
            x.value = value;
        } else {
            int level = randomLevel();
            x = new Node<>(key, value, level);
            for (int i = 0; i <= level; i++) {
                x.forward[i] = update[i].forward[i];
                update[i].forward[i] = x;
            }
        }
    }

    public V get(K key) {
        Node<K, V> x = head;

        for (int i = MAX_LEVEL; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key.compareTo(key) < 0) {
                x = x.forward[i];
            }
        }

        x = x.forward[0];

        if (x != null && x.key.compareTo(key) == 0) {
            return x.value;
        }

        return null;
    }

    public void remove(K key) {
        Node<K, V>[] update = new Node[MAX_LEVEL + 1];
        Node<K, V> x = head;

        for (int i = MAX_LEVEL; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].key.compareTo(key) < 0) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];

        if (x != null && x.key.compareTo(key) == 0) {
            for (int i = 0; i <= MAX_LEVEL; i++) {
                if (update[i].forward[i] != x) break;
                update[i].forward[i] = x.forward[i];
            }
        }
    }

    private int randomLevel() {
        int level = 0;
        while (random.nextInt(2) == 0 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        SkipList<String, String> db = new SkipList<>();
        db.put("key1", "value1");
        db.put("key2", "value2");
        db.put("key3", "value3");

        System.out.println("key1: " + db.get("key1"));
        System.out.println("key2: " + db.get("key2"));
        System.out.println("key3: " + db.get("key3"));

        db.remove("key2");
        System.out.println("After removing key2:");
        System.out.println("key1: " + db.get("key1"));
        System.out.println("key2: " + db.get("key2"));
        System.out.println("key3: " + db.get("key3"));
    }
}
