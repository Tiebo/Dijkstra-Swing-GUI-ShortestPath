package models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static int count = 1;
    private static List<Node> nodes = new ArrayList<>();
    private static List<Edge> edges = new ArrayList<>();

    private static Node source;
    private static Node destination;

    private boolean solved = false;

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setNodes(List<Node> nodes) {
        Graph.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setEdges(List<Edge> edges) {
        Graph.edges = edges;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setSource(Node node) {
        if (nodes.contains(node))
            source = node;
    }

    public void setDestination(Node node) {
        if (nodes.contains(node))
            destination = node;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public boolean isSource(Node node) {
        return node == source;
    }

    public boolean isDestination(Node node) {
        return node == destination;
    }

    public void addNode(Point coord) {
        Node node = new Node(coord);
        addNode(node);
    }

    public void addNode(Node node) {
        node.setId(count++);

        nodes.add(node);
    }

/*
    public void clear() {
        count = 1;
        nodes.clear();
        edges.clear();
        solved = false;

        source = null;
        destination = null;
    }
 *
 */

    //下面三个方法只是用来方便初始化地图
    public Node GetNodeAt(int id) {
        for(Node node :nodes)
        {
            if(node.getId()==id)
                return node;
        }
        return null;
    }

    public Edge GetEdgeAt(int a, int b){
        for(Edge edge : edges)
        {
            if(edge.getNodeOne().getId()==a && edge.getNodeTwo().getId() ==b)
                return edge;
        }
        return null;
    }

    public void addEdge(Edge new_edge) {
        edges.add(new_edge);
    }

}
