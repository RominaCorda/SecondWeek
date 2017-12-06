package com.virtualpairprogrammers.services;



import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.domain.User;

import java.util.List;

public class UserService
{
    private UserDAO userDao;

    public UserService()
    {
        this.userDao = new UserDAO();
    }
    public List<User> getAllUser ()
    {
        return this.userDao.getAllUser();
    }

    public boolean insertUser (User user) {
        return this.userDao.insertUser(user);
    }

}
