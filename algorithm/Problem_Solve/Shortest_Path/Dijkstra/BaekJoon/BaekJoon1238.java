package com.problemsolve.dijkstra.baekjoon;


import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1238 {

    /*
    N개의 숫자로 구분된 마을 - 한 명의 학생
    X번 마을에서 파티 - M개의 단방향 도로로 각 마을 이음
    i번째 길 지날 때, 1~100 까지의 시간 소비

    오고 가는데 가장 많은 시간 쓰는 학생의 소요 시간 구하기
     */
    static long[] backCost;
    static long[] goCost;
    static PartyVertex2[] vertex;
    static PartyVertex2[] backVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        vertex = new PartyVertex2[M+1];
        backVertex = new PartyVertex2[M+1];
        backCost = new long[M+1];
        goCost = new long[M+1];

        int y, x, c;
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            vertex[y] = new PartyVertex2(y, x, c, vertex[y]);
            backVertex[x] = new PartyVertex2(x, y, c, backVertex[x]);
        }

//        for(int i=0; i < M; i++){
//            System.out.println("i : " + i);
//            if(vertex[i] != null)
//                System.out.println("start : " + vertex[i].start + ", target : " + vertex[i].target + ", cost : " + vertex[i].cost + ",  v - next's start : " + vertex[i].next.start + ", v - next's target : " + vertex[i].next.target);
//            else
//                System.out.println("Null");
//        }

        for(int i=0; i < M; i++){
            System.out.println("i : " + i);
            if(backVertex[i] != null)
                System.out.println("start : " + backVertex[i].start + ", target : " + backVertex[i].target + ", cost : " + backVertex[i].cost);
            else
                System.out.println("Null");
        }

        System.out.println("------------------------------------------");
        goParty(X);
        goBack(X);
        long max = 0;
        for(int i=1; i <= M; i++){
            if(i==X) continue;
            max = Math.max(backCost[i] + goCost[i], max);
        }
        System.out.println(max);
        br.close();
    }

    private static void goParty(int start){
        PriorityQueue<PartyNode2> pq = new PriorityQueue<>();
        pq.add(new PartyNode2(start, 0));
        PartyNode2 n;
        PartyVertex2 v;
        while(!pq.isEmpty()){
            n = pq.poll();
            v = backVertex[n.start];
            System.out.println("v - start : " + v.start + ", v - target : " + v.target);
            while(v!=null){
                if((goCost[v.target] == 0 || goCost[v.target] > v.cost + n.cost)) {
                    goCost[v.target] = v.cost + n.cost;
                    pq.add(new PartyNode2(v.target, goCost[v.start]));
                }
                v = v.next;
                if(v != null)
                    System.out.println("Not null! v - start : " + v.start + ", v - target : " + v.target + ", v - next : " + v.next);
            }
        }
    }

    private static void goBack(int start){
        PriorityQueue<PartyNode2> pq = new PriorityQueue<>();
        pq.add(new PartyNode2(start, 0));
        PartyNode2 n;
        PartyVertex2 v;
        while(!pq.isEmpty()){
            n = pq.poll();
            v = vertex[n.start];
            while(v!=null){
                if((backCost[v.target] == 0 || backCost[v.target] > v.cost + n.cost)){
                    backCost[v.target] = v.cost + n.cost;
                    pq.add(new PartyNode2(v.target, backCost[v.target]));
                }
                v = v.next;
            }
        }
    }
}

class PartyVertex2{
    int start;
    int target;
    int cost;
    PartyVertex2 next;

    public PartyVertex2(int start, int target, int cost, PartyVertex2 next) {
        this.start = start;
        this.target = target;
        this.cost = cost;
        this.next = next;
    }
}

class PartyNode2 implements Comparable<PartyNode2>{
    int start;
    long cost;

    public PartyNode2(int start, long cost) {
        this.start = start;
        this.cost = cost;
    }

    @Override
    public int compareTo(PartyNode2 o) {
        return (int)(this.cost - o.cost);
    }
}