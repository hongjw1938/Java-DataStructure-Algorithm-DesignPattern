package problem_solve.basic.baekjoon;

import java.util.*;
import java.io.*;

public class BaekJoon10816{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.get(num) == null){
                map.put(num, 1);
            } else {
                int origin = map.get(num);
                map.put(num, origin+1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            int ans = map.get(num) == null ? 0 : map.get(num);
            sb.append(ans+" ");
        }
        System.out.println(sb);


        br.close();
    }
}