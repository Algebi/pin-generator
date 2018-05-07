package org.quantbet.pingenerator.model;

import java.time.LocalDate;

public class PinDetails {

    private final String pin;
    private final LocalDate validUntil;

    public PinDetails(String pin, LocalDate validUntil) {
        this.pin = pin;
        this.validUntil = validUntil;
    }

    public String getPin() {
        return pin;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

}
