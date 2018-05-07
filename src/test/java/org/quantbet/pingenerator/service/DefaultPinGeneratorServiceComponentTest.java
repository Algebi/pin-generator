package org.quantbet.pingenerator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quantbet.pingenerator.model.BankAccount;
import org.quantbet.pingenerator.model.Customer;
import org.quantbet.pingenerator.model.PinDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultPinGeneratorServiceComponentTest {

    @Autowired
    private PinGeneratorService service;


    @Test
    public void generateMultipleValidPins() {

        Customer customer = new Customer(
                null,
                new BankAccount("71-14-13", "13561342"),
                null
        );

        System.out.println("Pin generated for the given Customer");
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
    }

    @Test
    public void generateMultipleValidPins_ForCustomerWithHistory() {

        Customer customer = new Customer(
                null,
                new BankAccount("11-34-43", "13566342"),
                Arrays.asList(
                        new PinDetails("1122", LocalDate.now()),
                        new PinDetails("2679", LocalDate.now().minus(1, ChronoUnit.DAYS)),
                        new PinDetails("2679", LocalDate.now().minus(2, ChronoUnit.DAYS)),
                        new PinDetails("9432", LocalDate.now().minus(3, ChronoUnit.DAYS))
                )
        );

        System.out.println("Pin generated for the given Customer with pin history");
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
        System.out.println(service.secretPinFor(customer));
    }

}