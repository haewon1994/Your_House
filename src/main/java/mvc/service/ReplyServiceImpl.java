package mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import mvc.dao.notice.NoticeDAO;
import mvc.dao.notice.NoticeDAOImpl;
import mvc.dao.reply.ReplyDAO;
import mvc.dao.reply.ReplyDAOImpl;
import mvc.dto.notice.Notice;
import mvc.dto.reply.Reply;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDAO replyDAO = new ReplyDAOImpl();

	@Override
	public List<Reply> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Reply reply) throws SQLException {
		int result = replyDAO.insert(reply);
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public void delete(int replyCode) throws SQLException {
		Reply reply = replyDAO.selectByReplyCode(replyCode);

		if(reply==null) {
			throw new SQLException("공지번호 오류로 삭제할수 없습니다");
		}

		int result = replyDAO.delete(replyCode);
		if (result==0)throw new SQLException("삭제되지 않았습니다.");


	}

	@Override
	public Reply selectByReplyCode(int replyCode)throws SQLException {
		Reply reply = replyDAO.selectByReplyCode(replyCode);

		if(reply == null)
			throw new SQLException("상세보기에 오류가 발생했습니다.");

		return reply;
	}

}

