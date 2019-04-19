### Decorator Pattern
- Wiki 참조
    - ![Alt Text](./image/DecoratorPatternWiki.png)\
- 개요
    - 현재 있는 Object에 추가적인 기능을 추가하고 싶은 경우 사용한다.
    - rewrite 또는 있는 코드를 변경하고 싶지 않음(OCP)
    - 새로운 기능은 분리된 상태로 관리하고자 함(SRP)
    - 이미 구성된 Structure와 잘 상호작용이 되어야 함
    - 위를 해결하기 위한 옵션
        1. 필요 Object를 상속한다. 그러나 몇 Class는 final이라 상속이 불가하다.
        2. 불가한 경우, Decorator를 Build하여 decorated Object를 참조하도록 지정한다.
            - 예) <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Structural/Decorator/StringDecorator.java">String Class 기능 추가 참조</a>
            - 즉, 원하는 Class가 Final 이라서 상속이 불가하므로 Delegation을 통해서 해당 Method들을 모두 가져오는 방식을 취함
    - 즉, Decorator 패턴은 추가적인 Behavior를 개별적 Object에 추가하는데 직접적인 상속을 하지 않고 진행하는 방식을 의미한다.
- Dynamic Decorator
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Structural/Decorator/DynamicDecorator.java">참조</a>
    - 필요한 만큼 Interface를 상속한 다음 다른 방식으로 추가 기능을 넣어 구현할 수 있는 방식
- Static Decorator
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Structural/Decorator/StaticDecorator.java">참조</a>
    - Static 방식으로 Decorate 된 Class의 기능을 추가하여 다시 Decorate해서 구현할 수 있는 방식
    - 안타깝게도, Java는 상속이 하나만 되기 때문에 그 한계에 의해 구현 방식이 좀 더 복잡하다.
- Adapter Decorator
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/blob/master/DesignPattern/Structural/Decorator/AdapterDecorator.java">참조</a>
    - 동일하게 Delegation을 StringBuilder 것을 사용한 것인데, 2가지 큰 문제는 필요없는 Annotation이 존재한다는 것과 Delegation된 method의 Return 타입이 새로 만든 Class가 아닌 기존 Class Type이라는 것
    - 따라서, Return Type을 전부 변경해야 한다는 큰 문제가 발생한다.
    - 이에 따라, Decorator 패턴을 Adapter 패턴처럼 사용하는 방식을 생각해볼 수 있다. 해당 내용을 참조한다.