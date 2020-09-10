package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StackImpl stack = new StackImpl();
        int current = 2;
        if(n % 2 == 1) stack.add(n);
        while(current <= n){
            stack.add(current);
            current += 2;
        }

        while(stack.size > 1){
            stack.pop();
            StackNode popped = stack.pop();
            stack.add(popped.val);
        }

        System.out.println(stack.pop().val);

    }

    static class StackImpl{
        int size=0;
        StackNode front;
        StackNode last;
        public void add(int val){
            StackNode node = new StackNode(val);
            if(size == 0){
                front = node;
                last = node;
            } else {
                last.next = node;
                last = last.next;
            }
            size++;
        }
        public StackNode pop(){
            StackNode ret = front;
            front = front.next;
            size--;
            return ret;
        }
        public boolean isEmpty(){
            return size==0? true : false;
        }
    }
    static class StackNode{
        int val;
        StackNode next;
        public StackNode(int val){
            this.val = val;
            this.next = null;
        }
    }
}