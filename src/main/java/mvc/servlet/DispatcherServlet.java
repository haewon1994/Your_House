package mvc.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;
import mvc.controller.ModelAndView;

@WebServlet(urlPatterns = { "/front" }, loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;
	private Map<String, Class<?>> clzMap;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map = (Map<String, Controller>)application.getAttribute("map");
		clzMap = (Map<String, Class<?>>)application.getAttribute("clzMap");
	}
	
	/**
	 * 모든 사용자 요청을 처리할 진입점 Controller의 역할
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		
		if(key==null || key.equals("")) key="product";
		if(methodName==null || methodName.equals("")) methodName="selectAll";
		
		System.out.println(key);
		
		try {
			Controller con = map.get(key);
			Class<?> clz = clzMap.get(key);

			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			ModelAndView mv = (ModelAndView)method.invoke(con, request, response);	//invoke(실제 메소드가 호출됨)
			
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			} else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		
	}//service

}//DispatcherServlet