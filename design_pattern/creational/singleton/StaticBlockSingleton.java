package creational.singleton;

import java.io.File;
import java.io.IOException;

class StaticBlockSingletonExample{
    /*
    다음과 같이 생성자가 예외를 발생시킬 수 있는 경우에는 문제가 발생할 수 있다.
    더 이상 private static final을 이용해 value를 지정할 수 없게 된다.
     */
//    private StaticBlockSingletonExample() throws IOException {
//        System.out.println("Singleton is initializing");
//        File.createTempFile(".",".");
//    }

    private static StaticBlockSingletonExample instance;

    /*
    다음과 같이 static block을 사용하여 인스턴스를 생성해야 한다.
    getinstance로 단일 객체가 아닌 object pooling을 구현 시에도 매우 유용하게 사용 가능
    Object pooling이란, 많은 수의 object가 생성되지 않게 방지하고자 pool에 object를 담아두고 사용 및 반납

     */
    static{
        try{
            instance = new StaticBlockSingletonExample();
        } catch(Exception e){
            System.err.println("failed to create singleton");
        }
    }

    public static StaticBlockSingletonExample getInstance(){
        return instance;
    }
}

public class StaticBlockSingleton {
    public static void main(String[] args){
        StaticBlockSingletonExample s = new StaticBlockSingletonExample();
    }
}
