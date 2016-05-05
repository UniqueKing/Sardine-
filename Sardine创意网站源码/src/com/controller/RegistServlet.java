package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.entity.UserObject;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String checkCode = (String) getServletContext().getAttribute("checkCode");
		String code = request.getParameter("checkcode");
		if(checkCode.equals(code)){
			//得到注册信息
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			System.out.println(username+password+phone);
			UserDAO dao = new UserDAOImpl();
			//先判断数据库是不是已经存在这个用户
			UserObject user = dao.isUser(username);
			//如果不存在，则加入数据库
			if(user==null){
				String id = dao.insertUser(username, password, phone);
				if(id!=null){
					//登陆成功，跳向主页
					response.sendRedirect("/Sardine/Sardine.html");
				}else{
					//登陆失败，跳向失败中转页面
					response.sendRedirect("/Sardine/fail.html");
				}
			}else{//否则跳向失败页面
				response.sendRedirect("/Sardine/fail.html");
			}
			
			
		}else{
			response.sendRedirect("/Sardine/regist.html");
		}
		
		
		
	}

}
