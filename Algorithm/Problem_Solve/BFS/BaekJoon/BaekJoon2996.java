package com.problemsolve.bfs.baekjoon;

import java.util.Scanner;

public class BaekJoon2996 {
    // 로봇과 큐브가 주어질 때, 로봇을 움직여 큐브를 T자 모양으로 만들 것
    // T자가 되려면, 좌우로 3개, 가운데에 아래로 2개가 붙어야 함. T는 회전된 상태면 안됨
    // 우선 큐브와 로봇의 위치를 저장하고,

    private static CubePoint[] cubes;
    private static int[] moveY = {0, -1, 0, 1};
    private static int[] moveX = {1, 0, -1, 0};

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        cubes = new CubePoint[5];

        for(int i=0; i < 5; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            cubes[i] = new CubePoint(y, x);
        }

        scan.close();
    }
}

class CubePoint{
    int y;
    int x;

    public CubePoint(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}