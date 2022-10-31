package mvc.dao.product;

import java.sql.SQLException;

import mvc.dto.product.AdminTongyeDTO;
import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductImageDTO;

/**
 * 리뷰 등록, 조회, 중복체크 DAO
 * 
 * @author 강주형
 *
 */
public interface ReviewDAO {
	
	/**
	 * 리뷰 등록
	 * 
	 * 인수로 회원코드, 상품코드, 주문코드, 주문상세코드 필요
	 */
	public int insertReview() throws SQLException;
}
