package problem_solve.shortest_path.dag_shortest_path;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    // 기존의 Vertex, App Class는 그대로 사용할 것.
    // DFS를 기반으로 구현한다.

    private Stack<Vertex> stack;

    public TopologicalSort() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex){
        vertex.setVisited(true);

        for(Edge edge : vertex.getAdjacenciesList()){
            if(!edge.getTargetVertex().isVisited()){
                edge.getTargetVertex().setVisited(true);
                dfs(edge.getTargetVertex());
            }
        }

        stack.push(vertex);
    }

    public void makeTopologicalOrder(List<Vertex> vertexList){
        for(Vertex vertex : vertexList){
            if(!vertex.isVisited()){
                dfs(vertex);
            }
        }
    }

    public Stack<Vertex> getTopologicalOrder(){
        Collections.reverse(stack);
        return this.stack;
    }

    public Stack<Vertex> getStack(){
        return this.stack;
    }
}
