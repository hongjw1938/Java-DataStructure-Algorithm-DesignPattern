package problem_solve.shortest_path.floyd_warshall.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1238 {

    /*
    N개의 숫자로 구분된 마을 - 한 명의 학생
    X번 마을에서 파티 - M개의 단방향 도로로 각 마을 이음
    i번째 길 지날 때, 1~100 까지의 시간 소비

    오고 가는데 가장 많은 시간 쓰는 학생의 소요 시간 구하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int map[][] = new int[N+1][N+1];

        for(int i=1; i <= N; i++){
            for(int j=1; j <= N; j++){
                if(i!=j){
                    map[i][j] = 999999;
                }

            }
        }

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = Math.min(map[y][x], Integer.parseInt(st.nextToken()));
        }

        for(int k=1; k <= N; k++){
            for(int i=1; i <= N; i++){
                for(int j=1; j <= N; j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int ans = 0;
        for(int i=1; i <= N; i++){
            ans = Math.max(ans, map[i][X] + map[X][i]);
        }

        System.out.println(ans);
        br.close();
    }
}