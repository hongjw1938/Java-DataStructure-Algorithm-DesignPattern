package com.problemsolve.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class Programmars_2 {
    public boolean solution(String[] phone_book){
        // startsWith를 사용한 결과, HashMap 사용 방식보다 효율성테스트에서 조금 더 빨랐다.(1ms 차이)
        String[] phone_book = {"119", "97674223", "1195524421"};
        Arrays.sort(phone_book);
        boolean answer = true;

        for(int i=0; i < phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        //return answer;
        
        
        // 아래는 HashMap을 사용한 결과
        String[] phone_book = {"119", "97674223", "1195524421"};
        Arrays.sort(phone_book);
        boolean answer = true;
        HashMap<String, Boolean> map = new HashMap<>();
        for(int i=0; i < phone_book.length; i++){
            for(int j=1; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    answer = false;
                    break;
                }
            }
            if(!answer){
                break;
            }
            map.put(phone_book[i], true);
        }

        return answer;
    }
}