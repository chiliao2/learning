package com.cdz.graph.learningresult;

public class ChartWithRights {
    class PriorityQ {
        private Edge[] edges;
        private Integer size = 0;

        public PriorityQ(Integer size) {
            edges = new Edge[size];
        }

        public void insert(Edge edge) {
            if (isFull()) {
                throw new RuntimeException("priorityQ is full,can not insert");
            }
            edges[size++] = edge;

            //优先级排序,权值最小的排在队列最前面
            for (int i = 1; i < size; i++) {
                Edge temp = edges[i];
                while (i >= 1 && temp.weight > edges[i - 1].weight) {
                    edges[i] = edges[i - 1];
                    i--;
                }
                edges[i] = temp;
            }
        }

        public Edge peekN(Integer n) {
            return edges[n];
        }

        public Edge removeMin() {
            return removeN(0);
        }

        public Edge removeN(Integer n) {
            Edge temp = peekN(n);
            for (int i = n; i < size; i++) {
                edges[i] = edges[i + 1];
            }
            size--;
            return temp;
        }


        public Integer findDestIndex(Integer dest) {
            for (int i = 0; i < size; i++) {
                if (edges[i].dest == dest) {
                    return i;
                }
            }
            return -1;
        }

        public boolean isFull() {
            return size == edges.length;
        }
    }

    class Vertex {
        String name;
        boolean isIntree;

        public Vertex(String name) {
            this.name = name;
        }
    }

    class Edge {
        private Integer src;
        private Integer dest;
        private Integer weight;

        public Edge(Integer src, Integer dest, Integer weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    class Graph {

        public Integer inf = 9999;
        //优先级队列
        public PriorityQ pq;

        //顶点集合
        public Vertex[] vertices;

        //权重图
        public int[][] weights;

        //顶点数量
        public int nVerts;

        //当前顶点
        public int currentVert;

        //树集合个数
        public int nTree;

        public Graph(Integer nVerts) {
            this.pq = new PriorityQ(2 * nVerts);
            this.vertices = new Vertex[nVerts];
            this.weights = new int[nVerts][nVerts];
            for (int i = 0; i < nVerts; i++) {
                for (int j = 0; j < nVerts; j++) {
                    weights[i][j] = inf;
                }
            }
        }

        //添加顶点
        public void addVertex(String name) {
            vertices[nVerts++] = new Vertex(name);
        }

        //添加边
        public void addEdge(Integer start, Integer end, Integer weight) {
            weights[start][end] = weight;
            weights[end][start] = weight;
        }

        public void mtsk() {
            currentVert = 0;
            nTree++;
            vertices[currentVert].isIntree = true;
            while (nTree < nVerts) {
                for (int i = 1; i < nVerts; i++) {
                    if (currentVert == i) {
                        continue;
                    }

                    //如果已经处理过了
                    if (vertices[i].isIntree) {
                        continue;
                    }

                    //如果当前顶点到目标顶点的权重值为9999，说明不是直连
                    Integer weight = weights[currentVert][i];
                    if (weight == inf) {
                        continue;
                    }
                    for (int j = 0; j < pq.size; j++) {
                        Integer findIndex = pq.findDestIndex(i);
                        if (findIndex != -1) {
                            Edge temp = pq.peekN(findIndex);
                            if (temp.weight > weight) {
                                pq.removeN(findIndex);
                                pq.insert(new Edge(currentVert, i, weight));
                            }
                        } else {
                            pq.insert(new Edge(currentVert, i, weight));
                        }
                    }
                }
                Edge min = pq.removeMin();
                System.out.print(min.src);
                System.out.print(min.dest);
                currentVert = min.dest;
                nTree++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ChartWithRights sgwwg = new ChartWithRights();
        Graph graph = sgwwg.new Graph(6);
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
        graph.mtsk();
    }
}
