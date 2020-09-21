package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            StackImpl stack = new StackImpl();
            char[] arr = new char[101];
            char[] nextLine = br.readLine().toCharArray();
            System.arraycopy(nextLine, 0, arr, 0, nextLine.length);
            int startIndex = nextLine.length;

            while(arr[startIndex-1] != '.'){
                nextLine = br.readLine().toCharArray();
                System.arraycopy(nextLine, 0, arr, startIndex, nextLine.length);
                startIndex += nextLine.length;
            }
            if(arr[0] == '.'){
                break;
            }

            boolean isBal = true;
            for(char c : arr){
                if(c == '(' || c == '['){
                    stack.add(c);
                } else if(c == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                    } else {
                        isBal = false;
                        break;
                    }
                } else if(c == ']'){
                    if(stack.peek() == '['){
                        stack.pop();
                    } else {
                        isBal = false;
                        break;
                    }
                } else if(c == '.'){
                    break;
                }
            }
            if(stack.isEmpty() && isBal){
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    static class StackImpl{
        int size = 0;
        int lastIndex = -1;
        char[] arr = new char[101];

        public void add(char c){
            arr[++lastIndex] = c;
            size++;
        }

        public char pop(){
            char ret = arr[lastIndex];
            lastIndex--;
            size--;
            return ret;
        }

        public char peek(){
            if(isEmpty()){
                return ' ';
            }
            return arr[lastIndex];
        }

        public boolean isEmpty(){
            return size==0;
        }
    }
}
