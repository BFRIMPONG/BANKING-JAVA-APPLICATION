package com.frimpong.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer;

    @Before
    public void setUp() throws Exception {
        //       creating a new customer
        customer = new Customer("Daniel",250.06);
    }

    @Test
    public void getName() {
        //       test result should return Daniel because he is a customer of the bank
        assertEquals("Daniel", customer.getName());
    }

    @Test
    public void getTransactions() {
        //       test to check if the Daniel initial deposit is the same as expected value
        assertEquals(250.06,(double) customer.getTransactions().get(0), 0.00);
    }

    @Test
    public void addTransaction() {
        // Add a transaction
        customer.addTransaction(200);

        //   test to check if the new transaction has been added to the old one
        assertEquals(2, customer.getTransactions().size());
    }
}