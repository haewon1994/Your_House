package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import mvc.dto.story.Story;
import mvc.dto.user.UserDTO;
import mvc.service.StoryService;
import mvc.service.StoryServiceImpl;
import mvc.service.UserService;
import mvc.service.UserServiceImpl;

public class StoryController implements Controller {
	
	private StoryService storyService = new StoryServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	
	/**
	 *  전체검색
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/*
		 * String pageNo = request.getParameter("pageNo"); if(pageNo==null ||
		 * pageNo.equals("")) { pageNo="1"; }
		 */
		System.out.println(request.getSession().getAttribute("loginUser"));
		
		UserDTO my = (UserDTO) request.getSession().getAttribute("loginUser");
		int myCode = my.getUserCode();
		
		List<Story> storylist = storyService.selectAll(myCode);
		
		
		request.setAttribute("storylist", storylist);//뷰에서 ${list}
		/*
		 * request.setAttribute("pageNo", pageNo); //뷰에서 ${pageNo}
		 */		
		return new ModelAndView("community/storyHome.jsp"); //forward방식으로 이동
	}
	
	
	
	/**
	 * 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//폼에서 enctype="multipart/form-data" 설정되어 있기때문에 request아닌 MultipartRequest로 처리한다. - cos.jar
		String saveDir = request.getServletContext().getRealPath("/save"); //
		int maxSize=1024*1024*100; //100M
		String encoding="UTF-8";
		
		MultipartRequest m = 
		 new MultipartRequest(request,saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		//전송된 데이터 받기 
		String storyCode = m.getParameter("story_code");
		String userCode = m.getParameter("user_code");
		String storyImage = m.getParameter("story_image"); //베너
		String storyLiter = m.getParameter("story_liter");
		String storyReg = m.getParameter("story_reg");
		
		
		Story story = 
			new Story(0,Integer.parseInt(userCode), storyImage, storyLiter,null);
		
		//만약, 파일첨부가 되었다면....
		if(m.getFilesystemName("file") != null) {
			//파일이름저장
			story.setStoryImage(m.getFilesystemName("file"))	;
		}
	
		
		storyService.insert(story);

	   return new ModelAndView("front", true);//key=elec&methodName=select 기본으로 설정된다.	
	}
	
	/**
	 * 상세보기 
	 */

	public ModelAndView selectBynoticeCode(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		String storyCode=request.getParameter("storyCode");
		String flag = request.getParameter("flag");
		Story story=null;
		if(flag.equals("")||flag==null) {
			story = storyService.selectByStoryCode(Integer.parseInt(storyCode), false);
		}
		story = storyService.selectByStoryCode(Integer.parseInt(storyCode), true);
		request.setAttribute("story", story);
		
		return new ModelAndView("story/read.jsp"); //forward방식 
	}
	
	
	
	
	/**
	 *  수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String storyCode=request.getParameter("storyCode");
	Story story = storyService.selectByStoryCode(Integer.parseInt(storyCode),false);

		request.setAttribute("story", story);
		
		return new ModelAndView("story/update.jsp");//forward방식
	}
	
	/**
	 * 수정완료
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   //수정할 정보 1개 받기
		String storyCode = request.getParameter("storyCode");
		String storyLiter = request.getParameter("storyLiter");
		
		
		 
		storyService.update(new Story(Integer.parseInt(storyCode),storyLiter ));
		
		//수정이 완료가 된후....
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=story&methodName=selectBystoryCode&storyCode="+storyCode);
	    mv.setRedirect(true);
		return mv;
	}
	
	/**
	 * 삭제
	 * 
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String storyCode=request.getParameter("storyCode");
		//String password = request.getParameter("password");
		
		// 첨부된 파일을 삭제하는 경우라면 삭제가 되었을 때 폴더에서 파일도 삭제한다.-- 
		// 이 기능을 service에서 한다
		
		String saveDir = request.getServletContext().getRealPath("/save");
		storyService.delete(Integer.parseInt(storyCode), saveDir);
		 return new ModelAndView("front",true);
	
	}
	

}
