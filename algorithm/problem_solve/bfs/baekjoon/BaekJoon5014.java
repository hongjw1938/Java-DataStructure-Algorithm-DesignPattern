package com.algorithm.problem_solve.bfs.baekjoon;

import java.util.Scanner;

public class BaekJoon5014 {
    // 코딩 교육 스타트업 면접에 간 건물에 특정 층으로 가기 위한 로직

    private static int highest;
    private static int start;
    private static int target;

    private static int up;
    private static int down;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        highest = scan.nextInt();
        start = scan.nextInt();
        target = scan.nextInt();

        up = scan.nextInt();
        down = scan.nextInt();


        int answer = 0;
        int diff = target - start;

        if(diff == 0){
            System.out.println(0);
        } else {
            if(diff > 0){
                if(up == 0) {
                    System.out.println("use the stairs");
                } else {
                    while(answer * up < diff){
                        answer++;
                    }
                    if(answer * up == diff){
                        System.out.println(answer);
                    } else {
                        int go_down = 0;
                        while(answer * up - diff > go_down * down && down != 0){
                            go_down++;
                        }
                        if(go_down * down == answer * up - diff){
                            System.out.println(answer + go_down);
                        } else {
                            System.out.println("use the stairs");
                        }
                    }
                }
            } else {
                int abs_diff = Math.abs(diff);
                if(down == 0) {
                    System.out.println("use the stairs");
                } else {
                    while(abs_diff > answer * down){
                        answer++;
                    }
                    if(abs_diff == answer * down){
                        System.out.println(answer);
                    } else {
                        int go_up = 0;
                        while(answer * down - abs_diff > up * go_up && up != 0){
                            go_up++;
                        }
                        if(answer * down - abs_diff == up * go_up){
                            System.out.println(answer + go_up);
                        } else {
                            System.out.println("use the stairs");
                        }
                    }
                }
            }
        }
    }
}
