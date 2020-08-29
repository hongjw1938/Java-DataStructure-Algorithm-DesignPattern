package com.design_pattern.behavioral.command;
import java.utils.*;
class BankAccount
{
    private int balance;
    private int overdraftLimit = -500;
    
    public void deposit(int amount){
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
    }
    
    // 성공 여부를 알기 위해 boolean을 반환한다.
    public boolean withdraw(int amount){
        if(balance - amount >= overdraftLimit){
            balance -= amount;
            System.out.println("Withdrew " + amount + ", balance is now " + balance);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "BankAccount{" +
          "balance=" + balance +
          '}';
    }
}

interface Commands{
    void call();
    void undo();
}

class BankAccountCommand implements Commands{
    private BankAccount account;
    
    // 이전이 성공했는지를 파악할 필요가 있다!
    private boolean succeeded;
    
    @Override
    public void call(){
        switch (action){
            case DEPOSIT:
                account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }
    
    @Override
    public void undo(){
        
        // 이부분에 의해 모두 정상적으로 동작하게 된다.
        if(!succeeded) return;
        switch(action){
            case DEPOSIT:
                succeeded = true;
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }
    
    public enum Action{
        DEPOSIT, WITHDRAW;
    }
    
    private Action action;
    private int amount;
    
    public BankAccountCommand(BankAccount account, Action action, int amount){
        this.account = account;
        this.action = action;
        this.amount = amount;
    }
}


class UndoOperation{
    public static void main(String[] args){
        BankAccount ba = new BankAccount();
        System.out.println(ba);
        
        // 인출을 시도하는데 내역이 100 밖에 없어 1000을 꺼낼 수 없다.
        List<BankAccountCommand> commands = List.of(
            new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
            new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        );
        
        // 이에 따라 call을 하더라도 내역이 100이 그대로인 것을 확인할 수 있다
        for(BankAccountCommand c : commands){
            c.call();
            System.out.println(ba);
        }
        
        // 이전에 수행한 작업을 모두 취소
        /*
            undo method를 확인해보면 같은 enum일 때 반대의 행위를 하는 것을 알 수 있다.
            이는 어쩌면 좋은 방법처럼 보이지만, 아래를 시도해보는 순간 알 수 있다.
            1000을 이전에 꺼내지도 않았는데 1000을 넣어서 1100이 되어버린다.
            
            즉, 이전의 method가 성공했는지 여부를 알지 못한다는 문제가 있다.
            그래서 boolean 객체를 통해 성공 여부를 판단할 필요가 있다.
        */
        Collections.reverse(commands);
        for(Commands c : commands){
            c.undo();
            System.out.println(ba);
        }
    }
}