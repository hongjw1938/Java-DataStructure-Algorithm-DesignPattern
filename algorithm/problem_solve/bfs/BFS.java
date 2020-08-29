package com.algorithm.problem_solve.bfs;

import java.util.LinkedList;
import java.util.Queue;

// Algorithm을 구현하는 Class
public class BFS {

    // root는 최초 start vertex
    public void bfs(Vertex root){
        Queue<Vertex> queue = new LinkedList<>();

        // root는 방문했으므로 true로 설정
        // 그리고 해당 node는 추가
        root.setVisited(true);
        queue.add(root);

        // Queue가 비어있지 않은 상태라면
        while(!queue.isEmpty()){
            // Queue에서 dequeue
            Vertex actualVertex = queue.remove();
            System.out.print(actualVertex.getData() + " ");

            // 해당 Vertex의 이웃을 모두 꺼냄
            for(Vertex v : actualVertex.getNeighborList()){
                // 방문하지 않았다면 true로 바꾸고 해당 vertex를 queue에 추가
                if(!v.isVisited()){
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
