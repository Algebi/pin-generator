package org.quantbet.pingenerator.service.rulesengine.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRulesEngineTest {

    @Mock
    private CustomerRule mCustomerRuleValid;
    @Mock
    private CustomerRule mCustomerRuleInValid;

    @Mock
    private RuleContext mRuleContext;

    @Test
    public void validateCustomerRules_withValidRules_returnValid() {
        when(mCustomerRuleValid.isValid(mRuleContext)).thenReturn(true);

        assertThat(
                new CustomerRulesEngine(Collections.singletonList(mCustomerRuleValid))
                        .validate(mRuleContext))
                .isTrue();
    }

    @Test
    public void validateCustomerRules_withOneInValidRules_returnInValid() {
        when(mCustomerRuleInValid.isValid(mRuleContext)).thenReturn(false);

        assertThat(
                new CustomerRulesEngine(Collections.singletonList(mCustomerRuleInValid))
                        .validate(mRuleContext))
                .isFalse();
    }

    @Test
    public void validateCustomerRules_withOneOrManyInValidRules_returnInValid() {
        when(mCustomerRuleValid.isValid(mRuleContext)).thenReturn(true);
        when(mCustomerRuleInValid.isValid(mRuleContext)).thenReturn(false);

        assertThat(
                new CustomerRulesEngine(Arrays.asList(mCustomerRuleValid, mCustomerRuleInValid))
                        .validate(mRuleContext))
                .isFalse();
    }

}