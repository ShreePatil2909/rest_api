package rest_api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	int add_id;
	String city;
	public Address() {
		super();
	}
	public Address(int add_id, String city) {
		super();
		this.add_id = add_id;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [add_id=" + add_id + ", city=" + city + "]";
	}
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
