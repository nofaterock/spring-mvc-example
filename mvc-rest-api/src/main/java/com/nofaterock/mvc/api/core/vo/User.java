package com.nofaterock.mvc.api.core.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 한승룡
 * @since 2019-11-06
 */
@Getter
@Setter
@NoArgsConstructor
public class User {
	private String userId;
	private String name;

	public User(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}
}
