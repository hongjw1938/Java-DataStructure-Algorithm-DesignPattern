//package behavioral.command;
//
//import java.utils.*;
//class BankAccount
//{
//    private int balance;
//    private int overdraftLimit = -500;
//
//    public void deposit(int amount){
//        balance += amount;
//        System.out.println("Deposited " + amount + ", balance is now " + balance);
//    }
//
//    public void withdraw(int amount){
//        if(balance - amount >= overdraftLimit){
//            balance -= amount;
//            System.out.println("Withdrew " + amount + ", balance is now " + balance);
//        }
//    }
//
//    @Override
//    public String toString(){
//        return "BankAccount{" +
//          "balance=" + balance +
//          '}';
//    }
//}
//
//interface Commands{
//    void call();
//}
//
//class BankAccountCommand implements Commands{
//    private BankAccount account;
//
//    @Override
//    public void call(){
//        switch (action){
//            case DEPOSIT:
//                account.deposit(amount);
//                break;
//            case WITHDRAW:
//                account.withdraw(amount);
//                break;
//        }
//    }
//
//    public enum Action{
//        DEPOSIT, WITHDRAW;
//    }
//
//    private Action action;
//    private int amount;
//}
//
//class Command{
//    public static void main(String[] args){
//        BankAccount ba = new BankAccount();
//        System.out.println(ba);
//
//        // 인출을 시도하는데 내역이 100 밖에 없어 1000을 꺼낼 수 없다.
//        List<BankAccountCommand> commands = List.of(
//            new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
//            new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
//        );
//
//        // 이에 따라 call을 하더라도 내역이 100이 그대로인 것을 확인할 수 있다
//        for(BankAccountCommand c : commands){
//            c.call();
//            System.out.println(ba);
//        }
//    }
//}