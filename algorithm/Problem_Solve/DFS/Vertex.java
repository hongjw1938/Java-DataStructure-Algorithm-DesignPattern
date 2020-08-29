package com.problemsolve.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> neighborList;

    // 이것은 Cycle Detection을 위해 쓰임
    // 이 내용이 true인데 다시 방문을 했다면 Cycle이 있다고 판단 가능
    private boolean beingVisited;


    public Vertex(String name){
        this.name = name;
        this.neighborList = new ArrayList<>();
    }

    public void setNeighborList(List<Vertex> neighborList) {
        this.neighborList = neighborList;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
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
