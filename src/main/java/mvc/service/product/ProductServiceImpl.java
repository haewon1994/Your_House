package mvc.service.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.product.ProductDAO;
import mvc.dao.product.ProductDAOImpl;
import mvc.dto.product.ProductDTO;

public class ProductServiceImpl implements ProductService {
	private ProductDAO dao = new ProductDAOImpl();

	@Override
	public ProductDTO selectByProductCode(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		return dao.selectAll();
	}

	@Override
	public boolean duplicateCheckByProductName(String productName) {
		// TODO Auto-generated method stub
		return false;
	}

}
