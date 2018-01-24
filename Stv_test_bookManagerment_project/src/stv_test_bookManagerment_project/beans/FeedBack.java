package stv_test_bookManagerment_project.beans;

public class FeedBack {
	private int ID;
	private int productId;
	private String feedBack;

	public FeedBack() {

	}

	public FeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public FeedBack(int ID, int productId, String feedBack) {
		this.ID = ID;
		this.productId = productId;
		this.feedBack = feedBack;
	}

	public FeedBack(int productId, String feedBack) {
		this.productId = productId;
		this.feedBack = feedBack;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

}
