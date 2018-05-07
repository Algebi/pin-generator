package org.quantbet.pingenerator.service.rules.customer;

import org.junit.Before;
import org.junit.Test;
import org.quantbet.pingenerator.model.Customer;
import org.quantbet.pingenerator.model.PersonalDetails;
import org.quantbet.pingenerator.service.rulesengine.customer.RuleContext;

import java.time.LocalDate;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MustNotContainCustomerDateOfBirthTest {

    private MustNotContainCustomerDateOfBirth rule;

    @Before
    public void setUp() {
        rule = new MustNotContainCustomerDateOfBirth();
    }

    @Test
    public void pinNumberNotContainsDateOfBirthValues_valid() {
        RuleContext context = new RuleContext(
                new Customer(new PersonalDetails("name surname", LocalDate.of(1980, 01, 01))
                        , null, null),
                "1199"
        );

        assertThat(rule.isValid(context)).isTrue();
    }

    @Test
    public void pinNumberContainsYearOfBirth_valid() {
        RuleContext context = new RuleContext(
                new Customer(new PersonalDetails("name surname", LocalDate.of(1980, 01, 01))
                        , null, null),
                "1980"
        );

        assertThat(rule.isValid(context)).isFalse();
    }

    @Test
    public void pinNumberContainsDayAndMonthOfBirth_valid() {
        RuleContext context = new RuleContext(
                new Customer(new PersonalDetails("name surname", LocalDate.of(1980, 01, 01))
                        , null, null),
                "0101"
        );

        assertThat(rule.isValid(context)).isFalse();
    }
}