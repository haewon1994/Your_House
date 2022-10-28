package mvc.controller.store;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;
import mvc.controller.ModelAndView;
import mvc.dto.product.ProductDTO;
import mvc.dto.user.UserDTO;
import mvc.service.product.ProductService;
import mvc.service.product.ProductServiceImpl;

public class StoreController implements Controller{
	private ProductService proService = new ProductServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView reUserProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = user.getUserCode();
		return null;
	}
	
	/**
	 * 스토어홈 화면에 출력해아하는 정보
	 */
	public ModelAndView storeHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		List<ProductDTO> list = proService.bestProdcut();
		request.setAttribute("bestList", list);
		return new ModelAndView("store/storeHome.jsp");
	}
	
	/**
	 * 상품 상세페이지
	 */
	public ModelAndView productDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String url="error/signupError.jsp";
		String errMsg="상품이 없습니다";
		
		// 넘어오는 값 받기
		String productCode = request.getParameter("productCode");
		
		if(productCode.equals("") || productCode==null) {
			request.setAttribute("errMsg", errMsg);
		} else {
			ProductDTO prdocut = proService.selectByProductCode(Integer.parseInt(productCode));
			request.setAttribute("prodocut", prdocut);
			
			url="store/productDetail.jsp";
		}
		
		return new ModelAndView(url);
	}

}
