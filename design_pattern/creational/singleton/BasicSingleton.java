package com.design_pattern.creational.singleton;

class BasicSingletonObject{
    // 이와 같이 생성자를 private으로 생성하여 외부에서 접근할 수 없도록 한다.
    private BasicSingletonObject() {
    }

    // 하나의 final 객체로만 생성
    // Compile 이후 JVM에 올리자 마자 객체가 생성됨
    private static final BasicSingletonObject INSTANCE
            = new BasicSingletonObject();

    // 객체를 반환해서 사용할 수 있도록 지정
    public static BasicSingletonObject getInstance(){
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class BasicSingleton {
    public static void main(String[] args){
        BasicSingletonObject singleton = BasicSingletonObject.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());
    }
}
