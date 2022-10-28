package mvc.service.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.ProductDTO;

public interface ProductService {

	ProductDTO selectByProductCode(int prodcutCode) throws SQLException;

	void insert(ProductDTO product);

	List<ProductDTO> selectAll() throws SQLException;

	boolean duplicateCheckByProductName(String productName);
	
	List<ProductDTO> bestProdcut() throws SQLException;

}
