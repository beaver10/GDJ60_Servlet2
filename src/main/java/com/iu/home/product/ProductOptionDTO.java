package com.iu.home.product;

public class ProductOptionDTO {
	
	private Long optionNum;
	private Long productnum;
	private String optionName;
	private Integer optionPrice;
	private Integer optionStock;
	
	
	public Long getOptionNum() {
		return optionNum;
	}
	public void setOptionNum(Long optionNum) {
		this.optionNum = optionNum;
	}
	public Long getProductnum() {
		return productnum;
	}
	public void setProductnum(Long productnum) {
		this.productnum = productnum;
	}
	public String getOptionname() {
		return optionName;
	}
	public void setOptionname(String optionName) {
		this.optionName = optionName;
	}
	public Integer getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(Integer optionPrice) {
		this.optionPrice = optionPrice;
	}
	public Integer getOptionStock() {
		return optionStock;
	}
	public void setOptionStock(Integer optionStock) {
		this.optionStock = optionStock;
	}
	
	

}
