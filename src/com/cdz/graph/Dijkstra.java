package com.cdz.graph;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    class DisPar {
        public int distance;
        public int parentVert;

        public DisPar(int pv, int d) {
            this.parentVert = pv;
            this.distance = d;
        }
    }

    class Vertex {
        public char label;
        public boolean isIntree = false;

        public Vertex(char label) {
            this.label = label;
        }
    }

    class Graph {
        public int maxVerts = 20;
        public Vertex[] vertexList = new Vertex[maxVerts];
        public Integer adjMat[][];
        public int nVerts;
        public int nTree;
        public DisPar[] sPath;
        public int currentVert;
        public int startToCurrent;

        public Graph() {
            adjMat = new Integer[maxVerts][maxVerts];
            sPath = new DisPar[maxVerts];
            for (int i = 0; i < maxVerts; i++) {
                for (int j = 0; j < maxVerts; j++) {
                    adjMat[i][j] = 9999;
                }
            }
        }

        public void addVertex(Character lable) {
            vertexList[nVerts++] = new Vertex(lable);
        }

        public void addEdge(int start, int end, int weight) {
            adjMat[start][end] = weight;
        }

        public void path() {
            int startTree = 0;
            vertexList[startTree].isIntree = true;
            nTree = 1;
            for (int j = 0; j < nVerts; j++) {
                int tempDist = adjMat[startTree][j];
                sPath[j] = new DisPar(startTree, tempDist);
            }
            while (nTree < nVerts) {
                int indexMin = getMin();
                int minDist = sPath[indexMin].distance;
                if (minDist == 9999) {
                    System.out.println("there are unreachable vertices");
                    return;
                }
                currentVert = indexMin;
                startToCurrent = minDist;
                vertexList[currentVert].isIntree = true;
                nTree++;
                adjust_spath();
            }
            displayPaths();
        }

        private void displayPaths() {
            for (int j = 0; j < nVerts; j++) {
                System.out.print(vertexList[j].label + "=");
                if (sPath[j].distance == 9999) {
                    System.out.print("inf");
                } else {
                    System.out.print(sPath[j].distance);
                }
                char parent = vertexList[sPath[j].parentVert].label;
                System.out.print("{" + parent + "}");
            }
            System.out.println();
        }

        private void adjust_spath() {
            int column = 1;
            while (column < nVerts) {
                if (vertexList[column].isIntree) {
                    column++;
                    continue;
                }
                int currentToFridge = adjMat[currentVert][column];
                int startToFridge = startToCurrent + currentToFridge;
                int sPathDist = sPath[column].distance;
                if (startToFridge < sPathDist) {
                    sPath[column].distance = startToFridge;
                    sPath[column].parentVert = currentVert;
                }
                column++;
            }
        }

        private int getMin() {
            int min = 9999;
            int k = 0;
            for (int j = 0; j < nVerts; j++) {
                if (!vertexList[j].isIntree && sPath[j].distance < min) {
                    min = sPath[j].distance;
                    k = j;
                }
            }
            return k;
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        Dijkstra.Graph graph = dijkstra.new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addEdge(0, 1, 50);
        graph.addEdge(0, 3, 80);
        graph.addEdge(1, 2, 60);
        graph.addEdge(1, 3, 90);
        graph.addEdge(2, 4, 40);
        graph.addEdge(3, 2, 20);
        graph.addEdge(3, 4, 70);
        graph.addEdge(4, 1, 50);
        graph.path();
    }
}
