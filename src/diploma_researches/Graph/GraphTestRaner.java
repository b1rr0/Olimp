package diploma_researches.Graph;


import java.util.List;

public class GraphTestRaner {


    public void run(List<String> ids, List<Relation> relationships, GraphDatabase db) {
        int numElements = ids.size();
        long startTime, endTime;


        System.out.println("GraphDatabase count: " + ids.size());

        // Замер памяти до вставки
        long memoryBeforeInsert = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Вставка узлов
        startTime = System.nanoTime();
        for (String id : ids) {
            GraphDatabase.Node node = db.createNode(id);
            node.setProperty("name", "Node" + id);
        }
        for (Relation relationship : relationships) {
            db.createRelationship(relationship.relation(), db.getNode(relationship.node1()), db.getNode(relationship.node2()));
        }
        endTime = System.nanoTime();
        System.out.println("Insert time: " + (endTime - startTime) / 1e6 + " ms");

        // Замер памяти после вставки
        long memoryAfterInsert = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used after insert: " + (memoryAfterInsert - memoryBeforeInsert) / 1e6 + " MB");

        // Поиск узлов
        startTime = System.nanoTime();
        for (String id : ids) {
         db.getNode(id);

        }
        endTime = System.nanoTime();
        System.out.println("Search time: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        for (Relation relation : relationships) {
            db.getRelationships(relation.relation());
        }
        endTime = System.nanoTime();
        System.out.println("Search relation time: " + (endTime - startTime) / 1e6 + " ms");

        // Замер памяти перед удалением
        long memoryBeforeRemove = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Удаление узлов
        startTime = System.nanoTime();
        for (String id : ids) {
            db.deleteNode(id);
        }
        endTime = System.nanoTime();
        System.out.println("Remove time: " + (endTime - startTime) / 1e6 + " ms");
    }

}

