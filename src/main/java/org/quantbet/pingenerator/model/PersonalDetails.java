package org.quantbet.pingenerator.model;

import java.time.LocalDate;

public class PersonalDetails {

    private final String name;
    private final LocalDate dob;

    public PersonalDetails(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }
}
