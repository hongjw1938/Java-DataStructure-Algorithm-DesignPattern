package com.recursive;

public class RecursiveFactorial {
    public static void main(String[] args){
        System.out.println(recursiveFactorial(4));
    }

    public static int recursiveFactorial(int num){
        // 종료 조건문
        if(num == 0) return 1;

        return num * recursiveFactorial(num - 1);
    }
}
