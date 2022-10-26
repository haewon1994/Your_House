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
		String sql = "select * from product where product_code = ?";
		
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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select product_name from product where product_name = ?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, productName);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return result;
	}

	@Override
	public int insert(ProductDTO product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into product values(product_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?)";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getCategoryCode());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getImage());
			ps.setString(4, product.getProductDetail());
			ps.setInt(5, product.getStock());
			ps.setInt(6, product.getPrice());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int update(ProductDTO product) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update product set product_name=?, product_detail=?, price=? where product_code=?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductDetail());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getProductCode());
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int updateByProductCode(int productCode, int stock) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update product set stock=? where product_code=?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, productCode);
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int delete(int productCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from product where product_code=?";
		
		try {
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setInt(2, productCode);
			
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
	}

}
