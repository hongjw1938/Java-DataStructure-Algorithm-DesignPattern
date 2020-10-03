package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2493 {
    static int N;
    static int[] towers = new int[500001];
    static int[] heights = new int[500001];
    static int idx = 0;
    static int highest = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= N; i++){
            int current = Integer.parseInt(st.nextToken());
            if(highest < current || idx == 0){
                sb.append("0 ");
                highest = current;
                towers[0] = i;
                heights[0] = current;
                idx=1;
                continue;
            }

            while(true){
                if(heights[idx-1] > current){
                    sb.append(towers[idx-1]).append(" ");
                    towers[idx] = i;
                    heights[idx] = current;
                    idx++;
                    break;
                }
                idx--;
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
