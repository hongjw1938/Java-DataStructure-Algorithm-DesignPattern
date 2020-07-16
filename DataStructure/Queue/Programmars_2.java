package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] priorities = {2, 1, 3, 2};
        System.out.println(s.solution(priorities, 2));

        priorities = new int[]{1, 1, 9, 1, 1, 1};
        System.out.println(s.solution(priorities, 0));

    }
    public int solution(int[] priorities, int location){
        int answer = 1;
        Queue<Paper> q1 = new LinkedList<>();
        for(int i=0; i < priorities.length; i++){
            Paper p = new Paper(i, priorities[i]);
            q1.offer(p);
        }

        while(!q1.isEmpty()){
            Paper current = q1.poll();
            boolean flag = false;
            for(int i=0; i < q1.size(); i++){
                if(((LinkedList<Paper>) q1).get(i).priority > current.priority){
                    q1.offer(current);
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            if(current.index == location){
                break;
            } else {
                answer++;
            }
        }
        return answer;
    }
    private class Paper{
        int index;
        int priority;
        public Paper(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
}

