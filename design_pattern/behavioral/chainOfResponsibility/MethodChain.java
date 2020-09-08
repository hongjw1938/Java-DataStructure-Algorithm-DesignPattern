package behavioral.chainOfResponsibility;
class Creature{
    public String name;
    public int attack, defense;
    
    public Creature(String name, int attack, int defense){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }
    
    @Override
    public String toString(){
        return "Creature{"+ 
        "name = '" + name + '\'' +
        ", attack=" +attack +
        ", defense=" +defense + 
        '}';
    }
}

/*
  Creature는 이름, attack / defense value를 갖는 객체임
  
  게임에서 Creature Object가 주변을 찾아다니며 마법 object를 찾아 attack / defense 능력을 증가시키려 한다고 하자.
  예를 들어 마법의 검을 통해 attack 기회는 2번인데 저주를 받아 attack value는 낮아진다고 해보자.
  
  여기서 질문은 modification을 어떻게 설정하여 계산을 수행할 것인지 이다.
*/

class CreatureModifier{
    protected Creature creature;
    protected CreatureModifier next;
    
    public CreatureModifier(Creature creature){
        this.creature = creature;
    }
    
    public void add(CreatureModifier cm){
        if (next != null){
            // next가 null이 아니라면 이미 chain을 갖고 있어서 특정 modifier를 갖고 있다는 의미
            next.add(cm);
        } else {
            next = cm;
        }
    }
    
    public void handle(){
        if(next != null) next.handle();
    }
}

class DoubleArrackModifier extends CreatureModifier{
    public DoubleArrackModifier(Creature creature){
        super(creature);
    }    
    @Override
    public void handle(){
        System.out.println("Doubling " + creature.name + "'s attack");
        creature.attack *= 2;
        super.handle();
    }
}

class IncreaseDefenseModifier extends CreatureModifier{
    public IncreaseDefenseModifier(Creature creature){
        super(creature);
    }
    
    @Override
    public void handle(){
        System.out.println("Increasing " + creature.name + "'s defense");
        creature.defense += 3;
        super.handle();
    }
    
}

class MethodChain{
    public static void main(String[] args){
        
        /*
            Goblin Creature가 root를 발견하여 attack과 defense를 상승시킨다.
            이러한 method chaining을 통하여 객체의 modifying이 가능하다.
        */
        Creature goblin = new Creature("Goblin", 2, 2);
        System.out.println(goblin);
        
        CreatureModifier root = new CreatureModifier(goblin);
        
        // 이 코드에 의해 아래의 modifier가 동작하지 않게 된다.
        // 왜냐하면 NoBonusesModifier는 super.handle()을 부르지 않아서 chain을 끊어버리기 때문
        root.add(new NoBonusesModifier(goblin));
        
        System.out.println("Let's double goblin's attack...");
        root.add(new DoubleArrackModifier(goblin));
        
        System.out.println("Let's increase goblin's defense");
        root.add(new IncreaseDefenseModifier(goblin));
        
        root.handle();
        System.out.println(goblin);
        
        /*
            그러면 이 때, chaining을 중간에 disrupt 시켜서 cancel 시킬 수 있는가이다.
            고블린이 숲을 걷다가 마녀와 마주쳐 저주를 받아 어떤 modifier를 갖지 못하게 된다고 보자.
            그러한 행위를 위한 class는 아래에 구현하였다.
        */
    }
}

class NoBonusesModifier extends CreatureModifier{
    public NoBonusesModifier(Creature creature){
        super(creature);
    }
    
    @Override
    public void handle(){
        System.out.println("No bonuses for you!");
        
    }
}