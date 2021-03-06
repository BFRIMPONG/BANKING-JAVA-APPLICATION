package com.frimpong.classes;

import com.frimpong.interfaces.IBranch;

import java.util.ArrayList;

public class Branch implements IBranch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchName){
        this.name = branchName;
        this.customers = new ArrayList<Customer>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    @Override
    public boolean newCustomer(String customerName, double initialTransaction) {

        if(findCustomer(customerName) == null){
            customers.add(new Customer(customerName, initialTransaction));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomerTransaction(String customerName, double transaction) {

        Customer checkedCustomer = findCustomer(customerName);
        if((checkedCustomer != null) && transaction > 0){
            findCustomer(customerName).addTransaction(transaction);
            return true;
        }
        return false;
    }


    private Customer findCustomer(String customerName) {

        for(Customer customer: customers){
            if(customer.getName().equals(customerName)){
                return customer;
            }
        }
        return null;
    }
}
