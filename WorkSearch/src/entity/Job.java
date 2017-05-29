package entity;

public class Job {

	private int id;
	private String name, requirements, name_enterprise, phone_enterprise;
	private Career principalCareer;
	private long id_enterprise;

	public Job() {

	}

	public Job(int id, String name, String requirements, String name_enterprise, Career principalCareer,
			long id_enterprise, String phone_enterprise) {
		this.id = id;
		this.name = name;
		this.requirements = requirements;
		this.name_enterprise = name_enterprise;
		this.principalCareer = principalCareer;
		this.id_enterprise = id_enterprise;
		this.phone_enterprise = phone_enterprise;
	}

	public String[] vectorStringToGraduated() {
		String[] rowData = { String.valueOf(id_enterprise), String.valueOf(id), name, name_enterprise, phone_enterprise,
				principalCareer.getTipo() };
		return rowData;
	}

	public String[] vectorStringToEnterprise() {
		String[] rowData = { String.valueOf(id_enterprise), String.valueOf(id), name, principalCareer.getTipo() };
		return rowData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Career getPrincipalCareer() {
		return principalCareer;
	}

	public void setPrincipalCareer(Career principalCareer) {
		this.principalCareer = principalCareer;
	}

	public long getId_enterprise() {
		return id_enterprise;
	}

	public void setId_enterprise(long id_enterprise) {
		this.id_enterprise = id_enterprise;
	}

	public String getName_enterprise() {
		return name_enterprise;
	}

	public void setName_enterprise(String name_enterprise) {
		this.name_enterprise = name_enterprise;
	}

	public String getPhone_enterprise() {
		return phone_enterprise;
	}

	public void setPhone_enterprise(String phone_enterprise) {
		this.phone_enterprise = phone_enterprise;
	}
}
