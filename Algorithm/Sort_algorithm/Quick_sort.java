package com.sorting;

public class Quick_sort {
    public static void main(String[] args){
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quick_sort(intArray, 0, intArray.length);

        // 출력
        for(int i=0; i < intArray.length; i++){
            if(i == intArray.length-1){
                System.out.println(intArray[i]);
            } else {
                System.out.print(intArray[i] + ", ");
            }
        }
    }

    public static void quick_sort(int[] intArray, int start, int end){
        if(end - start < 2){
            return;
        }

        int pivotIndex = partition(intArray, start, end);
        quick_sort(intArray, start, pivotIndex);
        quick_sort(intArray, pivotIndex+1, end);
    }

    public static int partition(int[] input, int start, int end){
        //첫 element를 pivot으로 사용

        int pivot = input[start];
        int i = start;
        int j = end;

        while(i < j){

            while(i < j && input[--j] >= pivot);
            if(i < j){
                input[i] = input[j];
            }


            while(i < j && input[++i] <= pivot);
            if(i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }
}
