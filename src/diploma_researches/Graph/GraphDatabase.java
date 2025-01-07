package diploma_researches.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphDatabase {
    public class Node {
        private final String id;
        private final Map<String, String> properties;
        private final List<Relationship> relationships;

        public Node(String id) {
            this.id = id;
            this.properties = new HashMap<>();
            this.relationships = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public Map<String, String> getProperties() {
            return properties;
        }

        public String getProperty(String key) {
            return properties.get(key);
        }

        public void setProperty(String key, String value) {
            properties.put(key, value);
        }

        public List<Relationship> getRelationships() {
            return relationships;
        }

        public void addRelationship(Relationship relationship) {
            relationships.add(relationship);
        }

        public void removeRelationship(Relationship relationship) {
            relationships.remove(relationship);
        }
    }

    class Relationship {
        private final String type;
        private final Node startNode;
        private final Node endNode;
        private final Map<String, String> properties;

        public Relationship(String type, Node startNode, Node endNode) {
            this.type = type;
            this.startNode = startNode;
            this.endNode = endNode;
            this.properties = new HashMap<>();
        }

        public String getType() {
            return type;
        }

        public Node getStartNode() {
            return startNode;
        }

        public Node getEndNode() {
            return endNode;
        }

    }

    private final Map<String, Node> nodes;
    private final Map<String, List<Relationship>> relationships;

    public GraphDatabase() {
        nodes = new HashMap<>();
        relationships = new HashMap<>();
    }

    public Node createNode(String id) {
        Node node = new Node(id);
        nodes.put(id, node);
        return node;
    }

    public Relationship createRelationship(String type, Node startNode, Node endNode) {
        Relationship relationship = new Relationship(type, startNode, endNode);
        startNode.addRelationship(relationship);
        endNode.addRelationship(relationship);
        relationships.computeIfAbsent(type, k -> new ArrayList<>()).add(relationship);
        return relationship;
    }

    public Node getNode(String id) {
        return nodes.get(id);
    }

    public List<Relationship> getRelationships(String type) {
        return relationships.get(type);
    }

    public void deleteRelation(String node1Name, String node2Name, String relation) {
         Relationship rel=null;
        for (Relationship relationship : relationships.get(relation)) {
            if (relationship.endNode.id.equals(node2Name) && relationship.startNode.id.equals(node1Name)) {
               rel =relationship;
               break;
            }
        }
        deleteRelationship(rel);
    }

    public List<Node> findNodesByProperty(String key, String value) {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes.values()) {
            if (value.equals(node.getProperty(key))) {
                result.add(node);
            }
        }
        return result;
    }



    public void deleteNode(String id) {
        Node node = nodes.remove(id);
        if (node != null) {
            for (Relationship rel : new ArrayList<>(node.getRelationships())) {
                deleteRelationship(rel);
            }
        }
    }

    public void deleteRelationship(Relationship relationship) {
        relationship.getStartNode().removeRelationship(relationship);
        relationship.getEndNode().removeRelationship(relationship);
        List<Relationship> relList = relationships.get(relationship.getType());
        if (relList != null) {
            relList.remove(relationship);
        }
    }

    public void printNodes() {
        System.out.println("Nodes:");
        for (Node node : nodes.values()) {
            System.out.println("Node ID: " + node.getId());
            System.out.println("Relationships:");
            for (Relationship rel : node.getRelationships()) {
                System.out.println("  Type: " + rel.getType() + ", StartNode: " + rel.getStartNode().getId() + ", EndNode: " + rel.getEndNode().getId());
            }
        }
    }

    public void printRelationships() {
        System.out.println("Relationships:");
        for (List<Relationship> relList : relationships.values()) {
            for (Relationship rel : relList) {
                System.out.println("Type: " + rel.getType() + ", StartNode: " + rel.getStartNode().getId() + ", EndNode: " + rel.getEndNode().getId());
            }
        }
    }
}