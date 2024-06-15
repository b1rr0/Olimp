package diploma.HashTable;

import java.util.TreeMap;

public class RedisLikeHashMapWithTree<K, V> implements RedisHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private TreeMap<K, V>[] table;
    private int size;

    public RedisLikeHashMapWithTree() {
        table = new TreeMap[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new TreeMap<>();
        }
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        if (size >= LOAD_FACTOR * table.length) {
            resize();
        }

        int index = hash(key);
        if (table[index].put(key, value) == null) {
            size++;
        }
    }

    public V get(K key) {
        int index = hash(key);
        return table[index].get(key);
    }

    public V remove(K key) {
        int index = hash(key);
        V value = table[index].remove(key);
        if (value != null) {
            size--;
        }
        return value;
    }

    private void resize() {
        TreeMap<K, V>[] oldTable = table;
        table = new TreeMap[oldTable.length * 2];
        for (int i = 0; i < table.length; i++) {
            table[i] = new TreeMap<>();
        }
        size = 0;

        for (TreeMap<K, V> bucket : oldTable) {
            for (K key : bucket.keySet()) {
                put(key, bucket.get(key));
            }
        }
    }
    public int size() {
        return size;
    }
}


