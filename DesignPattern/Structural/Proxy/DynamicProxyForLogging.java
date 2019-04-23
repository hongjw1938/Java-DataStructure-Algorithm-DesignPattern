package com.designPattern.structural.proxy;

/*
Dynamic Proxy의 기본 개념은 Proxy가 compile time이 아닌 runtime에 생성된다는 것이다.
즉, runtume에 object의 wrapper를 만들어서 사용함.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface  Human{
    void walk();
    void talk();
}

/*
  아래와 같이 Human interface를 구현한 Person Class가 있을 때,
  Dynamic Proxy를 사용해 내부 Object를 take하고 method의 개수를 count하고자 한다.
 */
class Person implements Human{
    @Override
    public void walk() {
        System.out.println("I am walking");
    }

    @Override
    public void talk() {
        System.out.println("I am talking");
    }
}

class LoggingHandler implements InvocationHandler{
    // 우선 Object의 reference를 갖는 Object 저장 - Numbering을 위해
    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }
    
    // 아래 Method에 의해 모든 method call시 intercept되어 갯수를 세어보게 된다.

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if(name.contains("toString")){
            return calls.toString();
        }

        calls.merge(name, 1, Integer::sum);
        return method.invoke(target, args);
    }
}

public class DynamicProxyForLogging {

    @SuppressWarnings("unchecked")
    public static <T> T withLogging(T target, Class<T> itf){
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[] {itf},
                new LoggingHandler(target)
        );
    }

    public static void main(String[] args){
        Person person = new Person();
        Human logged = withLogging(person, Human.class);
        logged.talk();
        logged.walk();
        logged.walk();

        System.out.println(logged);
    }
}
