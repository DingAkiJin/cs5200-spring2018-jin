package model;

public class Role {
	private int id;
	private int developerId;
	private int websiteId;
	private int roleId;
	
	public Role() {
		super();
	}

	public Role(int id, int developerId, int websiteId, int roleId) {
		super();
		this.id = id;
		this.developerId = developerId;
		this.websiteId = websiteId;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
