package com.algorith.problem_solve.shortest_path.bellmanford;

import java.util.List;

public class BellmanFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFord(Vertex startVertex){
        // Start에서의 Start의 거리는 0
        startVertex.setDistance(0);

        // Relax all Edges of V-1 Iteration
        // 전체 Vertex에 대해서 바로 실행
        for(int i=0; i < vertexList.size()-1; i++){
            // 각 Vertex가 연결된 edge를 V-1 번 Relax시킴
            for(Edge edge : edgeList){

                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                // 최대값인 경우 해당 Vertex와는 연결이 안된다는 것.
                if(u.getDistance() == Double.MAX_VALUE){
                    continue;
                }

                // 해당 거리와 간선의 cost를 더함
                double newDistance = u.getDistance() + edge.getWeight();

                // 기존 cost와 새로이 계산된 cost를 비교하여 더 짧으면 update
                if(newDistance < v.getDistance()){

                    v.setDistance(newDistance);
                    v.setPreviousVertex(u);
                }
            }
        }

        // 이미 계산이 완료되었으니 다시 한 번 모든 Edge를 탐색
        for(Edge edge : edgeList){  // V-th iteration
            // 해당 Edge에서 edge에 연결된 start Vertex와의 거리가 최대값인 경우는 고려하지 않음
            if(edge.getStartVertex().getDistance() != Double.MAX_VALUE){
                // Negative Cycle 검사
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
            System.out.print(actual + " - ");
            actual = actual.getPreviousVertex();
        }
        System.out.println(actual);
    }
}
