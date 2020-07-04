package com.problemsolve.dynamic_programming;
import java.io.*;
import java.util.Arrays;

public class Main{
    static boolean button[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        button = new boolean[10];
        Arrays.fill(button, true);

        int M = Integer.parseInt(br.readLine());
        String s[] = new String[0];
        if(M > 0){
            s = br.readLine().split(" ");
        }

        for(int i=0; i < M; i++){
            int c = Integer.parseInt(s[i]);
            button[c] = false;
        }

        int ans = Math.abs(N - 100);
        for(int i=0; i <= 1000000; i++){
            if(M == 10) break;
            int check_result = check(i);
            if(check_result == -1){
                continue;
            }
            int press = Math.abs(N - i);
            ans = Math.min(ans, press + check_result);
        }
        System.out.println(ans);
        br.close();
    }
    private static int check(int n){
        int temp = n;
        int press = 0;

        while(true){
            int d = temp % 10;
            if(!button[d]){
                break;
            }
            temp /= 10; press++;
            if(temp == 0) return press;
        }
        return -1;
    }
}