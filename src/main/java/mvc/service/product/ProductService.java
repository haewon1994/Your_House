package mvc.service.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.ProductDTO;

public interface ProductService {

	ProductDTO selectByProductCode(int parseInt);

	void insert(ProductDTO product);

	List<ProductDTO> selectAll() throws SQLException;

	boolean duplicateCheckByProductName(String productName);

}
