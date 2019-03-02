package com.designPattern.creational.singleton;

class ChiefExecutiveOfficer{
    // Monostate pattern
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Monostate {
    /*
    Monostate는 위와 같은 CEO 객체 Class가 있을 때,
    Singleton으로 만들어 버리게 되면, 각각의 value를 static으로 만들어야 하기에
    모든 객체가 다 같은 state를 갖게 되는데,

    누군가가 새로운 CEO 객체를 만들고 싶어하게 되면, 해당 객체 또한 기존의 state를
    유지하게 되어 class와의 communication이 되지 않는 다는 문제가 생김

    이것이 Monostate pattern이다. 즉, 객체는 별도로 할당 받더라도 데이터의 유일성을 보장함함
    */
    public static void main(String[] args){

    }
}
