package org.quantbet.pingenerator.service.rules.customer;

import org.junit.Before;
import org.junit.Test;
import org.quantbet.pingenerator.model.BankAccount;
import org.quantbet.pingenerator.model.Customer;
import org.quantbet.pingenerator.service.rulesengine.customer.RuleContext;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NotContainedInSortCodeOrAccountNumberRuleTest {

    private NotContainedInSortCodeOrAccountNumberRule rule;

    private BankAccount bankAccount;

    @Before
    public void setUp() {
        rule = new NotContainedInSortCodeOrAccountNumberRule();
        bankAccount = new BankAccount("71-14-13", "13561342");

    }

    @Test
    public void pinNumberNotContainedInBankDetails_valid() {
        RuleContext context = new RuleContext(
                new Customer(null, bankAccount, null),
                "1199"
        );

        assertThat(rule.isValid(context)).isTrue();
    }

    @Test
    public void pinNumberContainedBetweenSortCodeAndAccountNumber_valid() {
        RuleContext context = new RuleContext(
                new Customer(null, bankAccount, null),
                "1313"
        );

        assertThat(rule.isValid(context)).isTrue();
    }

    @Test
    public void pinNumberContainedInSortCode_invalid() {
        RuleContext context = new RuleContext(
                new Customer(null, bankAccount, null),
                "7114"
        );

        assertThat(rule.isValid(context)).isFalse();
    }

    @Test
    public void pinNumberContainedInAccountNumber_invalid() {
        RuleContext context = new RuleContext(
                new Customer(null, bankAccount, null),
                "5613"
        );

        assertThat(rule.isValid(context)).isFalse();
    }

}