package diploma_researches.SkipList;

import java.util.List;


public class SkipListDatabaseTest {

    public void run(List<Integer> list, SkipList<Integer, Integer> map) {
        int numElements = list.size();
        long startTime, endTime;

        System.out.println(map.getClass().getSimpleName() + " count: " + list.size());

        long memoryBeforeInsert = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.put(list.get(i), list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Insert time: " + (endTime - startTime) / 1e6 + " ms");

        long memoryAfterInsert = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used after insert: " + (memoryAfterInsert - memoryBeforeInsert) / 1e6 + " MB");

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.get(list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Search time: " + (endTime - startTime) / 1e6 + " ms");

        long memoryBeforeRemove = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.remove(list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Remove time: " + (endTime - startTime) / 1e6 + " ms");

        long memoryAfterRemove = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used after remove: " + (memoryAfterRemove - memoryBeforeRemove) / 1e6 + " MB");
    }

}

