package entity;

public class Enterprise {

	private long nit;
	private String name, phone, password;

	public Enterprise() {

	}

	public Enterprise(long nit, String name, String phone, String password) {
		this.nit = nit;
		this.name = name;
		this.phone = phone;
		this.password = password;
	}

	public long getNit() {
		return nit;
	}

	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
