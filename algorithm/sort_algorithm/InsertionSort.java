package com.algorithm.sort_algorithm;

public class InsertionSort {
    public static void main(String[] args){
        int intArray[] = {20, 35, -15, 7, 55, 1, -22};

        for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++){
            int toBeInserted = intArray[firstUnsortedIndex];

            int i;

            for(i=firstUnsortedIndex; i > 0 && intArray[i-1] > toBeInserted; i--){
                intArray[i] = intArray[i-1];
            }

            intArray[i] = toBeInserted;
        }

        for(int i=0; i < intArray.length; i++){
            System.out.print(intArray[i] + ", ");
        }
    }
}
