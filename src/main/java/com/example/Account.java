package com.example;

import java.io.Serializable;

/**
 * Created by chenh on 2017/4/15.
 */
public class Account implements Serializable{

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
