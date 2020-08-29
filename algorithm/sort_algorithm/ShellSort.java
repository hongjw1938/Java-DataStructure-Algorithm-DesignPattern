package com.algorithm.sort_algorithm;

public class ShellSort {

    public static void main(String[] args){
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // Gap에 따라 정렬 하기 위해 Gap을 이용한 반복문을 생성함
        for(int gap = intArray.length / 2; gap > 0; gap /= 2){

            // Gap의 크기에 맞게 최초 정렬을 시작할 기준을 지정하여 반복문 형성
            for(int i=gap; i < intArray.length; i++) {

                // i에 지정된 값에 해당하는 Value를 정렬 시를 대비해 미리 저장해 둠
                int newElement = intArray[i];

                // j를 이용해 Gap 만큼의 반복 정렬을 수행할 것이므로 따로 저장
                int j = i;

                // 해당 반복 정렬을 조건이 참인 경우 수행
                // 해당 조건은, j의 index 값이 gap보다 커야 하며, j-gap의 index에 지정 된 배열 값이 이전에 저장된 내용보다 큰 경우
                while (j >= gap & intArray[j - gap] > newElement) {

                    // 해당 값을 뒤 쪽으로 미루어 저장
                    intArray[j] = intArray[j - gap];

                    // 반복 비교를 위해 gap만큼 차감
                    j -= gap;
                }

                // 기존에 저장한 배열 값을 저장
                intArray[j] = newElement;
            }
        }

        for(int i=0; i < intArray.length; i++){
            if(i == intArray.length-1){
                System.out.print(intArray[i]);
            } else {
                System.out.print(intArray[i] + ", ");
            }
        }
    }
}
