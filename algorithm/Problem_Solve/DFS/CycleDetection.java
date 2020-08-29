package com.problemsolve.dfs;

import java.util.List;

public class CycleDetection {

    public void detectCycle(List<Vertex> vertexList){
        for(Vertex v : vertexList){
            if(!v.isVisited()){
                dfs(v);
            }
        }
    }

    private void dfs(Vertex vertex){

        // 현재 dfs로 탐색 중인 vertex가 탐색 되는 중임을 표시
        System.out.println("DFS on vertex : " + vertex);
        vertex.setBeingVisited(true);

        for(Vertex v : vertex.getNeighborList()){
            System.out.println("Visiting the neighbours of vertex : " + v);

            // 만약 현재 backward되지 않았는데 탐색 중이면 cycle 존재
            if(v.isBeingVisited()){
                System.out.println("There is backward edge. There is cycle");
                return;
            }

            // cycle이 발견되지 않은 상태라면 계속 탐색
            if(!v.isVisited()){
                System.out.println("Visiting vertex "  + v + "recursively...");
                v.setVisited(true);
                dfs(v);
            }
        }

        System.out.println("Set vertex" + vertex + "setBeingVisited(false) and visited(true)...");
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}
