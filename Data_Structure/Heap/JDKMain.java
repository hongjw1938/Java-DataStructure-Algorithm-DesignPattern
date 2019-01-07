package com.datastructure.heap;

import java.util.PriorityQueue;

public class JDKMain {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());

        System.out.println(pq.poll());

        // 특정 value를 제거할 수도 있다.
        System.out.println(pq.remove(54));
        System.out.println(pq.peek());

        System.out.println("-----------------------");
        Object[] ints = pq.toArray();
        for(Object num : ints){
            System.out.println(num);
        }

        pq.add(-1);
        System.out.println(pq.peek());
    }
}
