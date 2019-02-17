package com.designPattern.creational.builder;


class Person{
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

// 지네릭스를 이용하여 PersonBuilder를 상속하는 Class의 Type만 받을 수 있도록 지정함
// 이를 이용하지 않으면 EmployeeBuilder와 같이 상속 받는 Class에서만 정의한
// WorksAt method를 이용해 객체 Build를 chaining 할 수가 없다.
class PersonBuilder<SELF extends PersonBuilder<SELF>>{
    protected  Person person = new Person();

    public SELF withName(String name){
        person.name = name;
        return self();
    }

    public Person build(){
        return person;
    }

    protected SELF self(){
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
    public EmployeeBuilder worksAt(String position){
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

public class FluentInterface {

    public static void main(String[] args){
        EmployeeBuilder pb = new EmployeeBuilder();
        Person dmitri = pb
                .withName("Dmitri")

                // worksAt Chaining이 가능한 이유는 Generics로 타입을 지정했기 때문임임
               .worksAt("Developer")
                .build();

        System.out.println(dmitri);
    }
}
