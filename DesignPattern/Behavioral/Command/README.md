### Command 패턴
- 개요
    - 일반적으로 Java의 명령문은 perishable하다. 즉, field assign을 취소하지도 못하고, action sequence serialize도 불가하다.
    - 예를 들어, object X가 w()라는 member method를 호출하는데 그 때까지 X는 Y를 유지하다가 Z로 변경되어야 하는 경우 등
    - 이 패턴은 즉, 특정 action을 수행하는 instruction을 갖는 object라고 보면 된다.
        - 해당 object는 action이 수행될 조건, 정보를 모두 갖는다.
    - 다시 말하자면, 각각의 object에 operation detail이 캡슐화 되어 있고, command를 적용하는데에 따른 instruction이 정의되어 있어야 한다.
        - 또한, 선택적으로 undoing 명령을 정의할 수 있고, composite command를 생성할 수 있다.
- 사용 예시
    - GUI commands, multi-level undo/redo, macro recording ..