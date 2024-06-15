package diploma.BTree;

import java.util.List;

public class BeTreePerformanceTest {
    public void run(List<Integer> list, BTree map) {
        int numElements = list.size();
        long startTime, endTime;

        System.out.println(map.getClass().getSimpleName() + "  count: " + list.size());

        // Замер памяти до вставки
        long memoryBeforeInsert = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Вставка элементов
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.add(list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Insert time: " + (endTime - startTime) / 1e6 + " ms");

        // Замер памяти после вставки
        long memoryAfterInsert = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used after insert: " + (memoryAfterInsert - memoryBeforeInsert) / 1e6 + " MB");

        // Поиск элементов
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.contains(list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Search time: " + (endTime - startTime) / 1e6 + " ms");

        // Замер памяти перед удалением
        long memoryBeforeRemove = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Удаление элементов
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            map.remove(list.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Remove time: " + (endTime - startTime) / 1e6 + " ms");

        // Замер памяти после удаления
        long memoryAfterRemove = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used after remove: " + (memoryAfterRemove - memoryBeforeRemove) / 1e6 + " MB");
    }


}
