package com.problemsolve.bellman_ford;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
        edgeList.add(new Edge(-11, vertexList.get(1), vertexList.get(2)));
        edgeList.add(new Edge(-1, vertexList.get(2), vertexList.get(1)));

        BellmanFord bellmanFord = new BellmanFord(edgeList, vertexList);
        bellmanFord.bellmanFord(vertexList.get(0));
//        bellmanFord.shortestPathTo(vertexList.get(2));
    }
}
