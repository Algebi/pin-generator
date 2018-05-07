package org.quantbet.pingenerator.service;

import org.quantbet.pingenerator.model.Customer;
import org.quantbet.pingenerator.service.exception.PinNotGeneratedException;
import org.quantbet.pingenerator.service.randomgenerator.PinGenerator;
import org.quantbet.pingenerator.service.rulesengine.customer.CustomerRulesEngine;
import org.quantbet.pingenerator.service.rulesengine.customer.RuleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPinGeneratorService implements PinGeneratorService {

    private static final int MAX_ATTEMPS = 100;

    private final CustomerRulesEngine customerRulesEngine;
    private final PinGenerator pinGenerator;

    @Autowired
    public DefaultPinGeneratorService(CustomerRulesEngine customerRulesEngine, PinGenerator pinGenerator) {
        this.customerRulesEngine = customerRulesEngine;
        this.pinGenerator = pinGenerator;
    }

    @Override
    public String secretPinFor(Customer customer) {

        RuleContext context = new RuleContext(customer);
        int attempts = 0;

        do {
            context.setPinNumber(pinGenerator.createOne());

            if (attempts > MAX_ATTEMPS) {
                throw new PinNotGeneratedException();
            }
            attempts++;

        } while (rulesAreInvalid(context));

        return context.getPinNumber();
    }

    private boolean rulesAreInvalid(RuleContext context) {
        return !customerRulesEngine.validate(context);
    }
}