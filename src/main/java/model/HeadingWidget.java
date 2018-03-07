package model;

public class HeadingWidget extends Widget {
	
	private int size;

	public HeadingWidget() {
		super();
	}

	public HeadingWidget(String name, String width, String height, String cssClass, String cssStyle, String text, int order,
			Page page, int size) {
		//super(name, width, height, cssClass, cssStyle, text, order, page);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
