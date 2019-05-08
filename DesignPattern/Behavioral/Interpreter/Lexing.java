package com.designPattern.behavioral.interpreter;

import java.utils.*;

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
    public static void main(String[] args){
        String input = "(13+4)-(12+1)";
        List<Token> tokens = lex(input);
        
        // 위 input을 lexical token으로 분리시킨다.(Token class 이용)
        System.out.println(tokens.stream()
            .map(t -> t.toString())
            .collect(Collectors.joining("\t")));
    }
}