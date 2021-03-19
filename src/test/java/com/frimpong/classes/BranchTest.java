package com.frimpong.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTest {
    Branch branch;


    @Before
    public void setUp() throws Exception {
        // Creating a new branch
        branch = new Branch("seven");
        branch.newCustomer("John",152.35);
    }

    @Test
    public void getName() {
        //     Test should expect seven because it has been created in the setup
        assertEquals("seven",branch.getName());
    }

    @Test
    public void getCustomers() {
        //     Test should expect John because he has been created in the setup
        assertEquals("John",branch.getCustomers().get(0).getName());
    }

    @Test
    public void newCustomer() {
        //
        assertTrue(branch.newCustomer("David",62.23));
        assertFalse(branch.newCustomer("John",25.32));
    }

    @Test
    public void addCustomerTransaction() {
        //   test should return true because John is a customer of the bank
        assertTrue( branch.addCustomerTransaction("John",35.22));

        //   test should return false because David is not a customer of the bank
        assertFalse(branch.addCustomerTransaction("David",23.11));
    }
}