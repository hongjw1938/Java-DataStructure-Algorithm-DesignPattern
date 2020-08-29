package com.problemsolve.dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2668 {
    // 숫자 고르기
    // 우선 Cycle이 있는지에 따른 여부를 구하여 해당 사이클에 존재하는 Node만 true로 변경하는 방식을 취하였음
    // 더 빠른 방식은, 반복문 내에서 각 index마다 자기 자신과의 cycle이 형성되는지만 조사하여 해당 index를 더하는 것이 더 빠름
    private static int[] table = new int[101];
    private static int n;
    private static boolean[] set = new boolean[101];
    private static boolean[] visited = new boolean[101];
    private static boolean[] visiting = new boolean[101];
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=1; i <= n; i++){
            int num = Integer.parseInt(br.readLine());
            table[i] = num;
        }

        size = 0;
        for(int i=1; i <= n; i++){
            dfs(i, i);
        }

        System.out.println(size);

        for(int i=1; i <= n; i++){
            if(set[i]){
                System.out.println(i);
            }
        }
        br.close();
    }

    private static void dfs(int start, int element){
        if(!visited[element]){
            visited[element] = true;
            visiting[element] = true;
            if(!visiting[table[element]]){
                dfs(start, table[element]);
            }
        }

        if(start == table[element] && !set[element]) cycleDetected();
        visited[element] = false;
        visiting[element] = false;
    }

    private static void cycleDetected(){
        for(int i=1; i <= n; i++){
            if(visiting[i]){
                set[i] = true;
                size++;
            }
        }
    }
}
