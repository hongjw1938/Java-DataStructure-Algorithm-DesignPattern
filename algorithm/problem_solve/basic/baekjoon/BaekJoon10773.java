package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StackImpl s = new StackImpl(k);
        int sum = 0;
        for(int i=0; i < k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                sum -= s.pop();
            } else {
                s.add(n);
                sum += n;
            }
        }

        System.out.println(sum);
        br.close();
    }

    static class StackImpl{
        int nums[];
        int size = 0;
        int index = 0;
        public StackImpl(int capacity){
            nums = new int[capacity];
        }

        public boolean isEmpty(){
            return this.size == 0 ? true : false;
        }

        public void add(int n){
            nums[index] = n;
            size++;
            index++;
        }
        public int pop(){
            if(isEmpty()){
                throw new NullPointerException("Stack is Empty");
            }
            int ret_val = nums[index-1];
            nums[index] = 0;
            index--;
            size--;
            return ret_val;
        }
    }
}
