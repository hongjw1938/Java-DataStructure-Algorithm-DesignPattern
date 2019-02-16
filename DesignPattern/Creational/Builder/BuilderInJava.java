package com.designPattern.creational.builder;

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
