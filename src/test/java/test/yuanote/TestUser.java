package test.yuanote;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuanote.domain.Result;
import com.yuanote.domain.User;
import com.yuanote.mapper.UserMapper;
import com.yuanote.service.IUserService;
import com.yuanote.service.impl.UserServiceImpl;

public class TestUser {
	@Test
	public void testAddUser() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml",
				"applicationContext-servlet.xml");
		IUserService userService = ctx.getBean(UserServiceImpl.class);
		User user = new User();
		user.setUserName("lisi");
		user.setPassword("111");
		// userService.addUser(user);

		boolean flag = userService.addUser(user);
		Result aResult = new Result(flag);
		System.out.println(aResult);

	}
	@Autowired
	private IUserService userService;
	@Test
	public void testFindUser() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml",
				"applicationContext-servlet.xml");
//		IUserService userService = ctx.getBean(UserServiceImpl.class);
		User user =this.userService.findUser("lisi");
		System.out.println("=================="+user+"==============");
	}
	@Test
	public void testBase() throws Exception {
		User user = new User();
		String name = user.getUserName();
		System.out.println(name);
	}
	
	@Test
	public void testFInd() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml",
				"applicationContext-servlet.xml");
		UserMapper mapper = ctx.getBean(UserMapper.class);
		User user = new User();
		user.setUserName("lisi1");
		user.setPassword("111");
		mapper.insertSelective(user);
		System.out.println(user);

	}
	
	

}
