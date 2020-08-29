package com.design_pattern.creational.singleton;

class InnerStaticSingleton{
    private InnerStaticSingleton(){}

    // Inner Class를 이용하여 Singleton type을 만들어내는 방법
    // 이 방법은 Synchronization 문제를 피할 수 있다.
    // 이 방법으로 손 쉽게 thread safe를 이루어낼 수 있게 되었다.
    private static class Impl{
        private static final InnerStaticSingleton INSTANCE
                = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance(){
        return Impl.INSTANCE;
    }
}

public class InnerStaticSingletonExample {
}
