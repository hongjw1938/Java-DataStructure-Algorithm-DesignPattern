package com.datastructure;

public class Bubble_sort {
    public static void main(String[] args){

        int[] intArray = { 20, 35, -15, 7, 55, 1, -22};

        // 정렬되지 않은 Index를 지정하여 해당 partition을 기반으로 재정렬을 시도한다.
        for(int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            // 정렬되지 않은 부분의 Partition 내부 인접 요소 검사하는 부분
            for(int i=0; i < lastUnsortedIndex; i++){

                // 오름차순 정렬 기반으로 낮은 인덱스를 가진 요소가 인접 요소보다 큰 값인 경우 위치 상호 변경한다.
                if(intArray[i] > intArray[i+1]){

                    // swap하기 위한 method를 호출하는 부분
                    swap(intArray, i, i+1);
                }
            }

            for(int i=0; i < intArray.length; i++){
                System.out.println(intArray[i]);
            }
        }
    }


    // 인접한 요소끼리의 위치를 변경한다.
    public static void swap(int[] array, int i, int j){

        if(i==j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
