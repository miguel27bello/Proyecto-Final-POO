package entity;

public class Graduated {

	private long id;
	private String name, lastName, address, phone, password;
	private Career career;

	public Graduated() {

	}

	public Graduated(long id, String phone, String name, String lastName, String address, Career career,
			String password) {
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.career = career;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
