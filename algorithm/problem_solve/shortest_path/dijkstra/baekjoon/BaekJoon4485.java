package problem_solve.shortest_path.dijkstra.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon4485 {
    /*
    젤다의 전설 화폐 : 루피, 검은 루피(루피 감소)
    링크 -> N*N 크기의 동굴의 가장 왼쪽 위에 위치[0][0]

    [N-1][N-1] 까지 이동해야함. 각 칸에 도둑루피 있음. 소지금 감소
    잃는 금액 최소로 건너편에 이동하는 방법

    가장 적게 잃는 금액은?
     */

    private static int[][] map = new int[125][125];
    private static int N;
    private static int[][] M = new int[125][125];
    private static int move[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 0;
        while(true){
            T++;
            String s = br.readLine();
            if(s.equals("0")) break;
            N = Integer.parseInt(s);

            for(int i=0; i < N; i++){
                Arrays.fill(M[i], Integer.MAX_VALUE);
            }

            for(int i=0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<Vertex> pq = new PriorityQueue<>();

            pq.add(new Vertex(0, 0, map[0][0]));
            M[0][0] = map[0][0];
            while(!pq.isEmpty()){
                Vertex actual = pq.poll();

                int cy = actual.y;
                int cx = actual.x;

                if(cy == N-1 && cx == N-1){
                    System.out.println("Problem " + T + ": " + M[N-1][N-1]);
                    break;
                }
                for(int i=0; i < 4; i++){
                    int ny = cy + move[i][0];
                    int nx = cx + move[i][1];

                    if(0 > ny || ny >= N || 0 > nx || nx >= N) continue;
                    if(M[cy][cx] + map[ny][nx] < M[ny][nx]){
                        M[ny][nx] = M[cy][cx] + map[ny][nx];

                        pq.add(new Vertex(ny, nx, M[ny][nx]));
                    }
                }
            }

        }



        br.close();
    }
}

class Vertex implements Comparable<Vertex>{
    int y;
    int x;
    int weight;

    public Vertex(int y, int x, int weight) {
        this.y = y;
        this.x = x;
        this.weight = weight;
    }
    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.weight, o.weight);
    }
}