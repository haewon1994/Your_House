package mvc.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.product.ProductDTO;
import mvc.service.ProductService;

public class ProductController implements Controller {
	private ProductService serivce = new ProductService();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//���� ȣ���ϰ�  dao ȣ��
		List<ProductDTO> list = serivce.selectAll();
		System.out.println(list);
		
		request.setAttribute("list", list);
		
		/*
		 * //상품베스트 a=Service.go
		 * 
		 * //리뷰베스트 b=Service.go //새로운상품 c=Service.go
		 * 
		 * request.setAttribute("a", list); request.setAttribute("b", list);
		 * request.setAttribute("c", list);
		 */
		
		return new ModelAndView("index.jsp");
	}

}
