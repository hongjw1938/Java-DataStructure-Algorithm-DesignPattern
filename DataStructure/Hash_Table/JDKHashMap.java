package com.datastructure.hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JDKHashMap {
    public static void main(String args[]){
        Employee employee = new Employee("Jane", "Jones", 12);
        Employee employee1 = new Employee("John", "Doe", 23);
        Employee employee2 = new Employee("Mary", "Smith", 25);
        Employee employee3 = new Employee("Mike","Wilson", 32);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put(employee.getLastName(), employee);
        hashMap.put(employee1.getLastName(), employee1);
        hashMap.put(employee2.getLastName(), employee2);
        hashMap.put(employee3.getLastName(), employee3);
//        Employee now = hashMap.put(employee2.getLastName(), employee3);

        // 이를 시도해 보면, Smith가 아닌, Wilson을 반환하는 것을 확인할 수 있다.
//        System.out.println(hashMap.get(now.getLastName()));


        // 위와 같은 상황을 방지하기 위해 다른 method가 있다.
        // 이를 시도해보면 mary가 출력되는 것을 확인할 수 있다.
        Employee employee22 = hashMap.putIfAbsent(employee2.getLastName(), employee3);
        System.out.println(employee22);

        System.out.println(hashMap.remove(employee.getLastName()));
        // Key를 가지고 찾는 것이 더 효율적임.
        System.out.println(hashMap.containsKey("Doe"));
        System.out.println(hashMap.containsValue(employee1));
//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}
