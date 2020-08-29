package com.data_structure.hashTable;
import java.util.*;

public class Programmars_4 {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
        int[] plays = {500, 600, 150, 800, 2500, 2000, 6000};

        HashMap<String, int[]> map = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        for(int i=0; i < genres.length; i++){
            String key = genres[i];
            if(!map.containsKey(key)){
                int[] init = {i, -1};
                map.put(key, init);
            } else {
                int play = plays[i];
                int input_index = i;
                int[] val = map.get(key);
                for(int j=0; j < val.length; j++){
                    int current_index = val[j];
                    if(current_index == -1){
                        val[j] = input_index;
                        break;
                    }
                    if(play > plays[val[j]]){
                        play = plays[current_index];
                        int temp = val[j];
                        val[j] = input_index;
                        input_index = temp;
                    }
                }
            }

            total.put(key, total.getOrDefault(key, 0) + plays[i]);
        }

        // Total 정렬
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(total.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(HashMap.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(HashMap.Entry<String, Integer> entry : entries){
            int arr[] = map.get(entry.getKey());
            for(int val : arr){
                if(val != -1){
                    arrayList.add(val);
                }
            }
        }

        int[] answer = new int[arrayList.size()];
        for(int i=0; i < arrayList.size(); i++){
            answer[i] = arrayList.get(i);
            System.out.print(answer[i] + ", ");
        }

    }
}
