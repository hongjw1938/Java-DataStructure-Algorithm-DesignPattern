package sort_algorithm;

public class QuickSort {
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
        // Data가 1개만 남은 경우 더 이상 분할할 수 없으니 반환
        if(end - start < 2){
            return;
        }
        
        // partition method를 통해 pivor의 index를 구하면 좌측은 모두 pivot 이하의 값, 우측은 pivot 이상의 값
        int pivotIndex = partition(intArray, start, end);
        
        // 해당 pivot의 위치만을 제외한 좌 / 우측의 내부를 다시 정렬
        quick_sort(intArray, start, pivotIndex);
        quick_sort(intArray, pivotIndex+1, end);
    }

    public static int partition(int[] input, int start, int end){
        //첫 element를 pivot으로 사용
        // pivot이 될 값을 다른 변수에 잠시 저장
        int pivot = input[start];
        int i = start;
        int j = end;
        
        // start되는 pivot index와 end가 교차되지 않는 동안 반복
        while(i < j){
            
            // i와 j가 교차되지 않았고 end부분에서 --한 값이 pivot보다 크거나 같은 동안 계속 j의 값을 감소
            // 왜 prefix냐면 첫 번째인 경우 length로 시작하니까 거기엔 값이 없으며
            // 그 이후엔 이전 pivot의 위치이므로 역시 비교할 이유가 없기 때문
            while(i < j && input[--j] >= pivot);
            
            // 만약 i와 j가 교차되지 않았다면 i의 index자리에 j의 index 값을 넣는다.
            // 왜냐하면 그 값은 pivot보다 작으니까 pivot보다 좌측에 놓아야 하기 때문
            if(i < j){
                input[i] = input[j];
            }

            // 이번엔 i와 j가 교차되지 않았고 ++i동안 pivot보다 작거나 같다면 이미 더 작은 값이므로 계속 ++
            // 왜 prefix냐면 최초 i는 pivot값이니까
            while(i < j && input[++i] <= pivot);
            
            // 교차되지 않았다면 pivot보다 큰 값이 있다는 것이므로 우측에 놓기 위해 값의 위치 변경
            if(i < j) {
                input[j] = input[i];
            }
        }
        
        // 교차되었다면 반복문을 빠져나온 것이므로 pivot의 값을 입력
        input[j] = pivot;
        
        // 해당 pivot의 위치를 반환
        return j;
    }
}
