package com.knet.template.mvc.api.core.service;

import com.knet.template.mvc.api.core.vo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 한승룡
 * @since 2019-11-06
 */
@Service
public class UserServiceImpl implements UserService {

	private static List<User> registeredUsers = new ArrayList<User>() {
		{
			add(new User("park", "박지성"));
			add(new User("lee", "이영표"));
			add(new User("son", "손흥민"));
			add(new User("lsh", "이승환"));
		}
	};

	@Override
	public User addUser(User user) {
		for (User registeredUser : registeredUsers) {
			if (registeredUser.getUserId().equals(user.getUserId())) {
				throw new RuntimeException("Duplicated userId=" + user.getUserId());
			}
		}

		registeredUsers.add(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		for (User registeredUser : registeredUsers) {
			if (registeredUser.getUserId().equals(user.getUserId())) {
				registeredUser.setName(user.getName());
				return registeredUser;
			}
		}

		throw new RuntimeException("Cannot find user. userId=" + user.getUserId());
	}

	@Override
	public void deleteUser(String userId) {
		for (User registeredUser : registeredUsers) {
			if (registeredUser.getUserId().equals(userId)) {
				registeredUsers.remove(registeredUser);
				return;
			}
		}

		throw new RuntimeException("Cannot find user. userId=" + userId);
	}

	@Override
	public User getUser(String userId) {
		for (User registeredUser : registeredUsers) {
			if (registeredUser.getUserId().equals(userId)) {
				return registeredUser;
			}
		}

		throw new RuntimeException("Cannot find user. userId=" + userId);
	}

	@Override
	public List<User> getUsers() {
		return registeredUsers;
	}
}
