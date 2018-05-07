package org.quantbet.pingenerator.service.randomgenerator;


import org.quantbet.pingenerator.service.exception.PinNotGeneratedException;
import org.quantbet.pingenerator.service.rulesengine.format.FormatRulesEngine;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PinGenerator {

    private static final int MAX_ATTEMPS = 1000;

    private final FormatRulesEngine rules;
    private final PinUtils pinUtils;

    public PinGenerator(FormatRulesEngine rules, PinUtils pinUtils) {
        this.rules = rules;
        this.pinUtils = pinUtils;
    }

    public String createOne() {
        String pin;
        int attempts = 0;

        do {

            pin = Optional.of(pinUtils.random())
                    .filter(rules::validate)
                    .orElse(null);

            attempts++;

        } while (pin == null && attempts <= MAX_ATTEMPS);

        if (pin == null) {
            throw new PinNotGeneratedException();
        }

        return pin;
    }
}