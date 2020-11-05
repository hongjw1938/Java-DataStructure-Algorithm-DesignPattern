package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1766 {
    static ArrayList<Integer>[] p;
    static int[] pointer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new ArrayList[n+1];
        pointer = new int[n+1];

        for(int i=1; i <= n; i++){
            p[i] = new ArrayList();
        }
        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            p[a].add(b);
            pointer[b]++;
        }
        topologicalSort();
        br.close();
    }

    private static void topologicalSort(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i < p.length; i++){
            if(pointer[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int n = q.poll();
            sb.append(n).append(" ");
            for(int i=0; i < p[n].size(); i++){
                int num = p[n].get(i);
                pointer[num]--;

                if(pointer[num] == 0){
                    q.add(num);
                }
            }
        }
        System.out.println(sb);
    }
}
