package com.sorting;

public class Counting_sort {
    public static void main(String[] args){
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};


        countingSort(intArray, 1, 10);
        for(int i=0; i < intArray.length; i++){
            if(i == intArray.length-1){
                System.out.println(intArray[i]);
            } else {
                System.out.print(intArray[i] + ", ");
            }
        }
    }

    public static void countingSort(int[] input, int min, int max){

        // Element의 범위에 알맞는 배열 생성
        int[] countArray = new int[(max-min)+1];

        for(int i=0; i < input.length; i++){

            // 해당 element의 index를 알기 위해선 min을 빼줘야 함
            // 해당 Element가 나왔다면 ++해줌
            countArray[input[i] - min]++;
        }

        // input 배열에 써나가기 위한 index
        int j = 0;

        // min에서 max 값, 즉 각 element 마다 계속 반복
        for(int i = min; i <= max; i++){
            // countArray의 i-min의 위치이면 해당 element의 count가 저장된 곳
            // 즉, 그 value가 0 초과라면 element가 1번 이상 나왔다는 의미
            while(countArray[i - min] > 0){

                // 해당 반복 동안 원래의 input 배열에 해당 element를 채워 넣음
                input[j++] = i;

                // 그리고 채워 넣은 만큼 count value를 낮춤춤
                countArray[i -min]--;
            }
        }
    }
}
