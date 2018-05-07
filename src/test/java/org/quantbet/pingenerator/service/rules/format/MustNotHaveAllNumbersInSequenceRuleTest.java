package org.quantbet.pingenerator.service.rules.format;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MustNotHaveAllNumbersInSequenceRuleTest {

    private MustNotHaveAllNumbersInSequenceRule rule;

    @Before
    public void setUp() {
        rule = new MustNotHaveAllNumbersInSequenceRule();

    }

    @Test
    public void allNumbersInSecuence_Invalid() {

        assertThat(rule.isValid("1234")).isFalse();
    }

    @Test
    public void allNumbersInReverseSecuence_Invalid() {

        assertThat(rule.isValid("4321")).isFalse();
    }


    @Test
    public void threeNumbersInSecuence_valid() {

        assertThat(rule.isValid("1456")).isTrue();
    }

    @Test
    public void twoNumbersInSecuence_valid() {

        assertThat(rule.isValid("1356")).isTrue();
    }
}