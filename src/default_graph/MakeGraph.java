package default_graph;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeGraph {

    private static final List<Vertex> vertices = new ArrayList<>();

    public static Graph makeGraph() {
        fillVertex();
        Graph graph = new Graph(vertices);
        fillEdges(graph);
        return graph;
    }
    private static void fillVertex() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество вершин: ");
        int numVertices = scanner.nextInt();
        System.out.println("------------------------------");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Введите эвристическую значимость для вершины " + (i + 1) + ": ");
            double heuristic = scanner.nextDouble();
            vertices.add(new Vertex(i, heuristic));
            System.out.println("------------------------------");
        }
    }

    private static void fillEdges(Graph graph) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество ребёр: ");
        int numEdges = scanner.nextInt();
        System.out.println("------------------------------");
        for (int i = 0; i < numEdges; i++) {
            System.out.print("Введите ID первой вершины ребра " + (i + 1) + ": ");
            int vertex1Id = scanner.nextInt();
            System.out.print("Введите ID второй вершины ребра " + (i + 1) + ": ");
            int vertex2Id = scanner.nextInt();
            System.out.print("Введите весовой коэффициент ребра " + (i + 1) + ": ");
            double weight = scanner.nextDouble();
            Vertex vertex1 = vertices.get(vertex1Id-1);
            Vertex vertex2 = vertices.get(vertex2Id-1);
            graph.addEdge(vertex1, vertex2, weight);
            vertex1.addEdge(new Edge(vertex1, vertex2, weight));
            System.out.println("------------------------------");
        }
    }

}
