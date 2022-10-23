package mvc.dao.product;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductCategoryDTO;
import mvc.dto.product.ProductDTO;
import mvc.dto.product.ProductImageDTO;

/**
 * dbQuery사용
 * @author 강주형
 *
 */
public class AdminProductDAOImpl implements AdminProductDAO {
	
	private Properties proFile = new Properties();
	
	public AdminProductDAOImpl() {
		
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().
					getResourceAsStream("dbAdminProductQuery.properties");
			proFile.load(is);
			
			//System.out.println("출력확인용" +proFile.getProperty("product.selectAll"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertProduct(ProductDTO product) throws SQLException {
		// 
		return 0;
	}

	@Override
	public int updateProductByProductCode(int ProductCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProductStockByProductCode(int productCode, int stock) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO selectProductByProductCode(int productCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategoryDTO> selectProductCategory() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategoryDTO selectProductCategoryByCategoryCode(int productCategoryCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertProductCategory(ProductCategoryDTO productCategory) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByCategoryCode(int productCategoryCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertColor(ColorDTO color) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateColorByColorCode(int colorCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteColorByColorCode(int colorCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ColorDTO selectByColorCode(int colorCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColorDTO> selectColorAllByProductCode(int productCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int insertProductImage(ProductImageDTO productImage) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProductImageByProductImageCode(int productImageCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductImageDTO> selectByProductCode(int productCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductImageDTO selectByProductImageCode(int productImageCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
