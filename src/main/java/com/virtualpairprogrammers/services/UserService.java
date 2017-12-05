package com.virtualpairprogrammers.services;



import com.virtualpairprogrammers.dao.UserDao;
import com.virtualpairprogrammers.domain.User;

import java.util.List;

public class UserService
{
    private UserDao userDao;

    public UserService()
    {
        this.userDao = new UserDao();
    }
    public List<User> getAllUser ()
    {
        return this.userDao.getAllUser();
    }

    public boolean insertUser (User user) {
        return this.userDao.insertUser(user);
    }

}
