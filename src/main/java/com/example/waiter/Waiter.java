package com.example.waiter;


import java.util.concurrent.ExecutionException;


public class Waiter {

    public void waitFor(SupplierObject condition, long maxTimeSeconds, long pooligTimeSeconds)
            throws Exception {
        long start = System.currentTimeMillis();
        for (long i = 0; i < maxTimeSeconds; i++) {
            Thread.sleep(pooligTimeSeconds * 1000);
            System.out.println((System.currentTimeMillis() - start) / 1000 + ", " + i);
            if (condition.getItem().get().equals(true)) {
                System.out.println("cond in waiter ,method: " + condition);
                Main.testVal = true;
                System.out.println("testVal  in waiter method: " + Main.testVal);
                return;
            }
        }
        throw new Exception("waiter Time Out!");
    }
}








/*

public void waitFor(SupplierObject condition, long max_time, long poolingTimeSeconds) throws NullPointerException {
        long start = System.currentTimeMillis();
        System.out.println("start waiting for cond ");
        long i = 1;
        while (System.currentTimeMillis() - start <= max_time * 1000L) {
                if ((1000L + System.currentTimeMillis() - start <= i * poolingTimeSeconds * 1000L)) {
                    //System.out.println(i + ", ");
                    if (condition.getItem().get().equals(true)) {
                        System.out.println("cond in waiter ,method: " + condition);
                        break;
                    }

                }
                else
                    i++;
            }
            if (!condition.getItem().get()) {
                throw new NullPointerException("waitFor Time Out!");
            }
        long end = System.currentTimeMillis();
        System.out.println("End of waiting, time: " + ": " + (end - start) / 1000L);
    }
 */