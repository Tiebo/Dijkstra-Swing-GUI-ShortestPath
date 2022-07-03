package algo;

import models.Edge;
import models.Graph;
import models.Node;

import java.util.*;

public class DijkstraAlgorithm {

    private final Graph graph;
    private final Map<Node, Node> predecessors;
    private final Map<Node, Integer> distances;

    private PriorityQueue<Node> unvisited;
    private final HashSet<Node> visited;

    //重写比较器
    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return distances.get(node1) - distances.get(node2);
        }
    }

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
        predecessors = new HashMap<>();
        distances = new HashMap<>();

        for (Node node : graph.getNodes()) {
            //使用0x3f3f3f3f代替无穷大距离
            distances.put(node, 0x3f3f3f3f);
        }

        visited = new HashSet<>();
    }

    public void run() {

        unvisited = new PriorityQueue<>(graph.getNodes().size(), new NodeComparator());
        //初始化
        Node source = graph.getSource();
        distances.put(source, 0);
        visited.add(source);

        for (Edge neighbor : getNeighbors(source)) {
            Node adjacent = getAdjacent(neighbor, source);
            if (adjacent == null)
                continue;

            distances.put(adjacent, neighbor.getWeight());
            predecessors.put(adjacent, source);
            unvisited.add(adjacent);
        }

        while (!unvisited.isEmpty()) {
            Node current = unvisited.poll();

            updateDistance(current);

            unvisited.remove(current);
            visited.add(current);
        }

        for (Node node : graph.getNodes()) {
            node.setPath(getPath(node));
        }

        graph.setSolved(true);

    }

    private void updateDistance(Node node) {
        int distance = distances.get(node);

        for (Edge neighbor : getNeighbors(node)) {
            Node adjacent = getAdjacent(neighbor, node);
            if (visited.contains(adjacent))
                continue;

            int current_dist = distances.get(adjacent);
            int new_dist = distance + neighbor.getWeight();

            if (new_dist < current_dist) {
                distances.put(adjacent, new_dist);
                predecessors.put(adjacent, node);
                unvisited.add(adjacent);
            }
        }
    }

    private Node getAdjacent(Edge edge, Node node) {
        if (edge.getNodeOne() != node && edge.getNodeTwo() != node)
            return null;

        return node == edge.getNodeTwo() ? edge.getNodeOne() : edge.getNodeTwo();
    }

    private List<Edge> getNeighbors(Node node) {
        List<Edge> neighbors = new ArrayList<>();

        for (Edge edge : graph.getEdges()) {
            if (edge.getNodeOne() == node || edge.getNodeTwo() == node)
                neighbors.add(edge);
        }

        return neighbors;
    }

    public Integer getDestinationDistance() {
        return distances.get(graph.getDestination());
    }

    public Integer getDistance(Node node) {
        return distances.get(node);
    }

    public List<Node> getDestinationPath() {
        return getPath(graph.getDestination());
    }

    public List<Node> getPath(Node node) {
        List<Node> path = new ArrayList<>();

        Node current = node;
        path.add(current);
        while (current != graph.getSource()) {
            current = predecessors.get(current);
            path.add(current);
        }

        Collections.reverse(path);
        return path;
    }

}
