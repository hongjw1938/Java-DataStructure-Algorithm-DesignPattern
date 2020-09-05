package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Programmars_4 {
    public static void main(String[] args){
        Programmars_4 s = new Programmars_4();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = s.solution(progresses, speeds);
        for(int i=0; i < answer.length; i++){
            System.out.print(answer[i] + ", ");
        }

    }
    public int[] solution(int[] progresses, int[] speeds){
        int[] complete = new int[progresses.length];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < progresses.length; i++){
            complete[i] = (100 - progresses[i]) % speeds[i] > 0 ? (100 - progresses[i]) / speeds[i] + 1: (100 - progresses[i]) / speeds[i];
            if(stack.isEmpty() || stack.get(0) >= complete[i]){
                stack.push(complete[i]);
            } else {
                queue.offer(stack.size());
                while(!stack.isEmpty()){
                    stack.pop();
                }
                stack.push(complete[i]);
            }
        }
        queue.offer(stack.size());

        int answer[] = new int[queue.size()];
        int index = 0;
        while(!queue.isEmpty()){
            answer[index] = queue.poll();
            index++;
        }
        return answer;
    }
}

