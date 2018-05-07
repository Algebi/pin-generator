package org.quantbet.pingenerator.service.rulesengine.customer;

import org.quantbet.pingenerator.model.Customer;

public class RuleContext {

    private final Customer customer;
    private String pinNumber;


    public RuleContext(Customer customer) {
        this.customer = customer;
    }

    public RuleContext(Customer customer, String pinNumber) {
        this.customer = customer;
        this.pinNumber = pinNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }
}
