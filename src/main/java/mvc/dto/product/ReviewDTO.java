package mvc.dto.product;

/**
 * 리뷰 DTO -> 상품에 ReviewList있음
 * 
 * @author 강주형
 *
 */
public class ReviewDTO {
	private int reviewCode;
	private int userCode;
	private int productCode;
	private int detailCode;
	private int ordersCode;
	private int rating;
	private String reviewContent;
	private String createdReg;
	
	private String avgRating;
	
	public ReviewDTO(int reviewCode, int userCode, int productCode, int detailCode, int ordersCode, int rating,
			String reviewContent, String createdReg, String avgRating) {
		super();
		this.reviewCode = reviewCode;
		this.userCode = userCode;
		this.productCode = productCode;
		this.detailCode = detailCode;
		this.ordersCode = ordersCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.createdReg = createdReg;
		this.avgRating = avgRating;
	}

	public ReviewDTO(int userCode, int productCode) {
		super();
		this.userCode = userCode;
		this.productCode = productCode;
	}

	public ReviewDTO(int reviewCode, int userCode, int productCode, int detailCode, int ordersCode, int rating,
			String reviewContent, String createdReg) {
		super();
		this.reviewCode = reviewCode;
		this.userCode = userCode;
		this.productCode = productCode;
		this.detailCode = detailCode;
		this.ordersCode = ordersCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.createdReg = createdReg;
	}

	public ReviewDTO(int userCode, int productCode, int detailCode, int ordersCode, int rating, String reviewContent) {
		super();
		this.userCode = userCode;
		this.productCode = productCode;
		this.detailCode = detailCode;
		this.ordersCode = ordersCode;
		this.rating = rating;
		this.reviewContent = reviewContent;
	}

	public ReviewDTO(int userCode, int productCode, int detailCode, int ordersCode, int rating) {
		super();
		this.userCode = userCode;
		this.productCode = productCode;
		this.detailCode = detailCode;
		this.ordersCode = ordersCode;
		this.rating = rating;
	}

	public int getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getDetailCode() {
		return detailCode;
	}

	public void setDetailCode(int detailCode) {
		this.detailCode = detailCode;
	}

	public int getOrdersCode() {
		return ordersCode;
	}

	public void setOrdersCode(int ordersCode) {
		this.ordersCode = ordersCode;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getCreatedReg() {
		return createdReg;
	}

	public void setCreatedReg(String createdReg) {
		this.createdReg = createdReg;
	}

	public String getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(String avgRating) {
		this.avgRating = avgRating;
	}
	
}
