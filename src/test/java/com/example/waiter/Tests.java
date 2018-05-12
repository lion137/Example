package com.example.waiter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {

    @Test
    public void testConstructors() {
        Waiter waiter = new Waiter();
        ConditionDelayer delayer = new ConditionDelayer();
        assertEquals(waiter.getClass(), Waiter.class);
        assertEquals(delayer.getClass(), ConditionDelayer.class);
    }

    @Test
    public void testWaiterWaitLongerThanDelay() throws Exception, InterruptedException {
        SupplierObject condition = new SupplierObject(false);
        Waiter waiter = new Waiter();
        ConditionDelayer delayer = new ConditionDelayer();
        new Thread(() -> delayer.cond_changer(condition, 2L)).start();
        waiter.waitFor(condition, 3L, 1L);
        assertTrue(Main.testVal);
    }

    @Test(expected = Exception.class)
    public void testWaiterWaitEquallyWithDelay() throws Exception, InterruptedException {
        SupplierObject condition = new SupplierObject(false);
        Waiter waiter = new Waiter();
        ConditionDelayer delayer = new ConditionDelayer();
        new Thread(() -> delayer.cond_changer(condition, 3L)).start();
        waiter.waitFor(condition, 3L, 1L);
    }

    @Test(expected = Exception.class)
    public void testWaiterWaitLessThanDelay() throws Exception, InterruptedException {
        SupplierObject condition = new SupplierObject(false);
        Waiter waiter = new Waiter();
        ConditionDelayer delayer = new ConditionDelayer();
        new Thread(() -> delayer.cond_changer(condition, 3L)).start();
        waiter.waitFor(condition, 2L, 1L);
    }

}
