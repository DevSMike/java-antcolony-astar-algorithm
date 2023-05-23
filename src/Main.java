import aStar.AStar;
import ant.AntColonyOptimization;
import default_graph.FullGraph;
import default_graph.MakeGraph;
import graph.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph;
        System.out.println("Создать новый граф(1) или использовать граф по умолчанию(2)?");
        String choice = scanner.next();
        switch(choice) {
            case "1": {
                graph = MakeGraph.makeGraph();
                break;
            }
            case "2": {
                graph = FullGraph.makeGraph();
                break;
            }
            default: {
                System.out.println("Введено неверное значение!");
                return;
            }
        }
        System.out.println("Получившийся граф: ");
        graph.printGraph();
        System.out.println("------------------------------");

        List<Vertex> vertices = graph.getVertices();
        System.out.print("Введите ID начальной вершины: ");
        int startId = scanner.nextInt();
        System.out.print("Введите ID конечной вершины: ");
        int endId = scanner.nextInt();
        Vertex start = vertices.get(startId-1);
        Vertex end = vertices.get(endId-1);

        System.out.println("Выберите алгоритм:");
        System.out.println("1. A*");
        System.out.println("2. Ant Colony Optimization");
        int algorithmChoice = scanner.nextInt();
        List<Vertex> path;
        switch (algorithmChoice) {
            case 1:
                path = AStar.findPath(graph, start, end);
                break;
            case 2:
                path = AntColonyOptimization.findPath(graph, start, end);
                break;
            default:
                System.out.println("Неверно.");
                return;
        }
        System.out.println("Путь:");
        for (Vertex vertex : path) {
            System.out.print(vertex.getId()   + "->");
        }
        System.out.println();
    }
}









