package com.springMyBatis.system.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springMyBatis.system.dao.UserDao;
import com.springMyBatis.system.model.User;

public class UserController {
    
    /**
     * @param args
     */
	
	public static void main(String[] args) {
    	ClassPathXmlApplicationContext ctx=null;
        ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserDao userDao=(UserDao) ctx.getBean("userDao");

        User user = new User();
        List<User> users = new ArrayList<User>();
        //�½�
        user.setId(1);
        user.setUsername("Jessica");
        user.setPassword("123");
        userDao.addUser(user);
        user.setId(2);
        user.setUsername("Jessica2");
        user.setPassword("123");
        userDao.addUser(user);
        System.out.println("�½��ɹ�");
        //��ѯ�ɹ�
        user.setUsername("Jessica");
        user.setPassword("123");
        users=userDao.getUser(user);
        System.out.println(users.toString());
        user.setUsername("Jessica2");
        user.setPassword("123");
        users=userDao.getUser(user);
        System.out.println(users.toString());
        //���³ɹ�
        user.setId(2);
        user.setPassword("802");
        userDao.updateUser(user);
        System.out.println("���³ɹ�");
        // ɾ���ɹ�
        userDao.deleteUser(2);
        System.out.println("ɾ���ɹ�");
        
        ctx.close();
    }

}