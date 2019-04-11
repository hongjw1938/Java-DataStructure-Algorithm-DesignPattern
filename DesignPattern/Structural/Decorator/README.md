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
    - 즉, Decorator 패턴은 추가적인 Behavior를 개별적 Object에 추가하는데 직접적인 상속을 하지 않고 진행하는 방식을 의미한다.