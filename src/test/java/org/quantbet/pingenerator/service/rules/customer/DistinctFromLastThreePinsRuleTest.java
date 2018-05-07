package org.quantbet.pingenerator.service.rules.customer;

import org.junit.Before;
import org.junit.Test;
import org.quantbet.pingenerator.model.Customer;
import org.quantbet.pingenerator.model.PinDetails;
import org.quantbet.pingenerator.service.rulesengine.customer.RuleContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class DistinctFromLastThreePinsRuleTest {

    private DistinctFromLastThreePinsRule rule;

    @Before
    public void setUp() {
        rule = new DistinctFromLastThreePinsRule();
    }

    @Test
    public void nonEqualPinsOnHistory_validRule() {
        RuleContext context = new RuleContext(
                new Customer(null, null,
                        Arrays.asList(
                                new PinDetails("1122", LocalDate.now()),
                                new PinDetails("2679", LocalDate.now().minus(1, ChronoUnit.DAYS)),
                                new PinDetails("9432", LocalDate.now().minus(2, ChronoUnit.DAYS))
                        )),
                "9641"

        );

        assertThat(rule.isValid(context)).isTrue();
    }

    @Test
    public void pinAlreadyUsedLast3Times_invalidRule() {
        RuleContext context = new RuleContext(
                new Customer(null, null,
                        Arrays.asList(
                                new PinDetails("1122", LocalDate.now()),
                                new PinDetails("2679", LocalDate.now().minus(1, ChronoUnit.DAYS)),
                                new PinDetails("9432", LocalDate.now().minus(2, ChronoUnit.DAYS))
                        )),
                "2679"

        );

        assertThat(rule.isValid(context)).isFalse();
    }

    @Test
    public void pinFoundAfterThirdChange_validRule() {
        RuleContext context = new RuleContext(
                new Customer(null, null,
                        Arrays.asList(
                                new PinDetails("1122", LocalDate.now()),
                                new PinDetails("2679", LocalDate.now().minus(1, ChronoUnit.DAYS)),
                                new PinDetails("2679", LocalDate.now().minus(2, ChronoUnit.DAYS)),
                                new PinDetails("9432", LocalDate.now().minus(3, ChronoUnit.DAYS))
                        )),
                "9432"

        );

        assertThat(rule.isValid(context)).isTrue();
    }
}