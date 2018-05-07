package org.quantbet.pingenerator.model;

public class BankAccount {

    private final String sortCode;
    private final String accountNumber;

    public BankAccount(String sortCode, String accountNumber) {
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;

    }

    public String getSortCode() {
        return sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
