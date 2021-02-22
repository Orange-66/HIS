import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.his.dao.UserDao;
import com.his.entity.User;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })

public class testMybatis
{
	@Autowired
	private UserDao userDao;

	@Test
	public void findAll() throws Exception {
		List<User> userList = userDao.findAll();
		for(User u: userList)
		{
			System.out.println(u);
		}
	}

	@Test
	public void isLegal() throws Exception {
		String userName = "bianque";
		User user = userDao.queryByName(userName);
		System.out.print(user);

	}
}

