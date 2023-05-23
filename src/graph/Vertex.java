package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private final int id;
    private double x;
    private double y;
    private final double heuristic;
    private final List<Edge> edges;

    public Vertex(int id, double heuristic) {
        this.id = id;
        this.heuristic = heuristic;
        this.edges = new ArrayList<>();
    }

    public Vertex(int id, double x, double y, double heuristic) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.heuristic = heuristic;
        this.edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                '}';
    }
}
