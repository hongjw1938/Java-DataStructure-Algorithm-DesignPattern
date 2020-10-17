package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class BaekJoon1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HeapImpl maxHeap = new HeapImpl(n, false); // 작은 숫자들이 내림차순
        HeapImpl minHeap = new HeapImpl(n, true); // 큰 숫자들이 오름차순

        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= n; i++){
            int num = Integer.parseInt(br.readLine());

            if(minHeap.getSize() == maxHeap.getSize()){
                maxHeap.insert(num);
            } else {
                minHeap.insert(num);
            }
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    int temp = minHeap.pop();
                    minHeap.insert(maxHeap.pop());
                    maxHeap.insert(temp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static class HeapImpl implements Comparator<Integer> {
        private int array[];
        private int capacity;
        private int size = 0;
        private int lastIndex = 0;
        private boolean asc;

        public HeapImpl(int n, boolean asc){
            this.capacity = n+1;
            this.array = new int[n+1];
            this.asc = asc;
        }

        public void insert(int val){
            this.array[++this.lastIndex] = val;
            this.aboveHeapify();
            this.size++;
        }

        private void aboveHeapify(){
            int relocate = this.array[this.lastIndex];
            int current = this.lastIndex;

            while(current > 1 && this.compare(this.array[current / 2], relocate) > 0){
                this.array[current] = this.array[current / 2];
                current /= 2;
            }
            this.array[current] = relocate;
        }

        public int pop(){
            int retData = this.array[1];
            belowHeapify();
            this.size--;
            return retData;
        }

        private void belowHeapify(){
            int relocate = this.array[this.lastIndex];
            this.array[this.lastIndex--] = 0;

            int currIdx = 1;
            this.array[currIdx] = relocate;
            while(currIdx < this.lastIndex){
                int leftIdx = currIdx * 2;
                int rightIdx = currIdx * 2 + 1;
                if(leftIdx > this.lastIndex){
                    break;
                } else {
                    int leftChild = this.array[leftIdx];
                    int rightChild = rightIdx > this.lastIndex ? (this.asc ? Integer.MAX_VALUE : Integer.MIN_VALUE) : this.array[rightIdx];

                    if(rightChild == Integer.MAX_VALUE || rightChild == Integer.MIN_VALUE){
                        if(this.compare(relocate, leftChild) > 0){
                            this.array[currIdx] = leftChild;
                            this.array[leftIdx] = relocate;
                        } else {
                            break;
                        }
                    } else {
                        int swapChild = this.compare(leftChild, rightChild) > 0 ? rightChild : leftChild;
                        int swapIdx = this.compare(leftChild, rightChild) > 0 ? rightIdx : leftIdx;
                        if(this.compare(relocate, swapChild) > 0){
                            this.array[currIdx] = swapChild;
                            this.array[swapIdx] = relocate;
                        }
                        currIdx = swapIdx;
                    }
                }
            }
        }

        public int peek(){
            return this.array[1];
        }

        public boolean isEmpty(){
            return this.size == 0;
        }

        public int getSize(){
            return this.size;
        }

        @Override
        public int compare(Integer n1, Integer n2) {
            int mul = 1;
            if(this.asc) {
                mul = 1;
            } else {
                mul = -1;
            }
            return (n1 - n2) * mul;
        }
    }
}

