package com.problemsolve.dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11559 {
    // 뿌요뿌요 연쇄 횟수 풀기 문제

    private static char[][] puyoMap = new char[12][6];
    private static boolean[][] visited = new boolean[12][6];
    private static int m, n;
    private static int tobePopped = 0;

    public static void main(String[] args) throws IOException {
        /*
          1. 우선 전체를 읽어낼 String 배열 생성
          2. 배열에 값 입력 후, 현재 4개로 이어진 뿌요 찾기
            - pop method로 수행
            -
          3. 배열 재배열 시킬 수 있는 method call
          4. 위 과정 반복
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = 12; n = 6;
        for(int i=0; i < m; i++){
            String line = br.readLine();
            for(int j=0; j < line.length(); j++){
                puyoMap[i][j] = line.charAt(j);
            }
        }

        int popped = 0;

        boolean ispopped = true;
        while(ispopped){
            ispopped = false;
            for(int i=0; i < m; i++){
                for(int j=0; j < n; j++){
                    char c = puyoMap[i][j];
                    if(c != '.' && !visited[i][j]){
                        dfs(i, j, c);
                    }

                    if(tobePopped >= 4){
                        pop();
                        ispopped = true;
                    } else {
                        visited = new boolean[12][6];
                    }
                    tobePopped=0;
                }
            }
            if(ispopped){
                popped++;
            }
//            System.out.println("current num : " + popped + ", bolean ? : " + ispopped);
            relocation();


        }

        System.out.println(popped);
        br.close();
    }

    private static void dfs(int i, int j, char c){
        if(visited[i][j]) return;

        tobePopped++;
        visited[i][j] = true;

        if((i+1) < m && puyoMap[i+1][j] == c){
            dfs(i+1, j, c);
        }
        if((i-1) >= 0 && puyoMap[i-1][j] == c){
            dfs(i-1, j, c);
        }
        if((j+1) < n && puyoMap[i][j+1] == c){
            dfs(i, j+1, c);
        }
        if((j-1) >= 0 && puyoMap[i][j-1] == c){
            dfs(i, j-1, c);
        }

    }

    private static void pop(){
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(visited[i][j]){
                    puyoMap[i][j] = '.';
                    visited[i][j] = false;
                }
            }
        }
//        System.out.println("popped!!--------------------");
//        for(int i=0; i < m; i++){
//            for(int j=0; j < n;j++){
//                System.out.print(puyoMap[i][j]);
//            }
//            System.out.println();
//        }

    }

    private static void relocation(){
        for(int j=0; j < n; j++){
            for(int i=m-1; i >= 0; i--){
                if(puyoMap[i][j] != '.'){
                    int go = i+1;
                    while(go < m && puyoMap[go][j] == '.'){
                        puyoMap[go][j] = puyoMap[go-1][j];
                        puyoMap[go-1][j] = '.';
                        go++;
                    }
                }
            }
        }
//        System.out.println("relocated--------------------");
//        for(int i=0; i < m; i++){
//            for(int j=0; j < n;j++){
//                System.out.print(puyoMap[i][j]);
//            }
//            System.out.println();
//        }
    }
}
