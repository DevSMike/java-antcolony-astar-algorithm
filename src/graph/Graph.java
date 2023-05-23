package graph;

import java.util.*;


public class Graph {

        private List<Vertex> vertices;
        private Map<Vertex, List<Edge>> edges;

        public Graph(List<Vertex> ver) {
            vertices = new ArrayList<>();
            edges = new HashMap<>();
            for (Vertex v : ver) {
                addVertex(v);
            }
        }

        public void addVertex(Vertex vertex) {
            vertices.add(vertex);
            edges.put(vertex, new ArrayList<>());
        }

        public void addEdge(Vertex source, Vertex destination, double weight) {
            Edge edge = new Edge(source, destination, weight);
            edges.get(source).add(edge);
        }

        public List<Vertex> getVertices() {
            return vertices;
        }

        public List<Edge> getEdges(Vertex vertex) {
            return edges.get(vertex);
        }

    public Vertex getRandomVertex() {
        List<Vertex> vertices = new ArrayList<>(getVertices());
        Random random = new Random();
        int randomIndex = random.nextInt(vertices.size());
        return vertices.get(randomIndex);
    }

    public void printGraph() {
        for (Vertex vertex : vertices) {
            System.out.print("Vertex " + vertex.getId() + ": ");
            for (Edge edge : edges.get(vertex)) {
                Vertex dest = edge.getDestination();
                double weight = edge.getWeight();
                System.out.print("[" + dest.getId() + ", " + weight + "] ");
            }
            System.out.println();
        }
    }

}




