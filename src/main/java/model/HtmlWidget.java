package model;

public class HtmlWidget extends Widget{
	
	private String html;

	public HtmlWidget() {
		super();
	}

	public HtmlWidget(String name, String width, String height, String cssClass, String cssStyle, String text, int order,
			Page page, String html) {
		//super(name, width, height, cssClass, cssStyle, text, order, page);
		this.html = html;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	

}
