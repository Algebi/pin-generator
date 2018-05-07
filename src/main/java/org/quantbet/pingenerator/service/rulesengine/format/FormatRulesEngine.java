package org.quantbet.pingenerator.service.rulesengine.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormatRulesEngine {

    private final List<FormatRule> rules;

    @Autowired
    public FormatRulesEngine(List<FormatRule> rules) {
        this.rules = rules;
    }

    public boolean validate(String pinNumber) {

        return rules.stream()
                .allMatch(rule -> rule.isValid(pinNumber));
    }
}