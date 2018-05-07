package org.quantbet.pingenerator.service.rules.format;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MaxTwoConsecutiveRuleTest {

    private MaxTwoConsecutiveRule rule;

    @Before
    public void setUp() {
        rule = new MaxTwoConsecutiveRule();
    }

    @Test
    public void twoConsecutives_validFormat() {

        assertThat(rule.isValid("1121")).isTrue();

    }

    @Test
    public void threeConsecutives_invalidFormat() {

        assertThat(rule.isValid("1112")).isFalse();

    }

    @Test
    public void fourConsecutives_invalidFormat() {

        assertThat(rule.isValid("1111")).isFalse();

    }
}