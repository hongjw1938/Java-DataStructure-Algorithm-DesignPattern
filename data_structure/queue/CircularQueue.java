package queue;

import java.util.NoSuchElementException;

public class CircularQueue {

    private Employee[] queue;

    // 비어있으면 둘 다 0
    // back은 stack의 top과 같다. 다음에 이용가능한 position을 가리킴
    // 즉, back = 3이면, 현재 queue의 end item의 위치는 2이라는 의미임.
    private int front;
    private int back;

    public CircularQueue(int capacity){
        queue = new Employee[capacity];
    }

    public void add(Employee employee){
        // 현재 꽉 찼다면 resizing
        if(size() == queue.length - 1){
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        // 현재 이용가능한 위치, 즉 back의 위치에 추가하고 ++
        queue[back] = employee;

        if(back < queue.length - 1){
            back++;
        } else {
            back = 0;
        }
    }

    public Employee remove(){
        // queue가 empty 상태라면, 즉, back - front = 0이라면
        if(size() == 0){
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;

        // queue를 resetting 하는 부분
        if(size() == 0){
            front = 0;
            back = 0;
        }
        return employee;
    }

    public Employee peek(){
        if(size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size(){
        return back - front;
    }

    public void printQueue(){
        for(int i=front; i < back; i++){
            System.out.println(queue[i]);
        }
    }
}
