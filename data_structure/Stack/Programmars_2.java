package com.datastructure.stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        String arrangement = "()(((()())(())()))(())";
        System.out.println(s.solution(arrangement));

    }
    public int solution(String arrangement){
        int answer = 0;
        int sticks = 0;
        int lazer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < arrangement.length(); i++){
            char curr = arrangement.charAt(i);
            if(stack.isEmpty()){
                stack.push(curr);
                continue;
            }
            if(stack.peek() == '(' && curr == ')'){
                lazer++;
                answer += sticks;
            } else if(stack.peek() == '(' && curr == '('){
                sticks++;
                answer++;
            } else if(stack.peek() == ')' && curr == '('){
                if(lazer > 0){
                    lazer--;
                } else {
                    sticks--;
                }
            } else {
                sticks--;
            }
            stack.push(curr);
        }
        return answer;
    }
}

