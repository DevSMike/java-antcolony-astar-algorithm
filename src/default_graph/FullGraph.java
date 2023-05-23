package default_graph;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class FullGraph {

    private static final List<Vertex> vertices = new ArrayList<>();

    public static Graph makeGraph() {
        fillVertex();
        Graph graph = new Graph(vertices);
        fillEdges(graph);
        return graph;
    }

    private static void fillVertex() {
        for (int i = 0; i < 15; i++) {
            vertices.add(new Vertex(i+1, i+1));
        }
    }

    private static void fillEdges(Graph graph) {
        for (int i = 0; i < 15; i++) {
            for (int j = i+1; j < 15; j++) {
                double weight = Math.random() * 10;
                String result = String.format("%.1f",weight);
                weight = Double.parseDouble(result.replace(",", "."));
                graph.addEdge(vertices.get(i), vertices.get(j), weight);
                graph.addEdge(vertices.get(j), vertices.get(i), weight);
                vertices.get(i).addEdge(new Edge(vertices.get(i), vertices.get(j), weight));
                vertices.get(j).addEdge(new Edge(vertices.get(j), vertices.get(i), weight));
            }
        }
    }
}
