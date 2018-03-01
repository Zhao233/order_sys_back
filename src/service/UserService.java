package service;

import dao.UserDao;

import java.sql.SQLException;

public class UserService {
    UserDao userDao;

    public UserService(){
        try {
            userDao = new UserDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isFirst(String id, String name) throws SQLException {
        return userDao.isFirst(id, name);
    }
}
