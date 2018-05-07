package org.quantbet.pingenerator.service.rulesengine.format;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FormatRulesEngineTest {


    private static final String PIN_NUMBER = "1468";

    @Mock
    private FormatRule mValidRule;
    @Mock
    private FormatRule mInvalidRule;


    @Test
    public void validateCustomerRules_withValidRules_returnValid() {
        when(mValidRule.isValid(PIN_NUMBER)).thenReturn(true);

        assertThat(
                new FormatRulesEngine(Collections.singletonList(mValidRule))
                        .validate(PIN_NUMBER))
                .isTrue();
    }

    @Test
    public void validateCustomerRules_withOneInValidRules_returnInValid() {
        when(mInvalidRule.isValid(PIN_NUMBER)).thenReturn(false);

        assertThat(
                new FormatRulesEngine(Collections.singletonList(mInvalidRule))
                        .validate(PIN_NUMBER))
                .isFalse();
    }

    @Test
    public void validateCustomerRules_withOneOrManyInValidRules_returnInValid() {
        when(mValidRule.isValid(PIN_NUMBER)).thenReturn(true);
        when(mInvalidRule.isValid(PIN_NUMBER)).thenReturn(false);

        assertThat(
                new FormatRulesEngine(Arrays.asList(mValidRule, mInvalidRule))
                        .validate(PIN_NUMBER))
                .isFalse();
    }

}