package org.quantbet.pingenerator.service.rules.customer;

import org.quantbet.pingenerator.service.rulesengine.customer.CustomerRule;
import org.quantbet.pingenerator.service.rulesengine.customer.RuleContext;

import java.time.format.DateTimeFormatter;

public class MustNotContainCustomerDateOfBirth implements CustomerRule {

    @Override
    public boolean isValid(RuleContext context) {

        String year = context.getCustomer()
                .getDetails().getDob().format(DateTimeFormatter.ofPattern("yyyy"));

        String dayMonth = context.getCustomer()
                .getDetails().getDob().format(DateTimeFormatter.ofPattern("ddMM"));

        return !year.contains(context.getPinNumber())
                && !dayMonth.contains(context.getPinNumber());
    }
}