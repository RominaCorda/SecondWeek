package com.virtualpairprogrammers.services;



import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.domain.User;

import java.util.List;

public class UserService
{
    private UserDAO userDao;
    private static UserService reference;

    public static UserService getService() {
        if (reference == null)
            reference = new UserService();
        return reference;
    }



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
