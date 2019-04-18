### Facade
- Wiki 참조
    - ![Alt Text](./image/FacadePatternWiki.png)\
- 개요
    - 기본적으로 복수의 component들을 단일 interface를 통해 exposing 시키는 디자인 패턴 >> End user가 사용하기 편리함
    - 집을 예시로 들어보자
        - 집은 전기, 위생 설비, 공조 설비 등 여러 설비 즉, Sub System을 갖추고 있다.
        - 내부 구조는 매우 복잡한데, End User는 이러한 내부 구조를 직접 확인할 필요가 없다.
    - 위와 같이, Software에서도 마치 Console 화면 처럼 API를 소비하여 동작하도록 하고 기반이 되는 Sub System은 직접 확인할 필요 없는 유연성을 갖는 시스템을 의미한다.
    - 즉, 크고 정교한 Code Body를 갖는 User에게 쉽고 직관적인 interface를 제공할 수 있는 패턴을 의미한다.