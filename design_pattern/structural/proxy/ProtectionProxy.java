package com.design_pattern.structural.proxy;


/*
  누군가가 운전을 한다. - Drivable!
*/

interface Drivable{
    void drive();
}

class Car implements Drivable{
    protected Driver driver;
    public Car(Driver driver){
        this.driver = driver;
    }
    
    @Override
    public void driver(){
        System.out.println("Car being driven");
    }
}

class Driver{
    public int age;
    public Driver(int age){
        this.age = age;
    }
    
    
}

/*
  운전을 하기에 적절한 나이인지 확인을 하고 싶다!
  Car Object를 직접 생성해서 Driver 객체를 넣는 것은 해당 검사를 진행할 수 없다.
  
  따라서 Car Object에 접근할 수 있을 만큼 Old Enough한지 알아보기 위해 CarProxy를 만들어 Car를 상속하게 한다.
  이를 통해 기존 Class의 코드 변경 없이 하나의 Interface처럼 동작하도록 만들 수 있다.
*/
class CarProxy extends Car{
    public CarProxy(Driver driver){
        super(driver);
    }
    
    @Override
    public void drive(){
        if(driver.age >= 16){
            super.drive();
        } else {
            System.out.println("Driver too Young!");
        }
    }
}

class ProtectionProxy{
    public static void main(String[] args){
        Car car = new CarProxy(new Driver(12));
        car.drive();
    }
}