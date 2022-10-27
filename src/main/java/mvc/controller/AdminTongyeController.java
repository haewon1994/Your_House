package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 관리자페이지-통계조회 페이지로 연결
 * 
 * 출력 : 매출액,매출수량 + 기간(~부터, ~까지) + 옵션들
 * 
--필터링 정리 - 다음중 하나씩만 선택가능/ 기본선택 맨 앞 / 반드시 입력
--조회범위 : 상품전체:PAll / 특정카테고리(카테고리코드 입력):CAll / 특정상품(상품코드 입력):Prod
--출력범위 : 매출통계만:Sum / 매출+상품정보:Pro
--시간범위 : (yyyymmdd 형식) 시작일-변수명:startDate , 마지막일 (하루면 동일 날짜)-변수명:lastDate

 * @author 강주형
 *
 */
public class AdminTongyeController implements Controller {

	서비스호출
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 필터별로 각각 개별 호출
	 * 뷰로 보낼때 DB정보 외 추가할것들
	 * : 입력된 날짜-시작일,마지막일 
	 * DB정보
	 * : 매출금액, 매출수량 + 필터링에 설정된 상품정보
	 */
	public ModelAndView selectTongye(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//받은 값 : 시작일, 마지막일
		String startDate=

		
		
		return null;
	}
}
