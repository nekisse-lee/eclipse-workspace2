package net.nekisse.user;

import static org.junit.Assert.*;

import org.junit.Test;

import net.nekisse.db.Database;

public class UserTest {
	public static User TEST_USER = new User("userId", "password", "name", "email@email.com"); 

	@Test
	public void matchPassword() {
		assertTrue(TEST_USER.matchPassworld("password"));
	}

	@Test
	public void notMatchPassword() {
		assertFalse(TEST_USER.matchPassworld("password2"));
	}

	@Test
	public void login() throws Exception {
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		assertTrue(User.login(TEST_USER.getUserId(), TEST_USER.getPassword()));
	}
	
	@Test(expected=UserNotFoundException.class)
	public void loginWhenNotExistedUser() throws Exception {
		User.login("userId2", TEST_USER.getPassword());
	}
	
	@Test(expected=PasswordMisMatchException.class)
	public void loginWhenPasswordMismatch() throws Exception {
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		User.login(TEST_USER.getUserId(), "password2");
	}
	
	
}
