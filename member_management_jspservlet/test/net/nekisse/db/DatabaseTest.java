package net.nekisse.db;

import static org.junit.Assert.*;

import org.junit.Test;

import net.nekisse.user.User;
import net.nekisse.user.UserTest;

public class DatabaseTest {

	@Test
	public void addAndFindWhenExisted() {
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		
		User dbUser = Database.findByUserId(user.getUserId());
		assertEquals(user, dbUser);
		
	}
	
	public void addAndFindWhenNotExisted() {
		User dbUser = Database.findByUserId("userId2");
		assertNull(dbUser);
		
	}

}
