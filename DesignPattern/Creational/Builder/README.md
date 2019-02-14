### Builder 패턴
- Wiki 설명 참조
    - ![Alt Text](../image/BuilderPatternExplain.png)
- 개념
    - 전체 argument를 받는 생성자로 모든 객체가 받게 하면 비효율적이고 가독성이 떨어짐
    - 각각의 argument의 조합으로 생성자를 만들면 너무 코드가 복잡해지고 유지 보수에 좋지 않음
    - 그렇다고 객체를 만들고 option을 setter(자바 bean등) 으로 설정하도록 해도 비효율적
    - 따라서, 불필요한 생성자를 제거하고 / 데이터 순서에 무관하게 객체를 생성하며, 사용자가 명시적으로 이해할 수 있도록 만든 패턴이 builder 패턴
- fluent interface
    - StringBuilder처럼 지속적으로 append를 하여 chaining을 하여 객체의 속성을 변경할 수 있는 방법
        - 이를 쓸 수 있는 이유는 StringBuilder 객체가 StringBuilder 객체를 반환하기 때문임
    - Builder.java코드에서 addChild의 반환 값을 HtmlBuilder로 해주면 된다.
        - 해당 내용은 코드에서 확인
    - Fluent Interface를 상속 Class에서 확장하여 Propagate하기
        - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/DesignPattern/Creational/Builder/FluentInterface.java">FluentInterface.java<a/>
        - 해당 코드에서 확인할 수 있듯이 Generics를 사용해 특정 Type을 받고 반환할 수 있도록 지정해야 함
- 복수의 Builder 사용
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/DesignPattern/Creational/Builder/FacetedBuilder.java">FacetedBuilder.java<a/>
    - 복수의 Builder Class를 이용하여 객체를 생성 시에 직관적으로 볼 수 있도록 구현 함
- 간단 Builder 코드 예시
    - <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/DesignPattern/Creational/Builder/BuilderInJava.java">BuilderInJava.java</a>
        - Java내에서 구현되어 있는 StringBuilder Class를 이용해 코드를 간단하게 작성한다.
        - StringBuilder는 Concatenate나 + Operation이 아닌 append를 사용해 String 객체의 속성을 쉽게 생성하고 사용할 수 있다.
        ```
            public class BuilderInJava {
                public static void main(String[] args){
                    String hello = "hello";
                    System.out.println("<p>" + hello + "</p>");
            
                    String[] words = {"hello", "world"};
            
                    // Concatenate (+ operation) 등을 사용하는 것보다 훨씬 직관적
                    // 이는 String 객체를 표현하기 위해 Java에 내장되어 있는 Builder 이다.
                    StringBuilder sb = new StringBuilder();
                    
                    // append method를 활용해 직관적인 코드 작성
                    sb.append("<ul>\n");
                    for(String word : words){
                        sb.append(String.format("   <li>%s</li>\n, word"));
                    }
                    sb.append("</ul>");
                    System.out.println(sb);
                }
            }
        ```
    -
