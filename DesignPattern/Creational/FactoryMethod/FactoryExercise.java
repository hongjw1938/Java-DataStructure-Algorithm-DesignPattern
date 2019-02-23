package com.designPattern.creational.factory;

import java.util.ArrayList;
import java.util.List;

// 반드시 Person 객체는 0부터 시작하여 sequence를 가지는 객체로 생성해야 한다.
class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    private static List<Person> personList = new ArrayList<>();
    private static int size = 0;
    public static Person createPerson(String name)
    {
        // todo
        Person person = new Person(size, name);
        personList.add(person);
        size++;
        return person;
    }
}
public class FactoryExercise {
    public static void main(String[] args){
        Person person1 = PersonFactory.createPerson("gildong");
    }
}
