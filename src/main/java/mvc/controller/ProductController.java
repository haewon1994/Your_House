package mvc.controller;

import java.io.IOException;
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
		//서비스 호출하고  dao 호출
		List<ProductDTO> list = serivce.selectAll();
		System.out.println(list);
		
		request.setAttribute("list", list);
		
		return new ModelAndView("index.jsp");
	}

}
