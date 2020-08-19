package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    enum AddressType {
        DEILIVERING,
        BILLING
    }

    private String address, city, state;
    private Integer zipcode;
    private AddressType addressType;

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public Address() {
    }

    public Address(String address, String city, String state, Integer zipcode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

}
