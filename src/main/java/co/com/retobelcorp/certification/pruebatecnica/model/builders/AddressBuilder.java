package co.com.retobelcorp.certification.pruebatecnica.model.builders;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.ModelCreationException;
import co.com.retobelcorp.certification.pruebatecnica.model.Address;
import co.com.retobelcorp.certification.pruebatecnica.util.builder.Builder;

public class AddressBuilder implements Builder<Address> {

    private final String department;
    private final String province;
    private final String district;
    private final String address;
    private final String additionalInformation;
    private final String reference;
    private final String phone;

    private AddressBuilder() {
        this.department = "LIMA";
        this.province = "CANTA";
        this.district = "SAN BUENAVENTURA";
        this.address = "Calle 30 # 27a-2";
        this.additionalInformation = "Piso 1";
        this.reference = "Paralela a la cuadra 10 de Velasco Astete";
        this.phone = "1234567890";
    }

    public String getDepartment() {
        return department;
    }

    public String getProvince() {
        return province;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public String getReference() {
        return reference;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public Address build() throws ModelCreationException {
        return new Address(this);
    }

    public static AddressBuilder theAddress(){
        return new AddressBuilder();
    }

}
