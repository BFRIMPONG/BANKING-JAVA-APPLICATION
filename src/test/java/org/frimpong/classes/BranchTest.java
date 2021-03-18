package org.frimpong.classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTest {
    Branch branch;


    @Before
    public void setUp() throws Exception {
        // Creating a new branch
        Branch branch = new Branch("seven");
        branch.newCustomer("John",152.35);
    }

    @Test
    public void getName() {
        assertEquals("seven",branch.getName());
    }

    @Test
    public void getCustomers() {
        assertEquals("John",branch.getCustomers().get(0));
    }

    @Test
    public void newCustomer() {
    }

    @Test
    public void addCustomerTransaction() {
    }
}