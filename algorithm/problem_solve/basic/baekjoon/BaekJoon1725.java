package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1725 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[100001];

        StackImpl stack = new StackImpl();
        long max = 0;
        for(int i=0; i <= n; i++) {
            if(i < n){
                arr[i] = Integer.parseInt(br.readLine());
            }

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int peek = stack.pop();
                long width = i;
                if(!stack.isEmpty()) {
                    width = i - stack.peek() - 1;
                }
                max = Math.max(max, arr[peek] * width);
            }
            stack.insert(i);
        }
        System.out.println(max);
        br.close();
    }

    private static class StackImpl{
        int size = 0;
        int lastIndex = -1;
        int[] arr = new int[100001];

        public void insert(int idx){
            this.arr[++this.lastIndex] = idx;
            this.size++;
        }

        public int pop(){
            int retVal = this.arr[this.lastIndex];
            this.size--;
            this.lastIndex--;
            return retVal;
        }

        public int peek(){
            return this.arr[this.lastIndex];
        }

        public boolean isEmpty(){
            return this.size == 0;
        }
    }
}
