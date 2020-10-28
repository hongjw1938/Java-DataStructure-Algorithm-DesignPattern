package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon6549 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StackImpl stack = new StackImpl();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            long arr[] = new long[100001];
            long max = 0;
            for(int i=0; i <= n; i++){
                if(i < n) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                    int pop = stack.pop();
                    long width = i;
                    if(!stack.isEmpty()){
                        width = i - stack.peek() - 1;
                    }
                    max = Math.max(max, width * arr[pop]);
                }
                stack.add(i);
            }
            System.out.println(max);
        }

        br.close();
    }
    private static class StackImpl{
        int size = 0;
        int lastIndex = -1;
        int[] arr = new int[100001];
        public void add(int idx){
            arr[++lastIndex] = idx;
            this.size++;
        }

        public int pop(){
            int ret = this.arr[this.lastIndex--];
            this.size--;
            return ret;
        }
        public int peek(){
            return this.arr[this.lastIndex];
        }
        public boolean isEmpty(){
            return this.size == 0;
        }
    }
}
