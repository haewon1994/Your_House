package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dto.reply.Reply;
import mvc.dto.user.UserDTO;
import mvc.service.ReplyService;
import mvc.service.ReplyServiceImpl;


public class AjaxReplyController implements AjaxController{
	private ReplyService replyService = new ReplyServiceImpl();

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}


	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		//전송된 데이터 받기 
		String replyCode = request.getParameter("reply_code");
		String storyCode = request.getParameter("story_code");
		UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		int userCode = Integer.parseInt(user.getUser_code());
		String replyContent = request.getParameter("reply_content");
		String createdReg = request.getParameter("created_reg");


		Reply reply = 
				new Reply(Integer.parseInt(replyCode),Integer.parseInt(storyCode), userCode, replyContent, createdReg);


		replyService.insert(reply);

	}


	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		String replyCode=request.getParameter("replyCode");
		replyService.delete(Integer.parseInt(replyCode));

	}
}
