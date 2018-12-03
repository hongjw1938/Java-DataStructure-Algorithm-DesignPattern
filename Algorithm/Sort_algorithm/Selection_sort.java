package com.sorting;

public class Selection_sort {
    public static void main(String args[]){

        int[] array = {20, 35, -15, 7, 55, 1, -22};
        for(int i = array.length-1; i >= 0; i--){
            int largest = 0;

            for(int j=0; j <= i; j++){
                if(array[largest] < array[j]){
                    largest = j;
                }
            }

            swap(array, largest, i);
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
