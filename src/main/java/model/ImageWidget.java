package model;

public class ImageWidget extends Widget {
	
	private String src;

	public ImageWidget() {
		super();
	}

	public ImageWidget(String name, String width, String height, String cssClass, String cssStyle, String text, int order,
			Page page, String src) {
		//super(name, width, height, cssClass, cssStyle, text, order, page);
		this.src = src;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	

}