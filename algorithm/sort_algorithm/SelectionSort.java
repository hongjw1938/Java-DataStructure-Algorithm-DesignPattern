package com.algorithm.sort_algorithm;

public class SelectionSort {
    public static void main(String args[]){

        int[] array = {20, 35, -15, 7, 55, 1, -22};
        for(int unsortedIndex = array.length-1; unsortedIndex > 0; unsortedIndex--){
            int largest = 0;

            for(int j=1; j <= unsortedIndex; j++){
                if(array[largest] < array[j]){
                    largest = j;
                }
            }

            swap(array, largest, unsortedIndex);
        }

        for(int i=0; i < array.length; i++){
            if(i == array.length-1){
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    private static void swap(int[] array, int largest, int unsortedIndex){

        if(largest == unsortedIndex){
            return;
        }
        int temp = array[largest];
        array[largest] = array[unsortedIndex];
        array[unsortedIndex] = temp;
    }
}
