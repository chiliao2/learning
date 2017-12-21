package com.cdz.graph;

public class Vertex {
    private String name;
    public boolean isVisited = false;

    public Vertex(String name) {
        this.name = name;
    }

    public void displayVertexName() {
        System.out.print(name);
    }
}
