package co.com.retobelcorp.certification.pruebatecnica.model;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.ModelCreationException;
import co.com.retobelcorp.certification.pruebatecnica.model.builders.AddressBuilder;

public class Address {

    private final String department;
    private final String province;
    private final String district;
    private final String address;
    private final String additionalInformation;
    private final String reference;
    private final String phone;

    public String department() {
        return department;
    }

    public String province() {
        return province;
    }

    public String district() {
        return district;
    }

    public String address() {
        return address;
    }

    public String additionalInformation() {
        return additionalInformation;
    }

    public String reference() {
        return reference;
    }

    public String phone() {
        return phone;
    }

    public Address(AddressBuilder builder) throws ModelCreationException {
        department = builder.getDepartment();
        province = builder.getProvince();
        district = builder.getDistrict();
        address = builder.getAddress();
        additionalInformation = builder.getAdditionalInformation();
        reference= builder.getReference();
        phone= builder.getPhone();
    }
}
