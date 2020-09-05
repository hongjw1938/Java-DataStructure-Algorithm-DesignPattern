package problem_solve.bfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon1389 {
    private static int[][] map = new int[101][101];
    private static int user;
    private static int relation;
    private static boolean[] visited;
    private static int[] distance = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        user = Integer.parseInt(line[0]);
        relation = Integer.parseInt(line[1]);

        for(int i=0; i < relation; i++){
            String s[] = br.readLine().split(" ");
            int y = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            map[y][x] = map[x][y] = 1;
        }

        for(int i=1; i <= user; i++){
            visited = new boolean[user+1];
            bfs(i);
            System.out.print("distance : ");
            for(int j=1; j <= user; j++){
                System.out.print(distance[j] + ", ");
            }
            System.out.println();
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i <= user; i++){
            if(distance[i] < min){
                min = distance[i];
            }
        }

        int ans = 0;
        for(int i=1; i <= user; i++){
            if(distance[i] == min){
                ans = i;
                break;
            }
        }

        System.out.println(ans);

        br.close();
    }

    private static void bfs(int current){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(current, 0));
        visited[current] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            int dist = node.dist;
            int y = node.pos;

            for(int x=1; x <= user; x++){
                if(map[y][x] == 1 && !visited[x]){
                    q.add(new Node(x, dist+1));
                    visited[x] = true;
                    distance[x] += dist+1;
                }
            }
        }
    }
}

class Node{
    int dist;
    int pos;

    public Node(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }
}
