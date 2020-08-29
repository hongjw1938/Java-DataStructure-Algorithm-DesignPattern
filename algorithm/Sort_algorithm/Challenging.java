package com.sorting;

public class Challenge {
    public static void main(String[] args){
        int[] intArray = {20, -1, 3, -4, 32, 21, -5, 425, 10, 452, 31, -353, -43};
        String[] stringArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
//        insertionSortWithRecursive2(intArray, intArray.length);
        radixSort(stringArray, 5, 28);

        for(int i=0; i < stringArray.length; i++){
            if(i == stringArray.length-1){
                System.out.print(stringArray[i]);
            } else {
                System.out.print(stringArray[i] + ", ");
            }
        }
    }

    // 병합 정렬 Descending 순서로 구현
    public static void mergeSort(int[] array, int start, int end){
        if(end - start < 2) return;
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merging(array, start,mid, end);
    }

    public static void merging(int[] array, int start, int mid, int end){
        if(array[mid - 1] >= array[mid]) return;
        int i=start;
        int j=mid;
        int[] temp = new int[end - start + 1];
        int tempIndex = 0;
        while(i < mid && j < end){
            temp[tempIndex++] = array[i] < array[j] ? array[j++] : array[i++];
        }
        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
    }

    // 삽입 정렬을 recursive로 변경해보기
    public static void insertionSortWithRecursive(int[] array, int start){
        if(start >= array.length || start <= 0) return;

        int tobeInserted = array[start];
        int i=start;
        while(i > 0 && array[i-1] > tobeInserted){
            array[i] = array[i-1];
            i--;
        }
        array[i] = tobeInserted;
        insertionSortWithRecursive(array, start + 1);
    }

    // 다른 Recusive 삽입 정렬
    public static void insertionSortWithRecursive2(int[] array, int itemNum){
        if(itemNum < 2) return;

        insertionSortWithRecursive2(array, itemNum-1);
        int tobeInserted = array[itemNum-1];
        int i;
        for(i=itemNum-1; i > 0 && array[i-1] > tobeInserted; i--){
            array[i] = array[i-1];
        }
        array[i] = tobeInserted;
    }

    // String value를 정렬하는 Radix 정렬
    public static void radixSort(String[] array, int width, int radix){
        for(int i=width-1; i >= 0; i--){
            radixSingleSort(array, i, radix);
        }
    }

    public static void radixSingleSort(String[] array, int position, int radix){
        int itemNum = array.length;
        int[] counting = new int[radix];
        for(int i=0; i < itemNum; i++){
            counting[radixGetChar(array[i], position)]++;
        }
        for(int i=1; i < counting.length; i++){
            counting[i] += counting[i-1];
        }
        String[] temp = new String[itemNum];
        for(int i=itemNum-1; i >= 0; i--){
            temp[--counting[radixGetChar(array[i], position)]] = array[i];
        }
        for(int i=0; i < itemNum; i++){
            array[i] = temp[i];
        }
    }

    public static int radixGetChar(String value, int position){
        return value.charAt(position) - 97;
    }

    public static void test(String value){
        System.out.println(value.charAt(0));
        System.out.println((int)value.charAt(0));
    }
}
