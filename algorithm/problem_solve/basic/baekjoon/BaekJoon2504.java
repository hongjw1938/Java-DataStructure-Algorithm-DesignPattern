package problem_solve.basic.baekjoon;

import java.io.*;

public class BaekJoon2504{

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StackImpl stack = new StackImpl();

        int ans = 0;
        for(int i=0; i < str.length(); i++){
            String s = str.substring(i, i+1);

            if(s.equals("(")){
                stack.add(")");
            } else if(s.equals("[")){
                stack.add("]");
            } else {

                int num = 0;
                while(!stack.isEmpty() && !stack.peek().s.equals(")") && !stack.peek().s.equals("]")){
                    num += Integer.parseInt(stack.pop().s);
                }

                if(stack.isEmpty()){
                    ans = 0;
                    break;
                }
                if(stack.peek().s.equals(s)){
                    stack.pop();
                    int newNum = s.equals(")") ? 2 : 3;
                    if(num == 0){
                        stack.add(String.valueOf(newNum));
                    } else {
                        stack.add(String.valueOf(newNum * num));
                    }
                } else {
                    ans = 0;
                    break;
                }

            }
        }

        while(!stack.isEmpty()){
            if(!stack.peek().s.equals(")") && !stack.peek().s.equals("]")){
                ans += Integer.parseInt(stack.pop().s);
            } else {
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }

    public static boolean isVPS(String c, String target){
        if(c.equals(target)){
            return true;
        }
        return false;
    }

    static class StackImpl{
        int size = 0;
        int lastIndex = -1;
        Node[] arr = new Node[30];


        public void add(String s){
            Node newNode = new Node(s);
            arr[++lastIndex] = newNode;
            size++;
        }

        public Node pop(){
            Node retNode = arr[lastIndex];

            lastIndex--;
            size--;
            return retNode;

        }

        public Node peek(){
            return arr[lastIndex];
        }

        public boolean isEmpty(){
            return size==0;
        }
    }

    static class Node{
        String s;
        public Node(String s){
            this.s = s;
        }
    }
}