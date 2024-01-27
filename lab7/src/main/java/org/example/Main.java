package org.example;


public class Main {
    public static void main(String[] args) {

        String[] Users = {"Tom", "Jerry", "Bulldog"};
        for (int i = 0;i<Users.length;i++){
            MyThread th = new MyThread(Users[i], 100);
            th.start();
        }

    }
}