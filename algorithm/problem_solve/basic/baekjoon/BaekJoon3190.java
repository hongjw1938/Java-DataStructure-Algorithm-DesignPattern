package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon3190 {
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        snake = new boolean[n][n];

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            board[r][c] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        int time = 0;
        int move_index = 0;

        LinkedListImpl ll = new LinkedListImpl();
        ll.add(0, 0);
        boolean isOver = false;
        for(int i=0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            while(time < x){
                time++;
                int next_row = ll.tail.row + move[move_index][0];
                int next_col = ll.tail.col + move[move_index][1];

                if(next_row < 0 || next_row > n-1 || next_col < 0 || next_col > n-1 || snake[next_row][next_col] == true) {
                    isOver = true;
                    break;
                }

                ll.add(next_row, next_col);
                boardCheck(next_row, next_col, '+');
                if(board[next_row][next_col] == 1){
                    board[next_row][next_col] = 0;
                } else {
                    Node popped = ll.pop();
                    boardCheck(popped.row, popped.col, '-');
                }
            }
            if(isOver){
                break;
            }
            if(direction.equals("D")){
                move_index = (move_index+1)%move.length;
            } else {
                move_index = (move_index+3)%move.length;
            }
        }
        if(!isOver){
            while(true){
                time++;
                int next_row = ll.tail.row + move[move_index][0];
                int next_col = ll.tail.col + move[move_index][1];

                if(next_row < 0 || next_row > n-1 || next_col < 0 || next_col > n-1 || snake[next_row][next_col] == true) {
                    break;
                }

                ll.add(next_row, next_col);
                boardCheck(next_row, next_col, '+');
                if(board[next_row][next_col] == 1){
                    board[next_row][next_col] = 0;
                } else {
                    Node popped = ll.pop();
                    boardCheck(popped.row, popped.col, '-');
                }
            }
        }
        System.out.println(time);
        br.close();
    }

    public static void boardCheck(int row, int col, char inst){
        if(inst =='+'){
            snake[row][col] = true;
        } else {
            snake[row][col] = false;
        }
    }

    static class LinkedListImpl{
        int size;
        Node head;
        Node tail;
        public LinkedListImpl(){
            size = 0;
            head = null;
        }

        public void add(int row, int col){
            Node node = new Node(row, col);
            if(head == null){
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public Node pop(){
            Node target = head;
            head = target.next;
            size--;
            return target;
        }
    }
    static class Node{
        Node next;
        int row;
        int col;

        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
