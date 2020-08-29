package com.data_structure.stack;

import java.util.EmptyStackException;

public class ArrayBackedStack<T> {

    // stack으로 만들 배열 생성성
   private T[] stack;

    // 현재 stack의 top의 위치를 반환
    private int top;

    //생성자
    public ArrayBackedStack(int capacity){
        stack = (T[])new Object[capacity];
    }

    // stack에 채워넣는 메소드
    public void push(T element){
        // 현재 stack이 full인지 검사
        if(top == stack.length){
            // back array를 resizing해야 함
            T[] newArray = (T[])new Object[2 * stack.length];
            System.arraycopy(stack, 0 ,newArray, 0, stack.length);
            stack = newArray;
        }

        // stack에 채워넣는 코드
        stack[top++] = element;
    }

    // stack에서 빼내는 메소드
    public T pop(){
        if(isEmpty()){
            // 비어있는 경우에는 예외를 발생시킴
            throw new EmptyStackException();
        }

        // top은 다음에 넣을 수 있는 index를 가리키기 때문에 해당 index에는 아무것도 없다..
        // 따라서 감소시킨 다음 빼내야 함
        T element = stack[--top];

        // 빼내야 하는 부분이므로 해당 내용 지움
        stack[top] = null;

        return element;
    }

    // top - 1 의 position에 있는 Element 자체만 반환하고 빼내지 않는 메소드
    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size(){
        return top;
    }

    // stack의 내용을 출력함.
    public void printStack(){
        for(int i=top-1; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }

    // stack이 비어있는가?
    public boolean isEmpty(){
        return top == 0;
    }
}
