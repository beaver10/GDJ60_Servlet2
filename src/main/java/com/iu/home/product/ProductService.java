package com.iu.home.product;

import java.util.List;

public class ProductService {
	
	
	//실행순서 1 (잘안씀)
	//멤버변수 선언 초기화
	//결합도가 높다(강하다)
	private ProductDAO productDAO = new ProductDAO();
	
	//실행순서 2 (잘안씀)
	//초기화 블럭
	{
		this.productDAO = new ProductDAO();
	}
	
	//실행순서 3
	//생성자
	public ProductService () {
		this.productDAO = new ProductDAO();
	}
	
	//실행순서 4
	//setter
	//결합도가 낮다(약하다)
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	public int setAddProduct (ProductDTO productDTO, List<ProductOptionDTO>ar) throws Exception{
		//product, option 등록
		Long productNum = productDAO.getProductnum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setAddProduct(productDTO);
		for(ProductOptionDTO productOptionDTO:ar) {
			productDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);
			
		}
		return result;
		
		
	}

	public static void main(String[] args) {
		
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOptionname("option1");
		productOptionDTO.setOptionPrice(100);
		productOptionDTO.setOptionStock(10);
		productOptionDTO.setProductnum(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOptionname("option2");
		productOptionDTO2.setOptionPrice(200);
		productOptionDTO2.setOptionStock(20);
		productOptionDTO2.setProductnum(null);
		
		try {
			Long num = productDAO.getProductnum();
			productDTO.setProductNum(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setProductnum(num);
			
			if(result>0) {
				productDAO.setAddProductOption(productOptionDTO);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
