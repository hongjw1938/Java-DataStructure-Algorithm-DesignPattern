package problem_solve.basic.baekjoon;
import java.io.*;
public class BaekJoon1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PQ p = new PQ();
        for(int i=0; i < n; i++){
            int card = Integer.parseInt(br.readLine());
            p.add(card);
        }

        long sum = 0;
        while(p.size > 1){
            long a = p.pop();
            long b = p.pop();
            long t = a+b;
            sum += t;
            p.add(t);
        }
        System.out.println(sum);

        br.close();
    }

    private static class PQ{
        long[] arr = new long[100001];
        int size = 0;
        int lastIndex = 0;

        public void add(long n){
            arr[++lastIndex] = n;
            aboveHeapify();
            size++;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }

        public void aboveHeapify(){
            long replace = arr[lastIndex];

            int current = lastIndex;
            while(current > 1 && arr[current / 2] > replace){
                arr[current] = arr[current/2];
                current /= 2;
            }
            arr[current] = replace;
        }

        public long pop(){
            long ret = arr[1];
            arr[1] = arr[lastIndex--];
            belowHeapify();
            this.size--;
            return ret;
        }

        public void belowHeapify(){
            long replace = arr[1];

            int current = 1;
            while(current <= lastIndex){
                int leftIdx = current * 2;
                int rightIdx = current * 2 + 1;
                if(leftIdx > lastIndex){
                    break;
                }

                int swapIdx = 0;
                long swapChild = 0;
                if(rightIdx > lastIndex){
                    long leftChild = arr[leftIdx];
                    if(replace > leftChild){
                        swapChild = leftChild;
                        swapIdx = leftIdx;
                    }
                } else {
                    long leftChild = arr[leftIdx];
                    long rightChild = arr[rightIdx];

                    long targetChild = leftChild < rightChild ? leftChild : rightChild;
                    int targetIdx = leftChild < rightChild ? leftIdx : rightIdx;

                    if(replace > targetChild){
                        swapIdx = targetIdx;
                        swapChild = targetChild;
                    }
                }
                if(swapIdx != 0){
                    arr[swapIdx] = replace;
                    arr[current] = swapChild;
                    current = swapIdx;
                } else {
                    break;
                }
            }
        }
    }
}
