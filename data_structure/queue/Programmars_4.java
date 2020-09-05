package queue;

import java.util.*;

public class Programmars_4 {
    public static void main(String[] args){
        Programmars_4 s = new Programmars_4();
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;

        int answer = s.solution(stock, dates, supplies, k);
        System.out.println(answer);

    }
    public int solution(int stock, int[] dates, int[] supplies, int k){
        PriorityQueue<Supply> queue = new PriorityQueue<>(new Comparator<Supply>() {
            @Override
            public int compare(Supply o1, Supply o2) {
                return o2.supply >= o1.supply ? 1 : -1;
            }
        });

        for(int i=0; i < dates.length; i++){
            queue.offer(new Supply(dates[i], supplies[i]));
        }

        int current = stock-1;
        int answer = 0;
        Queue<Supply> temp = new LinkedList<>();
        while(current < k-1){
            Supply next = queue.poll();
            if(current < next.date-1){
                temp.offer(next);
                continue;
            }

            current += next.supply;
            answer++;
            while(!temp.isEmpty()){
                queue.offer(temp.poll());
            }
        }

        return answer;
    }
    private class Supply{
        int date;
        int supply;
        public Supply(int date, int supply){
            this.date = date;
            this.supply = supply;
        }
    }
}

