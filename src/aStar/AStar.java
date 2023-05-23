package aStar;


import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.*;

public class AStar {

    public static List<Vertex> findPath(Graph graph, Vertex start, Vertex end) {

        Map<Vertex, Double> gScore = new HashMap<>();
        Map<Vertex, Double> fScore = new HashMap<>();
        Map<Vertex, Vertex> cameFrom = new HashMap<>();
        PriorityQueue<Vertex> openSet = new PriorityQueue<>(Comparator.comparingDouble(fScore::get));
        Set<Vertex> closedSet = new HashSet<>();

        gScore.put(start, 0.0);
        fScore.put(start, start.getHeuristic());
        openSet.add(start);


        while (!openSet.isEmpty()) {
            Vertex current = openSet.poll();
            if (current.equals(end)) {
                return reconstructPath(cameFrom, current);
            }
            closedSet.add(current);
            for (Edge edge : graph.getEdges(current)) {
                Vertex neighbor = edge.getDestination();
                if (closedSet.contains(neighbor)) {
                    continue;
                }
                double tentativeGScore = gScore.get(current) + edge.getWeight();
                if (!openSet.contains(neighbor) || tentativeGScore < gScore.get(neighbor)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, tentativeGScore + neighbor.getHeuristic());
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return null;
    }

    private static List<Vertex> reconstructPath(Map<Vertex, Vertex> cameFrom, Vertex current) {
        List<Vertex> path = new ArrayList<>();
        path.add(current);
        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(0, current);
        }
        return path;
    }
}



