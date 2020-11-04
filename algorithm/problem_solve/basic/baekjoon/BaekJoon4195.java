package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaekJoon4195 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] parent;
        int[] relations;
        StringTokenizer st;
        for(int i=0; i < t; i++){
            int f = Integer.parseInt(br.readLine());

            parent = new int[100001];
            relations = new int[100001];
            Map<String, Integer> map = new HashMap<>();
            int idx = 1;

            for(int j=1; j <= f; j++){
                st = new StringTokenizer(br.readLine());
                String left = st.nextToken();
                String right = st.nextToken();
                if(!map.containsKey(left)){
                    map.put(left, idx);
                    parent[idx] = idx;
                    relations[idx]++;
                    idx++;
                }
                if(!map.containsKey(right)){
                    map.put(right, idx);
                    parent[idx] = idx;
                    relations[idx]++;
                    idx++;
                }

                union(parent, relations, parent[map.get(left)], parent[map.get(right)]);
                sb.append(relations[find(parent, map.get(left))]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static int find(int[] parent, int e){
        if(parent[e] == e) return e;
        return find(parent, parent[e]);
    }

    public static void union(int parent[], int relations[], int e1, int e2){
        int e1_parent = find(parent, e1);
        int e2_parent = find(parent, e2);

        if(e1_parent == e2_parent) return;
        if(e1_parent < e2_parent){
            parent[e2_parent] = e1_parent;
            relations[e1_parent] += relations[e2_parent];
        } else {
            parent[e1_parent] = e2_parent;
            relations[e2_parent] += relations[e1_parent];
        }
    }
}
