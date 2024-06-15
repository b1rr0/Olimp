package diploma.HashTable;

public class RedisLikeHashMap<K, V> implements RedisHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Entry<K, V>[] table;
    private int size;

    public RedisLikeHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }


    private static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % table.length;
        }

        if (table[index] == null) {
            size++;
        }
        table[index] = new Entry<>(key, value);
    }

    public V get(K key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                V value = table[index].value;
                table[index] = null;
                size--;
                rehash(index);
                return value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    private void rehash(int start) {
        int index = (start + 1) % table.length;
        while (table[index] != null) {
            Entry<K, V> entry = table[index];
            table[index] = null;
            size--;
            put(entry.key, entry.value);
            index = (index + 1) % table.length;
        }
    }

    public int size() {
        return size;
    }


}