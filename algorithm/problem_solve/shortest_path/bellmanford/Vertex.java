package com.algorith.problem_solve.shortest_path.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private double distance = Double.MAX_VALUE;
    private Vertex previousVertex;
    private List<Edge> adjacencies;

    public Vertex(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
    }

    public void addNeighbour(Edge edge){
        this.adjacencies.add(edge);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
