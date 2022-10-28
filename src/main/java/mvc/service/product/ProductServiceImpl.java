package mvc.service.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.product.ColorDAO;
import mvc.dao.product.ColorDAOImpl;
import mvc.dao.product.ProductDAO;
import mvc.dao.product.ProductDAOImpl;
import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductDTO;

public class ProductServiceImpl implements ProductService {
	private ProductDAO proDAO = new ProductDAOImpl();
	private ColorDAO colorDAO = new ColorDAOImpl();

	@Override
	public ProductDTO selectByProductCode(int prodcutCode) throws SQLException {
		ProductDTO product = proDAO.selectByProductCode(prodcutCode);
		List<ColorDTO> colorlist = colorDAO.selectByProductCode(prodcutCode);
		product.setColorList(colorlist);
		return product;
	}

	@Override
	public void insert(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		return proDAO.selectAll();
	}

	@Override
	public boolean duplicateCheckByProductName(String productName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductDTO> bestProdcut() throws SQLException {
		List<ProductDTO> bestlist  = proDAO.bestProduct();
		return bestlist;
	}

}
