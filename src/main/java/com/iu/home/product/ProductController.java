package com.iu.home.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;   
    private ProductService productService;
    private ProductDTO productDTO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        productDAO = new ProductDAO();
        productService = new ProductService();
        productDTO = new ProductDTO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Product page");
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		String path ="";
		
		switch(uri) {
		case "list.do" :
			try {
				List<ProductDTO>ar = productService.getProductList();
				request.setAttribute("list", ar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path = "productList.jsp";
			break;
		case "add.do" :

			path = "productAdd.jsp";
			break;
		case "update.do" :
			
			path = "productUpdate.jsp";
			break;
		case "delete.do" :
			
			break;
		case "detail.do" :
				Long num = Long.parseLong(request.getParameter("productNum"));
				productDTO.setProductNum(num);
			try {
				 productDTO = productService.getProductDetail(productDTO);
				 request.setAttribute("detail", productDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path = "productDetail.jsp";
			break;
		default : 
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/product/"+path);
		view.forward(request, response);
		
//		String name = request.getParameter("name");
//		String detail = request.getParameter("detail");
//		System.out.println(name);
//		System.out.println(detail);
//		productDTO.setProductName(name);
//		productDTO.setProductDetail(detail);
//		
//		try {
//			int result = productService.setAddProduct(productDTO, new ArrayList<ProductOptionDTO>());
//			System.out.println(result); 
//			//1이면 등록완료 DBeaver 들어가서 Product에 data 들어갔는지 확인
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
