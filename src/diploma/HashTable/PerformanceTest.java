package diploma.HashTable;

import java.util.List;

public class PerformanceTest implements TestRunner {

    @Override
    public void run(List<Integer> list, RedisHashTable<String, String> map) {
        int numElements = list.size();
        long startTime, endTime;
        System.out.println(map.getClass().getSimpleName() + "  count: " + list.size());
        // Insert
        long memo1 = Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory();

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.put("key" + list.get(i), "value" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert time: " + (endTime - startTime) / 1e6 + " ms");

        // Search
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.get("key" + list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Search time: " + (endTime - startTime) / 1e6 + " ms");
        long memo2 = Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory();
        System.out.println("Memory used with all Items " + (memo2 - memo1) / 1e+6);

        // Remove
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.remove("key" + list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Remove time: " + (endTime - startTime) / 1e6 + " ms");
    }
}

