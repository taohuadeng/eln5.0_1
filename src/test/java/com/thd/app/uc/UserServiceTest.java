package com.thd.app.uc;

import com.thd.app.uc.model.User;
import com.thd.app.uc.service.BaseWebTests;
import com.thd.app.uc.service.UserService;
import com.thd.base.service.BaseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;


//public class UserServiceTest extends BaseWebTests {
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config/spring-servlet.xml",
        "classpath:/spring-config/spring-context.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UserServiceTest {
    @Resource
    private BaseService baseService;
    @Resource
    private UserService userService;

    public static void main(String[] args) {
        String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><sms><mt><status>0</status><msgid>8c988a40ed1a4a469ff12474e40ee439</msgid></mt></sms>";
        String substring = a.substring(55, 56);
        System.out.println(substring);
    }

    @Test
    public void testSaveUser() {
//        for (int i = 0; i < 50; i++) {
        String userId = UUID.randomUUID().toString().replace("-", "");
        User user = new User();
        user.setUserId(userId);
        user.setCorpCode("ladeng.com");
        user.setUserName("陶发登");
        user.setLoginName("1807");
        user.setCreateUser(userId);
        user.setGenderType(User.GenderType.MAN);
        user.setEmployeeCode("1807");
        user.setCreateTime(new Date());
        user.setLastModifyUser(userId);
        user.setLastModifyTime(new Date());
        userService.save(user);
//        }
    }

    @Test
    public void testGetUser() {

        String hql = "from User";
        User user = baseService.getByHQL(hql);
        Assert.assertNotNull(user);
        System.out.println(user.getUserName());
    }


    @Test
    public void testSwitchDataSource() {
        // hibernate创建实体
//        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.dataSource1);// 设置为另一个数据源
//        String hql = "from User";
//        User user = baseService.getByHQL(hql);
//        Assert.assertNotNull(user);
//        System.out.println(user.getUserName());
    }
}
