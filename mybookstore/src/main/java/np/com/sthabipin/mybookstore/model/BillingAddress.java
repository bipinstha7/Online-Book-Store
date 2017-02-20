package np.com.sthabipin.mybookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="billingAddress")
public class BillingAddress implements Serializable {

	
	private static final long serialVersionUID = -6367501457529010358L;
	
	@Id
	@GeneratedValue
	@Column(name="billing_address_id")
	private int billingAddressId;
	
	@Column(name="street_name")	
	private String streetName;
	
	@Column(name="apartment_number")
	private String apartmentNumber;
	
	private String city;
	
	private String state;
	
	private String country;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@OneToOne
	private Customer customer;

	public int getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BillingAddress [billingAddressId=" + billingAddressId
				+ ", streetName=" + streetName + ", apartmentNumber="
				+ apartmentNumber + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
	

}
