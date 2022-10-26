package mvc.dao.story;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.dto.story.Story;
import mvc.util.DBUtil;

public class StoryDAOImpl implements StoryDAO {
	private Properties proFile = new Properties();


	
	
	@Override
	public List<Story> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Story> list = new ArrayList<Story>();

		//String sql= proFile.getProperty("Story.select");//select * from Electronics  order by writeday desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from Story  order by noticeReg desc");
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
		return list;
	}


/*
   //페이징 처리
  	@Override 
	public List<Story> getBoardList(int storyCode) throws SQLException {
		
		return null;
	}

*/

	public StoryDAOImpl() {
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.

			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);

			System.out.println("query.select = " +proFile.getProperty("query.select"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public int insert(Story story) throws SQLException {

		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("story.insert");//insert into Electronics values(?,?,?,?,?,sysdate,0,?,?)
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into notice values(NOTICE_SEQ.NEXTVAL, ?,?,?,?,sysdate+9/24,?)");
			ps.setInt(1, story.getStoryCode());
			ps.setInt(2, story.getUserCode());
			ps.setString(3, story.getStoryImage());
			ps.setString(4, story.getStoryLiter());
			ps.setString(5, story.getStoryReg());

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;

	}

	@Override
	public int update(Story story) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("story.update");//update Electronics set model_name=?,price=?,description=? where model_num=? and password=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update STORY set STORY_LITER=? where STORY_CODE=?");
			ps.setString(1, story.getStoryLiter());
			ps.setInt(2, story.getStoryCode());


			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int storyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("query.delete");
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from Story where STORY_CODE = ?");

			ps.setInt(1, storyCode);
			//ps.setString(2, password) 비밀번호입력 시 삭제... 하고싶은데..

			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Story selectByStoryCode(int storyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Story story = null;

		//String sql= proFile.getProperty("Story.selectBynoticeCode");//select * from Electronics where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from notice where Story_CODE=?");
			ps.setInt(1, storyCode);

			rs = ps.executeQuery();
			if(rs.next()) {
				story = new Story(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return story;

	}


	@Override
	public List<Story> list(String keyWord) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Story> list = new ArrayList<Story>();
		
		String sql="SELECT * FROM STOYR";
		
		//sql ="SELECT * FROM MEMBER WHERE 1=1 -- like ?";   // keyField =  1=1 --
		
		try {
			if(keyWord != null && !keyWord.isEmpty()) {
				sql += " WHERE storLiter LIKE '%' || ? || '%'order by created_reg desc";
			}
			
			ps = con.prepareStatement(sql);
			
			if(keyWord != null && !keyWord.isEmpty()) {
				ps.setString(1, keyWord);
			}
			
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Story story =new Story(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5));				
				list.add(story);
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}


	@Override
	public int increamentByReadnum(int storyCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//String sql= proFile.getProperty("Story.increamentByReadnum");//update Electronics set readnum=readnum+1 where model_num=?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update Story set readnum=readnum+1 where STORY_CODE=?");
			ps.setInt(1, storyCode);
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}





}
