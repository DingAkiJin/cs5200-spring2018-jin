package model;

public class YouTubeWidget extends Widget {
	
	private String url;
	private boolean shareble;
	private boolean expandable;
	
	public YouTubeWidget() {
		super();
	}

	public YouTubeWidget(String name, String width, String height, String cssClass, String cssStyle, String text, int order,
			Page page, String url, boolean shareble, boolean expandable) {
		//super(name, width, height, cssClass, cssStyle, text, order, page, url, shareble, expandable,null, null,null);
		this.url = url;
		this.shareble = shareble;
		this.expandable = expandable;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isShareble() {
		return shareble;
	}

	public void setShareble(boolean shareble) {
		this.shareble = shareble;
	}

	public boolean isExpandable() {
		return expandable;
	}

	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	
	

}
