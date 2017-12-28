package com.cdz.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 带权图的最小生成树
 */
public class SparseGraphWithWeightedGraph {
    PriorityQ p = new PriorityQ(10);

    /**
     * 边
     */
    class Edge {
        private Integer srcVert;
        private Integer destVert;
        private Integer weight;

        public Edge() {
        }

        public Edge(Integer srcVert, Integer destVert, Integer weight) {
            this.srcVert = srcVert;
            this.destVert = destVert;
            this.weight = weight;
        }
    }

    /**
     * 优先级队列
     */
    class PriorityQ {
        private Integer size;
        private Edge[] edges;

        public PriorityQ(Integer size) {
            edges = new Edge[size];
            this.size = 0;
        }

        public void insert(Edge edge) {
            if (isEmpty()) {
                throw new RuntimeException("can not insert edge");
            }
            int i = 0;
            for (; i < size; i++) {
                if (edge.weight > edges[i].weight) {
                    break;
                }
            }
            for (int j = size - 1; j >= i; j--) {
                edges[j + 1] = edges[j];
            }
            edges[i] = edge;
            size++;
        }

        public Edge removeMin() {
            return edges[--size];
        }

        public Edge peek() {
            return edges[size - 1];
        }

        public Edge peekN(Integer index) {
            return edges[index];
        }

        public void removeN(int n) {
            for (int i = n; i < this.size; i++) {
                edges[n] = edges[n + 1];
            }
            n--;
        }

        public int find(int findDex) {
            for (int j = 0; j < size; j++) {
                if (edges[j].destVert == findDex) {
                    return j;
                }
            }
            return -1;
        }

        public int sise() {
            return size;
        }

        public boolean isEmpty() {
            return size == edges.length;
        }

    }

    /**
     * 顶点
     */
    class Vertex {
        private String name;
        private boolean isInTree;

        public Vertex(String name) {
            this.name = name;
            this.isInTree = false;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isInTree() {
            return isInTree;
        }

        public void setInTree(boolean inTree) {
            isInTree = inTree;
        }
    }

    class Graph {
        private int maxSize = 10;
        PriorityQ p = new PriorityQ(maxSize);
        private List<Vertex> vertices;
        private Integer[][] adjMat;
        private int nVerts;
        private int currentVert;
        private int nTree;

        public Graph() {
            vertices = new ArrayList<>(maxSize);
            adjMat = new Integer[maxSize][maxSize];
            nVerts = 0;
            currentVert = 0;
        }

        public void addVertex(String name) {
            vertices.add(new Vertex(name));
            nVerts++;
        }

        public void addEdge(int start, int end, int weight) {
            adjMat[start][end] = weight;
            adjMat[end][start] = weight;
        }

        public void mstw() {
            while (nTree < nVerts) {
                vertices.get(currentVert).isInTree = true;
                nTree++;
                for (int i = 0; i < nVerts; i++) {
                    if (currentVert == i) {
                        continue;
                    }
                    if (vertices.get(i).isInTree) {
                        continue;
                    }
                    Integer weight = adjMat[currentVert][i];
                    if (weight == null) {
                        continue;
                    }
                    putInPQ(i, weight);
                }
                if (p.isEmpty()) {
                    System.out.println("can not connected");
                    return;
                }
                Edge min = p.removeMin();
                int srcVert = min.srcVert;
                currentVert = min.destVert;
                System.out.print(vertices.get(srcVert).name);
                System.out.print(vertices.get(currentVert).name);
                System.out.println();
            }
        }

        public void putInPQ(Integer newVert, int newDist) {
            int qIndex = this.p.find(newVert);
            if (qIndex != -1) {
                Edge temp = p.peekN(qIndex);
                int oldDist = temp.weight;
                if (oldDist > newDist) {
                    p.removeN(qIndex);
                    Edge edge = new Edge(currentVert, newVert, newDist);
                    this.p.insert(edge);
                }
            } else {
                Edge edge = new Edge(currentVert, newVert, newDist);
                this.p.insert(edge);
            }
        }
    }

    public static void main(String[] args) {
        SparseGraphWithWeightedGraph sgwwg = new SparseGraphWithWeightedGraph();
        Graph graph = sgwwg.new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 5);
        graph.addEdge(2, 5, 6);
        graph.addEdge(3, 4, 12);
        graph.addEdge(4, 5, 7);
        graph.mstw();


    }
}
