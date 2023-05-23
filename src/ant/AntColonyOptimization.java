package ant;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AntColonyOptimization {
    private static final int MAX_ITERATIONS = 1000;
    private static final int NUM_ANTS = 10;
    private static final double ALPHA = 1.0;
    private static final double BETA = 2.0;
    private static final double RHO = 0.5;
    private static final double Q = 100.0;
    private static final double INITIAL_PHEROMONE = 0.1;

    public static List<Vertex> findPath(Graph graph, Vertex start, Vertex end) {
        List<Vertex> bestPath = null;
        double bestPathLength = Double.POSITIVE_INFINITY;
        double[][] pheromoneLevels = new double[graph.getVertices().size()+1][graph.getVertices().size()+1];
        for (int i = 0; i < graph.getVertices().size(); i++) {
            for (int j = 0; j < graph.getVertices().size(); j++) {
                pheromoneLevels[i][j] = INITIAL_PHEROMONE;
            }
        }
        for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
            List<Vertex> iterationBestPath = null;
            double iterationBestPathLength = Double.POSITIVE_INFINITY;
            for (int ant = 0; ant < NUM_ANTS; ant++) {
                List<Vertex> path = findAntPath(graph, start, end, pheromoneLevels);
                double pathLength = calculatePathLength(graph, path);
                if (pathLength < iterationBestPathLength) {
                    iterationBestPath = path;
                    iterationBestPathLength = pathLength;
                }
            }
            if (iterationBestPathLength < bestPathLength) {
                bestPath = iterationBestPath;
                bestPathLength = iterationBestPathLength;
            }
            updatePheromoneLevels(graph, pheromoneLevels, bestPath, Q);
        }
        return bestPath;
    }

    private static List<Vertex> findAntPath(Graph graph, Vertex start, Vertex end, double[][] pheromoneLevels) {
        List<Vertex> path = new ArrayList<>();
        Vertex current = start;
        while (!current.equals(end)) {
            path.add(current);
            List<Vertex> neighbors = getUnvisitedNeighbors(graph, current, path);
            double[] probabilities = calculateProbabilities(graph, current, end, neighbors, pheromoneLevels);
            current = selectNextVertex(neighbors, probabilities, graph);
        }
        path.add(end);
        return path;
    }

    private static List<Vertex> getUnvisitedNeighbors(Graph graph, Vertex vertex, List<Vertex> visited) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : graph.getEdges(vertex)) {
            Vertex neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    private static double[] calculateProbabilities(Graph graph, Vertex current, Vertex end, List<Vertex> neighbors, double[][] pheromoneLevels) {
        double[] probabilities = new double[neighbors.size()];
        double total = 0.0;
        for (int i = 0; i < neighbors.size(); i++) {
            Vertex neighbor = neighbors.get(i);
            double distance = calculateDistance(current, neighbor);
            double heuristic = calculateHeuristic(neighbor, end);
            double pheromoneLevel = pheromoneLevels[current.getId()][neighbor.getId()];
            probabilities[i] = Math.pow(pheromoneLevel, ALPHA) * Math.pow(heuristic, BETA);
            total += probabilities[i];
        }
        for (int i = 0; i < neighbors.size(); i++) {
            probabilities[i] /= total;
        }
        return probabilities;
    }

    private static Vertex selectNextVertex(List<Vertex> neighbors, double[] probabilities, Graph graph) {
        double randomValue = Math.random();
        double cumulativeProbability = 0.0;
        for (int i = 0; i < neighbors.size(); i++) {
            cumulativeProbability += probabilities[i];
            if (cumulativeProbability >= randomValue) {
                return neighbors.get(i);
            }
        }
        return neighbors.get(neighbors.size() - 1);
    }

    private static double calculatePathLength(Graph graph, List<Vertex> path) {
        double length = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            Vertex current = path.get(i);
            Vertex next = path.get(i + 1);
            length += calculateDistance(current, next);
        }
        return length;
    }

    private static double calculateDistance(Vertex vertex1, Vertex vertex2) {
        List<Double> distance2  = Collections.singletonList(vertex1.getEdges().stream()
                .filter(edge -> edge.getDestination().equals(vertex2)).mapToDouble(Edge::getWeight).findFirst().orElse(0.0));
       return distance2.get(0);
    }

    private static double calculateHeuristic(Vertex vertex, Vertex end) {
        return calculateDistance(vertex, end);
    }


    private static void updatePheromoneLevels(Graph graph, double[][] pheromoneLevels, List<Vertex> bestPath, double q) {
        for (int i = 0; i < graph.getVertices().size(); i++) {
            for (int j = 0; j < graph.getVertices().size(); j++) {
                pheromoneLevels[i][j] *= (1.0 - RHO);
                if (pheromoneLevels[i][j] < 0.0) {
                    pheromoneLevels[i][j] = INITIAL_PHEROMONE;
                }
            }
        }
        double pheromoneToAdd = q / calculatePathLength(graph, bestPath);
        for (int i = 0; i < bestPath.size() - 1; i++) {
            Vertex current = bestPath.get(i);
            Vertex next = bestPath.get(i + 1);
            pheromoneLevels[current.getId()][next.getId()] += pheromoneToAdd;
            pheromoneLevels[next.getId()][current.getId()] += pheromoneToAdd;
        }
    }
}
