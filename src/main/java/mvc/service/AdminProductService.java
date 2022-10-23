package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductCategoryDTO;
import mvc.dto.product.ProductDTO;
import mvc.dto.product.ProductImageDTO;


/**
 * 관리자 상품관리 service (상품상세페이지 관리)
 * 
 * @author 강주형
 *
 */
public interface AdminProductService {
	
	/**
	 * 상품 등록(상품만)
	 */
	void insertProduct(ProductDTO product) throws SQLException;
	
	/**
	 * 상품사진 등록
	 */
	void insertColor(ColorDTO color) throws SQLException; 
	
	/**
	 * 색상 등록
	 */
	void insertProductImage(ProductImageDTO productImage) throws SQLException;

	/**
	 * 카테고리 등록(버젼업시 생성)
	 */
	void insertProductCategory(ProductCategoryDTO productCategory) throws SQLException;
	
	//////////////////////////////////////////
	/**
	 * 상품코드에 해당하는 상품 수정(사진, 색상은 수정 없음)
	 */
	void updateProductByProductCode(ProductDTO product) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 재고량 수정(상품정보만)
	 * -> 재고량 수정 / 품절로 변경(0) / 판매중단으로 변경(-1)
	 */
	void updateProductStockByProductCode(int productCode, int stock) throws SQLException;
	
	//////////////////////////////////////////
	
	/**
	 * 색상코드로 색상 삭제
	 */
	void deleteColorByColorCode(int colorCode) throws SQLException;
	
	/**
	 * 상품사진코드로 상품사진 삭제
	 */
	void deleteProductImageByProductImageCode(int productImageCode) throws SQLException;
	
	//////////////////////////////////////////
	
	/**
	 * 상품코드에 해당하는 상품만 조회
	 */
	ProductDTO selectProductByProductCode(int productCode) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 상품사진 조회
	 */
	List<ProductImageDTO> selectByProductCode(int productCode) throws SQLException;
	
	/**
	 * 상품코드에 해당하는 상품색상 조회
	 */
	ColorDTO selectByColorCode(int colorCode) throws SQLException;
	
	/**
	 * 카테고리 코드로 카테고리 조회
	 */
	ProductCategoryDTO selectProductCategoryByCategoryCode(int productCategoryCode) throws SQLException;
	
	/**
	 * 카테고리 전체 조회
	 */
	List<ProductCategoryDTO> selectProductCategory() throws SQLException;
	
	/**
	 * 카테고리 코드로 카테고리 수정(버젼업시 생성)
	 */
	void updateByCategoryCode(int productCategoryCode) throws SQLException;
}
