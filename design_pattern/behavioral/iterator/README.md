### Iterator 패턴
- 개요
    - 자료 구조를 Traverse 할 수 있도록 구조화된 패턴
    - 즉, 자료 구조를 동작시키고 그 내에 있는 Element에 대한 iterate 작업을 할 수 있다.
    - 다양한 자료 구조들의 core 기능으로 동작하며, iterator는 현재 element에 대한 참조값을 저장한다. 그리고 다른 element로 어떻게 이동할지를 알고 있어야 한다.
- Java의 Iterator
    - Iterator<T> 인터페이스
        - iterator API를 의미함.
    - Iterable<T>
        - for(Foo foo : bar) loop와 같은 식으로 사용할 수 있으려면 해당 인터페이스를 구현해야 한다.