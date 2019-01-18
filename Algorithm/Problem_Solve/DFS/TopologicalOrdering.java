package com.problemsolve.dfs;

import java.util.Stack;

public class TopologicalOrdering {
    // 기존의 Vertex, App Class는 그대로 사용할 것.
    // DFS를 기반으로 구현한다.

    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex){
        vertex.setVisited(true);

        for(Vertex v : vertex.getNeighborList()){
            if(!v.isVisited()){
                dfs(v);
            }
        }

        stack.push(vertex);
    }

    public Stack<Vertex> getStack(){
        return this.stack;
    }
}
