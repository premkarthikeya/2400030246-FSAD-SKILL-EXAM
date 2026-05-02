package com.bank;

public class Account {

    private String accountNo;
    private String branch;
    private double balance;

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account[accountNo=" + accountNo +
               ", branch=" + branch +
               ", balance=" + balance + "]";
    }
}