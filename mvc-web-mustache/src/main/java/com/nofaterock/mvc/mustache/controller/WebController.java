package com.nofaterock.mvc.mustache.controller;

import com.nofaterock.mvc.mustache.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 한승룡
 * @since 2019-11-06
 */
@Controller
public class WebController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "users";
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public String getUser(Model model, @PathVariable String userId) {
		model.addAttribute("user", userService.getUser(userId));
		return "user";
	}

}
