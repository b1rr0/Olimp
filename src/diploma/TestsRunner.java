package diploma;

import diploma.HashTable.TestRunner;
import diploma.neo4j.GraphDatabase;
import diploma.neo4j.GraphTestRaner;
import diploma.neo4j.Relation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestsRunner {
    public static void main(String[] args) {
        List<TestRunner> testRunners = new ArrayList<>();

        Random r = new Random();

        // PerformanceTest p = new PerformanceTest();
        //long memo1 = Runtime.getRuntime().totalMemory() -
        //        Runtime.getRuntime().freeMemory();
        // p.run(dataSet, new RedisLikeHashMap<>());
        //  long memo2 = Runtime.getRuntime().totalMemory() -
        //          Runtime.getRuntime().freeMemory();
        //  System.out.println("Memory used " + (memo2 - memo1) / 1e+6);
        //  memo1 = memo2;
        //   p.run(dataSet, new RedisLikeHashMapWithTree<>());
        //  memo2 = Runtime.getRuntime().totalMemory() -
        Runtime.getRuntime().freeMemory();
        // System.out.println("Memory used " + (memo2 - memo1) / 1e+6);
        //  System.out.println("=====");
        // BeTree
        //BeTreePerformanceTest beTreePerformanceTest = new BeTreePerformanceTest();
        //  System.out.println("Min Key Size: 64");
        //    beTreePerformanceTest.run(dataSet, new BTree(64));
        //  System.out.println("Min Key Size: 8");
        //   beTreePerformanceTest.run(dataSet, new BTree(8));
        //   System.out.println("Min Key Size: 64");
        //  beTreePerformanceTest.run(dataSet, new BTree(64));

    //    SkipListDatabaseTest skipListDatabaseTest = new SkipListDatabaseTest();
     //   skipListDatabaseTest.run(dataSet, new SkipList<>());

        List<Integer> dataSet = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            dataSet.add(r.nextInt());
        }
        GraphTestRaner graphDatabaseTest = new GraphTestRaner();
        List<Relation> relations = new ArrayList<>();
        int relCount = 1_000_000;
        for (int i = 0; i < relCount; i++) {
            relations.add(new Relation(RelationType.getRandomRelation().toString(), "" + dataSet.get(Math.abs(r.nextInt()) % dataSet.size()), "" + dataSet.get(Math.abs(r.nextInt()) % dataSet.size())));
        }
        System.out.println("Relation count: " + relCount);
        graphDatabaseTest.run(dataSet.stream()
                .map(String::valueOf).toList(), relations, new GraphDatabase());
    }

    enum RelationType {
        PARENT,
        CHILD,
        SIBLING,
        FRIEND,
        COLLEAGUE,
        NEIGHBOR,
        PARTNER,
        SPOUSE,
        COUSIN,
        UNCLE,
        AUNT,
        GRANDPARENT,
        GRANDCHILD,
        ACQUAINTANCE,
        CLASSMATE,
        TEAMMATE,
        ROOMMATE,
        MENTOR,
        STUDENT,
        RIVAL;

        private static final Random RANDOM = new Random();

        public static RelationType getRandomRelation() {
            RelationType[] relations = RelationType.values();
            return relations[RANDOM.nextInt(relations.length)];
        }
    }
}
