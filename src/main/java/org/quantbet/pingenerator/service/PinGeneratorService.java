package org.quantbet.pingenerator.service;

import org.quantbet.pingenerator.model.Customer;

public interface PinGeneratorService {

    String secretPinFor(Customer customer);

}