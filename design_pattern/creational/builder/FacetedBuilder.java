package com.design_pattern.creational.builder;

class Person2{
    // Address
    public String streetAddress, postcode, city;

    // Employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// Builder
class PersonBuilder2{
    protected Person2 person = new Person2();

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works(){
        return new PersonJobBuilder(person);
    }

    public Person2 build(){
        return person;
    }
}

class PersonAddressBuilder extends  PersonBuilder2{
    public PersonAddressBuilder(Person2 person){
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress){
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode){
        person.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder in(String city){
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder2{
    public PersonJobBuilder(Person2 person){
        this.person = person;
    }

    public PersonJobBuilder at(String companyName){
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position){
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome){
        person.annualIncome = annualIncome;
        return this;
    }
}

public class FacetedBuilder {

    public static void main(String[] args){
        PersonBuilder2 pb = new PersonBuilder2();

        // 여러 개의 속성을 갖는 객체를 각각의 속성을 구분하여 복수의 Builder Class를 만들어
        // 직관적으로 볼 수 있게 구현함.
        Person2 person = pb
                .lives()
                  .at("123 London Road")
                  .in("London")
                  .withPostcode("SW12BC")
                .works()
                  .at("Fabrikam")
                  .asA("Engineer")
                  .earning(123000)
                .build();
        System.out.println(person);
    }
}
