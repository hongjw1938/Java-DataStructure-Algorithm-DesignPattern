### Singleton Pattern
- Wiki 참조
    - ![Alt Text](./image/SingletonPatternWiki.png)
- 개념
    - 안전한 Singleton pattern을 만드는 것은 간단
        - Lazy initialization, inner static class등을 이용하여 thread안전하게 만들 수 있다.
    - Singleton은 Test하기 어렵다.
        - 자체적으로 INSTANCE가 하나인데, DB 같은 경우를 이와 같이 만들어 Test하는 것은 적절하지 않다.
        - Dummy class를 만들어서 수행해야 한다.
        - 즉, Singleton을 직접 이용하기 보단 Abstraction을 이용하여 Test
        - 또는, Singleton lifetime in Dependency Injection container를 구성하는 것을 고려하라.
        - <a href="">예시</a>
    - 어떠한 구성 요소들은 하나의 system만 가지는 것이 적절함.
        - Database 저장소
        - Object Factory
            - 이는 어떤 state를 갖지 않고 객체를 생성하기만 함
            - 즉, abstract factory, builder, prototype 등이 사용 가능
    - 생성자 call이 expensive 한 경우
        - 한 번만 요청하는 것이 적절
        - 모든 시스템에 하나의 동일한 instance만 제공
    - 추가적인 인스턴스 복제는 금지하고 싶은 경우 적절
    - lazy instantiation 및 thread safety를 고려하는 경우 적절
        - lazy instantiation이란, JVM에 class가 로딩될 때 객체 생성하지 않고, 필요할 때 생성
            - 객체 생성하는 경우 : ```private List<Grade> grades = new ArrayList<Grade>();```
            - 즉, 위와 같이 직접 생성되도록 하지 않고 ```private List<Grade> grades;```와 같이 지정하고 필요 시 해당 변수에 객체를 넣어 생성하는 방식
            - 위의 행위를 위한 여타 메소드가 필요하며, 해당 method가 호출 될 때 객체가 생성된다.
        - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Creational/Singleton/LazyInitializationThreadSafe.java">참조</a>
    - Monostate vs Singleton
        - Monostate는 객체를 여럿 할당 받더라도 내부 상태 데이터의 유일성 보장
        - Singleton은 객체를 1개만 생성할 수 있음
        - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Creational/Singleton/Monostate.java">참조</a>
- 여러 Singleton pattern
    - Inner Static class 이용
        - 내부 클래스를 사용하여 패턴을 유지하는 방법으로, Synchronization 문제를 피할 수 있음. Thread safe
        - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Creational/Singleton/InnerStaticSingletonExample.java">참조</a>
    - Enum 기반 Singleton
        - Serialize를 하더라도 내부 Value들은 Serialize되지 않음.
        - 즉, State를 persist하게 유지할 필요 없음, 상속 불가
        - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Creational/Singleton/EnumBasedSingletonExample.java">참조</a>
    - Static block 
        - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Creational/Singleton/StaticBlockSingleton.java">참조</a>
- Singleton Pattern의 문제
    - Reflection 및 Serialization 시 Singleton Pattern을 유지할 수 없는 문제
        - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Creational/Singleton/SerializationProblem.java">참조</a>
        - Reflection을 이용하면 Class의 정보를 분석하여 강제로 접근 방식을 변경해 새로운 객체를 생성하도록 지정할 수 있음
            ```
            try{
                Class c = Class.forName("com.designPattern.creational.singleton.Singleton1");
                Method m[] = c.getDeclaredMethods();
                Constructor[] con = c.getDeclaredConstructors();
                for(Constructor constructor : con){
                    constructor.setAccessible(true);
                    Singleton1 s = (Singleton1) constructor.newInstance();
                    s.setValue(123);
                    System.out.println(s.getValue());
                }
            }catch(Exception e){

            }
            System.out.println(ins1.hashCode());
            System.out.println(ins2.hashCode());
            ```
        - Serialization화 하면 객체를 여러 개 생성 가능
    - Test 이슈
        - Singleton Pattern은 Test가 어렵다.
        - <a https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Creational/Singleton/TestabilityIssue.java>참조</a>