package com.problemsolve.brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15652{
    static int num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        num = new int[m];

        getNext(0, n, m, 1);
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
    private static void getNext(int index, int n, int m, int current){
        if(index == m){
            for(int p : num){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = current; i <= n; i++){
            num[index] = i;
            getNext(index+1, n, m, i);
        }
    }
}
