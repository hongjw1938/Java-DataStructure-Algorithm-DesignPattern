package com.problemsolve.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> neighborList;

    public Vertex(String name){
        this.name = name;
        this.neighborList = new ArrayList<>();
    }

    public void addNeighbor(Vertex vertex){
        this.neighborList.add(vertex);
    }

    public List<Vertex> getNeighborList() {
        return neighborList;
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

    @Override
    public String toString() {
        return this.name;
    }
}
