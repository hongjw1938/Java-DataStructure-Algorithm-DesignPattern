package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon5397 {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i < t; i++){
            String keyLogger = br.readLine();

            QueueImpl pre_q = new QueueImpl();
            QueueImpl post_q = new QueueImpl();
            for(int j=0; j < keyLogger.length(); j++){
                char c = keyLogger.charAt(j);
                switch(c){
                    case '<':post_q.add(pre_q.popLast()); break;
                    case '>':pre_q.add(post_q.popLast()); break;
                    case '-':pre_q.popLast(); break;
                    default: pre_q.add(c); break;
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!pre_q.isEmpty()){
                sb.append(pre_q.popFirst());
            }
            while(!post_q.isEmpty()){
                sb.append(post_q.popLast());
            }
            System.out.println(sb);
        }

        br.close();
    }

    private static class QueueImpl{
        int size = 0;
        int lastIndex = -1;
        int startIndex = 0;
        char[] arr = new char[1000001];

        public void add(char c){
            if(c == ' '){
                return;
            }
            arr[++lastIndex] = c;
            size++;
        }

        public char popFirst(){
            if(this.size == 0){
                return ' ';
            }
            char retChar = arr[startIndex++];
            this.size--;
            return retChar;
        }

        public char popLast(){
            if(this.size == 0){
                return ' ';
            }
            char retChar = arr[lastIndex--];
            this.size--;
            return retChar;
        }

        public boolean isEmpty(){
            return this.size==0;
        }
    }
}