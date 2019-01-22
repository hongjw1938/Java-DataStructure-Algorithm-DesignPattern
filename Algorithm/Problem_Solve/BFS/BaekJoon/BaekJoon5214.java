package com.problemsolve.bfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon5214{
    // 하이퍼튜브를 이용하여 1번에서 N번 역에 가는 도중 거처야 하는 역의 개수
    // 1번 역도 포함한게 된다.

    private static int station;
    private static int tube;
    private static ArrayList<ArrayList<Integer>> connection = new ArrayList<>();
    private static boolean visited[] = new boolean[101005];
    private static int visitedAt[] = new int[101005];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        station = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        tube = Integer.parseInt(st.nextToken());

        Arrays.fill(visitedAt, Integer.MAX_VALUE);
        for(int i=0; i <= station + tube; i++){
            connection.add(new ArrayList<>());
        }

        for(int i=1; i <= tube; i++){
            st = new StringTokenizer(br.readLine());
            int dummy = station + i;

            for(int j=0; j < m; j++){
                int neighbor = Integer.parseInt(st.nextToken());
                connection.get(dummy).add(neighbor);
                connection.get(neighbor).add(dummy);
            }
        }

        int result = bfs(1, station);
        System.out.println(result == -1 ? -1 : (result + 1) / 2);

    }

    private static int bfs(int start, int target){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        visitedAt[start] = 1;

        while(!q.isEmpty()){
            int actual = q.remove();
            ArrayList<Integer> connected = connection.get(actual);

            if(actual == target){
                return visitedAt[actual];
            }
            for(int next : connected){
                if(!visited[next] && visitedAt[next] > visitedAt[actual] + 1){
                    visited[next] = true;

                    visitedAt[next] = visitedAt[actual] + 1;
                    System.out.println("next : " + next + ", visited : " + visitedAt[next]);
                    q.add(next);
                }
            }
        }
        return -1;
    }
}