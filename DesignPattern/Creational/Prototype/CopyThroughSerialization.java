package com.designPattern.creational.prototype;

// 생성자 복사를 통한 문제를 해결하여 사용하는 방법

import java.io.Serializable;

class Foo implements Serializable{
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

public class CopyThroughSerialization {
    public static void main(String[] args){
        Foo foo = new Foo(42, "life");

        // serialize and deserialize
        // 모든 객체가 serialized되므로 값을 통해 deep copy
        // roundtrip을 통해서 모든 객체를 serialize하여 전체 Object graph를 안전하게 보호한 상태에서
        // deep copy가 가능하다.
        // 객체에 다른 객체가 포함되어 있어도 모든 것이 serialized 된다.
        // 해당 객체를 반환하여 새로 객체를 만듦.
        Foo foo2 = SerializationUtils.roundtrip(foo);

        foo2.whatever = "xyz";
        System.out.println(foo);
        System.out.println(foo2);
    }
}
