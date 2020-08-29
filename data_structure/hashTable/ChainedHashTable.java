package com.data_structure.hashTable;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {

    private LinkedList<StoredEmployee>[] hashTable;

    public ChainedHashTable(){
        hashTable = new LinkedList[10];

        // 배열의 각 부분에 LinkedList 객체 추가함
        for(int i=0; i < hashTable.length; i++){
            hashTable[i] = new LinkedList<StoredEmployee>();
        }
    }

    private int hashKey(String key){
//        return key.length() % hashTable.length;
        return Math.abs(key.hashCode() % hashTable.length);
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);

        // iterator 객체를 통해 정확한 객체를 반환하기 위해 LinkedList를 탐사사
       ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;

        while(iterator.hasNext()){
            employee = iterator.next();
            // 정확한 해당 객체를 찾으면 break
            if(employee.key.equals(key)){
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterater = hashTable[hashedKey].listIterator();
        StoredEmployee employee = null;

        // NullPointerException 방지
        int index = -1;
        while(iterater.hasNext()){
            employee = iterater.next();
            index++;
            if(employee.key.equals(key)){
                break;
            }
        }

        if(employee == null){
            return null;
        } else {
            hashTable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    public void printHashtable(){
        for(int i=0; i < hashTable.length; i++){
            if(hashTable[i].isEmpty()){
                System.out.println("Position " + i + " : empty");
            } else {
                System.out.print("Position " + i + " : ");
                ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
                while(iterator.hasNext()){
                    System.out.print(iterator.next().employee);
                    System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
    }
}
