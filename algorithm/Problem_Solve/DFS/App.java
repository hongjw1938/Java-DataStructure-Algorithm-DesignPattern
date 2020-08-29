package com.problemsolve.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args){
//        Vertex v1 = new Vertex("1");
//        Vertex v2 = new Vertex("2");
//        Vertex v3 = new Vertex("3");
//        Vertex v4 = new Vertex("4");
//        Vertex v5 = new Vertex("5");
//
//
//        List<Vertex> list = new ArrayList<>();
//
//        v1.addNeighbor(v2);
//        v1.addNeighbor(v3);
//        v3.addNeighbor(v4);
//        v4.addNeighbor(v5);
//
//        list.add(v1);
//        list.add(v2);
//        list.add(v3);
//        list.add(v4);
//        list.add(v5);
//
//        DFSWithStack dfs = new DFSWithStack();
//        dfs.dfs(list);

//        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
//
//        List<Vertex> graph = new ArrayList<>();
//        graph.add(new Vertex("0"));
//        graph.add(new Vertex("1"));
//        graph.add(new Vertex("2"));
//        graph.add(new Vertex("3"));
//        graph.add(new Vertex("4"));
//        graph.add(new Vertex("5"));
//
//        graph.get(2).addNeighbor(graph.get(3));
//
//        graph.get(3).addNeighbor(graph.get(1));
//
//        graph.get(4).addNeighbor(graph.get(0));
//        graph.get(4).addNeighbor(graph.get(1));
//
//        graph.get(5).addNeighbor(graph.get(0));
//        graph.get(5).addNeighbor(graph.get(2));
//
//        for(int i=0; i < graph.size() ;i++){
//            if(!graph.get(i).isVisited()){
//                topologicalOrdering.dfs(graph.get(i));
//            }
//        }
//
//        Stack<Vertex> stack = topologicalOrdering.getStack();
//
//        for(int i=0; i < graph.size(); i++){
//            Vertex vertex = stack.pop();
//            System.out.println(vertex + " -> " );
//        }

        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");

        vertex1.addNeighbor(vertex2);
        vertex2.addNeighbor(vertex3);
        vertex3.addNeighbor(vertex1);
        vertex4.addNeighbor(vertex1);
        vertex4.addNeighbor(vertex5);
        vertex5.addNeighbor(vertex6);
        vertex6.addNeighbor(vertex4);

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        vertexList.add(vertex5);
        vertexList.add(vertex6);

        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.detectCycle(vertexList);
    }

}
