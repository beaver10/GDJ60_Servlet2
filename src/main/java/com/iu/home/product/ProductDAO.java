package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.home.util.DBConnection;

public class ProductDAO {
	
	//getMax
	public Long getProductnum () throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL M FROM DUAL";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		Long num = rs.getLong("M");
		
		DBConnection.disConnect(st, con, rs);
		
		return num;
		
	}
	
	
	//---------------------------------------------------------------------------------------------------
	//Productoption
	
	public List<ProductOptionDTO> getProductOptionList() throws Exception{
		
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductnum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionname(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getInt("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getInt("OPTIONSTOCK"));			
		}
		DBConnection.disConnect(st, con, rs);
		return ar;
	}
	
	
	public int setAddProductOption (ProductOptionDTO productOptionDTO) throws Exception {
		
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION VALUES (PRODUCTOPTION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productOptionDTO.getProductnum());
		st.setString(2, productOptionDTO.getOptionname());
		st.setInt(3, productOptionDTO.getOptionPrice());
		st.setInt(4, productOptionDTO.getOptionStock());

		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	//--------------------------------------------------------------------------------------------------
	//Product
	
	public List<ProductDTO> getProductList() throws Exception {
		
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTJUMSU "
				+ "FROM PRODUCT ORDER BY PRODUCTJUMSU DESC";
			
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));	
			ar.add(productDTO);
		}
		
		DBConnection.disConnect(st, con, rs);
		
		return ar;
		
	}
	
	
	//setAddProduct
	public int setAddProduct(ProductDTO productDTO) throws Exception {
		
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU) "
				+ "VALUES (?, ?, ?, 0.0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		//st.setDouble(3, productDTO.getProductJumsu());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
		
	}
	
	
}
