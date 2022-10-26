package mvc.dao.notice;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.notice.Notice;
import mvc.util.DBUtil;

public class NoticeDAOImpl implements NoticeDAO {
	 private Properties proFile = new Properties();

	 /*public NoticeDAOImpl() {
	 
		 try {
				InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
				proFile.load(is);
				
				System.out.println("query.select = " +proFile.getProperty("query.select"));
			}catch (Exception e) {
				e.printStackTrace();
			}
	 
	 }
	*/ 

	@Override
	public int insert(Notice notice) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("notice.insert");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into notice values(NOTICE_SEQ.NEXTVAL, ?,?,?,?,sysdate+9/24,?)");
			ps.setInt(1, notice.getNoticeCode());
			ps.setString(2, notice.getNoticeCategory());
			ps.setString(3, notice.getIsPrivate());
			ps.setString(4, notice.getNoticeImage());
			ps.setString(5, notice.getSubject());
			ps.setString(6, notice.getNoticeReg());
			ps.setString(7, notice.getNoticContent());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
			
		}
		return result;
		
		
	}//insert

	@Override
	public int update(Notice notice) throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("notice.update");//update notice set SUBJECT=?,NOTICE_CONTENT=? where NOTICE_CODE=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("set IS_PRIVATE=?, SUBJECT=?,NOTICE_CONTENT=? where NOTICE_CODE=?");

			ps.setString(1, notice.getSubject());
			ps.setString(2, notice.getNoticContent());
			ps.setInt(3, notice.getNoticeCode());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
		
	}//update
	

	@Override
	public int delete(int noticeCode) throws SQLException {

		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("notice.delete");//delete from notice where NOTICE_CODE = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from notice where NOTICE_CODE = ?");

			ps.setInt(1,noticeCode);

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;

	}//delete


	@Override
	public Notice selectBynoticeCode(int noticeCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Notice notice = null;
		
		//String sql= proFile.getProperty("notice.selectBynoticeCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from notice where NOTICE_CODE=?");
			ps.setInt(1, noticeCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				notice = new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return notice;
	}


	@Override
	public  List<Notice> selectByBanner() throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Notice> list = new ArrayList<Notice>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from notice where is_private=1");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Notice notice = 
				new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
			   list.add(notice);
			}
			
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list ;
  }


	@Override
	public List<Notice> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Notice> list = new ArrayList<Notice>();
		
		//String sql= proFile.getProperty("query.selectAll");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from Notice");
			rs = ps.executeQuery();
			while(rs.next()) {
				Notice notice = 
				new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
			   list.add(notice);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
		
		 
		


}//클래스끝
