package model;

public class Priviledge {
	private int developerId;
	private int websiteId;
	private int priviledgeId;
	
	public Priviledge() {
		super();
	}

	public Priviledge(int developerId, int websiteId, int priviledgeId) {
		super();
		this.developerId = developerId;
		this.websiteId = websiteId;
		this.priviledgeId = priviledgeId;
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

	public int getPriviledgeId() {
		return priviledgeId;
	}

	public void setPriviledgeId(int priviledgeId) {
		this.priviledgeId = priviledgeId;
	}
}
