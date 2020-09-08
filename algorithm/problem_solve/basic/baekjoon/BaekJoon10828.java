package problem_solve.basic.baekjoon;

import java.util.Scanner;

public class BaekJoon10828 {
    static int N;
    static int array[];
    static int point;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        N = Integer.parseInt(s.nextLine());
        array = new int[N];
        point = -1;

        String order = new String();
        for(int i=0; i < N; i++){
            order = s.next();
            if(order.equals("top")){
                System.out.println(top());
            } else if(order.equals("push")){
                int num = s.nextInt();
                push(num);
            } else if(order.equals("pop")){
                System.out.println(pop());
            } else if(order.equals("empty")){
                System.out.println(empty());
            } else {
                System.out.println(size());
            }
        }
        s.nextLine();
    }

    private static int top(){
        return point == -1 ? -1 : array[point];
    }
    private static void push(int num){
        point++;
        array[point] = num;
    }
    private static int size(){
        return point+1;
    }
    private static int pop(){
        if(point==-1){
            return -1;
        } else {
            int ret_val = array[point];
            array[point] = 0;
            point--;
            return ret_val;
        }
    }
    private static int empty(){
        return point == -1 ? 1 : 0;
    }
}

