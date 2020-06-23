package cn.smbms.servlet.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smbms.tools.Constants;

@Controller
public class LogoutSpringMVC {
	@RequestMapping(value="/jsp/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "redirect:/login.jsp";
	}
	
	
	
	
	
	
	
	
	
}
