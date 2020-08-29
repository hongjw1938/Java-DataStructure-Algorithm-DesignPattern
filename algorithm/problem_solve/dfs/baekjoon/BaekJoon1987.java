package com.algorithm.problem_solve.dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1987 {
    // 세로 R, 가로 C 칸 표 모양의 보드 - 각 칸에 대문자 알파벳 하나씩
    // 좌측 상단 (1, 1)에는 말이 놓여 있음
    // 말은 상하좌우로 인접한 4칸 중의 한 칸 이동 가능. 새로 이동한 칸에 적힌
    // 알파벳은 지나온 모든 칸에 적힌 알파벳과는 달라야

    private static int n,m;
    private static String[] board = new String[20];
    private static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);

        for(int i=0; i < n; i++){
            board[i] = br.readLine();
        }

        int ans = 0;
        ans = Math.max(ans, dfs(ans, 0, 0));

        System.out.println(ans);
        br.close();
    }

    /*
    * 1. 현재 알파벳에 대해 방문 여부를 체크하고 기 방문 시 반환, 미 방문 시 true
    * 2. DFS 방식으로 지속 탐색하고 방문 여부에 대해 다시 false로 복귀
    * */
    private static int dfs(int ans, int y, int x){
        if(0 > y || y >= n || 0 > x || x >= m) return ans;

        char next = board[y].charAt(x);

        if(visited[next-65]) return ans;
        visited[next-65] = true;

        ans++;

        int temp = ans;

        ans = Math.max(ans, dfs(temp, y-1, x));
        ans = Math.max(ans, dfs(temp, y+1, x));
        ans = Math.max(ans, dfs(temp, y, x-1));
        ans = Math.max(ans, dfs(temp, y, x+1));

        visited[next-65] = false;
        return ans;
    }
}
