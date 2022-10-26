package mvc.dao.follow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dto.follow.Follow;
import mvc.dto.liked.Liked;
import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.util.DBUtil;

public class FollowDAOImpl implements FollowDAO {

	@Override
	public int insert(int followingCode, int followerCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("follow.insert");//insert into liked values(?,?,?)
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into follow values(=============_SEQ.NEXTVAL, ?,?)");
			ps.setInt(1, followingCode);
			ps.setInt(2, followerCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int FollowCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("follow.delete");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from follow where follow_CODE = ?");

			ps.setInt(1, FollowCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}


	@Override
	public Follow isFollow(int userCode, int followCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Follow follow = null;
		
		//String sql= proFile.getProperty("query.selectBymodelNum");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(" select * from Follow where USER_CODE=?  and Follow_Code=?");
			ps.setInt(1, userCode);
			ps.setInt(2, followCode);

			rs = ps.executeQuery();
			if(rs.next()) {
				follow = new Follow(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return follow;
	}

	@Override
	public List<UserDTO> selectByUserCode(int userCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from follow where following_Code = ?");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserDTO userDTO = 
				new UserDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				
			   list.add(story);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list ;
	}

	@Override
	public List<Story> selectByFollowingCode(int followingCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Story> list = new ArrayList<Story>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from follow where following_Code = ?");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Story story = 
				new Story(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				
			   list.add(story);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list ;
	}

	

}
