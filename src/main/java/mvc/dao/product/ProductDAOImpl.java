package mvc.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dto.product.ProductDTO;
import mvc.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product";
		
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

	@Override
	public ProductDTO selectByProductCode(int productCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDTO product = null;
		String sql = "selelct * from product where product_code = ?";
		
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
