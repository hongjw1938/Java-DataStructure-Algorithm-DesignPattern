package com.data_structure.queue;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = s.solution(scoville, K);
        System.out.println(answer);

    }
    public int solution(int[] scoville, int K){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i=0; i < scoville.length; i++){
            queue.offer(scoville[i]);
        }

        int answer = 0;
        while(queue.peek() < K && queue.size() >= 2){
            int new_scoville = queue.poll() + (queue.poll()*2);
            queue.offer(new_scoville);
            answer++;
        }

        if(queue.peek() < K){
            answer = -1;
        }
        return answer;
    }
}

