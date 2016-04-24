package test.yuanote;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuanote.domain.Result;
import com.yuanote.domain.User;
import com.yuanote.service.IUserService;

public class TestUser {
	@Test
	public void testAddUser() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml",
				"applicationContext-dao.xml");
		IUserService userService = ctx.getBean(IUserService.class);
		User user = new User();
		user.setUserName("lisi");
		user.setPassword("111");
		// userService.addUser(user);

		boolean flag = userService.addUser(user);
		Result aResult = new Result(flag);
		System.out.println(aResult);

	}
	@Test
	public void testFindUser() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml",
				"applicationContext-dao.xml");
		IUserService userService = ctx.getBean(IUserService.class);
		User user =userService.findUser("lisi");
		System.out.println("=================="+user+"==============");
	}
	@Test
	public void testBase() throws Exception {
		User user = new User();
		String name = user.getUserName();
		System.out.println(name);
	}

}
