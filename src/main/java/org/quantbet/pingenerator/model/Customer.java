package org.quantbet.pingenerator.model;

import java.util.List;

public class Customer {

    private final PersonalDetails details;
    private final BankAccount account;
    private final List<PinDetails> pinHistory;


    public Customer(PersonalDetails details, BankAccount account, List<PinDetails> pinHistory) {
        this.details = details;
        this.account = account;
        this.pinHistory = pinHistory;
    }

    public PersonalDetails getDetails() {
        return details;
    }

    public BankAccount getAccount() {
        return account;
    }

    public List<PinDetails> getPinHistory() {
        return pinHistory;
    }
}
