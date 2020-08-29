package com.algorithm.problem_solve.shortest_path.dag_shortest_path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclickShortestPath {

    public void shortestPath(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex){
        sourceVertex.setDistance(0);
        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.makeTopologicalOrder(vertexList);

        Stack<Vertex> stack = topologicalSort.getTopologicalOrder();

        for(Vertex actualVertex : stack){

            for(Edge edge : actualVertex.getAdjacenciesList()){
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                double newDistance = u.getDistance() + edge.getWeight();

                if(newDistance < v.getDistance()){
                    v.setDistance(newDistance);
                    v.setPredecessor(u);
                }
            }
        }

        if(targetVertex.getDistance() == Double.MAX_VALUE){
            System.out.println("No Shortest Path..");
        } else {
            System.out.println("Target vertex shortest path : " + targetVertex.getDistance());
        }
    }

    public void showShortestPathTo(Vertex targetVertex){
        List<Vertex> list = new ArrayList<>();

        Vertex actualVertex = targetVertex;
        list.add(actualVertex);

        while(actualVertex.getPredecessor() != null){
            actualVertex=actualVertex.getPredecessor();
            list.add(actualVertex);
        }

        Collections.reverse(list);
        System.out.println(list);
    }
}
