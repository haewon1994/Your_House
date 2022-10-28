package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.product.AdminTongyeDTO;
import mvc.service.AdminTongyeService;
import mvc.service.AdminTongyeServiceImpl;

/**
 * 관리자페이지-통계조회 페이지로 연결
 * 
 * 받는 인수 : startDate, lastDate, categoryCode(생략가능), productCode(생략가능)
 * ->시간형식 : yyyymmdd(숫자) / 코드 : 숫자입력
 * 
 * 보내는 인수 : adminTongyeList
 * 메소드 이름 : selectTongyeOnly(통계만리턴) / selectTongyeProduct(통계+상품정보)
 * 
 * 출력 : 매출액,매출수량 + 기간(~부터, ~까지) + 옵션들
 * 
 * @author 강주형
 *
 */
public class AdminTongyeController implements Controller {

	public AdminTongyeService adminTongyeService=new AdminTongyeServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 통계만 리턴하는 메소드
	 * 
	 * 받는 인수 : startDate, lastDate, categoryCode(생략가능), productCode(생략가능)
	 * 
	 * 보내는 인수 : adminTongyeList (${adminTongyeList}로 사용}
	 * 리스트속 인수 : sumPrice, sumQty
	 * 
	 * 완료후 연결뷰 : 통계페이지
	 * -> admin/tongye.jsp
	 */
	public ModelAndView selectTongyeOnly(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//받은 값 : 시작일, 마지막일 / 상품코드, 카테고리코드
		String startDate=request.getParameter("startDate");
		String lastDate=request.getParameter("lastDate");
		String categoryCode=request.getParameter("categoryCode");
		String productCode=request.getParameter("productCode");
		List<AdminTongyeDTO> adminTongyeList=new ArrayList<AdminTongyeDTO>();
		
		if(startDate.length()!=8||lastDate.length()!=8) throw new Exception("날짜입력형식을 확인해주세요 ex) 20221027");
		
		if(categoryCode==null&&productCode==null) {//1. 기본 : 상품전체 / 매출통계만
			adminTongyeList=adminTongyeService.selectTongyePrAllSum(startDate, lastDate);
		}
		if(categoryCode!=null&&productCode==null) {//3. 특정 카테고리 / 매출통계만
			adminTongyeList=adminTongyeService.selectTongyeCaAllSum(Integer.parseInt(categoryCode), startDate, lastDate);
		}
		if(categoryCode==null&&productCode!=null) {//5. 기본 : 상품전체 / 매출통계만
			adminTongyeList=adminTongyeService.selectTongyeProdSum(Integer.parseInt(productCode), startDate, lastDate);
		}

		//뷰에서 ${adminTongyeList}
		request.setAttribute("adminTongyeList", adminTongyeList);
		request.setAttribute("startDate", startDate);
		request.setAttribute("lastDate", lastDate);
		
		return new ModelAndView("admin/tongye.jsp"); //forward방식으로 이동
	}
	
	/**
	 * 통계+상품정보+카테고리이름 리턴하는 메소드
	 * 
	 * 받는 인수 : startDate, lastDate, categoryCode(생략가능), productCode(생략가능)
	 * 
	 * 보내는 인수 : adminTongyeList (${adminTongyeList}로 사용}
	 * 리스트속 인수 : sumPrice, sumQty, 상품DTO이름, categoryName
	 * 
	 * 완료후 연결뷰 : 통계페이지
	 * -> admin/tongye.jsp
	 */
	public ModelAndView selectTongyeProduct(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//받은 값 : 시작일, 마지막일 / 상품코드, 카테고리코드
		String startDate=request.getParameter("startDate");
		String lastDate=request.getParameter("lastDate");
		String categoryCode=request.getParameter("categoryCode");
		String productCode=request.getParameter("productCode");
		List<AdminTongyeDTO> adminTongyeList=new ArrayList<AdminTongyeDTO>();
		
		if(startDate.length()!=8||lastDate.length()!=8) throw new Exception("날짜입력형식을 확인해주세요 ex) 20221027");
		
		if(categoryCode==null&&productCode==null) {//2. 상품전체 / 상품정보
			adminTongyeList=adminTongyeService.selectTongyePrAllPro(startDate, lastDate);
		}
		if(categoryCode!=null&&productCode==null) {//4. 특정 카테고리 / 상품정보
			adminTongyeList=adminTongyeService.selectTongyeCaAllPro(Integer.parseInt(categoryCode), startDate, lastDate);
		}
		if(categoryCode==null&&productCode!=null) {//6. 특정 상품 / 상품정보
			adminTongyeList=adminTongyeService.selectTongyeProdPro(Integer.parseInt(productCode), startDate, lastDate);
		}

		//뷰에서 ${adminTongyeList}
		request.setAttribute("adminTongyeList", adminTongyeList);
		request.setAttribute("startDate", startDate);
		request.setAttribute("lastDate", lastDate);
		
		return new ModelAndView("admin/tongye.jsp"); //forward방식으로 이동
	}
}
