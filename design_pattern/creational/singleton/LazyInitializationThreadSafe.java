package com.design_pattern.creational.singleton;

class LazySingleton{
    private static LazySingleton instance;

    private LazySingleton(){
        System.out.println("initializing a lazy singleton");
    }

    // thread safe와 lazy initialization을 동시에 구현한 방식
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    // double-checked locking
    // 꽤 오래된 방식이나 알고는 있어야함
    // 다음과 같이 2번 체크하여 동기화를 시켜서 thread 안전성을 보장함
    public static LazySingleton getInstance2(){
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

public class LazyInitializationThreadSafe {

    /*
    필요 시에 초기화를 하겠다는 것이 Lazy Initialization이다.
     */
}
