package com.data_structure.stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] heights = {6, 9, 5, 7, 3};
        int[] answer = s.solution(heights);
        for(int i=0; i < answer.length; i++){
            System.out.print(answer[i] + ", ");
        }
        System.out.println();

        heights = new int[]{3, 9, 9, 3, 5, 7, 2};
        answer = s.solution(heights);
        for(int i=0; i < answer.length; i++){
            System.out.print(answer[i] + ", ");
        }
        System.out.println();

        heights = new int[]{1, 5, 3, 6, 7, 6, 5};
        answer = s.solution(heights);
        for(int i=0; i < answer.length; i++){
            System.out.print(answer[i] + ", ");
        }
    }
    public int[] solution(int[] heights){
        Stack<Integer> s1 = new Stack<>();
        for(int i=0; i < heights.length; i++){
            s1.push(heights[i]);
        }

        int answer[] = new int[heights.length];
        int index = heights.length - 1;
        Stack<Integer> s2 = new Stack<>();
        while(!s1.isEmpty()){
            int current = s1.pop();
            if(s1.isEmpty()){
                answer[index] = 0;
                break;
            }
            boolean flag = false;
            while(s1.peek() <= current){
                s2.push(s1.pop());
                if(s1.isEmpty()){
                    answer[index] = 0;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer[index] = s1.size();
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            index--;
        }
        return answer;
    }
}
