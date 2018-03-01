package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public UserDao() throws SQLException {
        connection = DBConnection.getConnection();
        statement=connection.createStatement();
    }
    public boolean isFirst(String id, String name) throws SQLException {
        String sql_search = "select * from user where id='"+id+"'";

        resultSet = statement.executeQuery(sql_search);

        while( resultSet.next() ){
            return true;
        }

        createUser(id,name);
        return false;
    }

    public void createUser(String id, String name){
        String sql_create = "insert into user values('"+id+"','"+name+"')";
    }
}
