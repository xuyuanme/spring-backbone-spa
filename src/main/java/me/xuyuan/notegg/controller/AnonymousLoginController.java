package me.xuyuan.notegg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.xuyuan.notegg.model.User;
import me.xuyuan.notegg.model.dto.LoginStatus;
import me.xuyuan.notegg.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/anonymousLogin")
public class AnonymousLoginController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(method = { RequestMethod.PUT })
	@ResponseBody
	public LoginStatus login(HttpServletRequest request,
			HttpServletResponse response, @RequestBody LoginStatus loginStatus) {
		LoginStatus result = null;
		User u = userService.getUser(loginStatus.getUsername());
		if (u == null) {
			u = new User();
			u.setLogin(loginStatus.getUsername());
			userService.save(u);
		}

		result = new LoginStatus();
		result.setId(u.getId());
		result.setUsername(u.getLogin());
		return result;
	}
}
