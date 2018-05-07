package org.quantbet.pingenerator.service.randomgenerator;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.quantbet.pingenerator.service.exception.PinNotGeneratedException;
import org.quantbet.pingenerator.service.rulesengine.format.FormatRulesEngine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PinGeneratorTest {

    @Mock
    private FormatRulesEngine rulesEngine;

    @Mock
    private PinUtils pinUtils;

    private PinGenerator generator;

    @Before
    public void setUp() {
        generator = new PinGenerator(rulesEngine, pinUtils);
    }

    @Test
    public void generatePinWithValidRules_returnExpectedPin() {
        String expectedPin = "1369";
        when(pinUtils.random()).thenReturn(expectedPin);
        when(rulesEngine.validate(expectedPin)).thenReturn(true);

        assertThat(generator.createOne()).isEqualTo(expectedPin);
    }

    @Test
    public void generatePinWithInValidRules_pinNotGeneratedExpection() {
        String expectedPin = "1369";
        when(pinUtils.random()).thenReturn(expectedPin);
        when(rulesEngine.validate(expectedPin)).thenReturn(false);

        assertThatThrownBy(() -> generator.createOne())
                .isInstanceOf(PinNotGeneratedException.class);


    }
}