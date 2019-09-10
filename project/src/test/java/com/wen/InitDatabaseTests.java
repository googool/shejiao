package com.wen;

import com.wen.dao.UserDAO;
import com.wen.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = InitDatabaseTests.class)
//@Sql("/init-schema.sql")
//public class InitDatabaseTests {

	//@Autowired(required=false)
	//@Qualifier("userDAO")
	//public UserDAO userDAO;

	/*@Test
	public void initDatabase() {
		Random random = new Random();

		for (int i = 0; i < 11; ++i) {
			User user = new User();
			user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
			user.setName(String.format("USER%d", i+1));
			user.setPassword("xx");
			user.setSalt("xx");
			userDAO.addUser(user);
			//System.out.println(user);
//			user.setPassword("xx");
//			userDAO.updatePassword(user);
		}

//		Assert.assertEquals("xx", userDAO.selectById(1).getPassword());
//		userDAO.deleteById(1);
//		Assert.assertNull(userDAO.selectById(1));
	}*/

//}
