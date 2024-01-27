package org.example;

public class MyThread extends Thread{
    public String name;
    public int sum;
    MyThread(String name, int sum){
        this.name = name;
        this.sum = sum;
    }
    public static  int balance = 200;
    public Boolean checkBalance(int a){
        return a<=balance;
    }
    public void getMoney(int a){
        balance -= a;
    }
    @Override
    public void run() {
        System.out.println(this.name);
        if (checkBalance(this.sum)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            getMoney(this.sum);
            System.out.println(this.name +" +" +this.sum + "  " + balance);
        }
        else {
            System.out.println("Недостаточно средств");
        }
    }
};
