package org.quantbet.pingenerator.model;

public class PersonalDetails {

    private final String name;
    private final String dob;

    public PersonalDetails(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }
}
