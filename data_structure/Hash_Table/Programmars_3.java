package com.problemsolve.hashtable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Programmars_3{
    public int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i < clothes.length; i++){
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(HashMap.Entry<String, Integer> entry : entries){
            answer *= (entry.getValue()+1);
        }
        return answer-1;
    }
}
