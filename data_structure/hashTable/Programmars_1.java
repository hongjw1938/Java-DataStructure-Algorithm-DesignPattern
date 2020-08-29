package com.data_structure.hashTable;

import java.util.Arrays;
import java.util.HashMap;

public class Programmars_1 {
    public String solution(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);

        String answer = "";
        int index = 0;
        for(String c : completion){
            if(!c.equals(participant[index])){
                answer = participant[index];
                return answer;
            }
            index++;
        }
        return participant[index];
    }
    public String solution2(String[] participant, String[] completion){
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for(String c : completion){
            map.put(c, map.get(c) -1);
        }
        
        // keySet()을 사용하는 방법과 EntrySet()을 사용하는 방법이 있음
        // 아래는 keySet()
        for(String s : map.keySet()){
            if(map.get(s) != 0){
                answer = s;
                break;
            }
        }
        
        // 아래는 EntrySet()
        // 아래의 방식이 시간복잡도 측면에서, 내부적인 로직으로는 위의 keySet의 get 보다 빠르다.
        // keyset의 get은 hash를 이용하나 entry는 해당 집합을 다 가져와서 O(1)이 되기 때문.
        // 물론 keySet()의 get도 그렇지만 같은 O(1)이라도 약간의 차이가 있다고 한다.
        // 참고 : https://stackoverflow.com/questions/3870064/performance-considerations-for-keyset-and-entryset-of-map
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(HashMap.Entry<String, Integer> entry : entries){
            if(entry.getValue() != 0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
