package com.developpez.skillbrowser.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.developpez.skillbrowser.model.Message;
import com.developpez.skillbrowser.model.User;
import com.developpez.skillbrowser.model.dto.MessageDto;
import com.developpez.skillbrowser.repository.MessageRepo;
import com.developpez.skillbrowser.repository.UserRepository;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageRepo messageRepo;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<MessageDto> getMessage(HttpServletRequest request,
			HttpServletResponse response) {
		List<MessageDto> mdl = new ArrayList<MessageDto>();
		Authentication authentication = getSessionAuthentication(request);
		if (isAuthenticated(authentication)) {
			User u = userRepository.findByLogin(authentication.getName());
			List<Message> ml = messageRepo.findByUser("" + u.getId());
			for (Message m : ml) {
				mdl.add(new MessageDto(m, u));
			}
		}
		return mdl;
	}

	private Authentication getSessionAuthentication(HttpServletRequest request) {
		SecurityContext securityContext = (SecurityContext) request
				.getSession()
				.getAttribute(
						HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if (securityContext == null) {
			return null;
		} else {
			return securityContext.getAuthentication();
		}
	}

	private boolean isAuthenticated(Authentication authentication) {
		return authentication != null
				&& !authentication.getName().equals("anonymousUser")
				&& authentication.isAuthenticated();
	}

}
