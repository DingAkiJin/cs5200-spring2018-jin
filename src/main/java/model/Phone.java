package model;

public class Phone {
	private String phone;
	private boolean primary;
	private String username;
	private int person_id;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public Phone() {
		super();
	}

	public Phone(String phone, boolean primary, String username, int person_id) {
		super();
		this.phone = phone;
		this.primary = primary;
		this.username = username;
		this.person_id = person_id;
	}

}
