package diploma.neo4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphDatabase {
class Node {
    private final String id;
    private final Map<String, String> properties;
    private final List<Relationship> relationships;

    public Node(String id) {
        this.id = id;
        this.properties = new HashMap<>();
        this.relationships = new ArrayList<>();
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

    public List<Node> findNodesByProperty(String key, String value) {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes.values()) {
            if (value.equals(node.getProperty(key))) {
                result.add(node);
            }
        }
        return result;
    }

    public List<Relationship> findRelationshipsByProperty(String key, String value) {
        List<Relationship> result = new ArrayList<>();
        for (List<Relationship> relList : relationships.values()) {
            for (Relationship rel : relList) {
                if (value.equals(rel.getProperty(key))) {
                    result.add(rel);
                }
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
}
