package com.nofaterock.mvc.freemarker.core.service;

import com.nofaterock.mvc.freemarker.core.vo.User;

import java.util.List;

/**
 * @author 한승룡
 * @since 2019-11-06
 */
public interface UserService {

	User addUser(User user);

	User updateUser(User user);

	void deleteUser(String userId);

	User getUser(String userId);

	List<User> getUsers();

}
