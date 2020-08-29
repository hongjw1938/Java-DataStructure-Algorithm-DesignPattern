package com.data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Programmars_1{
    public static void main(String[] args){

        // Test case 1
        /*int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};*/

        /*int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};*/

        int bridge_length = 4;
        int weight = 5;
        int[] truck_weights = {4, 3, 1, 4};
        Queue<Integer> queue = new LinkedList<>();

        int answer = 0;
        int current_weight = 0;
        int passed = 0;
        for(int i=0; i < truck_weights.length; i++){
            int next_truck = truck_weights[i];
            if(current_weight + next_truck > weight){
                while(queue.size() < bridge_length){
                    queue.offer(0);
                    answer++;
                }
            }
            while(true){
                int p = 0;
                if(queue.size() == bridge_length || current_weight+next_truck > weight){
                    p = queue.poll();
                    current_weight -= p;
                    if(p > 0){
                        passed++;
                    }
                }
                if(current_weight+next_truck <= weight){
                    break;
                }
                queue.offer(0);
                answer++;
            }
            queue.offer(next_truck);
            current_weight += next_truck;
            answer++;
        }
        if(queue.size() != bridge_length){
            answer += (bridge_length-queue.size());
        }

        while(passed != truck_weights.length){
            int poll = queue.poll();
            if(poll > 0){
                passed++;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
