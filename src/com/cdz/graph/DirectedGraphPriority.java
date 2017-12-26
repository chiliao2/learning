package com.cdz.graph;

import java.util.LinkedList;

public class DirectedGraphPriority {
    private Graph graph = new Graph(8);

    {
        graph.addVertes("A");//0
        graph.addVertes("B");//1
        graph.addVertes("C");//2
        graph.addVertes("D");//3
        graph.addVertes("E");//4
        graph.addVertes("F");//5
        graph.addVertes("G");//6
        graph.addVertes("H");//7
        graph.addDirectedEdge(0, 3);
        graph.addDirectedEdge(0, 4);
        graph.addDirectedEdge(1, 4);
        graph.addDirectedEdge(2, 5);
        graph.addDirectedEdge(3, 6);
        graph.addDirectedEdge(4, 6);
        graph.addDirectedEdge(5, 7);
        graph.addDirectedEdge(6, 7);
    }

    public LinkedList<String> getVertexList() {
        LinkedList<String> list = new LinkedList<String>();
        Integer vertexNum = graph.getVertexNum();
        Integer[][] edges = graph.getEdges();
        while (true) {

            //如果顶点全部取完，循环终止
            if (list.size() == vertexNum) {
                break;
            }
            for (int i = 0; i < vertexNum; i++) {
                boolean found = false;
                Integer[] row = edges[i];
                for (int j = 0; j < row.length; j++) {
                    if (edges[i][j] != null) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    String name = graph.getVertices().get(i).name;
                    if (!list.contains(name)) {
                        list.addLast(name);
                        for (int k = 0; k < vertexNum; k++) {
                            edges[k][i] = null;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        DirectedGraphPriority directedGraphPriority = new DirectedGraphPriority();
        LinkedList<String> linkedList = directedGraphPriority.getVertexList();
        while (!linkedList.isEmpty()) {
            System.out.print(linkedList.removeLast());
        }
    }
}
