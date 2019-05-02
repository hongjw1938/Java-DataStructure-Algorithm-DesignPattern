/*
  이전 예시인 Method Chain의 제한은 모든 modifier를 명시적으로 적용해야 한다는 것이다.
  
  여기선 조금 다른 combination demo를 다룬다.
  cor + observer + mediator + (-)memento
  
  
*/

import java.util.*;

// Observer Pattern, CQS
class Event<Args>
{
    private int index = 0;
    private Map<Integer, Consumer<Args>>   
      handlers = new HashMap<>();
      
    public int subscribe(Consumer<Args> handler){
        int i = index;
        handlers.put(index++, handler);
        return i;
    }
    
    public void unsubscribe(int key){
        handlers.remove(key);
        
    }
    
    public void fire(Args args){
        for (Consumer<Args) handler : handlers.values()){
            handler.accept(args);
        }
    }
}

class Query{
    public String creatureName;
    enum Argument{
        ATTACK, DEFENSE
    }
    
    public Argument argument;
    public int result;
    
    public Query(String creatureName, Argument argument, int result){
        this.creatureName = creatureName;
        this.argument = argument;
        this.result = result;
    }
}

class Game{
    public Event<Query> queries = new Event<>();   
}

class Creature{
    private Game game;
    public String name;
    public int baseAttack, baseDefense;
    
    public Creature(Game game, String name, int baseAttack, int baseDefense){
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }
    
    int getAttack(){
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.result;
    }
    int getDefense(){
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.result;
    }
    
    @Override
    public String toString(){
        return "Creature {" +
        "name='" + name +'\'' +
        ", attack=" + getAttack() +
        ", defense=" + getDefense()+
        '}';
    }
}

class CreatureModifier{
    protected Game game;
    protected Creature creature;
    
    public CreatureModifier(Game game, Creature creature){
        this.game = game;
        this.creature = creature;
    }
}

class IncreaseDefenseModifier extends CreatureModifier{
    public IncreaseDefenseModifier(Game game, Creature creature){
        super(game, creature);
        token = game.queries.subscribe(q -> {
            if(q.creatureName.equals(creature.name)
                && q.argument == Query.Argument.DEFENSE)
            {
                q.result += 3;
            }
        });
    }
}


class DoubleArrackModifier extends CreatureModifier implements AutoCloseable{
    public DoubleArrackModifier(Game game, Creature creature){
        super(game, creature);
        
        token = game.queries.subscribe(q -> {
            if(q.creatureName.equals(creature.name)
                && q.argument == Query.Argument.ATTACK)
            {
                q.result *= 2;
            }
        });
    }
    
    @Override
    public void close(){
        game.queries.unsubscribe(token);
    }
}

class BrokerChain{
    public static void main(String[] args){
        Game game = new Game();
        Creature goblin = new Creature(game, "Strong Goblin", 2, 2);
        
        System.out.println(goblin);
        
        IncreaseDefenseModifier icm = new IncreaseDefenseModifier(game, goblin);
        
        DoubleArrackModifier dam = new DoubleArrackModifier(game, goblin);
        try(dam){
            System.out.println(goblin);
        } 
        
        System.out.println(goblin);
    }
}