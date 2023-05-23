package default_graph;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class GraphByDefault {
    private static final List<Vertex> vertices = new ArrayList<>();

    public static Graph getGraphByDefault() {
        fillVertex();
        Graph graph = new Graph(vertices);
        fillEdges(graph);
        return graph;
    }

    private static void fillVertex() {
        vertices.add(new Vertex(0,7));
        vertices.add(new Vertex(1,6));
        vertices.add(new Vertex(2,9));
        vertices.add(new Vertex(3,1));
        vertices.add(new Vertex(4,0));
        vertices.add(new Vertex(5,4));
        vertices.add(new Vertex(6,6));
        vertices.add(new Vertex(7,9));
        vertices.add(new Vertex(8,1));
        vertices.add(new Vertex(9,0));
        vertices.add(new Vertex(10,2));
        vertices.add(new Vertex(11,0));
        vertices.add(new Vertex(12,0));
        vertices.add(new Vertex(13,3));
        vertices.add(new Vertex(14,0));
    }

    private static void fillEdges(Graph graph) {
        //1 --10->2
        graph.addEdge(vertices.get(0), vertices.get(1), 10.0);
        vertices.get(0).addEdge(new Edge(vertices.get(0), vertices.get(1), 10.0));
        //1 --12-> 3
        graph.addEdge(vertices.get(0), vertices.get(2), 12.0);
        vertices.get(0).addEdge(new Edge(vertices.get(0), vertices.get(2), 12.0));
        //1 --23-> 5
        graph.addEdge(vertices.get(0), vertices.get(4), 23.0);
        vertices.get(0).addEdge(new Edge(vertices.get(0), vertices.get(4), 23.0));

        //2 --18-> 6
        graph.addEdge(vertices.get(1), vertices.get(5), 18.0);
        vertices.get(1).addEdge(new Edge(vertices.get(1), vertices.get(5), 18.0));

        //2 --6-> 5
        graph.addEdge(vertices.get(1), vertices.get(4), 6.0);
        vertices.get(1).addEdge(new Edge(vertices.get(1), vertices.get(4), 6.0));

        //2 --14-> 4
        graph.addEdge(vertices.get(1), vertices.get(3), 14.0);
        vertices.get(1).addEdge(new Edge(vertices.get(1), vertices.get(3), 14.0));

        //3 --20->5
        graph.addEdge(vertices.get(2), vertices.get(4), 20.0);
        vertices.get(2).addEdge(new Edge(vertices.get(2), vertices.get(4), 20.0));

        //3 --4-> 4
        graph.addEdge(vertices.get(2), vertices.get(3), 4.0);
        vertices.get(2).addEdge(new Edge(vertices.get(2), vertices.get(3), 4.0));

        // 3 --34-> 7
        graph.addEdge(vertices.get(2), vertices.get(6), 34.0);
        vertices.get(2).addEdge(new Edge(vertices.get(2), vertices.get(6), 34.0));

        // 4 --26 -> 6
        graph.addEdge(vertices.get(3), vertices.get(5), 26.0);
        vertices.get(3).addEdge(new Edge(vertices.get(3), vertices.get(5), 26.0));

        //4 --7 -> 7
        graph.addEdge(vertices.get(3), vertices.get(6), 7.0);
        vertices.get(3).addEdge(new Edge(vertices.get(3), vertices.get(6), 7.0));

        // 4 --40-> 9
        graph.addEdge(vertices.get(3), vertices.get(8), 40.0);
        vertices.get(3).addEdge(new Edge(vertices.get(3), vertices.get(8), 40.0));

        //5 --7-> 6
        graph.addEdge(vertices.get(4), vertices.get(5), 7.0);
        vertices.get(4).addEdge(new Edge(vertices.get(4), vertices.get(5), 7.0));

        // 5 --23-> 8
        graph.addEdge(vertices.get(4), vertices.get(7), 23.0);
        vertices.get(4).addEdge(new Edge(vertices.get(4), vertices.get(7), 23.0));

        // 5 --10-> 7
        graph.addEdge(vertices.get(4), vertices.get(8), 10.0);
        vertices.get(4).addEdge(new Edge(vertices.get(4), vertices.get(8), 10.0));

        // 6 --3-> 8
        graph.addEdge(vertices.get(5), vertices.get(7), 3.0);
        vertices.get(5).addEdge(new Edge(vertices.get(5), vertices.get(7), 3.0));

        //6 --14 -> 12
        graph.addEdge(vertices.get(5), vertices.get(11), 14.0);
        vertices.get(5).addEdge(new Edge(vertices.get(5), vertices.get(11), 14.0));

        // 7 --6-> 10
        graph.addEdge(vertices.get(6), vertices.get(9), 6.0);
        vertices.get(6).addEdge(new Edge(vertices.get(6), vertices.get(9), 6.0));

        // 8 --8-> 12
        graph.addEdge(vertices.get(7), vertices.get(11), 8.0);
        vertices.get(7).addEdge(new Edge(vertices.get(7), vertices.get(11), 8.0));

        // 8 --1-> 10
        graph.addEdge(vertices.get(7), vertices.get(9), 1.0);
        vertices.get(7).addEdge(new Edge(vertices.get(7), vertices.get(9), 1.0));

        // 9 --5-> 10
        graph.addEdge(vertices.get(8), vertices.get(9), 5.0);
        vertices.get(8).addEdge(new Edge(vertices.get(8), vertices.get(9), 5.0));

        //9 --8-> 13
        graph.addEdge(vertices.get(8), vertices.get(12), 8.0);
        vertices.get(8).addEdge(new Edge(vertices.get(8), vertices.get(12), 8.0));

        // 10 --1-> 11
        graph.addEdge(vertices.get(9), vertices.get(10), 1.0);
        vertices.get(9).addEdge(new Edge(vertices.get(9), vertices.get(10), 1.0));

        //10 --4-> 13
        graph.addEdge(vertices.get(9), vertices.get(12), 4.0);
        vertices.get(9).addEdge(new Edge(vertices.get(9), vertices.get(12), 4.0));

        // 11 --4-> 12
        graph.addEdge(vertices.get(10), vertices.get(11), 4.0);
        vertices.get(10).addEdge(new Edge(vertices.get(10), vertices.get(11), 4.0));

        // 11 --9-> 15
        graph.addEdge(vertices.get(10), vertices.get(14), 9.0);
        vertices.get(10).addEdge(new Edge(vertices.get(10), vertices.get(14), 9.0));

        // 12 --4-> 15
        graph.addEdge(vertices.get(11), vertices.get(14), 4.0);
        vertices.get(11).addEdge(new Edge(vertices.get(11), vertices.get(14), 4.0));

        //12 --6-> 14
        graph.addEdge(vertices.get(11), vertices.get(13), 6.0);
        vertices.get(11).addEdge(new Edge(vertices.get(11), vertices.get(13), 6.0));

        //13 --3-> 14
        graph.addEdge(vertices.get(12), vertices.get(13), 3.0);
        vertices.get(12).addEdge(new Edge(vertices.get(12), vertices.get(13), 3.0));

        //14 --6-> 15
        graph.addEdge(vertices.get(13), vertices.get(14), 6.0);
        vertices.get(13).addEdge(new Edge(vertices.get(13), vertices.get(14), 6.0));

    }
}
