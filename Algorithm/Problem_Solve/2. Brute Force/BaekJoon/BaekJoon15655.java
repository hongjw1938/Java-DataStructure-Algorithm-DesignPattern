package com.problemsolve.brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15655{
    static int n, m;
    static int nums[], select[];
    static boolean b[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        nums = new int[n]; b = new boolean[n]; select = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){
            int next = Integer.parseInt(st.nextToken());
            int k;
            for(k = i; k > 0 && nums[k-1] > next; k--){
                nums[k] = nums[k-1];
            }
            nums[k] = next;
        }

        getNext(0, 0);
        System.out.println(sb);
    }
    private static void getNext(int index, int order){
        if(index == m){
            for(int p : select){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=order; i < n; i++){
            if(!b[i]){
                b[i] = true;
                select[index] = nums[i];
                getNext(index+1, i);
                b[i] = false;
            }
        }
    }
}
