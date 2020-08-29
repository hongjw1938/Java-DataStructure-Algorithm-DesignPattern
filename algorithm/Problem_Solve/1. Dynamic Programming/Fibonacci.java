package com.problemsolve.dp;

public class Fibonacci{
    public static void main(String[] args){
        return;
    }
    
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    
    public static int memoFibonacci(int n){
        if(n <= 1){
            return n;
        } else {
            // memo가 지정이 되지 않았다면 0이고 지정이 되었다면 0이 아닌 것이다.
            // 따라서 값을 계산하지 않고 배열의 값을 바로 return
            if(memo[n] > 0){
                return memo[n];
            }
            memo[n] = fibonacci(n-1) + fibonacci(n-2);
            return memo[n];
        }
    }
    
    public static int bottomupFibonacci(int n){
        int d = new int[100];
        d[0] = 0;
        d[1] = 1;
        for (int i=2; i < n; i++){
            d[i] = d[i-1] + d[i-2];
        }
        return d[n];
    }
}