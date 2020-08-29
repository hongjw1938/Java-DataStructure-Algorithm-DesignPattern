package com.design_pattern.structural.flyweight;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class User{
    private String fullName;
    public User(String fullName){
        this.fullName = fullName;
    }
}

class User2{
    static List<String> strings = new ArrayList<>();
    private int[] names;

    public User2(String fullName){
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = strings.indexOf(s);
            // -1 이 아니면 String을 찾은 것
            if(idx != -1){
                return idx;
            } else {
                strings.add(s);
                return strings.size() - 1;
            }
        };

        names = Arrays.stream(fullName.split(" "))
                .mapToInt(s -> getOrAdd.apply(s))
                .toArray();
    }
}

class RepeatingUserNames{
    public static void main(String[] args){
        // 아래와 같이 User를 각각 만들어 주는 것은 비효율
        // User user = new User("John Smith");
        // User user2 = new User("Jane Smith");



        User2 user = new User2("John Smith");
        User2 user2 = new User2("Jane Smith");

    }
}