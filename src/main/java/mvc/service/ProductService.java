package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.product.ProductDAO;
import mvc.dao.product.ProductDAOImpl;
import mvc.dto.product.ProductDTO;

public class ProductService {
	private ProductDAO dao = new ProductDAOImpl();

	public List<ProductDTO> selectAll() throws SQLException {
		List<ProductDTO> list = dao.selectAll();
		return list;
	}
}
