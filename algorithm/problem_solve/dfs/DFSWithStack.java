package problem_solve.dfs;

import java.util.List;
import java.util.Stack;

public class DFSWithStack {

    private Stack<Vertex> stack;

    public DFSWithStack(){
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList){
        for(Vertex v : vertexList){
            if(!v.isVisited()){
                v.setVisited(true);
                dfsWithStack(v);
            }
        }
    }

    private void dfsWithStack(Vertex rootVertex){
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);

        while(!stack.isEmpty()){
            Vertex actualVertex = this.stack.pop();
            System.out.print(actualVertex + " ");

            for(Vertex v : actualVertex.getNeighborList()){
                if(!v.isVisited()){
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }
}
