package com.datastructure;

public class Array1 {

    public static void main(String[] args) {
	// write your code here
        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;
        
        
        int index = -1;
        
        //최악 시간 복잡도 : O(n)
        for(int i=0; i < intArray.length; i++){
            if(intArray[i] == 7) {
                index = i;
                break;
            }
        }
        System.out.println("index : " + index);
    }
}
