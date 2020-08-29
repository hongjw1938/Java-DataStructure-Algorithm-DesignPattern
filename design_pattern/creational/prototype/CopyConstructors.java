package com.design_pattern.creational.prototype;

class Address2{
    public String streetAddress, city, country;

    public Address2(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Address2(Address2 other){
        this(other.streetAddress, other.city, other.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee2{
    String name;
    Address2 address;

    public Employee2(String name, Address2 address) {
        this.name = name;
        this.address = address;
    }

    public Employee2(Employee2 other){
        name = other.name;
        address = new Address2(other.address);
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

// Constructor를 이용하여 객체를 간단히 복사하여 사용하였다.
// 문제는 이 경우는 객체의 종류가 많다면 각각에 모든 복사용 생성자를
// 만들어두어야 한다는 것이다.
public class CopyConstructors {
    public static void main(String[] args){
        Employee2 john = new Employee2("John", new Address2("123 London Road", "London", "UK"));

        Employee2 chris = new Employee2(john);

        chris.name = "Chris";
        chris.address.streetAddress = "Gangnam 333";
        chris.address.city = "Seoul";
        chris.address.country = "KR";

        System.out.println(john);
        System.out.println(chris);
    }
}
