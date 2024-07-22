package org.example;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) context.getBean("userDao");

        // Tạo mới người dùng
        User user = new User();
        user.setName("Nguyen Gia Bao");
        user.setEmail("ngbao@paradox.com");
//        userDao.save(user);

        // Lấy tất cả người dùng
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail());
        }

        // Cập nhật người dùng
        user.setName("Nguyen Gia Bao B");
        userDao.update(user);

        // Lấy người dùng theo ID
        User userById = userDao.findById(3L);
        System.out.println(userById.getName());

        // Xóa người dùng
        userDao.delete(3L);
    }
}
