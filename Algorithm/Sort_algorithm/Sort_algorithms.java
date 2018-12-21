package com.sorting;

public class Sort_algorithms {

    public static void main(String[] args){
        int[] array1 = { 20, 35, -15, 7, 55, 1, -22};
        int[] array2 = {4725, 4586, 1330, 8792, 1594, 5729};
        int[] array3 = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        bubbleSort(array1);


        for(int i=0; i < array1.length; i++){
            System.out.println(array1[i]);
        }
    }

    public static void swap(int[] array, int i, int j){
        if(i==j) return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Bubble 정렬 좌측 부터 정렬
    public static void bubbleSort(int[] array){

        for(int i=array.length-1; i > 0; i--){
            for(int j=1; j <= i; j++){
                if(array[j] < array[j-1]){
                    swap(array, j, j-1);
                }
            }
        }
    }

    // Bubble 정렬 우측 부터 정렬
    public static void bubbleSort2(int[] array){
        for(int i=0; i < array.length-1; i++){
            for(int j = array.length-1; j > i; j--){
                if(array[j] < array[j-1]){
                    swap(array, j, j-1);
                }
            }
        }
    }
}
