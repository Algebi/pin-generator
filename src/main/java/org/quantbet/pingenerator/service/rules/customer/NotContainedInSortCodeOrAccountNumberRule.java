package org.quantbet.pingenerator.service.rules.customer;

import org.quantbet.pingenerator.service.rulesengine.customer.CustomerRule;
import org.quantbet.pingenerator.service.rulesengine.customer.RuleContext;
import org.springframework.stereotype.Component;

@Component
public class NotContainedInSortCodeOrAccountNumberRule implements CustomerRule {

    @Override
    public boolean isValid(RuleContext context) {

        if (context.getCustomer().getAccount() == null)
            return false;

        String pin = context.getPinNumber();

        String sortCode = context.getCustomer().getAccount().getSortCode().replace("-", "");
        String accountNumber = context.getCustomer().getAccount().getAccountNumber();

        return !(sortCode.contains(pin)
                || accountNumber.contains(pin));
    }
}
