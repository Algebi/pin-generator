package org.quantbet.pingenerator.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.quantbet.pingenerator.model.Customer;
import org.quantbet.pingenerator.service.exception.PinNotGeneratedException;
import org.quantbet.pingenerator.service.randomgenerator.PinGenerator;
import org.quantbet.pingenerator.service.rulesengine.customer.CustomerRulesEngine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DefaultPinGeneratorServiceTest {

    private static final String PIN_NUMBER = "1443";

    private DefaultPinGeneratorService service;
    @Mock
    private CustomerRulesEngine customerRulesEngine;
    @Mock
    private PinGenerator pinGenerator;
    @Mock
    private Customer customer;

    @Before
    public void setUp() {
        service = new DefaultPinGeneratorService(customerRulesEngine, pinGenerator);
    }

    @Test
    public void getSecretPinForRandomCustomerWithValidRules_returnValidPin() {

        when(customerRulesEngine.validate(any())).thenReturn(true);
        when(pinGenerator.createOne()).thenReturn(PIN_NUMBER);

        assertThat(service.secretPinFor(customer)).isEqualTo(PIN_NUMBER);
    }

    @Test
    public void getSecretPinForRandomCustomerWithMoreThan100Attempts_throwException() {

        when(customerRulesEngine.validate(any())).thenReturn(false);
        when(pinGenerator.createOne()).thenReturn(PIN_NUMBER);

        assertThatThrownBy(() -> service.secretPinFor(customer))
                .isInstanceOf(PinNotGeneratedException.class);
    }
}