package com.problemsolve.bellman_ford;

import java.util.List;

public class BellmanFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFord(Vertex startVertex){
        startVertex.setDistance(0);

        // Relax all Edges of V-1 Iteration
        for(int i=0; i < vertexList.size()-1; i++){
            for(Edge edge : edgeList){

                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                if(u.getDistance() == Double.MAX_VALUE){
                    continue;
                }

                double newDistance = u.getDistance() + edge.getWeight();

                if(newDistance < v.getDistance()){

                    v.setDistance(newDistance);
                    v.setPreviousVertex(u);
                }
            }
        }

        for(Edge edge : edgeList){  // V-th iteration
            if(edge.getStartVertex().getDistance() != Double.MAX_VALUE){
                if(hasCycle(edge)){
                    System.out.println("There has been a negative cycle detected");
                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge edge){
        // Better Solution이 있다는 의미임. target 까지의 Cost보다 Start에서 새로 더한 Cost가 더 작다면
        // 계속 갱신된다는 의미이기 때문
        return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }

    public void shortestPathTo(Vertex targetVertex){
        // 이 경우 가능한 Path가 없음
        if(targetVertex.getDistance() == Double.MAX_VALUE){
            System.out.println("No path is available to get to the Target!");
        }

        Vertex actual = targetVertex;

        while(actual.getPreviousVertex() != null){
            System.out.println(actual + " - ");
            actual = actual.getPreviousVertex();
        }
    }
}
