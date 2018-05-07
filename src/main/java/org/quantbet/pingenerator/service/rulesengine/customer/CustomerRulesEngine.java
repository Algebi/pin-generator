package org.quantbet.pingenerator.service.rulesengine.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRulesEngine {

    private final List<CustomerRule> rules;

    @Autowired
    public CustomerRulesEngine(List<CustomerRule> rules) {
        this.rules = rules;
    }

    public boolean validate(RuleContext context) {

        return rules.stream()
                .allMatch(rule -> rule.isValid(context));
    }
}