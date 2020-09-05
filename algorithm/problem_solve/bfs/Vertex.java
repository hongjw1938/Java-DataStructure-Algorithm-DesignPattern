package problem_solve.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    // Data저장. 물론 Type은 바꿔도 됨
    private int data;

    // vertex 방문 여부 확인
    private boolean visited;

    // 방문할 이웃 Vertex들
    // Edge pointing 방식으로 구현한 것.
    private List<Vertex> neighborList;

    public Vertex(int data){
        this.data = data;
        this.neighborList = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List<Vertex> neighborList) {
        this.neighborList = neighborList;
    }
    // 여기 까지 getter and setter


    public void addNeighbourVertex(Vertex vertex){
        // ArrayList에 vertex 추가하여 이웃 정보 저장
        this.neighborList.add(vertex);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
