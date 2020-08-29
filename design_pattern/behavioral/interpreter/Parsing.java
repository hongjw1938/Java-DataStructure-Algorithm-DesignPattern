package com.design_pattern.behavioral.interpreter;

import java.utils.*;

interface Element{
    int eval();
}

class Integer implemenets Element{
    public int value;
    
    public Integer(int value){
        this.value = value;
    }
    
    @Override
    public int eval(){
        return value;
    }
}

class BinaryOperation implements Element{
    public enum Type{
        ADDITION,
        SUBSTRACTION
    }
    
    public Type type;
    public Element left, right;
    
    // 실제 계산 수행
    @Override
    public int eval(){
        switch(type){
            case ADDITION:
                return left.eval() + right.eval();
                break;
            case SUBSTRACTION:
                return left.eval() - right.eval();
                break;
            default:
                return 0;
                break;
        }
    }
}


class Token{
    public enum Type{
        INTEGER,
        PLUS,
        MINUS,
        LPAREN,
        RPAREN,
    }
    
    public Type type;
    public String text;
    
    public Token(Type type, String text){
        this.type = type;
        this.text = text;
    }
    
    @Override
    public String toString(){
        return "`" + text + "`";
    }
}

public class Lexing{
    
    static List<Token> lex(String input){
        ArrayList<Token> result = new ArrayList<>();
        
        for(int i=0; i < input.length() ++i){
            switch(input.charAt(i)){
                case '+':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '(':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case ')':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for(int j = i+1; j < input.length(); ++j){
                        if(Character.isDigit(input.charAt(j))){
                            sb.append(input.charAt(j));
                            ++i;
                        } else {
                            result.add(new Token(
                                Token.Type.INTEGER, sb.toString()
                            ));
                            break;
                        }
                    }
                    break;
            }
        }
        return result;
    }
    
    static Element parse(List<Token> tokens){
        BinaryOperation result = new BinaryOperation();
        boolean haveLHS = false;
        
        for(int i = 0; i < tokens.size(); ++i){
            Token token = tokens.get(i);
            
            switch(token.type){
                case INTEGER:
                    Integer integer = new Integer(java.lang.Integer.parseInt(token.text));
                    if(!haveLHS){
                        result.left = integer;
                        haveLHS = true;
                    } else {
                        result.right = integer;
                    }
                    break;
                case PLUS:
                    result.type = BinaryOperation.Type.ADDITION;
                    break;
                case MINUS:
                    result.type = BinaryOperation.Type.SUBSTRACTION;
                    break;
                case LPAREN:
                    int j = 0;
                    for(; j < tokens.size(); ++j){
                        if(tokens.get(j).type == Token.Type.RPAREN){
                            break;
                        }
                    }
                    List<Token> subexpression = tokens.stream().skip(i+1).limit(j-i-1).collect(Collectors.toList());
                    Element element = parse(subexpression);
                    if(!haveLHS){
                        result.left = element;
                        haveLHS = true;
                    } else {
                        result.right = element;
                    }
                    i=j;
                    break;
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        String input = "(13+4)-(12+1)";
        List<Token> tokens = lex(input);
        
        // 위 input을 lexical token으로 분리시킨다.(Token class 이용)
        System.out.println(tokens.stream()
            .map(t -> t.toString())
            .collect(Collectors.joining("\t")));
            
        Element parsed = parse(tokens);
        System.out.println(input + " = " + parsed.eval());
    }
}