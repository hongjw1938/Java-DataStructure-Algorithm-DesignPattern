### Structural 디자인패턴
1. <a href="#adapter">Adapter</a>패턴
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/DesignPattern/Structural/Adapter">상세 설명 보기</a>
2. <a href="#bridge">Bridge</a>패턴
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/DesignPattern/Structural/Bridge">상세 설명 보기</a>
3. <a href="#composite">Composite</a>패턴
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/DesignPattern/Structural/Composite">상세 설명 보기</a>
</br></br></br>
- <b id="adapter">Adapter</b>
    - Wiki 참조
        - ![Alt Text](./image/Adapterwiki1.png)
        - ![Alt Text](./image/Adapterwiki2.png)
    - 개념
        - 실제 Power Adapter를 생각해보자
            - 그 전자 장비는 각각 다른 Requirement가 있다.
            - Voltage(5V, 220V..), Socket/Plug Type(Europe, UK, USA)
            - 위와 같이 다른 기준이 있을 때, 우리는 모든 가능한 Interface를 만족시키도록 변형할 순 없다.
            - 따라서, Special device를 통해 필요한 interface를 얻어야 한다.
        - 즉, Adapter와 같은 장비가 필요한데, 이 interface는 이미 있는 X interface를 필요한 Y interface의 룰을 따르는 interface로 adapt(맞추다)하는 디자인 방식임
        - 간단히, 필요한 Interface에 맞추어 기존 소스 코드의 변화 없이 동작을 조정할 수 있기에 매우 유용함
            - 기존 클래스의 사양만 알면 새로운 Class를 쉽게 작성할 수 있음
            - 새로운 Class나 기존 Class가 다른 Interface에 Attach된 경우, 조정하기 위한 API가 필요함
            - 즉, Adaptee들을 집계하는 component가 필요하다는 의미임(해당 adaptee에 대한 reference를 가짐)
            - Caching 등의 최적화를 통해 객체를 구현할 수도 있음.
</br></br></br>
- <b id="bridge">Bridge</b>
    - Wiki 참조
        - ![Alt Text](./image/BridgeWiki1.png)
        - ![Alt Text](./image/BridgeWiki2.png)
    - 개념
        - Abstrations를 통해서 Component의 연결을 짓는 방식의 패턴
            - Abstrations를 각각 Decoupling하는데 각각은 계층적 구조를 가질 수 있음.
        - Bridge는 'Cartesian Product' 복잡성을 방지할 수 있는 방식
        - Entity Explosion을 피할 수 있다.
        - 예
            - Base Class ThreadScheduler
            - Can be preemptive or cooperative
            - Can run on Windows or Unix
            - End up with a 2 x 2 Scenario : WindowsPTS, UnixPTS, WindowsCTS, UnixCTS
        - 그림 예시
            - 아래의 그림과 같이, 기본적인 개념은 Interface Decoupling임.
            - ![Alt Text](./image/BeforeBridge.png)
            - ![Alt Text](./image/AfterBridge.png)
<br/><br/><br/>
- <b id="composite">Composite</b>
    - Wiki 참조
        - ![Alt Text](./image/compositewiki.png)
    - 개념
        - 개별, Scalar 구성 요소를 Aggregate Object 또는 Collections of component 처럼 사용할 수 있게 만듦
        - Object는 다른 Object의 field / method를 상속, composition을 통해 사용할 수 있음
        - Composition은 object를 혼합함.
            - ex) 수학적 표현, 다양한 shape을 가지는 group
        - Composite 패턴은 single / composite object를 동일한 방식으로 사용함.
        - 즉, Object가 다른 Object를 상속, Composition을 통해 사용가능한 방식.
            - 어떠한 단일, 구성 object는 동일한 behavior를 가져야 함.
            - Java는 Iterable 인터페이스를 통해 container iteration을 제공
            - 단일 object가 collection처럼 사용될 수 있음.