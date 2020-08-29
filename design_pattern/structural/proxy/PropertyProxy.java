package com.design_pattern.structural.proxy;

/*
 멤버 변수에 무언가가 들어가는 것을 logging하고 싶다고 하자.
 자바는 안타깝지만 = 연산자를 overload 할 수 없다.
*/
class Property<T>{
    private T value;

    public Property(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        //logging
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property<?> property = (Property<?>) o;
        return value.equals(property.value);
    }

    @Override
    public int hashCode(){
        return value != null ? value.hashCode() : 0;
    }
}

class Creature{

    // private int agility;
    // public Creature{
    //     agility = 123;
    // }

    // public int getAgility(){
    //     return agility;
    // }

    // public void setAgility(int agility){
    //     this.agility = agility;
    // }

    private Property<Integer> agility = new Property<>(10);
    public void setAgility(int value){
        agility.setValue(value);
    }

    public int getAgility(){
        return agility.getValue();
    }
}

class PropertyProxy{
    public static void main(String[] args){
        Creature creature = new Creature();
        
        // 이와 같이 Creature를 통해서 underlying value에 값을 넣는 방식을 direct방식을 하지 않도록 지정함.
        // 직접 지정할 수 없는 이유는 private 이어서 이기도 하나, public 이라 할지라도 타입을 지정하지 않아 안됨.
        creature.setAgility(12);
    }
}