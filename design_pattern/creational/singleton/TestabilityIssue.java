package com.design_pattern.creational.singleton;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

interface Database{
    int getPopulation(String name);
}

class SingletonDatabase implements Database{
    private Dictionary<String, Integer> capitals
            = new Hashtable<>();
    private static int instanceCount = 0;
    public static int getCount(){
        return instanceCount;
    }
    private SingletonDatabase(){
        instanceCount++;
        System.out.println("Initializing database");

        try{
            File f = new File(
              SingletonDatabase.class.getProtectionDomain()
              .getCodeSource().getLocation().getPath()
            );

            // 다음과 같은 DB 데이터가 있다고 가정하자.
            Path fullPath = Paths.get(f.getPath(), "capitals.txt");
            List<String> lines = Files.readAllLines(fullPath);

//            Iterables.partition(lines, 2).forEach(kv -> capitals.put(
//                    kv.get(0).trim(),
//                    Integer.parseInt(kv.get(1))
//            ));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static final SingletonDatabase INSTANCE
            = new SingletonDatabase();

    public static SingletonDatabase getInstance(){
        return INSTANCE;
    }

    public int getPopulation(String name){
        return capitals.get(name);
    }
}

class SingletonRecordFinder{

    /*
    다음과 같은 방식은 Database의 concrete class를 생성하여 매우 의존성이 있는 방식으로
    구현되었기 때문에 결코 좋지 않다. 실제로 디자인 패턴 원칙에 따르면,
    DIP 와 같은 원칙에 따라 low module에 의존해선 안된다.
     */
    public int getTotalPopulation(List<String> names){
        int result = 0;
        for(String name : names){
            result += SingletonDatabase.getInstance().getPopulation(name);
        }

        return result;
    }
}

// Test용의 Dummy db를 만든다.
class DummyDatabase implements Database{
    private Dictionary<String, Integer> data
            = new Hashtable<>();

    public DummyDatabase(){
        data.put("alpha",1);
        data.put("beta",2);
        data.put("gamma",3);
    }

    @Override
    public int getPopulation(String name) {
        return 0;
    }
}

/*
실제 Database concrete class가 아닌, dummy database를 이용할 수 있게 되었다.
이를 통해 의존성 주입을 직접 수행

 */
class ConfigurableRecordFinder{
    private Database database;

    public ConfigurableRecordFinder(Database database){
        this.database = database;
    }

    public int getTotalPopulation(List<String> names){
        int result = 0;
        for(String name : names){
            result += database.getPopulation(name);
        }

        return result;
    }
}

public class TestabilityIssue {

//    @org.junit.Test
//    public void singletonTotalPopulationTest(){
//        SingletonRecordFinder rf = new SingletonRecordFinder();
//        List<String> names = List.of("Seoul", "Mexico City");
//        int tp = rf.getTotalPopulation(names);
//        assertEquals(1750000+1740000, tp);
//    }

    /*
    다음과 같이 live database가 아닌 dummy를 이용하여 테스트를 하는 것이 더 적합하다 할 수 있다.
     */
    @Test
    public void dependentPopulationTest(){
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder rf = new ConfigurableRecordFinder(db);
        assertEquals(4, rf.getTotalPopulation(
                Arrays.asList("alpha", "gamma")
        ));
    }

    public static void main(String[] args){

    }
}
