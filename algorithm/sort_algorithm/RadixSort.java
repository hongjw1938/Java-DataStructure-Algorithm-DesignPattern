package sort_algorithm;

public class RadixSort {
    public static void main(String[] args){
        int[] radixArray ={4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(radixArray, 10, 4);
        for(int i=0; i < radixArray.length; i++){
            if(i == radixArray.length-1){
                System.out.println(radixArray[i]);
            } else {
                System.out.print(radixArray[i] + ", ");
            }
        }
    }

    public static void radixSort(int[] input, int radix, int width){

        // radix는 진법, 즉 10이고 i는 value의 길이이므로 4이다.
        for(int i=0; i < width; i++){
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix){

        // 기존 배열의 길이를 따로 저장해둠
        // 추후 임시 배열 생성 시 사용
        int numItems = input.length;

        // radix, 즉 진법에 따라 배열 생성
        // 0~9까지의 숫자가 몇 번 나왔는지 각각 셈하기 위한 배열열
        int[] countArray = new int[radix];

        // position은 0,1,2,3으로 1,10,100,1000의 자리를 의미
        // input이라는 기존 배열에 있는 각 value들의 각 position의 값을 1자리 수로 받아서
        // 해당 값을 기반으로 몇 번 해당 값이 나왔는지 셈함
        for(int value : input){
            countArray[getDigit(position, value, radix)]++;
        }

        // adjust the count array
        // Stable한 알고리즘을 만들기 위해 countArray의 value를 직전 값을 누적하여 배열 저장
        for(int j=1; j < radix; j++){
            countArray[j] += countArray[j - 1];
        }

        // 기존 배열의 position에 따라서 임시 배열에 Stable하게 계속 값을 정렬하여 채워나감
        int[] temp = new int[numItems];
        for(int tempIndex = numItems -1; tempIndex >= 0; tempIndex--){
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        // 채워진 Value를 다시 기존 배열에 옮김
        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){
            input[tempIndex] = temp[tempIndex];
        }
    }

    // 각 자리수의 값(수)를 1자리로 반환하기 위한 메소드
    public static int getDigit(int position, int value, int radix){

        // value가 2014이고, position이 0이면, 10^0 이므로 1
        // 즉, value를 1로 나누면 그 자신이며 해당 값을 다시 radix로 나누면
        // 각 position에 맞는 값만 리턴할 수 있게 된다.
        return value / (int) Math.pow(radix, position) % radix;
    }
}
