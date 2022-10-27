package mvc.dao.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductCategoryDTO;
import mvc.dto.product.ProductDTO;
import mvc.dto.product.ProductImageDTO;

/**
 * 관리자 상품관리 DAO (상품상세페이지 관리)
 * 
 * : 상품,카테고리,색상,상품사진 테이블 관리
 * ->등록,수정,삭제,조회
 * 
 * ->상품:품절==재고량0, 삭제==재고량-1  
 *       조회-> 상품코드에 해당하는 상품 정보만 검색
 * 
 * @author 강주형
 *
 */
public interface AdminProductDAO {
	
	/**
	 * 상품 통합 등록(상품+색상1+상품사진1)
	 * @param product
	 * @return : 1 = 등록성공 / 0 = 등록실패
	 * @throws SQLException
	 */
	public int insertTotalProduct(ProductDTO product, ColorDTO color, ProductImageDTO productImage) throws SQLException;
	
	/**
	 * 상품만 등록
	 * @return : 1 = 등록성공 / 0 = 등록실패
	 */
	int insertProduct(ProductDTO product) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 상품 수정
	 * @return : 1 = 수정성공 / 0 = 수정실패
	 */
	int updateProductByProductCode(ProductDTO product) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 상품의 재고량 수정 
	 * -> 값이 0이면 품절상태, -1이면 삭제상태
	 * @return : 1 = 수정성공 / 0 = 수정실패
	 */
	int updateProductStockByProductCode(int stock, int productCode) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 상품 조회 (수정페이지 등에 출력용)
	 */
	ProductDTO selectProductByProductCode(int productCode) throws SQLException;
	
	/**
	 * 상품리스트 출력 : 최근 생성일 맨 앞으로
	 * 등록,수정등 성공후 연결 페이지
	 */
	List<ProductDTO> selectAllProduct() throws SQLException;
	
	/////////////////////////////////
	
	/**
	 * 카테고리 전체 조회
	 */
	List<ProductCategoryDTO> selectAllProductCategory() throws SQLException;
	
	/**
	 * 카테고리 코드로 카테고리 조회
	 */
	ProductCategoryDTO selectProductCategoryByCategoryCode(int productCategoryCode) throws SQLException;
	
	/**
	 * 카테고리 등록(버젼업시 사용)
	 * @return : 1 = 등록성공 / 0 = 등록실패
	 */
	int insertProductCategory(ProductCategoryDTO productCategory) throws SQLException;
	
	/**
	 * 카테고리 코드로 카테고리 이름 수정(버젼업 대비)
	 * @return : 1 = 수정성공 / 0 = 수정실패
	 */
	int updateProductCategoryByCategoryCode(int productCategoryCode) throws SQLException;
	
	/////////////////////////////////

	/**
	 * 색상 등록
	 * @return : 1 = 등록성공 / 0 = 등록실패
	 */
	int insertColor(ColorDTO color) throws SQLException; 
	
	/**
	 * 색상코드로 색상 수정
	 * @return : 1 = 수정성공 / 0 = 수정실패
	 */
	int updateColorByColorCode(int colorCode) throws SQLException; 
	
	/**
	 * 색상코드로 색상 삭제
	 * @return : 1 = 삭제성공 , 0 = 삭제실패
	 */
	int deleteColorByColorCode(int colorCode) throws SQLException;
	
	/**
	 * 색상코드로 색상 조회
	 */
	ColorDTO selectColorByColorCode(int colorCode) throws SQLException;
	
	/**
	 * 상품 코드로 색상 조회
	 */
	List<ColorDTO> selectAllColorByProductCode(int productCode) throws SQLException;
	
	
	/////////////////////////////////
	
	/**
	 * 상품사진 등록
	 * @return : 1 = 등록성공 / 0 = 등록실패
	 */
	int insertProductImage(ProductImageDTO productImage) throws SQLException; 
	
	/**
	 * 사진코드로 상품사진 삭제
	 * @return : 1 = 삭제성공 , 0 = 삭제실패
	 */
	int deleteProductImageByProductImageCode(int productImageCode) throws SQLException;
	
	
	/**
	 * 상품코드로 상품사진 조회
	 */
	List<ProductImageDTO> selectAllProductImageByProductCode(int productCode) throws SQLException;
	
	/**
	 * 사진코드로 상품사진 조회
	 */
	ProductImageDTO selectProductImageByProductImageCode(int productImageCode) throws SQLException;
	
}