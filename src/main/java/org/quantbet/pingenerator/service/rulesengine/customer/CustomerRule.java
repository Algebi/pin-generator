package org.quantbet.pingenerator.service.rulesengine.customer;

public interface CustomerRule {


    /**
     * The rule implementation
     *
     * @param context the {@link RuleContext} in which this rule will be run
     */
    boolean isValid(RuleContext context);
}

