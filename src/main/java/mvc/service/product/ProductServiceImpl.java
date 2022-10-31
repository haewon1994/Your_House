package mvc.service.product;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		//상품상세페이지
		
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
		//상품전제
		return proDAO.selectAll();
	}

	@Override
	public boolean duplicateCheckByProductName(String productName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductDTO> bestProdcut() throws SQLException {
		//누적판매수상품 베스트
		List<ProductDTO> bestlist  = proDAO.bestProduct();
		return bestlist;
	}

	@Override
	public Map<String, List<ProductDTO>> totalCategory() throws SQLException {
		// 각 카테고리에 해당하는 베스트 상품을 출력
		
		// 1=수납/정리
		List<ProductDTO> category1 = proDAO.categoryProduct(1);
		
		// 2=침대/매트리스
		List<ProductDTO> category2 = proDAO.categoryProduct(2);
				
		// 3=소파
		List<ProductDTO> category3 = proDAO.categoryProduct(3);	
		
		// 4=홈오피스
		List<ProductDTO> category4 = proDAO.categoryProduct(4);	
		
		// 5=조명
		List<ProductDTO> category5 = proDAO.categoryProduct(5);	
		
		//각 카테고리 정보를 Map에 담자
		Map<String, List<ProductDTO>> totalCategory = new HashMap<String, List<ProductDTO>>();
		totalCategory.put("1", category1);
		totalCategory.put("2", category2);
		totalCategory.put("3", category3);
		totalCategory.put("4", category4);
		totalCategory.put("5", category5);
		
		return totalCategory;
	}

	@Override
	public List<ProductDTO> totalBest() throws SQLException {
		// 실시간/역대 베스트 상품을 출력
		List<ProductDTO> list = proDAO.totalBest();
		
		return list;
	}

}
