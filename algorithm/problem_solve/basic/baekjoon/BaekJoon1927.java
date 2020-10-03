package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HeapImpl h = new HeapImpl();
        for(int i=0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                System.out.println(h.pop());
            } else {
                h.insert(x);
            }
        }

        br.close();
    }

    static class HeapImpl{
        int size = 0;
        int[] array = new int[100001];
        int capacity = 100001;
        int lastIndex = 0;

        public boolean isEmpty(){
            return this.size == 0;
        }

        public void insert(int x){
            this.array[++lastIndex] = x;
            this.aboveHeapify(lastIndex);
            this.size++;
        }

        private void aboveHeapify(int startIndex){
            int relocateData = this.array[startIndex];
            int current = startIndex;
            while(current > 1 && relocateData > this.array[current / 2]){
                this.array[current] = this.array[current/2];
                current /= 2;
            }
            this.array[current] = relocateData;
        }

        public int pop(){
            if(isEmpty()){
                return 0;
            }
            int retData = this.array[1];
            int rightMostData = this.array[lastIndex];
            this.array[lastIndex--] = 0;
            this.array[1] = rightMostData;

            belowHeapify(1);
            this.size--;
            return retData;
        }

        private void belowHeapify(int startIndex){
            int relocateData = this.array[startIndex];
            int current = startIndex;

            while(current <= this.lastIndex){
                int leftChildIndex = current * 2;
                int rightChildIndex = current * 2 + 1;

                if(leftChildIndex > lastIndex){
                    break;
                } else {
                    int leftChild = this.array[leftChildIndex];
                    int rightChild = rightChildIndex > this.lastIndex ? 0 : this.array[rightChildIndex];

                    if(rightChild == 0){
                        if(leftChild > relocateData){
                            this.array[leftChildIndex] = relocateData;
                            this.array[current] = leftChild;
                            current = leftChildIndex;
                        } else {
                            break;
                        }
                    } else {
                        int swapChild = leftChild > rightChild ? leftChild : rightChild;
                        int swapIndex = leftChild > rightChild ? leftChildIndex : rightChildIndex;

                        if(swapChild > relocateData){
                            this.array[swapIndex] = relocateData;
                            this.array[current] = swapChild;
                        }
                        current = swapIndex;
                    }
                }
            }
        }

    }
}
