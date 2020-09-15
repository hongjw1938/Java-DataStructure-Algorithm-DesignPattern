package problem_solve.basic.baekjoon;

import java.io.*;

public class BaekJoon1406 {
    static char[] left_string = new char[500000];
    static char[] right_string = new char[500000];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] original = br.readLine().toCharArray();
        int left_index = original.length;
        int right_index = 0;
        for(int i=1; i <= original.length; i++){
            left_string[i] = original[i-1];
        }

        int orders = Integer.parseInt(br.readLine());
        for(int i=0; i < orders; i++){
            char[] order = br.readLine().toCharArray();
            if(order[0] == 'L'){
                if(left_index >= 1){
                    right_string[++right_index] = left_string[left_index--];
                }
            } else if(order[0] == 'D'){
                if(right_index >= 1){
                    left_string[++left_index] = right_string[right_index--];
                }
            } else if(order[0] == 'B'){
                if(left_index >= 1){
                    left_index--;
                }
            } else {
                char add = order[2];
                left_string[++left_index] = add;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(left_index >= 1){
            for(int i=1; i <= left_index; i++){
                sb.append(left_string[i]);
            }
        }
        if(right_index >= 1){
            for(int i=right_index; i >= 1; i--){
                sb.append(right_string[i]);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
