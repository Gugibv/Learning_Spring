package cn.grey.tests;

import cn.grey.beans.Role;
import cn.grey.beans.User;
import cn.grey.controller.UserController;
import cn.grey.service.RoleService;
import cn.grey.service.UserService;
import cn.grey.service.impl.RoleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class IocTest {
    ClassPathXmlApplicationContext ioc;


    /**
     * 问题： IDEA中Spring配置错误：class path resource [.xml] cannot be opened because it does not exist
     * 原因： ClassPathXmlApplicationContext()方法是在其所在的目录中寻找 .xml 配置文件。
     * 注意： 这里指的是编译后的 .class 文件所在的目录，不是 .java 文件
     * 解决： 点击 File -> Project Structure，选择Modules -> Paths -> Output Paths
     *       修改为 spring_ioc.xml 文件所在目录。
     */
    @Before
    public void before() {

        ioc = new ClassPathXmlApplicationContext("spring_ioc.xml");
    }

    @Test
    public void test01() {
        UserController userController = (UserController) ioc.getBean("userController");
        System.out.println(userController);
    }

    @Test
    public void test02() {
        User bean = ioc.getBean(User.class);
        System.out.println(bean.getName());
    }

    @Test
    public void test03() {
        UserController bean = ioc.getBean(UserController.class);
        bean.getUser();
    }

    @Test
    public void test04() {

        Role bean = ioc.getBean(Role.class);
        Role bean2 = ioc.getBean(Role.class);
        Role bean3 = ioc.getBean(Role.class);
    }

    @Test
    public void test05() {

        Role bean = ioc.getBean(Role.class);
        ioc.close();
    }


    @Test
    public void test06() {

        UserService bean = ioc.getBean(UserService.class);
        System.out.println(bean.getClass());


        RoleServiceImpl roleService=new RoleServiceImpl();
        // instanceof  用户判断前面的对象是否是否吗的类，或者子类，或者接口
        if(roleService instanceof  RoleService)
        {
            System.out.println("OK");
            //RETURN
        }


    }
}
