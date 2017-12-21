package com.cdz.graph;

import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Graph {
    //顶点
    private List<Vertex> vertices;

    //边
    private Integer[][] edges;

    public Graph(Integer vertexNum) {
        vertices = new ArrayList<>(vertexNum);
        edges = new Integer[vertexNum][vertexNum];
    }

    //添加顶点
    public void addVertes(String name) {
        vertices.add(new Vertex(name));
    }

    //添加边
    public void addEdge(Integer start, Integer end) {
        edges[start][end] = 1;
        edges[end][start] = 1;
    }

    public void addDirectedEdge(Integer start, Integer end) {
        edges[start][end] = 1;
    }

    /**
     * 广度优先搜索
     */
    public void widthFirstTraversal() {
        LinkedList<Integer> queue = new LinkedList<>();
        Vertex vertex = vertices.get(0);
        vertex.isVisited = true;
        vertex.displayVertexName();
        queue.addLast(0);
        while (!queue.isEmpty()) {
            Integer n = getUnVisitedVertex(queue.getFirst());
            if (n == -1) {
                queue.removeFirst();
                continue;
            }
            Vertex next = vertices.get(n);
            next.isVisited = true;
            next.displayVertexName();
            queue.addLast(n);
        }
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).isVisited = false;
        }
    }

    /**
     * 深度优先遍历
     */
    public void depthFirstTraversal() {
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        Vertex vertex = vertices.get(0);
        vertex.isVisited = true;
//        vertex.displayVertexName();
        deque.push(0);
        while (!deque.isEmpty()) {
            Integer currentVertex = deque.peek();
            Integer i = getUnVisitedVertex(currentVertex);
            if (i == -1) {
                deque.pop();
                continue;
            }
            Vertex next = vertices.get(i);
            next.isVisited = true;
            vertices.get(currentVertex).displayVertexName();
            next.displayVertexName();
            deque.push(i);
            System.out.println();
        }
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).isVisited = false;
        }
    }

    /**
     * 获取下一个未被访问的顶点
     *
     * @param start
     * @return
     */
    private Integer getUnVisitedVertex(Integer start) {
        for (int i = 0; i < vertices.size(); i++) {
            if (edges[start][i] != null && !vertices.get(i).isVisited) {
                return i;
            }
        }
        return -1;
    }

    public Integer[][] getEdges() {
        return edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addVertes("A");
        graph.addVertes("B");
        graph.addVertes("C");
        graph.addVertes("D");
        graph.addVertes("E");
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.depthFirstTraversal();
        System.out.println();
        graph.widthFirstTraversal();
    }
}
