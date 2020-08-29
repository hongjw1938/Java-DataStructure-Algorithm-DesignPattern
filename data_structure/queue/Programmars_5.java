package com.data_structure.queue;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] job = {{0, 3}, {1, 9}, {2, 6}};

        int answer = s.solution(job);
        System.out.println(answer);

    }
    public int solution(int[][] jobs){
        LinkedList<Job> queue = new LinkedList<>();
        PriorityQueue<Job> priorityQueuequeue = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.workingTime - o2.workingTime;
            }
        });
        for(int i=0; i < jobs.length; i++){
            queue.offer(new Job(jobs[i][0], jobs[i][1]));
        }
        Collections.sort(queue, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.requestTime - o2.requestTime;
            }
        });

        int answer = 0;
        int cnt = 0;
        int time = queue.peek().requestTime;

        while(cnt < jobs.length){
            while(!queue.isEmpty() && queue.peek().requestTime <= time){
                priorityQueuequeue.offer(queue.pollFirst());
            }

            if(!priorityQueuequeue.isEmpty()){
                Job job = priorityQueuequeue.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                cnt++;
            } else {
                time++;
            }
        }

        return answer / cnt;
    }
    private class Job{
        int requestTime;
        int workingTime;
        public Job(int requestTime, int workingTime){
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }
}

