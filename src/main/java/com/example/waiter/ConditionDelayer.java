package com.example.waiter;


public class ConditionDelayer {
    public void cond_changer(SupplierObject condition, long time_pause) {
        long start = System.currentTimeMillis();
        System.out.println("start in cond_change");
        while (System.currentTimeMillis() - start <= time_pause * 1000) {
        }

        condition.setItem(true);
        long end = System.currentTimeMillis();
        System.out.println("End in con_change" + ": " + (end - start) / 1000);

    }
}

/*


    }
 */