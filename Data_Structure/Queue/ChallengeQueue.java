package com.datastructure.queue;

import java.util.*;

public class ChallengeQueue {
    public static void main(String[] args){
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        String lowered = string.toLowerCase();
        int leng = lowered.length();

        Stack<Character> stack = new Stack<>();
        Deque<Character> queue = new ArrayDeque<>(leng);

        for(int i=0; i < leng; i++){
            char now = lowered.charAt(i);
            if(now >= 'a' && now <= 'z'){
                stack.push(now);
                queue.offer(now);
            }
        }

        while(!stack.isEmpty() && !queue.isEmpty()){
            if(stack.pop() != queue.poll()){
                return false;
            }
        }
        return true;
    }
}
