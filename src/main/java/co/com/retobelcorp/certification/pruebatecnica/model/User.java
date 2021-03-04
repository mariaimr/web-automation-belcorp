package co.com.retobelcorp.certification.pruebatecnica.model;

import co.com.retobelcorp.certification.pruebatecnica.model.builders.UserBuilder;

public class User {

    private final String firstName;
    private final String lastName;
    private final String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public User(UserBuilder builder) {
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.email = builder.getEmail();
    }

}