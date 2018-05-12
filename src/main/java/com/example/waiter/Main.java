package com.example.waiter;


public class Main{
    public static boolean testVal = false;

    public static void main(String[] args) throws Exception {
        SupplierObject condition = new SupplierObject(false);
        Waiter waiter = new Waiter();
        ConditionDelayer delayer = new ConditionDelayer();
        //System.out.println(condition.get());

        new Thread(() -> delayer.cond_changer(condition, 3L)).start();
        waiter.waitFor(condition, 3L, 1L);
        System.out.println(condition.getItem().get());


    }
}
