package com.designPattern.creational.singleton;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// state를 persist하게 유지할 필요가 없다는 장점
// 상속이 불가하다는 단점
/*
이 경우에는 main method에서 처럼 serialize를 해도 INSTANCE의 name만 serialize될 뿐
내부의 어떤 value 들도 serialize 되지 않는다는 것이다.
 */
enum EnumBasedSingleton{
    INSTANCE;

    // 자체적으로 private이다.
    EnumBasedSingleton(){
        value = 42;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class EnumBasedSingletonExample {
    // Serialization
    static void saveToFile(EnumBasedSingleton singleton, String filename) throws  Exception{
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(singleton);
        }
    }

    // Deserialization
    static EnumBasedSingleton readFromFile(String filename) throws Exception{
        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            return (EnumBasedSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception{
        String filename = "myfile.bin";

        // 아래를 실행하면 42가 나오지 않고 111이 나온다. 왜냐하면
        // value가 serialize 되지 않기 때문이다.
        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
        singleton.setValue(111);
        saveToFile(singleton, filename);

        EnumBasedSingleton singleton2 = readFromFile(filename);
        System.out.println(singleton2.getValue());
    }
}
