package org.example;

import org.example.dao.UserDao;
import org.example.model.User;

public class App 
{
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // Tạo và lưu người dùng mới
        User newUser = new User();
        newUser.setName("Mau Truong");
        newUser.setEmail("ngo.mau.truong@sun-asterisk.com");
        userDao.save(newUser);

        // Tìm người dùng theo ID
        User user = userDao.findById(2L);
        System.out.println("User found: " + user.getName() + ", " + user.getEmail());

        // Cập nhật người dùng
        user.setName("Ngo Mau Truong");
        userDao.update(user);

        // Xóa người dùng
//        userDao.delete(user.getId());
    }
}
