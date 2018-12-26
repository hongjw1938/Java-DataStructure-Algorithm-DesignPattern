### Data Structure
- 자료구조란?
    - 데이터를 구조화하여 저장하는 방법
    - 예) 배열(순차적), 트리(계층적) 등
    - <a href="https://github.com/hongjw1991/java-data_structure-algorithm/tree/master/Data_Structure#%EB%B0%B0%EC%97%B4">배열</a>

<br>
<br>
<br>
<br>
<br>
<br>

- 배열
    - 크기 변경 불가
        - 메모리 상에서 인접한 위치 차지
        - 크기 변경 시 해당 memory 상 위치가 인접한지 보장할 수 없음
    - 메모리 상 동일한 크기의 공간 차지
        - 배열의 각 Element(요소)는 모두 동일한 크기의 공간을 차지한다.
        - Integer Type이라면 각 요소는 4byte씩 차지한다.
        - 각 요소마다 크기가 다를 수 없다.
        - Object Type을 저장하는 경우에는, 해당 Object를 참조하는 값이 해당하므로 크기에 차이가 없다.
        - 따라서, String의 경우도 String instance를 참조하는 값이 배열에 들어가므로 크기가 동일하게 된다.
    - Index를 기반으로 메모리 주소 계산 가능
        - 메모리에서 인접한 위치를 갖고, 동일한 크기만큼 공간이 있기 때문에, 배열의 Element를 찾는 주소 공간을 쉽게 계산할 수 있다.
        - 그러므로 배열의 요소가 i번째 위치 시, 주소 공간 계산 방법은 아래와 같다
            - x : 배열이 시작되는 element의 주소
            - y : 각 요소의 크기
            - i : 배열에서 위치하는 index
            - 계산 : x + i*y
            - ![Alt text](./image/array_1.png)
    - 배열의 요소를 반환하는 데 걸리는 시간은 동일하다
        - 요소가 배열의 어느 위치에 있더라도 index만 알면 동일한 계산 방법을 수행하므로 반환 시간이 동일하다.
        - 1번째, 5000번째, 100만번째 요소의 경우도 각각 동일함
        - 각 Step
            1. index를 구하고, 요소의 크기를 곱한다.
            2. 배열의 start 위치를 구한다
            3. 구하고자 하는 요소의 위치를 계산한다.
        - Big-O Notation
            - 찾고자 하는 요소의 Index를 아는 경우 : O(1)
            - Loop를 통해 Index를 검사하여 요소를 찾는 경우
                - 최악의 시간복잡도인 경우 : O(n)
                - 최선의 시간복잡도인 경우 : O(1), Constant Time
            - Operation 기반 시간복잡도
                - ![Alt text](./image/array_2.png)
                - 즉, 배열을 Loop하는 경우 선형 시간 복잡도를 갖게 된다.

- 추상 자료형(Abstract Data Type)
    - Abstract Data Type
        - 어떻게 Data가 organize 되어야 하는지 지정해놓지 않음.
        - 수행할 수 있는 operation을 지정
        - Concrete Data Structure가 아니다.(array의 경우 그러함, 그래서 class로 보통 구현함)
        - 보통 interface이다.
        - 일반적으로 특정 수행 가능한 behavior를 지정하며, conceptual idea를 의미함.
    - 즉, 기능의 구현 부분을 나타내지 않고 순수하게 가능한 기능이 무엇인지 나열한 것을 의미함
    - 대략, 사용 설명서와 같음.
    - 추상 자료형은, 구현자/사용자를 분리한다. 라이브러리를 사용하거나 내장 함수를 사용하는 것도 추상 자료형이 정의되어 있기 때문임
    - 이러한 구현은 외부로부터 숨겨져 있어, 정보 은닉의 효과를 얻는다.

- 리스트(List)
    - 개념
        - 기본적으로 Abstract Data Type이다. 따라서 Interface를 가짐
            - Java list : <a href="https://docs.oracle.com/javase/8/docs/api/java/util/List.html">참조</a>
                - 기존의 list와는 다르게 custom하며 사용하고 싶은 경우, AbstrctList / AbstractSequentialList 를 구현할 것
                - 여기서는 Array/LinkedList, Vector를 다룸
    - ArrayList
        - <a href="https://docs.oracle.com/javase/9/docs/api/java/util/ArrayList.html">Document</a>
        - 개념
            - 기본적으로 resizable하며, data는 array에 저장되고, 이러한 array를 backing array라고 부른다.
            - array를 기반으로 구현되었기 때문에, Accessing이 매우 빠르고 효율적.
            - 그러나, Data를 지속적으로 계속 추가하여야 하는 경우, resize, remove, move, add 등의 작업이 있어 많이 느릴 수 있다.
            - array를 기반으로 만들기 때문에 capacity를 지정하여 배열의 크기를 지정하여 구현한다.
            - 만약, capacity를 지정하지 않으면 기본적으로 10의 크기를 갖는 ArrayList를 만들게 된다.
        