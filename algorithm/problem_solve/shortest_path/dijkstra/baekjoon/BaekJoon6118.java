package com.algorithm.problem_solve.shortest_path.dijkstra.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon6118 {
    static int N,M;
    static Barn[] barn;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barn = new Barn[N+1];
        cost = new int[N+1];

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            barn[s] =
               new Barn(s, t, barn[s]);
            barn[t] = new Barn(t, s, barn[t]);
        }

        dijkstra(1);

        int index = 0;
        int t = 1;
        for(int i=2; i <= N; i++){
            if(cost[index] < cost[i]){
                index = i;
                t = 1;
            } else if(cost[i] == cost[index]){
                t++;
            }
        }

        System.out.println(index + " " + cost[index] + " " + t);
        br.close();
    }

    public static void dijkstra(int start){
        PriorityQueue<BarnNode> pq = new PriorityQueue<>();
        pq.add(new BarnNode(start, 0));
        cost[start] = 0;
        Barn b;
        BarnNode bn;

        while(!pq.isEmpty()){
            bn = pq.poll();
            b = barn[bn.start];

            while(b != null){
                if(cost[b.B] == 0 || cost[b.B] > cost[b.A] + 1){
                    cost[b.B] = cost[b.A] + 1;
                    pq.add(new BarnNode(b.B, cost[b.B]));
                }
                b = b.N;
            }
        }
    }
}

class BarnNode implements Comparable<BarnNode>{
    int start;
    int cost;

    public BarnNode(int start, int cost) {
        this.start = start;
        this.cost = cost;
    }

    @Override
    public int compareTo(BarnNode o) {
        return this.cost - o.cost;
    }
}

class Barn{
    int A;
    int B;
    Barn N;

    public Barn(int a, int b, Barn n) {
        A = a;
        B = b;
        N = n;
    }
}