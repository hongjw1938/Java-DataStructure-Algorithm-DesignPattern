package com.design_pattern.creational.prototype;


import java.util.Arrays;

class Person implements Cloneable{
    String[] name;
    Address address;

    public Person(String[] name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + Arrays.toString(name) +
                ", address=" + address +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(
                name.clone(),
                (Address) address.clone()
        );
    }
}

class Address implements Cloneable{
    String roadName;
    int houseNumber;

    public Address(String roadName, int houseNumber) {
        this.roadName = roadName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "roadName='" + roadName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    // 이 method를 override하여 deep copy를 할 수 있게 지정
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Address(roadName, houseNumber);
    }
}
public class DontUseCloneable {

    public static void main(String[] args) throws Exception{

        // Person 객체는 다른 클래스들의 집합으로 객체를 생성함
        // 이러한 복잡한 생성 방식을 객체를 생성할 때마다 직접 서술하는 것은 비효율
        Person john = new Person(new String[]{"John", "smith"}, new Address("London road", 123));

        /*
        1. 아래와 같은 방식으로 객체를 생성하면 객체를 그대로 복사하기 때문에 적절하지 않다.

            Person jane = john;
            jane.name[0] = "Jane";
            jane.address.houseNumber = 124;

        */

        /*
        2. 직접 clone을 통해서 다음과 같이 생성하는 것 또한 단순히 shallow copy가 되어 reference도 동일하게 참조하게 된다.
        이 예는 Cloneable interface를 구현하여 만든 것인데, 이 interface는 무엇을 하는 것인지 정확히 명시되지 않는다.
        그래서 상단에 보는 것과 같이 직접 Clone method를 override하여 코드를 변경하게 된다.

        이 때문에 실질적으로는 deep copy를 위한 추가적인 작업이 필요했던 것인데, 이 방식은 별로 권고되지 않는다.

         */
        Person jane = (Person) john.clone();
        jane.name[0] = "Jane";
        jane.address.houseNumber = 124;
        System.out.println(john);
        System.out.println(jane);

    }
}
