package mvc.dao.product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.product.ProductDTO;
import mvc.util.DBUtil;

/**
 * 테스트겸 생성중-강주형
 * 
 * dbQuery사용(map / 테스트겸작성중-kjhDbQuery.properties)
 * 
 * 상품 전체검색, 등록, 수정 / 삭제-재고0으로 
 * (품절/판매중단 전부 재고0, 관련 사항은 상품설명으로 고지)
 */
public class KjhProductDAOImpl2 implements ProductDAO {
	private Properties proFile = new Properties();

	/**
	 * DB쿼리 properties로 연결
	 * kjhDbQuery.properties
	 */
	public KjhProductDAOImpl2() {
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			//InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			InputStream is = getClass().getClassLoader().getResourceAsStream("kjhDbQuery.properties");
			proFile.load(is);
			
			//System.out.println("product.selectAll = " +proFile.getProperty("product.selectAll"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 상품 전체 검색(list)
	 * selctAll() : select * from product
	 */
	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		//String sql = "select * from product";
		String sql= proFile.getProperty("product.selectAll");
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7),
						rs.getInt(8)
					));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectAllPage(int pageNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 상품코드에 해당하는 상품 검색(또는 상세보기)
	 * selelct * from product where product_code= ?
	 */
	@Override
	public ProductDTO selectByProductCode(int productCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDTO product = null;

		String sql= proFile.getProperty("product.selectByProductCode");
		//String sql = "selelct * from product where product_code= ?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				product =new ProductDTO(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7),
						rs.getInt(8)
					);
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return product;
	}

	@Override
	public boolean duplicateCheckByProductName(String productName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insert(ProductDTO product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ProductDTO product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByProductCode(int productCode, int stock) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int productCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
