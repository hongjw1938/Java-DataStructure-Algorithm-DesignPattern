package com.algorithm.search_algorithm;

public class LinearSearch {
    public static void main(String[] args){
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.println(linearSearch(intArray, -15));
        System.out.println(linearSearch(intArray, 1));
        System.out.println(linearSearch(intArray, -12312));
        System.out.println(linearSearch(intArray, -22));
    }

    public static int linearSearch(int[] input, int value){
        for(int i=0; i < input.length; i++){
            if(input[i] == value){
                return i;
            }
        }

        return -1;
    }
}
