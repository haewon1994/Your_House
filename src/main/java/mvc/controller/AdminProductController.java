package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 상품 통합등록
	 */
	public ModelAndView insertAllProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 상품정보만 등록
	 */
	public ModelAndView insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 상품사진 등록
	 */
	public ModelAndView insertColor(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 색상 등록
	 */
	public ModelAndView insertProductImage(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}

	/**
	 * 카테고리 등록(버젼업시 생성)
	 */
	public ModelAndView insertProductCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	//////////////////////////////////////////
	
	/**
	 * 상품코드에 해당하는 상품 수정(사진, 색상은 수정 없음)
	 */
	public ModelAndView updateProductByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 카테고리 코드로 카테고리 수정(버젼업시 생성)
	 */
	public ModelAndView updateProductCategoryByProductCategoryCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	
	/**
	 * 상품코드에 해당하는 재고량 수정(상품정보만)
	 * -> 재고량 수정 / 품절로 변경(0) / 판매중단으로 변경(-1)
	 */
	public ModelAndView updateProductStockByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	//////////////////////////////////////////
	
	/**
	 * 색상코드로 색상 삭제
	 */
	public ModelAndView deleteColorByColorCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 상품사진코드로 상품사진 삭제
	 */
	public ModelAndView deleteProductImageByProductImageCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	//////////////////////////////////////////
	
	/**
	 * 상품코드에 해당하는 상품 통합 조회(카테고리+상품정보+상품사진+색상)
	 */
	public ModelAndView selectAllByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	
	/**
	 * 상품코드에 해당하는 상품사진 조회
	 */
	public ModelAndView selectByProductCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 상품코드에 해당하는 상품색상 조회
	 */
	public ModelAndView selectByColorCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 카테고리 코드로 카테고리 조회
	 */
	public ModelAndView selectProductCategoryByCategoryCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}
	
	/**
	 * 카테고리 전체 조회
	 */
	public ModelAndView selectProductCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return null;//리턴 바꿀것
	}

}
