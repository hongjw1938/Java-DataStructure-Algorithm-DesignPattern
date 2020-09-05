package problem_solve.shortest_path.dijkstra;

import java.util.ArrayList;
import java.util.List;

// Heap을 사용하여 Vertex들의 정렬을 해야 하므로 Comparable을 구현
public class Vertex implements Comparable<Vertex>{

    // Vertex의 자체 Data
    private String name;

    // Vertex에 연결된 Edge List
    private List<Edge> adjacenciesList;
    private boolean visited;

    // 가장 근접한 이웃 Vertex
    private Vertex predecessor;

    // 최초에 각 Vertex의 Start Vertex로의 Cost는 최대값
    private double distance = Double.MAX_VALUE;

    public Vertex(String name){
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public void addNeighbor(Edge edge){
        this.adjacenciesList.add(edge);
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.getDistance());
    }
}
