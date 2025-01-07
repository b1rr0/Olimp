package diploma_researches;

import diploma_researches.Graph.GraphDatabase;
import diploma_researches.Graph.Relation;

import java.util.*;

public class TestsRunnerGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GraphDatabase graph = new GraphDatabase();

        for (; ; ) {
            String a = scanner.nextLine();
            String[] test = a.split(" ");


            if (test[0].equals("help")){
                System.out.println("Available commands:");
                System.out.println("help                     - Display available commands.");
                System.out.println("addNode <nodeId>          - Add a node to the graph.");
                System.out.println("addRel <relation> <node1> <node2> - Add relationship.");
                System.out.println("addRel <nodeId>       - Remove a node from the graph.");
                System.out.println("removeNode <nodeId>       - Remove a relationship from the graph.");
                System.out.println("showNodes                 - Display all nodes in the graph.");
                System.out.println("showRel         - Display all relationships in the graph.");
                System.out.println("fill                      - Fill the graph with random data.");
                System.out.println("get <nodeId>              - Retrieve node information by ID.");
                System.out.println("clear                     - Clear the graph.");

            }
            if (test[0].equals("addNode")) {
                graph.createNode(test[1]);
                System.out.println("added");
            }
            if (test[0].equals("addRel")) {
                graph.createRelationship(test[1],graph.getNode(test[2]),graph.getNode(test[3]));
                System.out.println("added");
            }
            if (test[0].equals("rmRel")) {
                System.out.println(test[1]+" "+ test[2]+"_"+test[3]);
                graph.deleteRelation(test[2],test[3],test[1]);
                System.out.println("removed");
            }

            if (test[0].equals("rmNode")) {
                graph.deleteNode(test[1]);
                System.out.println("deleted");
            }

            if (test[0].equals("showNodes")) {
                graph.printNodes();
                System.out.println("---");
            }
            if (test[0].equals("showRel")) {
                graph.printRelationships();
                System.out.println("---");
            }

            if (test[0].equals("fill")) {
                graph = f(graph);
                System.out.println("filled");
            }

            if (test[0].equals("get")) {
                System.out.println(graph.getNode(test[1]));
            }

            if (test[0].equals("clear")) {
                graph = new GraphDatabase();
            }
            if (test[0].equals("exit")) break;
        }


    }

    public static GraphDatabase f(GraphDatabase graphDatabase) {
        List<Integer> dataSet = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            dataSet.add(r.nextInt());
        }
        List<Relation> relations = new ArrayList<>();
        int relCount = 10;
        for (int i = 0; i < relCount; i++) {
            relations.add(new Relation(RelationType.getRandomRelation().toString(), "" + dataSet.get(Math.abs(r.nextInt()) % dataSet.size()), "" + dataSet.get(Math.abs(r.nextInt()) % dataSet.size())));
        }
        return fill(dataSet.stream()
                .map(String::valueOf).toList(), relations, graphDatabase);
    }

    public static GraphDatabase fill(List<String> ids, List<Relation> relationships, GraphDatabase db) {
        for (String id : ids) {
            GraphDatabase.Node node = db.createNode(id);
            node.setProperty("name", "Node" + id);
        }
        for (Relation relationship : relationships) {
            db.createRelationship(relationship.relation(), db.getNode(relationship.node1()), db.getNode(relationship.node2()));
        }
        return db;
    }
}
