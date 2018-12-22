package com.sorting;

public class Sort_algorithms {

    public static void main(String[] args){
        int[] array1 = { 20, 35, -15, 7, 55, 1, -22};
        int[] array2 = {4725, 4586, 1330, 8792, 1594, 5729};
        int[] array3 = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        insertionSort2(array1);


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

    // Bubble 정렬 우측 부터 정렬
    public static void bubbleSort(int[] array){

        for(int i=array.length-1; i > 0; i--){
            for(int j=1; j <= i; j++){
                if(array[j] < array[j-1]){
                    swap(array, j, j-1);
                }
            }
        }
    }

    // Bubble 정렬 좌측 부터 정렬
    public static void bubbleSort2(int[] array){
        for(int i=0; i < array.length-1; i++){
            for(int j = array.length-1; j > i; j--){
                if(array[j] < array[j-1]){
                    swap(array, j, j-1);
                }
            }
        }
    }

    // Selection 정렬 우측 부터 정렬
    public static void selectionSort(int[] array){
        for(int i=array.length-1; i > 0; i--){
            int largest = i;
            int j;
            for(j=0; j < i; j++){
                if(array[j] > array[largest]){
                    largest = j;
                }
            }
            swap(array, j, largest);
        }
    }

    // Selection 정렬 좌측 부터 정렬
    public static void selectionSort2(int[] array){
        for(int i=0; i < array.length-1; i++){
            int smallest = i;
            int j;
            for(j=array.length-1; j > i; j--){
                if(array[j] < array[smallest]){
                    smallest = j;
                }
            }
            swap(array, j, smallest);
        }
    }

    // Insertion 정렬 좌측부터 정렬
    public static void insertionSort(int[] array){
        for(int i=1; i < array.length; i++){
            int tobeInserted = array[i];
            int j;
            for(j=i; j > 0 && array[j-1] > tobeInserted; j--){
                array[j] = array[j-1];
            }

            array[j] = tobeInserted;
        }
    }

    // insertion 정렬 우측부터 정렬
    public static void insertionSort2(int[] array){
        for(int i=array.length-2; i >= 0; i--){
            int tobeinserted = array[i];
            int j;
            for(j=i; j < array.length-1 && array[j+1] < tobeinserted; j++){
                array[j] = array[j+1];
            }
            array[j] = tobeinserted;
        }
    }
}
