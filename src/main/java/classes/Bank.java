package classes;

import interfaces.IBank;

import java.util.ArrayList;

public class Bank implements IBank  {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String branchName){
        this.name = branchName;
        this.branches = new ArrayList<Branch>();
    }

    @Override
    public boolean addBranch(String branchName) {

        if(findBranch(branchName) == null){
            branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    @Override
    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {

        Branch checkedBranch = findBranch(branchName);

        if(checkedBranch != null){
            return findBranch(branchName).newCustomer(customerName, initialTransaction);
        }

        return false;
    }

    @Override
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {

        Branch checkedBranch = findBranch(branchName);
        if(checkedBranch != null){
            return findBranch(branchName).addCustomerTransaction(customerName, transaction);
        }

        return false;
    }

    @Override
    public Branch findBranch(String branchName) {

        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }

        return null;
    }

    @Override
    public boolean listCustomers(String branchName, boolean printTransactions) {

        Branch checkedBranch = findBranch(branchName);
        if (checkedBranch != null) {
            System.out.println("Customer details for branch " + branchName);
            ArrayList<Customer> branchCustomer = checkedBranch.getCustomers();

            for (int i = 0; i < branchCustomer.size(); i++) {
                System.out.println("Customer: " + branchCustomer.get(i).getName() + "["+ (i+1) +"]");

                if (printTransactions) {
                    System.out.println("Transactions ");
                    ArrayList<Double> transactions = branchCustomer.get(i).getTransactions();

                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("["+ (j+1) +"]" + " Amount " + transactions.get(j));
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
