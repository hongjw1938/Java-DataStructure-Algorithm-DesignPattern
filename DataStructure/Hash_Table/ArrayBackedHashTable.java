package com.datastructure.hashtable;

public class ArrayBackedHashTable {

    private StoredEmployee[] hashTable;

    public ArrayBackedHashTable(){
        hashTable = new StoredEmployee[10];
    }

    // Employee의 last name을 넘겨서 hashing할 것
    private int hashKey(String key){
        return key.length() % hashTable.length;
    }

    // 이미 Employee 배열에 해당 value가 null이 아닌 상태인지 확인
    private boolean occupied(int index){
        return hashTable[index] != null;
    }

    // table에 value 넣는 method
    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        // 이미 차지되었다면
        if(occupied(hashedKey)){
            // Linear Probing 하는 코드
            int stopIndex = hashedKey;
            if(hashedKey == hashTable.length - 1){
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            // 만약 ++한 곳도 이미 value가 있고 기존의 hash 값과 같지 않은 경우라면,
            // 1을 한 번 더 더하고 length를 나눔. 왜 나누냐면 length 이상으로 가면 값을 넣을 수 없으니까
            while(occupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        // 위에서 Linear probing을 했지만 그래도 안된다면 array가 full한 상태
        if(occupied(hashedKey)){
            System.out.println("Sorry, you can't put any more value into that index" + hashedKey);
        } else {
            hashTable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    // key를 바탕으로 해당 key와 일치하는 key를 찾아야함.
    private int findKey(String key){
        int hashedKey = hashKey(key);
        // key를 hashing 시에 null이 아니고, hasing한 key로 저장한 table의 key가 찾는 key와 일치 시
        if(hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        // 일치하지 않는 다면 아래의 반복을 수행하여 Linear Probing
        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while (hashedKey != stopIndex
                && hashTable[hashedKey] != null
                    && !hashTable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if(hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        } else {
            return -1;
        }
    }

    public Employee get(String key){

        // directly access 하여 값을 반환함. 그래서 매우 효율적.
        int hashedKey = findKey(key);

        // 만약 해당 key에 따른 값이 없다면면
       if(hashedKey == -1){
            return null;
        }
        return hashTable[hashedKey].employee;
    }

    // key에 해당하는 value 배열에서 제거
    public Employee remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }

        Employee employee = hashTable[hashedKey].employee;

        hashTable[hashedKey] = null;

        StoredEmployee[] oldHashtable = hashTable;
        hashTable = new StoredEmployee[oldHashtable.length];
        // 실질적인 rehashing을 수행하는 table
        for(int i=0; i < oldHashtable.length; i++){
            if(oldHashtable[i] != null){
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }
        return employee;
    }

    public void printHashtable(){
        for(int i=0; i < hashTable.length; i++){
            if(hashTable[i] == null){
                System.out.println("Empty");
            } else {
                System.out.println("Position : " + i + ", " + hashTable[i].employee);
            }
        }
    }
}
