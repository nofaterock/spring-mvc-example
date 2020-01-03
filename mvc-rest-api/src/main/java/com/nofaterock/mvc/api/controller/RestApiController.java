package com.nofaterock.mvc.api.controller;

import com.nofaterock.mvc.api.core.service.UserService;
import com.nofaterock.mvc.api.core.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 한승룡
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public Object getUsers(@PathVariable String userId) {
		return userService.getUser(userId);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public Object addUsers(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public Object updateUsers(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public Object deleteUsers(@PathVariable String userId) {
		userService.deleteUser(userId);
		return null;
	}

}
