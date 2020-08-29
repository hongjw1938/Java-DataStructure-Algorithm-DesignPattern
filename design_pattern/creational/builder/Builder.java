package com.design_pattern.creational.builder;

import java.util.ArrayList;
import java.util.Collections;

class HtmlElement{
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {

    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent){
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine ));
        if(text != null && !text.isEmpty()){
            sb.append(String.join("", Collections.nCopies(indentSize*(indent+1), " ")))
                    .append(text)
                    .append(newLine);
        }

        for(HtmlElement e : elements){
            sb.append(e.toStringImpl(indent + 1));
        }

        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuilder{
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName){
        this.rootName = rootName;
        root.name = rootName;
    }

    public void addChild(String childName, String childText){
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }

    public void clear(){
        root = new HtmlElement();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

public class Builder {
    public static void main(String[] args){

        // Html 형식의 코드를 객체 형태로 생성하는 Class를 따로 생성한다.
        HtmlBuilder builder = new HtmlBuilder("ul");

        // 해당 Builder의 root 는 ui로 지정하고 그 아래 li tag들은 child 객체로 추가한다.
        // Builder Class에서 확인해보면 text가 비어 있는 경우는 indent가 없고, text가 있는 경우 indent가 존재함
        builder.addChild("li", "hello");
        builder.addChild("li", "world");
        System.out.println(builder);
    }
}
