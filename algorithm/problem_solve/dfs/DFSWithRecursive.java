package com.algorithm.problem_solve.dfs;

import java.util.List;

public class DFSWithRecursive {
    public DFSWithRecursive() {
    }

    private void dfsWithRecursive(Vertex rootVertex){
        System.out.print(rootVertex + " ");

        for(Vertex v : rootVertex.getNeighborList()){
            if( !v.isVisited()){
                v.setVisited(true);
                dfsWithRecursive(v);
            }
        }
    }

    public void dfs(List<Vertex> vertexList){
        for(Vertex v : vertexList){
            if(!v.isVisited()){
                v.setVisited(true);
                dfsWithRecursive(v);
            }
        }
    }
}
