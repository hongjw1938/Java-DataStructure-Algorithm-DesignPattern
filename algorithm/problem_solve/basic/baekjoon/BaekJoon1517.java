package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1517{
    static long swapped = 0;
    static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i < n; i++){
            int replace = arr[i];
            for(int j=i; j < n; j++){
                if(replace > arr[j]){
                    swap(i, j);
                }
            }
        }

        System.out.println(swapped);
        br.close();
    }

    private static void swap(int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        swapped++;
    }
}