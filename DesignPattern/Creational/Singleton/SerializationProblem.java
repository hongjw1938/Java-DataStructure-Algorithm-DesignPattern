package com.designPattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Singleton1{
    private Singleton1(){

    }
    private static final Singleton1 INSTANCE = new Singleton1();
    private int value = 0;

    public static Singleton1 getINSTANCE(){
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // serializable object 하에 다음과 같이 method를 구현하여
    // singleton pattern을 망가뜨리는 것을 해결할 수 있게 된다.
    protected  Object readResolve(){
        return INSTANCE;
    }
}

public class SerializationProblem {
    public static void main(String[] args) throws Exception{
        /*
        여기서는 private constructor가 defeat하는 문제들을 다룬다
        1. reflection 문제
           - 객체를 통해 class의 정보를 분석해 내는 프로그램 기법
            Singleton1 ins1 = Singleton1.getINSTANCE();
            Singleton1 ins2 = null;

            try{
                Class c = Class.forName("com.designPattern.creational.singleton.Singleton1");
                Method m[] = c.getDeclaredMethods();
                Constructor[] con = c.getDeclaredConstructors();
                for(Constructor constructor : con){
                    constructor.setAccessible(true);
                    Singleton1 s = (Singleton1) constructor.newInstance();
                    s.setValue(123);
                    System.out.println(s.getValue());
                }
            }catch(Exception e){

            }
            System.out.println(ins1.hashCode());
            System.out.println(ins2.hashCode());

            위와 같은 방식으로 Singleton 패턴을 무너뜨릴 수 있게 된다.
            각각의 hashcode가 달라 다른 객체라는 것을 확인할 수 있게 된다.

         2. Serialization 문제
           - file로 내보내서 serialization 하고 다시 불러들여 deserialization
           - 이 경우 각각의 객체가 생성되어 버림
         */
        Singleton1 singleton1 = Singleton1.getINSTANCE();
        singleton1.setValue(111);

        String filename = "singleton.bin";
        saveToFile(singleton1, filename);

        singleton1.setValue(222);
        Singleton1 singleton2 = readFromFile(filename);

        System.out.println(singleton1 == singleton2);

        System.out.println(singleton1.getValue());
        System.out.println(singleton2.getValue());
    }

    // Serialization
    static void saveToFile(Singleton1 singleton1, String filename) throws  Exception{
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){
                out.writeObject(singleton1);
        }
    }

    // Deserialization
    static Singleton1 readFromFile(String filename) throws Exception{
        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (Singleton1) in.readObject();
        }
    }
}
