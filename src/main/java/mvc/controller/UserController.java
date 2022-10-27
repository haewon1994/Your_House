package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.dao.user.UserDAO;
import mvc.dao.user.UserDAOImpl;
import mvc.dto.user.UserDTO;
import mvc.service.UserService;
import mvc.service.UserServiceImpl;
import net.sf.json.JSONArray;




public class UserController implements Controller {

	private UserService userService = new UserServiceImpl();
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 회원가입
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String url="error/signupError.jsp";
		String errMsg="회원가입을 실패했습니다.";
		boolean isRedirect=false;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String pwdCheck = request.getParameter("pwdCheck");
		String birth = request.getParameter("birth");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String adress = request.getParameter("adress");
		String gender = request.getParameter("gender");
		String categoryCode = request.getParameter("categoryCode");


		if(email==null || email.equals("") || password==null || password.equals("") || pwdCheck==null || pwdCheck.equals("") || 
				birth==null || birth.equals("") || nickname==null || nickname.equals("") ||
				phone==null || phone.equals("") ||  adress==null  || adress.equals("") ||  
				gender==null  || gender.equals("") ||  categoryCode==null  || categoryCode.equals("")){

			errMsg="전부 입력해주세요.";
			request.setAttribute("errMsg", errMsg);
		}else {
			UserDAO dao = new UserDAOImpl();
			if( dao.duplicateCheckByEmail(email) ) {
				errMsg = email+"는 사용중인 이메일입니다.";
				request.setAttribute("errMsg", errMsg);
			}else {
				if(dao.duplicateCheckByNickname(nickname)) {
					errMsg = nickname+"는 사용중인 닉네임입니다.";
					request.setAttribute("errMsg", errMsg);
				}else {
					//이메일 + 닉네임 모두 가능
					UserDTO user = 
							new UserDTO(email, password, birth, nickname, phone, adress, gender, Integer.parseInt(categoryCode));


					if( dao.insert(user) > 0) {
						url="index.jsp";
						isRedirect=true;
					}
				}
			}
		}	


		return new ModelAndView(url, isRedirect);

	}	//끝

	/**
	 * 로그인 기능
	 * */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//두개의 전송되는 값을 받는다.
		String email =request.getParameter("email");
		String password =request.getParameter("password");

		System.out.println(email);

		//서비스 호출 
		UserDTO dbDTO = userService.loginCheck( new UserDTO(email, password) );
		System.out.println("로그인 된 이메일 : "+email+" , "+"비밀번호 : "+password);

		//로그인성공하면 세션에 정보를 저장 - ${loginUser} / ${loginName}

		UserDTO user = userService.select(email);
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user);

		//index.jsp이동 - redirect방식
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 로그아웃
	 * */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//모든 세션의정보를 삭제한다.
		request.getSession().invalidate();

		return new ModelAndView("user/logoutpage.jsp", true);


	}

	/**
	 * 유저 정보 조회
	 * @throws SQLException 
	 * */

	public void searchUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");   

		List<UserDTO> list = userService.searchUser();

		//list를 응답할수 없기때문에 list를 jsonArray변환해서 보낸다.
		JSONArray arr = JSONArray.fromObject(list);

		PrintWriter out = response.getWriter();
		out.print(arr);

	}
}






