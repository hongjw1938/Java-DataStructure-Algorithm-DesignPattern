package com.data_structure.stack;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] prices = {1, 2, 3, 2 ,3};
        int[] answer = s.solution(prices);

        for(int i=0; i < prices.length; i++){
            System.out.print(answer[i]);
        }
    }
    public int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        Stack<Price> stack = new Stack<>();
        for(int i=0; i < prices.length; i++){
            int current = prices[i];
            while(!stack.isEmpty()){
                Price top = stack.peek();
                if(top.price > current){
                    answer[top.index] = i - top.index;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new Price(i, current));
        }
        while(!stack.isEmpty()){
            Price top = stack.pop();
            answer[top.index] = prices.length - 1 - top.index;
        }
        return answer;
    }
    private class Price{
        int index;
        int price;
        public Price(int index, int price){
            this.index=index;
            this.price=price;
        }
    }
}

