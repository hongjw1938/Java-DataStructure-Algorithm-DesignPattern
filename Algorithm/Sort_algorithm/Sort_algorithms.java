package com.sorting;

public class Sort_algorithms {

    public static void main(String[] args){
        int[] array1 = { 20, 35, -15, 7, 55, 1, -22};
        int[] array2 = {4725, 4586, 1330, 8792, 1594, 5729};
        int[] array3 = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        int[] array4 = { 10, -12, -52, 2315, 23, -5, 1, 0, 2, 7312};
        shellSort2(array1);
        mergeSort(array4, 0, array4.length);


        for(int i=0; i < array4.length; i++){
            System.out.println(array4[i]);
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

    // Shell 정렬 좌측부터 정렬
    public static void shellSort(int[] array){
        for(int gap = array.length / 2; gap > 0; gap /= 2){
            for(int i=gap; i < array.length; i++){
                int tobeInserted = array[i];
                int j=i;
                while(j >= gap && array[j-gap] > tobeInserted){
                    array[j] = array[j-gap];
                    j -= gap;
                }
                array[j] = tobeInserted;
            }
        }
    }

    // Shell 정렬 우측부터 정렬
    public static void shellSort2(int[] array){
        for(int gap = array.length / 2; gap > 0; gap /= 2){
            for(int i=array.length-gap-1; i >= 0; i--){
                int tobeInserted = array[i];
                int j=i;
                while(j < array.length-gap && array[j+gap] < tobeInserted ){
                    array[j] = array[j+gap];
                    j += gap;
                }
                array[j] = tobeInserted;
            }
        }
    }

    // Merge(병합) 정렬
    public static void mergeSort(int[] array, int start, int end){
        if(end - start < 2) return;

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merging(array, start, mid, end);
    }

    public static void merging(int[] array, int start, int mid, int end){
        if(array[mid-1] <= array[mid]) return;
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] temp = new int[end - start];

        while(i < mid && j < end){
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);

        System.arraycopy(temp, 0, array, start, tempIndex);
    }
}
