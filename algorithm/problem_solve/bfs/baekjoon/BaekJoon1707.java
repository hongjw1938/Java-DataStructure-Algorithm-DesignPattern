package com.algorithm.problem_solve.bfs.baekjoon;

import java.util.*;

public class BaekJoon1707 {
    // 이분 그래프 여부 확인하는 알고리즘

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();

        for(int i=0; i < cases; i++){
            int v = scan.nextInt();
            int e = scan.nextInt();

            GraphVertex[] vertices = new GraphVertex[v+1];
            for(int j=1; j <= v; j++){
                int data = j;
                vertices[j] = new GraphVertex(data);
            }

            for(int j=1; j <= e; j++){
                int index = scan.nextInt();
                int neighbor = scan.nextInt();

                if (index == neighbor) continue;

                vertices[index].addNeighbors(vertices[neighbor]);
                vertices[neighbor].addNeighbors(vertices[index]);
            }

            boolean result = bfs(vertices, v);

            System.out.println(result == true ? "YES" : "NO");
        }
        scan.close();
    }

    private static boolean bfs(GraphVertex[] graph, int vertex_num){
        Queue<GraphVertex> q = new LinkedList<>();

        boolean isValid = true;
        for(int i=1; i <= vertex_num; i++){
            if(graph[i].getColor() != 0) continue;
            q.add(graph[i]);

            while(!q.isEmpty()){
                GraphVertex actual = q.remove();
                List<GraphVertex> neighbors = actual.getNeighbors();

                graph[i].setColor(1);
                int actualColor = actual.getColor();
                for(GraphVertex v : neighbors){
                    if(v.getColor() == 0){
                        v.setColor(actualColor * -1);
                        q.add(v);
                    } else if(v.getColor()+actualColor != 0){
                        isValid = false;
                        return isValid;
                    }
                }
            }
        }

        return isValid;
    }

}

class GraphVertex{
    private int data;
    private List<GraphVertex> neighbors;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public GraphVertex(int data) {
        this.data = data;
        neighbors = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<GraphVertex> getNeighbors() {
        return neighbors;
    }

    public void addNeighbors(GraphVertex v){
        neighbors.add(v);
    }
}