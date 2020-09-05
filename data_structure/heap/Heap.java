package heap;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity){
        heap = new int[capacity];
    }

    public void insert(int value){
        // resize할 수 있지만 여기선 그냥 예외처리
        if(isFull()) {
            throw new IndexOutOfBoundsException("Heap is Full");
        }

        heap[size] = value;

        // heapify하는 코드
        fixHeapAbove(size);
        size++;
    }

    // root value를 반환할 것
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        return heap[0];
    }

    // 일반적으로 heap은 우선순위에 따라 값이 들어가기 때문에 root를 항상 delete하게 됨
    // 그러나 특정 구현 방식에 따라 내부에 heap value를 제거하고 싶을 수 있음
    // 이 때, value를 넘기지 않고 index를 넘긴다. 왜냐면 value를 넘기면 linear search를 하기 때문
    public int delete(int index){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        // rightmost value로 대체
        heap[index] = heap[size - 1];

        // heapify 전에 above / below 결정
        if(index == 0 || heap[index] < heap[parent]){
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    // heapify하는 method
    private void fixHeapAbove(int index){
        int newValue = heap[index];

        // index가 root에 다다르지 않았고 new item의 value가 parent보다 크다면
        while(index > 0 && newValue > heap[getParent(index)]){

            // parent의 값을 새 index에 넣음
            heap[index] = heap[getParent(index)];

            // parent의 parent와도 비교해야 하므로 index 조정
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    // last position은 기본적으로 size -1
    private void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;

        while(index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            // 좌측 child가 있는 경우
            if(leftChild <= lastHeapIndex){
                // 우측 child는 없는 경우
                if(rightChild > lastHeapIndex){
                    childToSwap = leftChild;
                // 둘 다 있다면 더 큰 쪽하고
               } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
               }
                // swap할 조건에 만족 시 swap
               if(heap[index] < heap[childToSwap]){
                   int temp =  heap[index];
                   heap[index] = heap[childToSwap];
                   heap[childToSwap] = temp;
               } else {
                   break;
               }

               index = childToSwap;
            } else {
                break;
            }
        }
    }

    public void printHeap(){
        for(int i=0; i < size; i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public int getParent(int index){
        // Integer라 알아서 flooring됨
        return (index - 1) / 2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index, boolean left){
        return 2 * index + (left ? 1 : 2);
    }
}
