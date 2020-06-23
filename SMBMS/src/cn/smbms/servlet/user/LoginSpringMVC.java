package cn.smbms.servlet.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;

@Controller
public class LoginSpringMVC {
	@Resource
	private UserService userService;
	@RequestMapping(value="login.do")
	public String login(String userCode, String userPassword, 
			HttpSession session, HttpServletRequest request){
		User user = userService.login(userCode,userPassword);
//		String s = null;
//		s.equals("");
		if(null != user){//登录成功
			//放入session
			session.setAttribute(Constants.USER_SESSION, user);
			return "/jsp/frame.jsp";
//			return "redirect:http://www.baidu.com";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "/login.jsp";
//			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
