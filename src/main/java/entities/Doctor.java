package entities;

public class Doctor {
	private int id;
	private String name;
	private String dob;
	private String qualification;
	private String specalist;
	private String email;
	private String mobNo;
	private String password;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecalist() {
		return specalist;
	}
	public void setSpecalist(String specalist) {
		this.specalist = specalist;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor( String name, String dob, String qualification, String specalist, String email, String mobNo,
			String password) {
		super();
		this.name = name;
		this.dob = dob;
		this.qualification = qualification;
		this.specalist = specalist;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}
	public Doctor(int id, String name, String dob, String qualification, String specalist, String email, String mobNo,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.qualification = qualification;
		this.specalist = specalist;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	} 
	
	
	
}
