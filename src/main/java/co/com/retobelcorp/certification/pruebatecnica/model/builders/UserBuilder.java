package co.com.retobelcorp.certification.pruebatecnica.model.builders;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.ModelCreationException;
import co.com.retobelcorp.certification.pruebatecnica.model.User;
import co.com.retobelcorp.certification.pruebatecnica.util.builder.Builder;

public class UserBuilder implements Builder<User> {

    private  String firstName;
    private  String lastName;
    private  String email;

    private UserBuilder() {
        this.firstName = "Maria Antonia";
        this.lastName = "Ramirez";
        this.email = "antonia54@gmail.com";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public User build() throws ModelCreationException {
        return new User(this);
    }

    public static UserBuilder theUser(){
        return new UserBuilder();
    }

}
