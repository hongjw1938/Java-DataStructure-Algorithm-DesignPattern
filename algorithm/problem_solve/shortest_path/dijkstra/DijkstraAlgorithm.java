package problem_solve.shortest_path.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    // 최단 경로를 계산하는 Method
    public void computePaths(Vertex sourceVertex){
        // Start 하고자 하는 Vertex는 자기 자신이므로 Cost = 0
        sourceVertex.setDistance(0);

        // Heap을 이용하여 이웃 Vertex와의 거리를 비교해 가장 짧은 것부터 조사함
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        // 최초에는 Source Vertex 뿐이므로 해당 Vertex를 추가함
        priorityQueue.add(sourceVertex);

        while(!priorityQueue.isEmpty()){

            // 현재 이전 Vertex의 이웃 Vertex 중 가장 최단 경로로 이어진 Vertex부터 조사함
            Vertex actualVertex = priorityQueue.poll();

            // 해당 Vertex와 연결된 모든 Edge를 검사
            for(Edge edge : actualVertex.getAdjacenciesList()){
                // Edge는 Start / Target Vertex의 정보를 갖고 있음. Target Vertex를 저장
                Vertex v = edge.getTargetVertex();

                // 현재 조사 중인 Vertex의 Source 로부터의 거리에 다음 Vertex로의 Cost를 더해 변수에 저장
                double newDistance = actualVertex.getDistance() + edge.getWeight();

                // 현재 저장한 Cost가 Target Vertex와의 이전에 저장된 Cost 정보보다 작다면 해당 정보로 Update
                if(newDistance < v.getDistance()){
                    // Remove 후 아래에서 다시 Add
                    // 왜냐하면, 정보를 update하고 나서 다시 Heap의 적절한 위치에 배치하기 위함
                    priorityQueue.remove(v);

                    // Cost를 Update
                    v.setDistance(newDistance);

                    // Cost가 변경되었다는 의미는 가장 가까운 이전 Vertex가 갱신되었다는 것을 의미
                    // 따라서 Update
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex){

        // Target Vertex로의 이동 경로를 계산하기 위해서 List를 생성
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        // Target Vertex에서 시작하여 가장 가까운 이전 Vertex를 차례로 List에 추가함
        for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()){
            shortestPathToTarget.add(vertex);
        }

        // Source가 아닌 Target에서 부터 시작하였으므로 경로를 Reverse
        Collections.reverse(shortestPathToTarget);

        // 해당 경로 반환
        return shortestPathToTarget;
    }
}
