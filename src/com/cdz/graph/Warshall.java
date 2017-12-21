package com.cdz.graph;

import java.util.List;

public class Warshall {
    private List<Vertex> vertices;
    private Integer[][] edges;

    public void union(Graph graph) {
        vertices = graph.getVertices();
        edges = graph.getEdges();
        display();
        System.out.println("-----------------------");
        for (int y = 0; y < vertices.size(); y++) {
            Integer[] rows = edges[y];
            for (int x = 0; x < rows.length; x++) {
                if (edges[y][x] != null) {
                    for (int z = 0; z < edges.length; z++) {
                        if (edges[z][y] != null) {
                            edges[z][x] = 1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addVertes("A");
        graph.addVertes("B");
        graph.addVertes("C");
        graph.addVertes("D");
        graph.addVertes("E");
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(1, 0);
        graph.addDirectedEdge(1, 4);
        graph.addDirectedEdge(3, 4);
        graph.addDirectedEdge(4, 2);
        Warshall warshall = new Warshall();
        warshall.union(graph);
        warshall.display();
    }

    public void display() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (edges[i][j] != null) {
                    System.out.print(edges[i][j] + ",");
                } else {
                    System.out.print(0 + ",");
                }
            }
            System.out.println();
        }
    }

}
