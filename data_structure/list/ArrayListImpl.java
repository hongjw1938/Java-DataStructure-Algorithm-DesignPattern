package list;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayListImpl<T> {

    private int size;
    private T[] array;
    private int capacity;

    ArrayListImpl(){
        array = (T[]) new Object[16];
        size = 0;
        capacity = 16;
    }

    ArrayListImpl(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    private void makeDouble() {
        @SuppressWarnings("unchecked")
        T[] doubled = (T[]) new Object[capacity * 2];
        System.arraycopy(array, 0, doubled, 0, size);

        array = doubled;
        capacity *= 2;
    }

    public boolean add(T obj, int index) {
        if(index > size) return false;
        if(index >= capacity) makeDouble();

        for(int i=size-1; i >= index; i--) {
            array[i] = array[i-1];
        }

        array[index] = obj;
        size++;

        return true;
    }

    public boolean add(T obj) {
        return add(obj, size);
    }

    public boolean addFirst(T obj) {
        return add(obj, 0);
    }

    public boolean addLast(T obj) {
        if(size == capacity) makeDouble();
        array[size] = obj;
        size++;
        return true;
    }

    public T remove(int index) {
        if(index >= size || index < 0) throw new ArrayIndexOutOfBoundsException();
        T removed = array[index];

        for(int i=index+1; i <= size-1; i++) {
            array[i-1] = array[i];
        }


        size--;
        array[size] = null;

        return removed;

    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        T removed = array[size-1];
        size--;
        array[size] = null;
        return removed;
    }

    public String toString() {
        String str = "[";

        for(int i=0; i < size; i++) {
            str += array[i];
            if(i < size-1) {
                str += ",";
            }
        }
        return str + "]";
    }

    public T get(int index) {
        if(index >= size || index < 0) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public int sizeOf() {
        return size;
    }

    public int indexOf(T obj) {
        for(int i=0; i < size; i++) {
            if(obj.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) array, 0, size, c);
    }





}