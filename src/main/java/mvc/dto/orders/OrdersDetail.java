package mvc.dto.orders;

public class OrdersDetail {
	private int detailCode;
	private int productCode;
	private int ordedrsCode;
	private int orderQty;
	private String colorName;
	private int unitPrice;
	
	public OrdersDetail() {}

	public OrdersDetail(int detailCode, int productCode, int ordedrsCode, int orderQty, String colorName,
			int unitPrice) {
		this.detailCode = detailCode;
		this.productCode = productCode;
		this.ordedrsCode = ordedrsCode;
		this.orderQty = orderQty;
		this.colorName = colorName;
		this.unitPrice = unitPrice;
	}

	public int getDetailCode() {
		return detailCode;
	}

	public void setDetailCode(int detailCode) {
		this.detailCode = detailCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getOrdedrsCode() {
		return ordedrsCode;
	}

	public void setOrdedrsCode(int ordedrsCode) {
		this.ordedrsCode = ordedrsCode;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
}
