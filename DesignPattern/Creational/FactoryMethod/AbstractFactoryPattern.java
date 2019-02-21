package com.designPattern.creational.factory;

import com.sun.management.HotSpotDiagnosticMXBean;
import javafx.util.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.*;

interface  HotDrink{
    void consume();
}

class Tea implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This tea is delicous");
    }
}

class Coffee implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This coffee is delicous");
    }
}

interface  HotDrinkFactory{
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println(
                "Put in tea bag, boil water, pour " +
                        amount + "ml, add lemon, enjoy!"
        );
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println(
        "Grind some beans, boil water, pour" +
                amount + "ml, add cream and sugar, enjoy!"
        );
        return new Coffee();
    }
}

class HotDrinkMachine{
    private List<Pair<String, HotDrinkFactory>> namedFactories
            = new ArrayList<>();

    public HotDrinkMachine(){
        Set<Class<? extends HotDrinkFactory>> types =
                new Reflections("").getSubTypesOf(HotDrinkFactory.class);

        for (Class<? extends  HotDrinkFactory> type : types){
            namedFactories.add(new Pair<>(
                    type.getSimpleName().replace("Factory", ""),
                    type.getDeclaredConstructors().newInstance()
            ));
        }
    }

    public HotDrink makeDrink() throws Exception{
        System.out.println("Available drinks");
        for(int index = 0; index < namedFactories.size(); ++index){
            Pair<String, HotDrinkFactory> item = namedFactories.get(index);
            System.out.println("" + index + ": " + item.getKey());
        }
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s;
            int i, amount;
            if((s = reader.readLine()) != null
                && (i = Integer.parseInt(s)) >= 0
                && i < namedFactories.size()){
                System.out.println("Specify amount;");
                s = reader.readLine();
                if(s != null && (amount = Integer.parseInt(s)) > 0){
                    return namedFactories.get(i).getValue().prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again.");
        }
    }
}
public class AbstractFactoryPattern {
    public static void main(String[] args) throws Exception{
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeDrink();
        drink.consume();
    }
}
