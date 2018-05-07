package org.quantbet.pingenerator.service.rules.customer;

import org.quantbet.pingenerator.model.PinDetails;
import org.quantbet.pingenerator.service.rulesengine.customer.CustomerRule;
import org.quantbet.pingenerator.service.rulesengine.customer.RuleContext;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class DistinctFromLastThreePinsRule implements CustomerRule {

    @Override
    public boolean isValid(RuleContext context) {

        List<PinDetails> history = context.getCustomer().getPinHistory();

        if (history == null || history.size() < 3)
            return true;

        Comparator<PinDetails> comparator
                = (Comparator.comparing(PinDetails::getValidUntil));

        return history.stream()
                .sorted(comparator.reversed())
                .limit(3)
                .map(PinDetails::getPin)
                .noneMatch(pin -> pin.equals(context.getPinNumber()));
    }
}