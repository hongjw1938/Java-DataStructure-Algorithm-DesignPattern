package sort_algorithm;

public class HeapSortTest {

    public static void main(String[] args){
        HeapSort heap = new HeapSort(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();
        heap.sort();
        heap.printHeap();
    }
}
