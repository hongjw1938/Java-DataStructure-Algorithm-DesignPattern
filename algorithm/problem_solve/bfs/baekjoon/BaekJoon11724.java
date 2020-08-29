package com.algorithm.problem_solve.bfs.baekjoon;

import java.util.*;

public class BaekJoon11724 {

    private static VertexNode[] nodes;
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int vertex_num = scan.nextInt();
        int edge_num = scan.nextInt();

        nodes = new VertexNode[vertex_num];

        for(int i=1; i <= vertex_num; i++){
            nodes[i-1] = new VertexNode(i);
        }
        visited = new boolean[vertex_num];

        int listNum = 0;

        for(int i=0; i < edge_num; i++){
            int firstNodeIndex = scan.nextInt() - 1;
            int secondNodeIndex = scan.nextInt() - 1;

            nodes[firstNodeIndex].addNeighbor(nodes[secondNodeIndex]);
            nodes[secondNodeIndex].addNeighbor(nodes[firstNodeIndex]);
        }

        for(int i=0; i < vertex_num; i++){
            if(!visited[i]){
            
                bfs(nodes[i]);
                listNum++;
            }
        }
        scan.close();
        System.out.println(listNum);
    }

    public static void bfs(VertexNode node){
        Queue<VertexNode> q = new LinkedList<>();

        q.add(node);
        visited[node.getData()-1] = true;

        while(!q.isEmpty()){
            int node_num = q.peek().getData()-1;
            VertexNode actual = q.remove();

            for(VertexNode v : actual.getList()){
                int neighborIndex = v.getData()-1;
                if(!visited[neighborIndex]){
                    q.add(nodes[neighborIndex]);
                    visited[neighborIndex] = true;
                }
            }

        }
    }
}


class VertexNode{
    private int data;
    private List<VertexNode> list;

    VertexNode(int data){
        this.data = data;
        list = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<VertexNode> getList() {
        return list;
    }

    public void setList(List<VertexNode> list) {
        this.list = list;
    }

    public void addNeighbor(VertexNode node){
        list.add(node);
    }
}