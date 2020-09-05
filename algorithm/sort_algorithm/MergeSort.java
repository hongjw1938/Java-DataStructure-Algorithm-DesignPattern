package sort_algorithm;

public class MergeSort {
    public static void main(String[] args){
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};


        mergeSort(intArray, 0, intArray.length);
        // 출력
        for(int i=0; i < intArray.length; i++){
            if(i == intArray.length-1){
                System.out.println(intArray[i]);
            } else {
                System.out.print(intArray[i] + ", ");
            }
        }
    }

    // 병합 정렬 구현하는 메소드
    public static void mergeSort(int[] intArray, int start, int end){

        // recursive 기반이므로 method 호출을 멈추는 breaking point가 필요
        // 배열에 남은 인자가 하나라면 더 이상 나눌 필요 없음. 해당 조건 명시
        if( end - start < 2) {
            return;
        }

        // 배열을 2가지로 나눌 기준을 정함
        int mid = (start + end) / 2;

        // left 부분을 기반으로 mergeSort 메소드 호출
        mergeSort(intArray, start, mid);

        // right 부분을 기반으로 mergeSort 메소드 호출
        mergeSort(intArray, mid, end);

        // partitioning 된 배열을 기반으로 병합 수행
        merge(intArray, start, mid, end);
    }

    // 실제로 병합을 수행하는 메소드
    public static void merge(int[] intArray, int start, int mid, int end){

        // mid-1인 경우는 left의 마지막 element
        // mid는 right의 최초 element
        // 이 경우 다음 조건에 해당한다면, left의 모든 정렬된 배열의 인자값이
        // right의 배열의 인자보다 작거나 같으므로 더 이상 정렬을 수행할 이유가 없다는 것
        if(intArray[mid - 1] <= intArray[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        // i값은 mid보다 작다는 것은 left index의 최대 까지 증가할 수 있다는 의미
        // j값이 end 보다 작다는 조건은 right index의 최대 까지 증가할 수 있다는 의미
        // 그 조건이 만족되는 동안, i와 j의 index의 배열을 검사하여 정렬하고
        // 맞는 element를 임시 배열에 넣고 해당 index에 해당하는 변수의 값을 1 증가시킴
        while( i < mid && j < end){
            temp[tempIndex++] = intArray[i] <= intArray[j] ? intArray[i++] : intArray[j++];
        }

        // 위의 반복문을 이용해서 모든 index가 조정된 것은 아니므로 나머지 element를 정렬해야 한다.
        // right 쪽에 남아있는 경우에는 어차피 가장 큰 값이므로 또 다시 복사되지 않아도 상관없음
        // 그러나 left 쪽에 남아 있는 경우에는 position이 변경되어야 하므로 처리해야함
        // 그러므로, index 위치 i에서 시작하여 mid - i 부분의 길이(해당 길이는, mid와 i 사이에 남은 left 배열의 인자 개수)만큼 임시 배열에 저장된 마지막 index+1의 부분에 복사함.
        System.arraycopy(intArray, i, intArray, start + tempIndex, mid - i);

        // 그리고 전체 임시배열의 내용을 본래 배열에 전체 복사
        System.arraycopy(temp, 0, intArray, start, tempIndex);
    }
}
